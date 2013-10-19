/**
 * A basic block!
 */

package evil.evilCFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintStream;
import java.util.Stack;
import evil.instruction.*;
import java.util.Iterator;
import java.util.HashSet;

public class BasicBlock implements Iterable<BasicBlock>
{
   private static int blockCount = 0;
   private static boolean mark = true;
   private static ArrayList<BasicBlock> allBlocks = new ArrayList<BasicBlock>();
   private static final String kTagPrefix = "TAG";

   private int id;
   private boolean visited;
   private String tag;
   private BasicBlock root;
   private ArrayList<Instruction> instructions;
   private ArrayList<BasicBlock> kids;
   private ArrayList<BasicBlock> parents;
   private HashMap<String, Register> regMapping;
   private ArrayList<String> visitedValues;

   public BasicBlock()
   {
      id = blockCount++;
      tag = kTagPrefix + Integer.toString(id);
      instructions = new ArrayList<Instruction>();
      kids = new ArrayList<BasicBlock>();
      parents = new ArrayList<BasicBlock>();
      root = this;
      regMapping = new HashMap<String, Register>();
      visitedValues = new ArrayList<String>();

      visited = mark;
      allBlocks.add(this);
   }

   public ArrayList<Register> getAllRegs()
   {
         ArrayList<Register> allRegs = new ArrayList<Register>();
         HashSet<Register> h = new HashSet<Register>();
         Stack<BasicBlock> stk = new Stack<BasicBlock>();
         remark();
         mark = !mark;
         root.markedTopo(stk);
         for (BasicBlock block : stk)
         {
            for(Instruction ins : block.getInstructions())
            {
                h.addAll(ins.getSources());
                h.addAll(ins.getTargets());
            }
         }
         allRegs.addAll(h);
         return allRegs;
   }

   public BasicBlock(String tag)
   {
      id = blockCount++;
      this.tag = tag;
      instructions = new ArrayList<Instruction>();
      kids = new ArrayList<BasicBlock>();
      parents = new ArrayList<BasicBlock>();
      root = this;
      regMapping = new HashMap<String, Register>();
      visitedValues = new ArrayList<String>();

      visited = mark;
      allBlocks.add(this);
   }

   public static ArrayList<BasicBlock> getAllBlocks()
   {
      return allBlocks;
   }

   public Register getMapping(String key)
   {
      root.visitedValues.add(key);
      return root.regMapping.get(key);
   }

   public boolean isVisited(String key)
   {
      return root.visitedValues.contains(key);
   }

   public boolean containsMapping(String key)
   {
      return root.regMapping.containsKey(key);
   }

   public void addMapping(String key, Register value)
   {
      root.regMapping.put(key, value);
      root.visitedValues.add(key);
   }

   public BasicBlock getbBlock()
   {
      return this;
   }

   public String getTag()
   {
      return tag;
   }

   public ArrayList<Instruction> getInstructions()
   {
      return instructions;
   }

   public ArrayList<FakeInstruction> getFakeInstructions()
   {
      ArrayList<FakeInstruction> fakes = new ArrayList<FakeInstruction>();

      for (Instruction inst : instructions)
      {
         if (inst instanceof FakeInstruction)
         {
            fakes.add(((FakeInstruction)(inst)));
         }
      }

      return fakes;
   }

   public void addInstruction(Instruction toAdd)
   {
      instructions.add(toAdd);
   }
   
   private static void remark()
   {
      for (BasicBlock i : allBlocks)
      {
         i.visited = mark;
      }
   }

   public void addKid(BasicBlock toAdd)
   {
      if (!kids.contains(toAdd))
      {
         kids.add(toAdd);
         toAdd.root = root;
      }
   }

   public ArrayList<BasicBlock> getKids()
   {
      return kids;
   }

   public ArrayList<BasicBlock> getParents()
   {
      return parents;
   }

   public void setParents(ArrayList<BasicBlock> blks)
   {
      parents = blks;
   }

   public void setKids(ArrayList<BasicBlock> blks)
   {
      kids = blks;
   }

   public void addParent(BasicBlock toAdd)
   {
      if (!parents.contains(toAdd))
      {
         parents.add(toAdd);
         root = toAdd.root;
      }
   }

   public String toString()
   {
      String rtn = new String();

      rtn += ("Block ID: " + id + ", tag: " + tag + "\n");

      for (Instruction i : instructions)
      {
         rtn += (i.toString() + "\n");
      }

      return rtn;
   }

   public String fullToString()
   {
      String rtn = new String();
      Stack<BasicBlock> stk = new Stack<BasicBlock>();
      
      mark = !mark;
      markedTopo(stk);

      BasicBlock temp;

      rtn += "Passed in Graph (usually main):\n";
      while (!stk.isEmpty())
      {
         temp = stk.pop();

         rtn += (temp.toString() + "\n");
      }

      //All unreached blocks, usually functions.
      rtn += "All unreached nodes (usually functions):\n";
      for (BasicBlock i : allBlocks)
      {
         if (i.visited != mark)
         {
            rtn += (i.toString() + "\n");
         }
      }

      remark();

      return rtn;
   }

