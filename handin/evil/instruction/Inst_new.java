/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_new extends Instruction
{
   private static String opcode = "new";
   private String structName;
   private String fields;
   private Register dest;
   private String structname;

   public Inst_new(String structName, String fields, Register dest, String structname)
   {
      super();
      this.structName = structName;
      this.fields = fields;
      this.dest = dest;
      this.structname = structname;

      super.addTarget(dest);
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
      return structName;
   }

   public String getAddr1()
   {
      return fields;
   }

   public Register getAddr2()
   {
      return dest;
   }

   public String getstructName()
   {
      return structName;
   }

   public String getfields()
   {
      return fields;
   }

   public Register getdest()
   {
      return dest;
   }

   public void setAddr0(String val)
   {
      this.structName = val;
   }

   public void setAddr1(String val)
   {
      this.fields = val;
   }

   public void setAddr2(Register val)
   {
      this.dest = val;
   }

   public void setstructName(String val)
   {
      this.structName = val;
   }

   public void setfields(String val)
   {
      this.fields = val;
   }

   public void setdest(Register val)
   {
      this.dest = val;
   }

   public String toString()
   {
      return (opcode + " " +  structName + ", " + fields + ", " + dest );
   }

   public String getExtraInfo()
   {
      return structname;
   }

   public String getstructname()
   {
      return structname;
   }

}
