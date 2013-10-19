package EvilTypeChecker;

public class TypeVoid implements Type
{
   public boolean equals(Object other)
   {
      return (other != null && other instanceof TypeVoid);
   }

   public String toString()
   {
      return "void";
   }
}
