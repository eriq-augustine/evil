public class TypeNull implements Type
{
   public boolean equals(Object other)
   {
      return (other != null && other instanceof TypeNull);
   }

   public String toString()
   {
      return "null";
   }
}
