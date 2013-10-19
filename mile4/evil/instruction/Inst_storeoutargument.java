/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_storeoutargument extends Instruction
{
   private static String opcode = "storeoutargument";
   private Register src;
   private int paramNumber;

   public Inst_storeoutargument(Register src, int paramNumber)
   {
      super();
      this.src = src;
      this.paramNumber = paramNumber;

      super.addSource(src);
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

   public int getAddr1()
   {
      return paramNumber;
   }

   public Register getsrc()
   {
      return src;
   }

   public int getparamNumber()
   {
      return paramNumber;
   }

   public void setAddr0(Register val)
   {
      this.src = val;
   }

   public void setAddr1(int val)
   {
      this.paramNumber = val;
   }

   public void setsrc(Register val)
   {
      this.src = val;
   }

   public void setparamNumber(int val)
   {
      this.paramNumber = val;
   }

   public String toString()
   {
      return (opcode + " " +  src + ", " + paramNumber );
   }

}
