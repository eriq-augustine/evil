/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_loadai extends Instruction
{
   private static String opcode = "loadai";
   private Register src;
   private String offset;
   private Register dest;
   private String struct;

   public Inst_loadai(Register src, String offset, Register dest, String struct)
   {
      super();
      this.src = src;
      this.offset = offset;
      this.dest = dest;
      this.struct = struct;

      super.addSource(src);
      super.addTarget(dest);
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
      return offset;
   }

   public Register getAddr2()
   {
      return dest;
   }

   public Register getsrc()
   {
      return src;
   }

   public String getoffset()
   {
      return offset;
   }

   public Register getdest()
   {
      return dest;
   }

   public void setAddr0(Register val)
   {
      this.src = val;
   }

   public void setAddr1(String val)
   {
      this.offset = val;
   }

   public void setAddr2(Register val)
   {
      this.dest = val;
   }

   public void setsrc(Register val)
   {
      this.src = val;
   }

   public void setoffset(String val)
   {
      this.offset = val;
   }

   public void setdest(Register val)
   {
      this.dest = val;
   }

   public String toString()
   {
      return (opcode + " " +  src + ", " + offset + ", " + dest );
   }

   public String getExtraInfo()
   {
      return struct;
   }

   public String getstruct()
   {
      return struct;
   }

}
