/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package EvilCFG;

public class Inst_funcode implements Instruction
{
   private static String opcode = "funcode";
   private Register field1;
   private String field2;
   private int filed3;

   public Inst_funcode(Register field1, String field2, int filed3)
   {
      this.field1 = field1;
      this.field2 = field2;
      this.filed3 = filed3;
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
      return field1;
   }

   public String getAddr1()
   {
      return field2;
   }

   public int getAddr2()
   {
      return filed3;
   }

   public Register getfield1()
   {
      return field1;
   }

   public String getfield2()
   {
      return field2;
   }

   public int getfiled3()
   {
      return filed3;
   }

   public void setAddr0(Register val)
   {
      this.field1 = val;
   }

   public void setAddr1(String val)
   {
      this.field2 = val;
   }

   public void setAddr2(int val)
   {
      this.filed3 = val;
   }

   public void setfield1(Register val)
   {
      this.field1 = val;
   }

   public void setfield2(String val)
   {
      this.field2 = val;
   }

   public void setfiled3(int val)
   {
      this.filed3 = val;
   }

   public String toString()
   {
      return (opcode + " " +  field1 + ", " + field2 + ", " + filed3 );
   }

}
