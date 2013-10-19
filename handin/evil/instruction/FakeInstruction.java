package evil.instruction;

public class FakeInstruction extends Instruction
{
   private String name;

   public FakeInstruction(String name)
   {
      this.name = name;
   }

   public String toString()
   {
      return name;
   }

   public String getOp()
   {
      return toString();
   }

   public String getOpcode()
   {
      return toString();
   }

   public void replaceSource(Register a, Register b)
   {
   }

   public boolean equals(Object obj)
   {
      if (obj == null || !(obj instanceof FakeInstruction))
      {
         return false;
      }

      return (((FakeInstruction)(obj)).name.equals(this.name));
   }
}
