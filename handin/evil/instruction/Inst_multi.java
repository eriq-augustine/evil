/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_multi extends Instruction
{
   private static String opcode = "multi";
   private Register src1;
   private int src2;
   private Register dst;

   public Inst_multi(Register src1, int src2, Register dst)
   {
      super();
      this.src1 = src1;
      this.src2 = src2;
      this.dst = dst;

      super.addSource(src1);
      super.addTarget(dst);
   }

   public void replaceSource(Register victim, Register toReplace)
   {
      if (victim == src1)
      {
         super.removeSource(src1);
         super.addSource(toReplace);
         src1 = toReplace;
      }
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

   public int getAddr1()
   {
      return src2;
   }

   public Register getAddr2()
   {
      return dst;
   }

   public Register getsrc1()
   {
      return src1;
   }

   public int getsrc2()
   {
      return src2;
   }

   public Register getdst()
   {
      return dst;
   }

   public void setAddr0(Register val)
   {
      this.src1 = val;
   }

   public void setAddr1(int val)
   {
      this.src2 = val;
   }

   public void setAddr2(Register val)
   {
      this.dst = val;
   }

   public void setsrc1(Register val)
   {
      this.src1 = val;
   }

   public void setsrc2(int val)
   {
      this.src2 = val;
   }

   public void setdst(Register val)
   {
      this.dst = val;
   }

   public String toString()
   {
      return (opcode + " " +  src1 + ", " + src2 + ", " + dst );
   }

}
