/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_div extends Instruction
{
   private static String opcode = "div";
   private Register src1;
   private Register src2;
   private Register dst;

   public Inst_div(Register src1, Register src2, Register dst)
   {
      super();
      this.src1 = src1;
      this.src2 = src2;
      this.dst = dst;

      super.addSource(src1);
      super.addSource(src2);
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
      if (victim == src2)
      {
         super.removeSource(src2);
         super.addSource(toReplace);
         src2 = toReplace;
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

   public Register getAddr1()
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

   public Register getsrc2()
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

   public void setAddr1(Register val)
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

   public void setsrc2(Register val)
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
