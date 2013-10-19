/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_loadret extends Instruction
{
   private static String opcode = "loadret";
   private Register dst;

   public Inst_loadret(Register dst)
   {
      super();
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

   public Register getAddr0()
   {
      return dst;
   }

   public Register getdst()
   {
      return dst;
   }

   public void setAddr0(Register val)
   {
      this.dst = val;
   }

   public void setdst(Register val)
   {
      this.dst = val;
   }

   public String toString()
   {
      return (opcode + " " +  dst );
   }

}
