/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_read implements Instruction
{
   private static String opcode = "read";
   private Register addr;

   public Inst_read(Register addr)
   {
      this.addr = addr;
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