   //topo-sort plz
   private void markedTopo(Stack<BasicBlock> stk)
   {
      visited = mark;
      
      for (BasicBlock bb : kids)
      {
         if (bb.visited != mark)
         {
            bb.markedTopo(stk);
         }
      }

      stk.push(this);
   }

/*
   private String fullToStringHelp(String base)
   {
      String rtn = new String();

      rtn += (baseToString(base) + "\n");
      base += "  ";

      for (BasicBlock bb : kids)
      {
         rtn += (bb.fullToStringHelp(base) + "\n");
      }
      
      return rtn;
   }
*/

   private String baseToString(String base)
   {
      String rtn = new String();

      rtn += (base + "Block ID: " + id + ", tag: " + tag + "\n");

      for (Instruction i : instructions)
      {
         rtn += (base + i.toString() + "\n");
      }

      return rtn;
   }

   //Ends all children who do not have a child with a common end block.
   // Think: function exit block.

   public void addCommonEnd(BasicBlock end)
   {
      remark();
      mark = !mark;
      
      addCommonEndHelp(end);
      
      remark();
   }

   private void addCommonEndHelp(BasicBlock end)
   {
      if (this != end && visited != mark)
      {
         visited = mark;

         if (kids.isEmpty())
         {
            //Jump to the common end.
            addInstruction(new Inst_jumpi(end.getTag()));
            addKid(end);
            end.addParent(this);
         }
         else
         {
            for (BasicBlock i : kids)
            {
               i.addCommonEndHelp(end);
            }
         }
      }
   }

   /**
    * Dump Instructions into a file in the proper format.
    * All function entry blocks shoud start with the FakeInstruction: "ENTRY <function name>"
    * and all function exit blocks should end with the FakeInstruction: "EXIT <function name>"
    *
    * If sym is not null, print a mochi header
    */
   public static void dumpInstructions(PrintStream outStream, SymbolTable sym)
   {
      String tab = "        ";
      BasicBlock temp;

      //Print a mochi header.
      if (sym != null)
      {
         for(Function fun : sym.getFunctions())
         {
            String name = fun.getName();

            //Print function declaration
            outStream.println("@function " + name);
         }
         for (Function fun : sym.getFunctions())
         {
            String name = fun.getName();

            //print formals
            for (String local : fun.getFormals())
            {
               outStream.println("@local " + name + ":" + local);
            }
            
            //Print locals.
            for (String local : fun.getLocals())
            {
               outStream.println("@local " + name + ":" + local);
            }
            outStream.println();
         }
      }

      //Toggle the marker.
      remark();
      mark = !mark;

      //FOR all blocks
      for (BasicBlock block : allBlocks)
      {
         //IF block has not been visited yet.
         if (block.visited != mark)
         {
            //Topologically print its intructions using the proper tab size.
            
            Stack<BasicBlock> stk = new Stack<BasicBlock>();
            block.markedTopo(stk);

            while (!stk.isEmpty())
            {
               temp = stk.pop();

               //Printout tag.
               outStream.println(temp.tag + ":");

               for (Instruction inst : temp.instructions)
               {
                  //IF first instruction
                  if (inst.toString().contains("ENTRY:"))
                  {
                     //outStream.println(inst.toString().trim().replaceFirst("ENTRY: ", "") + ":");
                     //outStream.println();
                  }
                  //ELSEIF is last instruction
                  else if (inst.toString().contains("EXIT:"))
                  {
                     outStream.println();
                  }
                  else
                  {
                     outStream.println(tab + inst);
                  }
               }
            }
         }
      }
   }

   public BasicBlock getTopBlock()
   {
      return allBlocks.get(0);
   }

   public ArrayList<BasicBlock> getTopoCFG()
   {
      Stack<BasicBlock> stk = new Stack<BasicBlock>();
      ArrayList<BasicBlock> blks = new ArrayList<BasicBlock>();

      remark();
      mark = !mark;

      root.markedTopo(stk);

      while (!stk.isEmpty())
      {
         blks.add(stk.pop());
      }

      return blks;
   }

   public ArrayList<BasicBlock> getReverseTopoCFG()
   {
      Stack<BasicBlock> stk = new Stack<BasicBlock>();
      ArrayList<BasicBlock> blks = new ArrayList<BasicBlock>();

      remark();
      mark = !mark;

      root.markedTopo(stk);

      while (!stk.isEmpty())
      {
         blks.add(0, stk.pop());
      }

      return blks;
   }

   public void setInstructions(ArrayList<Instruction> insts)
   {
      instructions = insts;
   }

