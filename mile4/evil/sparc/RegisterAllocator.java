/**
 * Eriq Augustine and Evan Ralston
 * Register allocator for our Evil compiler.
 * Codename: Alligator The Register Allocator
 */

package evil.sparc;

import evil.instruction.*;
import evil.evilCFG.*;

import java.util.BitSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RegisterAllocator
{
   //Map of register to their bitsets.
   private HashMap<Register, BitSet> regToBitSet;

   //Map of bitsets to their Registers.
   private HashMap<BitSet, Register> bitSetToReg;

   //ILOC -> sparc mapping.
   private HashMap<Register, String> mapping;

   //Color -> that colors bitset
   private HashMap<String, BitSet> colorToBitSet;

   //color's bitset -> Color
   private HashMap<BitSet, String> bitSetToColor;

   //ALL COLORS in my box!
   private BitSet allColors;

   //The interference graph
   private HashMap<Register, Node> graph;

   //The reverse of the interference graph
   private HashMap<Node, Register> revGraph;
   
   private BasicBlock cfg;

   private ArrayList<Register> spills;

   private int numRegs;

   //%g1 and %g2 will be reserverd for translator.
   private static final ArrayList<String> kAvailableRegs = new ArrayList<String>(Arrays.asList(new String[]{ 
    //Can use l's (they are local, saved across calls). 
    "%l0", "%l1", "%l2", "%l3", "%l4", "%l5", "%l6", "%l7"//,
    //G's please
//    "%g1", "%g2", "%g3", "%g4", "%g5"
//    "%l0", "%l1", "%l2"
    }));

   public RegisterAllocator(BasicBlock cfg)
   {
      this.cfg = cfg;

      numRegs = cfg.getAllRegs().size();

      spills = new ArrayList<Register>();

      bitSetToReg = new HashMap<BitSet, Register>();
      regToBitSet = new HashMap<Register, BitSet>();
      maskRegisters();

      allColors = new BitSet(numRegs);
      colorToBitSet = new HashMap<String, BitSet>();
      bitSetToColor = new HashMap<BitSet, String>();
      maskColors();
      
      mapping = new HashMap<Register, String>();
      
      graph = new HashMap<Register, Node>();
      revGraph = new HashMap<Node, Register>();
   }

   public RegisterMap getMapping()
   {
      allocateRegisters();

      return new RegisterMap(mapping, spills);
   }

   private void allocateRegisters()
   {
      //Live Variable Analysis prz.
      HashMap<BasicBlock, LocalInfo> info = doLVA();

      buildInterference(info);
      
      try
      {
         color();
      }
      catch (SpillException ex)
      {
         System.out.println("Warning: Unable to find a valid coloring, must spill.");

         Register selected = selectSpillRegister();
         //System.err.println("Spill selection: " + selected);

         spills.add(selected);
         
         mapping.clear();
         graph.clear();
         revGraph.clear();

         //There is one less active register now.
         numRegs--;

         bitSetToReg.clear();
         regToBitSet.clear();
         maskRegisters();

         allocateRegisters();
      }  
   }

   private Register selectSpillRegister()
   {
      Node candidateNode = null;

      //Right now, just select the register with the most edges.
      for (Node node : graph.values())
      {
         if (candidateNode == null)
         {
            candidateNode = node;
         }
         else if (node.edges.cardinality() > candidateNode.edges.cardinality())
         {
            candidateNode = node;
         }
      }

      return revGraph.get(candidateNode);
   }

   //Live Variable Analysis
   private HashMap<BasicBlock, LocalInfo> doLVA()
   {
      HashMap<BasicBlock, LocalInfo> info = getLocalInfo();
      propogate(info);

      return info;
   }

   private void color() throws SpillException
   {
      Stack<Node> nodes = new Stack<Node>();
      //System.err.println("color");

      //While nodes in graph
      while (hasUnmarkedNodes())
      {
         Node node = null;
         
         node = markUnconstrainedNode();

         //If there is no unconstrained node
         if (node == null)
         {
            //Select constrained node.
            node = markConstrainedNode();
         }

         //Place node on stack.
         nodes.push(node);
      }

      for (Node node : nodes)
      {
         //Insert into graph (unmark).
         node.mark = false;

         //Color newly added node.
         
         BitSet takenColors = new BitSet(numRegs);

         //For all neighbors
         int currNeighborNdx = node.edges.nextSetBit(0);
         while (currNeighborNdx != -1)
         {
            BitSet temp = new BitSet(numRegs);
            temp.set(currNeighborNdx);

            Register neighbor = bitSetToReg.get(temp);

            //Union their color to the set of not available colors.
            takenColors.or(graph.get(neighbor).color);
            
            currNeighborNdx = node.edges.nextSetBit(currNeighborNdx + 1);
         }

         //FOR all non-taken colors.
         int notTaken = takenColors.nextClearBit(0);
         
         //if there is no available color.
         if (notTaken == -1 || notTaken >= kAvailableRegs.size())
         {
            //throw
            throw new SpillException();
         }
         else
         {
            //Set the node's color to the non-taken color.
            node.color.set(notTaken);

            //Add the mapping of this register to the color.
            mapping.put(revGraph.get(node), bitSetToColor.get(node.color));
         }
      }
   }

   private Node markConstrainedNode()
   {
      BitSet allNodes = new BitSet(numRegs);
      //System.err.println("mark con");

      //Union all sets of edges.
      for (Node node : graph.values())
      {
         //If Node has not yet been "removed"
         if (!node.mark)
         {
            allNodes.or(node.edges);
         }
      }
      
      //System.err.println("Constrained");
      //System.err.println("graph: " + graph);
      //System.err.println("all const nodes: " + allNodes);

      Node candidate = null;

      int constrained = allNodes.nextSetBit(0);
      while (constrained != -1)
      {
         BitSet temp = new BitSet(numRegs);
         temp.set(constrained);

         //If node has not yet been "removed" (marked).
         if (!graph.get(bitSetToReg.get(temp)).mark)
         {
            //If candidate is null or the new node has more edges.
            if (candidate == null ||
             graph.get(bitSetToReg.get(temp)).edges.cardinality() > candidate.edges.cardinality())
            {
               candidate = graph.get(bitSetToReg.get(temp));
            }
         }
      
         constrained = allNodes.nextSetBit(constrained + 1);
      }

      if (candidate == null)
      {
         throw new RuntimeException("Uh OH! Can't find a constrained candidate.");
      }

      candidate.mark = true;
      return candidate;
   }

   //Returns the first unconstrained node it finds, null if none.
   //Marks the returned node.
   private Node markUnconstrainedNode()
   {
      BitSet allNodes = new BitSet(numRegs);
      //System.err.println("mark UNCONS");
      //System.err.println("INITIAL SIZE: " + allNodes.size());

      //System.err.println("graph: " + graph);

      //Union all sets of edges.
      for (Node node : graph.values())
      {
         //If Node has not yet been "removed"
         if (!node.mark)
         {
            //System.err.println("NODE: " + node);
            //System.err.println("EDGES: " + node.edges);
            allNodes.or(node.edges);
         }
      }

         //System.err.println("allNodes: " + allNodes);
      //System.err.println("SIZE: " + allNodes.size());
      //System.err.println("numREGERSESESESE: " + numRegs);

      int unconstrained = allNodes.nextClearBit(0);
      while (unconstrained != -1 && unconstrained < numRegs)
      {
         BitSet temp = new BitSet(numRegs);
         temp.set(unconstrained);

         //System.err.println("UNCONST: " + unconstrained);
         //System.err.println("bitSetToReg " + bitSetToReg);
         //System.err.println("TEMP: " + temp);
         //System.err.println(graph.get(bitSetToReg.get(temp)));

         //If node has not yet been "removed" (marked).
         if (!graph.get(bitSetToReg.get(temp)).mark)
         {
            graph.get(bitSetToReg.get(temp)).mark = true;
            return graph.get(bitSetToReg.get(temp));
         }
         
         unconstrained = allNodes.nextClearBit(unconstrained + 1);
      }

      return null;
   }

   private boolean hasUnmarkedNodes()
   {
      for (Node node : graph.values())
      {
         if (!node.mark)
         {
            return true;
         }
      }

      return false;
   }

   private void buildInterference(HashMap<BasicBlock, LocalInfo> info)
   {
      //System.err.println("build");

      for (Register reg : cfg.getAllRegs())
      {
         if (!spills.contains(reg))
         {
            Node temp = new Node();

            graph.put(reg, temp);
            revGraph.put(temp, reg);
         }
      }
               
               //System.err.println("graph: " + graph);
               //System.out.println("regToBitSet: " + regToBitSet);

      //For all blocks
      for (BasicBlock block : cfg.getReverseTopoCFG())
      {
         //Livenow is now liveout
         BitSet livenow = info.get(block).liveout;

         ArrayList<Instruction> insts = block.getInstructions();

         //For all instruction in block
         for (int i = insts.size() - 1; i >= 0; i--)
         {
            int regIndex = livenow.nextSetBit(0);
            
            //System.err.println("TEST");
            //System.err.println("Livenow: " + livenow);

            //For all regs in livenow
            while (regIndex != -1)
            {
               //System.err.println("regndx: " + regIndex);
               //System.out.println("inst: " + insts.get(i));
               //For all for all targets of the inst
               for (Register reg : insts.get(i).getTargets())
               {
                  //IF not already in spills
                  if (!spills.contains(reg))
                  {
                     BitSet temp = new BitSet(numRegs);
                     temp.set(regIndex);
                     //System.err.println("Extra TEST: " + temp);
                     Register currentInLivenow = bitSetToReg.get(temp);
   
                     // '==' is good enough, they should be exactly the same register.
                     if (currentInLivenow != reg)
                     {
                        //System.err.println("FUN");
                        //Add edge between target and current reg in livenow
                        graph.get(reg).edges.set(regIndex);

                        //Add reverse edge too.
                        graph.get(currentInLivenow).edges.or(regToBitSet.get(reg));
                     }
                  }
               }
               
               regIndex = livenow.nextSetBit(regIndex + 1);
            }

            //For all targets of the inst
            for (Register reg : insts.get(i).getTargets())
            {
               //IF not already in spills
               if (!spills.contains(reg))
               {
                  //System.err.println("trg");
                  //Remove target from livenow
                  livenow.andNot(regToBitSet.get(reg));
               }
            }

            //For all sources of the inst
            for (Register reg : insts.get(i).getSources())
            {
               //IF not already in spills
               if (!spills.contains(reg))
               {
                  //System.err.println("src");
                  //add source to livenow
                  livenow.or(regToBitSet.get(reg));
               }
            }
         }
      }
   }

   private void propogate(HashMap<BasicBlock, LocalInfo> info)
   {
      boolean changed = true;
      //System.err.println("PROP");

      while (changed)
      {
         changed = false;

         for (BasicBlock block : cfg.getReverseTopoCFG())
         {
            BitSet newLiveout = new BitSet(numRegs);

            for (BasicBlock kid : block.getKids())
            {
               LocalInfo kidInfo = info.get(kid);

               BitSet temp = (BitSet)(kidInfo.liveout.clone());
               //Note: andNot == <minus>
               temp.andNot(kidInfo.kill);
               temp.or(kidInfo.gen);

               newLiveout.or(temp);
            }

            if (!newLiveout.equals(info.get(block).liveout))
            {
               changed = true;
               info.get(block).liveout = newLiveout;
            }
         }
      }
   }

   private HashMap<BasicBlock, LocalInfo> getLocalInfo()
   {
      HashMap<BasicBlock, LocalInfo> info = new HashMap<BasicBlock, LocalInfo>();

      //System.err.println("loalINFO");

      //FOR all blocks.
      for (BasicBlock curBlock : cfg.getReverseTopoCFG())
      {
         LocalInfo currInfo = new LocalInfo();
         info.put(curBlock, currInfo);

         //FOR all instruction inside each block.
         for (Instruction inst : curBlock.getInstructions())
         {
            //FOR each source in each instruction.
            for (Register src : inst.getSources())
            {
               //IF not already spilled
               if (!spills.contains(src))
               {
                  //if not in kill
                  if (!regToBitSet.get(src).intersects(currInfo.kill))
                  {
                     //Add to gen
                     currInfo.gen.or(regToBitSet.get(src));
                  }
               }
            }
            
            //FOR each target in each instruction.
            for (Register trg : inst.getTargets())
            {
               //IF not already spilled
               if (!spills.contains(trg))
               {
                  //add to kill
                  currInfo.kill.or(regToBitSet.get(trg));
               }
            }
         }
      }

      return info;
   }

   private void removeSpills(ArrayList<Register> regs)
   {
      for (Register spilled : spills)
      {
         if (regs.contains(spilled))
         {
            regs.remove(spilled);
         }
      }
   }

   private void maskRegisters()
   {
      int i = 0;

      for (Register reg : cfg.getAllRegs())
      {
         if (!spills.contains(reg))
         {
            //System.err.println(i + " : " + reg);
            BitSet tempSet = new BitSet(numRegs);
            tempSet.set(i++);

            regToBitSet.put(reg, tempSet);
            bitSetToReg.put(tempSet, reg);
         }
      }
   }

   private void maskColors()
   {
      int i = 0;

      for (String color : kAvailableRegs)
      {
         BitSet tempSet = new BitSet(numRegs);
         tempSet.set(i++);

         colorToBitSet.put(color, tempSet);
         bitSetToColor.put(tempSet, color);

         allColors.or(tempSet);
      }
   }

   private class LocalInfo
   {
      public BitSet gen;
      public BitSet kill;
      public BitSet liveout;

      public LocalInfo()
      {
         gen = new BitSet(numRegs);
         kill = new BitSet(numRegs);
         liveout = new BitSet(numRegs);
      }
   }

   private class Node
   {
      public BitSet color;
      public BitSet edges;
      public boolean mark;

      public Node()
      {
         color = new BitSet(numRegs);
         edges = new BitSet(numRegs);
         mark = false;
      }
   }

   private class SpillException extends Exception
   {
   }
}
