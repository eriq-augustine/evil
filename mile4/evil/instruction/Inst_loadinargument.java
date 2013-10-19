/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_loadinargument extends Instruction
{
   private static String opcode = "loadinargument";
   private String label;
   private int paramNumber;
   private Register trg;

   public Inst_loadinargument(String label, int paramNumber, Register trg)
   {
      super();
      this.label = label;
      this.paramNumber = paramNumber;
      this.trg = trg;

      super.addTarget(trg);
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

   public int getAddr1()
   {
      return paramNumber;
   }

   public Register getAddr2()
   {
      return trg;
   }

   public String getlabel()
   {
      return label;
   }

   public int getparamNumber()
   {
      return paramNumber;
   }

   public Register gettrg()
   {
      return trg;
   }

   public void setAddr0(String val)
   {
      this.label = val;
   }

   public void setAddr1(int val)
   {
      this.paramNumber = val;
   }

   public void setAddr2(Register val)
   {
      this.trg = val;
   }

   public void setlabel(String val)
   {
      this.label = val;
   }

   public void setparamNumber(int val)
   {
      this.paramNumber = val;
   }

   public void settrg(Register val)
   {
      this.trg = val;
   }

   public String toString()
   {
      return (opcode + " " +  label + ", " + paramNumber + ", " + trg );
   }

}
