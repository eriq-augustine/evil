/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_loadi extends Instruction
{
   private static String opcode = "loadi";
   private int imm;
   private Register dst;

   public Inst_loadi(int imm, Register dst)
   {
      super();
      this.imm = imm;
      this.dst = dst;

      super.addTarget(dst);
   }

   public void replaceSource(Register victim, Register toReplace)
   {
   }

   public String getOp()
   {
      return opcode;
   }

   public String getOpcode()
   {
      return opcode;
   }

   public int getAddr0()
   {
      return imm;
   }

   public Register getAddr1()
   {
      return dst;
   }

   public int getimm()
   {
      return imm;
   }

   public Register getdst()
   {
      return dst;
   }

   public void setAddr0(int val)
   {
      this.imm = val;
   }

   public void setAddr1(Register val)
   {
      this.dst = val;
   }

   public void setimm(int val)
   {
      this.imm = val;
   }

   public void setdst(Register val)
   {
      this.dst = val;
   }

   public String toString()
   {
      return (opcode + " " +  imm + ", " + dst );
   }

}
