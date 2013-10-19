/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_read extends Instruction
{
   private static String opcode = "read";
   private Register addr;

   public Inst_read(Register addr)
   {
      super();
      this.addr = addr;

      super.addSource(addr);
   }

   public void replaceSource(Register victim, Register toReplace)
   {
      if (victim == addr)
      {
         super.removeSource(addr);
         super.addSource(toReplace);
         addr = toReplace;
      }
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
      return addr;
   }

   public Register getaddr()
   {
      return addr;
   }

   public void setAddr0(Register val)
   {
      this.addr = val;
   }

   public void setaddr(Register val)
   {
      this.addr = val;
   }

   public String toString()
   {
      return (opcode + " " +  addr );
   }

}
