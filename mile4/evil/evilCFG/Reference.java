package evil.evilCFG;

public class Reference extends Variable
{
   public Struct myStruct;

   public Reference(Struct myStruct)
   {
      super("TEMP_NAME");
      this.myStruct = myStruct;
   }

   public Reference(String name, Struct myStruct)
   {
      super(name);
      this.myStruct = myStruct;
   }

   public boolean isReference()
   {
      return true;
   }

   public Struct getStruct()
   {
      return myStruct;
   }

   public Reference copy()
   {
      Reference temp = new Reference(getName(), myStruct);
      return temp;
   }

   public String toString()
   {
      return ("Reference to: struct " + myStruct.getName() + " " + super.getName());
   }
}
