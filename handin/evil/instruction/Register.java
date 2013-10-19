package evil.instruction;

import java.util.ArrayList;

public class Register
{
   private static int count = 0;
   private static ArrayList<Register> allRegs = new ArrayList<Register>();
   
   private int myNumber;
   private String name;
   private int value;
   private String extraInfo;

   public Register()
   {
      myNumber = count++;
      name = "r" + myNumber;

      allRegs.add(this);
      extraInfo = new String();
   }

   public Register(String name)
   {
      myNumber = count++;
      this.name = name;
      
      allRegs.add(this);
      extraInfo = new String();
   }

   public static Register newRegister()
   {
      return new Register();
   }

   public void setExtraInfo(String extra)
   {
      extraInfo = extra;
   }

   public String getExtraInfo()
   {
      return extraInfo;
   }

   public int getNumber()
   {
      return myNumber;
   }

   public String toString()
   {
      return name;
   }

   public void setValue(int v)
   {
      value = v;
   }

   public int getValue()
   {
      return value;
   }

   public static ArrayList<Register> getAllRegs()
   {
      return allRegs;
   }
}
