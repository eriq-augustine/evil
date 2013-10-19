/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_computeglobaladdress extends Instruction
{
   private static String opcode = "computeglobaladdress";
   private String name;
   private Register dst;

   public Inst_computeglobaladdress(String name, Register dst)
   {
      super();
      this.name = name;
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

   public String getAddr0()
   {
      return name;
   }

   public Register getAddr1()
   {
      return dst;
   }

   public String getname()
   {
      return name;
   }

   public Register getdst()
   {
      return dst;
   }

   public void setAddr0(String val)
   {
      this.name = val;
   }

   public void setAddr1(Register val)
   {
      this.dst = val;
   }

   public void setname(String val)
   {
      this.name = val;
   }

   public void setdst(Register val)
   {
      this.dst = val;
   }

   public String toString()
   {
      return (opcode + " " +  name + ", " + dst );
   }

}
