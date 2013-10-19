/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_print implements Instruction
{
   private static String opcode = "print";
   private Register src;

   public Inst_print(Register src)
   {
      this.src = src;
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
