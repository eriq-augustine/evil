/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_storeglobal extends Instruction
{
   private static String opcode = "storeglobal";
   private Register src;
   private String globalName;

   public Inst_storeglobal(Register src, String globalName)
   {
      super();
      this.src = src;
      this.globalName = globalName;

      super.addSource(src);
   }

   public void replaceSource(Register victim, Register toReplace)
   {
      if (victim == src)
      {
         super.removeSource(src);
         super.addSource(toReplace);
         src = toReplace;
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
      return src;
   }

   public String getAddr1()
   {
      return globalName;
   }

   public Register getsrc()
   {
      return src;
   }

   public String getglobalName()
   {
      return globalName;
   }

   public void setAddr0(Register val)
   {
      this.src = val;
   }

   public void setAddr1(String val)
   {
      this.globalName = val;
   }

   public void setsrc(Register val)
   {
      this.src = val;
   }

   public void setglobalName(String val)
   {
      this.globalName = val;
   }

   public String toString()
   {
      return (opcode + " " +  src + ", " + globalName );
   }

}
