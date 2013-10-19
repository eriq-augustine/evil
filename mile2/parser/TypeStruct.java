import java.util.HashMap;

public class TypeStruct implements Type
{
   private String structID;
   private HashMap<String, Type> members;

   public TypeStruct(String structID)
   {
      this.structID = structID;
      members = new HashMap<String, Type>();
   }

   public void addMember(String id, Type type)
   {
      members.put(id, type);
   }

   public Type getMember(String id) 
   {
      return members.get(id);
   }

   public String getName()
   {
      return structID;
   }

   public boolean equals(Object other)
   {
      if (other == null || !(other instanceof TypeStruct))
      {
         return false;
      }

      return structID.equals(((TypeStruct)(other)).structID);
   }

   public String toString()
   {
      return "struct " + structID;
   }
}
