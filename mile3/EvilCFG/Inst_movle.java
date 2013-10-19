/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_movle implements Instruction
{
   private static String opcode = "movle";
   private int imm;
   private Register dst;

   public Inst_movle(int imm, Register dst)
   {
      this.imm = imm;
      this.dst = dst;
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
