/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_call extends Instruction
{
   private static String opcode = "call";
   private String label;

   public Inst_call(String label)
   {
      super();
      this.label = label;

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

   public String getAddr0()
   {
      return label;
   }

   public String getlabel()
   {
      return label;
   }

   public void setAddr0(String val)
   {
      this.label = val;
   }

   public void setlabel(String val)
   {
      this.label = val;
   }

   public String toString()
   {
      return (opcode + " " +  label );
   }

}
