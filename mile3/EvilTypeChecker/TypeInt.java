package EvilTypeChecker;

public class TypeInt implements Type
{
   public boolean equals(Object other)
   {
      return (other != null && other instanceof TypeInt);
   }

   public String toString()
   {
      return "int";
   }
}
