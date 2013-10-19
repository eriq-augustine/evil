/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_new implements Instruction
{
   private static String opcode = "new";
   private String label;
   private Register dst;

   public Inst_new(String label, Register dst)
   {
      this.label = label;
      this.dst = dst;
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

   public Register getAddr1()
   {
      return dst;
   }

   public String getlabel()
   {
      return label;
   }

   public Register getdst()
   {
      return dst;
   }

   public void setAddr0(String val)
   {
      this.label = val;
   }

   public void setAddr1(Register val)
   {
      this.dst = val;
   }

   public void setlabel(String val)
   {
      this.label = val;
   }

   public void setdst(Register val)
   {
      this.dst = val;
   }

   public String toString()
   {
      return (opcode + " " +  label + ", " + dst );
   }

}
