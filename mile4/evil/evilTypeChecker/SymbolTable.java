package evil.evilTypeChecker;

import java.util.HashMap;
import java.util.Iterator;

public class SymbolTable
{
   private HashMap<String, Type> formals;
   private HashMap<String, Type> locals;
   
   public SymbolTable()
   {
      formals = new HashMap<String, Type>();
      locals = new HashMap<String, Type>();
   }

   public boolean isDefined(String lookup)
   {
      if(formals.containsKey(lookup) || locals.containsKey(lookup))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   //isFormal = checks the formals (parameters)
   public boolean isFormal(String lookup)
   {
      return formals.containsKey(lookup);
   }
   public boolean isLocal(String lookup)
   {
      return locals.containsKey(lookup);
   }
   //get type of something
   public Type get(String lookup)
   {
      if(formals.get(lookup) == null)
      {
         return locals.get(lookup);
      }
      else
      {
         return formals.get(lookup);
      }
   }
   //add formal
   public void addFormal(String id, Type type)
   {
      formals.put(id, type);
   }
   //add local
   public void addLocal(String id, Type type)
   {
      if(!isFormal(id))
      {
         locals.put(id, type);
      }
   }

   public void print()
   {
      Iterator<Type> iter = formals.values().iterator();
      while(iter.hasNext())
      {
         System.out.println("Formal: "+iter.next().toString());
      }

      iter = locals.values().iterator();
      while(iter.hasNext())
      {
         System.out.println("Local: "+iter.next().toString());
      }
   }  
}
