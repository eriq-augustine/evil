/**
 * Holds a Register and a Basic block to help with returning in antlr
 */
 
package evil.evilCFG;

import evil.instruction.*;

public class Warden {
   private Register reg;
   private BasicBlock bBlock;
   private String extraInfo;
   private int constant;
   private boolean hasConstant;

   public Warden(Register reg_, BasicBlock bBlock_)
   {
      hasConstant = false;

      reg = reg_;
      bBlock = bBlock_;
      extraInfo = new String();
   }

   public Warden(int constant, Register reg_, BasicBlock bBlock_)
   {
      hasConstant = true;

      this.constant = constant;
      reg = reg_;
      bBlock = bBlock_;
      extraInfo = new String();
   }

   public String getExtraInfo()
   {
      return extraInfo;
   }

   public void setExtraInfo(String info)
   {
      extraInfo = info;
   }

   public Register getReg()
   {
      return reg;
   }

   public boolean hasConstant()
   {
      return hasConstant;
   }

   public int getConstant()
   {
      if (!hasConstant)
      {
         throw new NoConstantException("No CONSTANT!");
      }
      return constant;
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

   public class NoConstantException extends RuntimeException
   {
      public NoConstantException(String msg)
      {
         super(msg);
      }
   }
}
