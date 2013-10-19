/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_jmp implements Instruction
{
   private static String opcode = "jmp";
   private String label;

   public Inst_jmp(String label)
   {
      this.label = label;
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
