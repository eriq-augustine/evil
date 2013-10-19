package EvilCFG;

public class Primitive extends Variable
{
   private int value;
   
   public Primitive()
   {
      super("TEMP_NAME");
   }

   public Primitive(String name)
   {
      super(name);
   }

   public void setValue(int value)
   {
      this.value = value;
   }

   public int getValue()
   {
      return value;
   }

   public boolean isPrimitive()
   {
      return true;
   }

   public Primitive copy()
   {
      Primitive temp = new Primitive(getName());
      temp.setValue(value);

      return temp;
   }

   public String toString()
   {
      return ("Primitive " + super.getName());
   }
}
