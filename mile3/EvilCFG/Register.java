package EvilCFG;

public class Register
{
   private static int count = 0;
   
   private int myNumber;
   private String name;
   private int value;

   public Register()
   {
      myNumber = count++;
      name = "R" + myNumber;
   }

   public Register(String name)
   {
      myNumber = count++;
      this.name = name;
   }

   public static Register newRegister()
   {
      return new Register();
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
}
