/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_print extends Instruction
{
   private static String opcode = "print";
   private Register src;

   public Inst_print(Register src)
   {
      super();
      this.src = src;

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

   public Register getsrc()
   {
      return src;
   }

   public void setAddr0(Register val)
   {
      this.src = val;
   }

   public void setsrc(Register val)
   {
      this.src = val;
   }

   public String toString()
   {
      return (opcode + " " +  src );
   }

}
