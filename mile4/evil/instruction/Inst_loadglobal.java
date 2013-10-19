/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_loadglobal extends Instruction
{
   private static String opcode = "loadglobal";
   private String globalName;
   private Register trg;

   public Inst_loadglobal(String globalName, Register trg)
   {
      super();
      this.globalName = globalName;
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
      return globalName;
   }

   public Register getAddr1()
   {
      return trg;
   }

   public String getglobalName()
   {
      return globalName;
   }

   public Register gettrg()
   {
      return trg;
   }

   public void setAddr0(String val)
   {
      this.globalName = val;
   }

   public void setAddr1(Register val)
   {
      this.trg = val;
   }

   public void setglobalName(String val)
   {
      this.globalName = val;
   }

   public void settrg(Register val)
   {
      this.trg = val;
   }

   public String toString()
   {
      return (opcode + " " +  globalName + ", " + trg );
   }

}
