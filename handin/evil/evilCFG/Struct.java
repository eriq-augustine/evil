package evil.evilCFG;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Struct
{
   private String name;
   private ArrayList<Variable> fields;

   public Struct(String name)
   {
      this.name = name;
      fields = new ArrayList<Variable>();
   }
   
   public Struct(String name, ArrayList<Variable> fields)
   {
      this.name = name;
      this.fields = fields;
   }

   public void addField(Variable toAdd)
   {
      fields.add(toAdd);
   }

   public ArrayList<Variable> getFields()
   {
      return fields;
   }

   public Variable getField(int index)
   {
      return fields.get(index);
   }

   public Variable getField(String name)
   {
      for (Variable i : fields)
      {
         if (i.getName().equals(name))
         {
            return i;
         }
      }

      throw new NoSuchElementException("Struct is surprized at ur stupidity");
   }

   public int getFieldNum(String name)
   {
      for (int i = 0; i < fields.size(); i++)
      {
         if (fields.get(i).getName().equals(name))
         {
            return i;
         }
      }
      
      throw new NoSuchElementException("Struct is surprized at ur stupidity");
   }

   public String getFieldId(int num)
   {
      return fields.get(num).getName();
   }

   public String getName()
   {
      return name;
   }

   public String toString()
   {
      String rtn = "struct\n{\n";

      for (Variable i : fields)
      {
         rtn += ("   " + i.toString() + "\n");
      }

      rtn += "}\n";

      return rtn;
   }

   public String getFieldsString()
   {
      String rtn = "[";

      if (fields.size() == 0)
      {
         return "[]";
      }

      for (Variable var : fields)
      {
         rtn += (var.getName() + ", ");
      }

      rtn = rtn.substring(0, rtn.length() - 2);
      rtn += "]";

      return rtn;
   }

   public int getNumFields()
   {
      return fields.size();
   }
}
