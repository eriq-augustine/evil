package evil.instruction;

public class FakeInstruction implements Instruction
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
}
