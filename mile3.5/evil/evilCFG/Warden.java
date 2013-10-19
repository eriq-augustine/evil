/**
 * Holds a Register and a Basic block to help with returning in antlr
 */
 
package evil.evilCFG;

import evil.instruction.*;

public class Warden {
   private Register reg;
   private BasicBlock bBlock;

   public Warden(Register reg_, BasicBlock bBlock_)
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
}
