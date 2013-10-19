/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_mov extends Instruction
{
   private static String opcode = "mov";
   private Register src;
   private Register dst;

   public Inst_mov(Register src, Register dst)
   {
      super();
      this.src = src;
      this.dst = dst;

      super.addSource(src);
      super.addTarget(dst);
   }

   public void replaceSource(Register victim, Register toReplace)
   {
      if (victim == src)
      {
         super.removeSource(src);
         super.addSource(toReplace);
         src = toReplace;
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
      return src;
   }

   public Register getAddr1()
   {
      return dst;
   }

   public Register getsrc()
   {
      return src;
   }

   public Register getdst()
   {
      return dst;
   }

   public void setAddr0(Register val)
   {
      this.src = val;
   }

   public void setAddr1(Register val)
   {
      this.dst = val;
   }

   public void setsrc(Register val)
   {
      this.src = val;
   }

   public void setdst(Register val)
   {
      this.dst = val;
   }

   public String toString()
   {
      return (opcode + " " +  src + ", " + dst );
   }

}
