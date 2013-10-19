/**
  * Eriq Augustine / Evan Ralston
  * Automaticly generated Instruction file
  */

package Instruction;

public class Inst_opcode implements Instruction
{
   private String opcode;
   private String field1;
   private String field2;
   private String filed3;

   public String getOp()
   {
      return opcode;
   }

   public String getopcode()
   {
      return opcode;
   }

   public String getAddr0()
   {
      return field1;
   }

   public String getAddr1()
   {
      return field2;
   }

   public String getAddr2()
   {
      return filed3;
   }

   public String getfield1()
   {
      return field1;
   }

   public String getfield2()
   {
      return field2;
   }

   public String getfiled3()
   {
      return filed3;
   }

   public void setAddr0(String name)
   {
      field1 = name;
   }

   public void setAddr1(String name)
   {
      field2 = name;
   }

   public void setAddr2(String name)
   {
      filed3 = name;
   }

   public void setfield1(String name)
   {
      field1 = name;
   }

   public void setfield2(String name)
   {
      field2 = name;
   }

   public void setfiled3(String name)
   {
      filed3 = name;
   }

   public String toString()
   {
      return (opcode + field1 + "," + field2 + "," + filed3);
   }

}
