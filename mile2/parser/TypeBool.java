public class TypeBool implements Type
{
   public boolean equals(Object other)
   {
      return (other != null && other instanceof TypeBool);
   }

   public String toString()
   {
      return "bool";
   }
}