   public static ArrayList<ArrayList<BasicBlock>> getAllCFGs()
   {
      ArrayList<ArrayList<BasicBlock>> allCFGs = new ArrayList<ArrayList<BasicBlock>>();

      remark();
      mark = !mark;

      for (BasicBlock blk : allBlocks)
      {
         if (blk.visited != mark)
         {
            ArrayList<BasicBlock> temp = new ArrayList<BasicBlock>();
            blk.helpGetCFG(temp);

            allCFGs.add(temp);
         }
      }
      return allCFGs;
   }

   public ArrayList<BasicBlock> getCFG()
   {
      ArrayList<BasicBlock> blks = new ArrayList<BasicBlock>();
      
      remark();
      mark = !mark;

      root.helpGetCFG(blks);

      return blks;
   }

   private void helpGetCFG(ArrayList<BasicBlock> blks)
   {
      if (visited != mark)
      {
         blks.add(this);
         visited = mark;

         for (BasicBlock kid : kids)
         {
            kid.helpGetCFG(blks);
         }
      }
   }

   public Iterator<BasicBlock> iterator()
   {
      return new BlockIterator();
   }

   private class BlockIterator implements Iterator<BasicBlock>
   {
      private Stack<BasicBlock> stk;

      public BlockIterator()
      {
         stk = new Stack<BasicBlock>();

         remark();
         mark = !mark;

         for (BasicBlock block : allBlocks)
         {
            if (block.visited != mark)
            {
               block.markedTopo(stk);
            }
         }
      }

      public boolean hasNext()
      {  
         return !stk.isEmpty();
      }

      public BasicBlock next()
      {
         return stk.pop();
      }

      public void remove()
      {
         throw new java.util.NoSuchElementException();
      }
   }

   public boolean isEntry()
   {
      return parents.isEmpty();
   }

   public boolean isExit()
   {
      return kids.isEmpty();
   }

   public String getFunName()
   {
      return root.tag;
   }

   public int getMostArgs(SymbolTable sym)
   {
      int mostArgs = 0;

      remark();
      mark = !mark;

      Stack<BasicBlock> stk = new Stack<BasicBlock>();
      root.markedTopo(stk);

      for (BasicBlock block : stk)
      {
         for (Instruction inst : block.instructions)
         {
            if (inst instanceof Inst_call)
            {
               int numArgs = ((Function)(sym.get(((Inst_call)(inst)).getAddr0()))).getFormals().size();

               if (numArgs > mostArgs)
               {
                  mostArgs = numArgs;
               }
            }
         }
      }

      return mostArgs;
   }

   public static void printRelations()
   {
      for (BasicBlock block : allBlocks)
      {
         System.out.println(block.id);
         System.out.print("   Parents: ");

         for (BasicBlock i : block.parents)
         {
            System.out.print(i.id + ", ");
         }
         System.out.println();
         
         System.out.print("   Kids: ");

         for (BasicBlock i : block.kids)
         {
            System.out.print(i.id + ", ");
         }
         System.out.println();
         System.out.println();
      }
   }

   public boolean equals(Object other)
   {
      if (other == null || !(other instanceof BasicBlock))
      {
         return false;
      }

      return id == ((BasicBlock)(other)).id;
   }

   public void sanityCheck() throws SanityException
   {
      //Check that every parent/child relation is mutual.
      for (BasicBlock block : allBlocks)
      {
         for (BasicBlock parent : block.parents)
         {
            if (!parent.kids.contains(block))
            {
               throw new SanityException("Block: " + parent.getTag() + 
                " does not acknowledge block: " + block.getTag() + 
                " as its child.");
            }
         }
         
         for (BasicBlock kid : block.kids)
         {
            if (!kid.parents.contains(block))
            {
               throw new SanityException("Block: " + kid.getTag() + 
                " does not acknowledge block: " + block.getTag() + 
                " as its parent.");
            }
         }
      }

      //Check that every cfg has one entry and one end.
      ArrayList<ArrayList<BasicBlock>> allCFGs = getAllCFGs();
      for (ArrayList<BasicBlock> cfg : allCFGs)
      {
         boolean headFound = false;
         boolean tailFound = false;

         for (BasicBlock block : cfg)
         {
            if (block.parents.size() == 0)
            {
               if (headFound)
               {
                  throw new SanityException("Block: " + block.tag + 
                   " is duplicate entry within function: " + block.root.tag);
               }
               
               headFound = true;
            }
            
            if (block.kids.size() == 0)
            {
               if (tailFound)
               {
                  throw new SanityException("Block: " + block.tag + 
                   " is duplicate exit within function: " + block.root.tag);
               }
               
               tailFound = true;
            }
         }
      }
   }

   public class SanityException extends Exception
   {
      public SanityException(String msg)
      {
         super(msg);
      }
   }
}


