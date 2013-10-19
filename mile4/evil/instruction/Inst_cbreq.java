/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_cbreq extends Instruction
{
   private static String opcode = "cbreq";
   private String label1;
   private String label2;

   public Inst_cbreq(String label1, String label2)
   {
      super();
      this.label1 = label1;
      this.label2 = label2;

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
      return label1;
   }

   public String getAddr1()
   {
      return label2;
   }

   public String getlabel1()
   {
      return label1;
   }

   public String getlabel2()
   {
      return label2;
   }

   public void setAddr0(String val)
   {
      this.label1 = val;
   }

   public void setAddr1(String val)
   {
      this.label2 = val;
   }

   public void setlabel1(String val)
   {
      this.label1 = val;
   }

   public void setlabel2(String val)
   {
      this.label2 = val;
   }

   public String toString()
   {
      return (opcode + " " +  label1 + ", " + label2 );
   }

}
