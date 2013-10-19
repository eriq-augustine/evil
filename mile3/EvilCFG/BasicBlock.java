/**
 * A basic block!
 */

package EvilCFG;

import java.util.ArrayList;
import java.util.Stack;

public class BasicBlock
{
   private static int blockCount = 0;
   private static boolean mark = true;
   private static ArrayList<BasicBlock> allBlocks = new ArrayList<BasicBlock>();

   private int id;
   private boolean visited;
   private String tag;
   private ArrayList<Instruction> instructions;
   private ArrayList<BasicBlock> kids;
   private ArrayList<BasicBlock> parents;

   public BasicBlock()
   {
      id = blockCount++;
      tag = Integer.toString(id);
      instructions = new ArrayList<Instruction>();
      kids = new ArrayList<BasicBlock>();
      parents = new ArrayList<BasicBlock>();

      visited = mark;
      allBlocks.add(this);
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
   }

   public void addParent(BasicBlock toAdd)
   {
      parents.add(toAdd);
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
            addInstruction(new Inst_jmp(end.getTag()));
            kids.add(end);
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
}

/*public class Encapsulate {
   private Register reg;
   private BasicBlock bBlock;
   
   public Encapsulate(Register reg_, BasicBlock bBlock_)
   {
      reg = reg_;
      bBlock = bBlock_;
   }
   
   public Register getReg()
   {
      return reg;
   }
   public BasicBlock getbBlock()
   {
      return bBlock;
   }
   public void setReg(Register r)
   {
      reg = r;
   }
   public void setbBlock(BasicBlock b)
   {
      bBlock = b;
   }
   public void addInstruction(Instruction i)
   {
      bBlock.addInstruction(i);
   }
   public void addKid(BasicBlock b)
   {
      bBlock.addKid(b);
   }
   public void addParent(BasicBlock b)
   {
      bBlock.addParent(b);
   }
   public void addCommonEnd(BasicBlock b)
   {
      bBlock.addCommonEnd(b);
   }
}*/

