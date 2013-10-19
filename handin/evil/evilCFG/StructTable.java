package evil.evilCFG;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StructTable
{
   private Hashtable<String, Struct> table;

   public StructTable()
   {
      table = new Hashtable<String, Struct>();
   }

   public Struct get(String name)
   {
      if (table.containsKey(name))
      {
         return table.get(name);
      }

      throw new NoSuchElementException("SrtructTbale sez, ur stoopid! Looking for: " + name);
   }

   public void add(String name, Struct toAdd)
   {
      table.put(name, toAdd);
   }

   public String toString()
   {
      String rtn = "Structs:\n";

      rtn += table.toString();

      return rtn;
   }
}
