/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_ret extends Instruction
{
   private static String opcode = "ret";

   public Inst_ret()
   {
      super();

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

   public String toString()
   {
      return (opcode );
   }

}
