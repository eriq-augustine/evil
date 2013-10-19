/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_comp implements Instruction
{
   private static String opcode = "comp";
   private Register src1;
   private Register src2;

   public Inst_comp(Register src1, Register src2)
   {
      this.src1 = src1;
      this.src2 = src2;
   }

   public String getOp()
   {
      return opcode;
   }

   public String getOpcode()
   {
      return opcode;
   }

   public Register getAddr0()
   {
      return src1;
   }

   public Register getAddr1()
   {
      return src2;
   }

   public Register getsrc1()
   {
      return src1;
   }

   public Register getsrc2()
   {
      return src2;
   }

   public void setAddr0(Register val)
   {
      this.src1 = val;
   }

   public void setAddr1(Register val)
   {
      this.src2 = val;
   }

   public void setsrc1(Register val)
   {
      this.src1 = val;
   }

   public void setsrc2(Register val)
   {
      this.src2 = val;
   }

   public String toString()
   {
      return (opcode + " " +  src1 + ", " + src2 );
   }

}
