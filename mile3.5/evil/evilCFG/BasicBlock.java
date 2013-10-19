/**
 * A basic block!
 */

package evil.evilCFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintStream;
import java.util.Stack;
import evil.instruction.*;

public class BasicBlock
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

   public BasicBlock()
   {
      id = blockCount++;
      tag = kTagPrefix + Integer.toString(id);
      instructions = new ArrayList<Instruction>();
      kids = new ArrayList<BasicBlock>();
      parents = new ArrayList<BasicBlock>();
      root = this;
      regMapping = new HashMap<String, Register>();

      visited = mark;
      allBlocks.add(this);
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

      visited = mark;
      allBlocks.add(this);
   }

   public Register getMapping(String key)
   {
      return root.regMapping.get(key);
   }

   public boolean containsMapping(String key)
   {
      return root.regMapping.containsKey(key);
   }

   public void addMapping(String key, Register value)
   {
      root.regMapping.put(key, value);
   }

   public BasicBlock getbBlock()
   {
      return this;
   }

   public String getTag()
   {
      return tag;
   }

   public void addInstruction(Instruction toAdd)
   {
      instructions.add(toAdd);
   }
   
   private void remark()
   {
      for (BasicBlock i : allBlocks)
      {
         i.visited = mark;
      }
   }

   public void addKid(BasicBlock toAdd)
   {
      kids.add(toAdd);
      toAdd.root = root;
   }

   public void addParent(BasicBlock toAdd)
   {
      parents.add(toAdd);
      root = toAdd.root;
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
}


