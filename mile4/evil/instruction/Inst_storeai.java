/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package evil.instruction;

public class Inst_storeai extends Instruction
{
   private static String opcode = "storeai";
   private Register trg;
   private Register src;
   private String offset;
   private String struct;

   public Inst_storeai(Register trg, Register src, String offset, String struct)
   {
      super();
      this.trg = trg;
      this.src = src;
      this.offset = offset;
      this.struct = struct;

      super.addSource(trg);
      super.addSource(src);
   }

   public void replaceSource(Register victim, Register toReplace)
   {
      if (victim == trg)
      {
         super.removeSource(trg);
         super.addSource(toReplace);
         trg = toReplace;
      }
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
      return trg;
   }

   public Register getAddr1()
   {
      return src;
   }

   public String getAddr2()
   {
      return offset;
   }

   public Register gettrg()
   {
      return trg;
   }

   public Register getsrc()
   {
      return src;
   }

   public String getoffset()
   {
      return offset;
   }

   public void setAddr0(Register val)
   {
      this.trg = val;
   }

   public void setAddr1(Register val)
   {
      this.src = val;
   }

   public void setAddr2(String val)
   {
      this.offset = val;
   }

   public void settrg(Register val)
   {
      this.trg = val;
   }

   public void setsrc(Register val)
   {
      this.src = val;
   }

   public void setoffset(String val)
   {
      this.offset = val;
   }

   public String toString()
   {
      return (opcode + " " +  trg + ", " + src + ", " + offset );
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
