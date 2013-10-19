package evil.evilCFG;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SymbolTable
{
   private LinkedList<Hashtable<String, Variable>> table;

   public SymbolTable()
   {
      table = new LinkedList<Hashtable<String, Variable>>();
      table.addFirst(new Hashtable<String, Variable>());
   }

   public ArrayList<Function> getFunctions()
   {
      ArrayList<Function> funs = new ArrayList<Function>();

      for (Hashtable<String, Variable> curState : table)
      {
         for (Variable var : curState.values())
         {
            if (var.isFunction())
            {
               funs.add((Function)var);
            }
         }
      }

      return funs; 
   }

   public Variable get(String name)
   {
      for (Hashtable<String, Variable> curState : table)
      {
         if (curState.containsKey(name))
         {
            return curState.get(name);
         }
      }

      throw new NoSuchElementException("SymbolTbale sez, ur stoopid!");
   }

   public void add(String name, Variable toAdd)
   {
      table.get(0).put(name, toAdd);
   }

   public void newState()
   {
      table.addFirst(new Hashtable<String, Variable>());
   }

   public Hashtable<String, Variable> removeState()
   {
      return table.removeFirst();
   }

   public void addState(Hashtable<String, Variable> sym)
   {
      table.addFirst(sym);
   }

   public String toString()
   {
      String rtn = "Symbols:\n";

      for (int i = 0; i < table.size(); i++)
      {
         rtn += ("Level: " + i + "\n");

         rtn += table.get(i).toString() + "\n";
      }

      return rtn;
   }

   //Careful when using... you culd break the CFG/ILOC
   public Variable remove(String name)
   {
      for (Hashtable<String, Variable> curState : table)
      {
         if (curState.containsKey(name))
         {
            return curState.remove(name);
         }
      }

      throw new NoSuchElementException("SymbolTbale sez, ur stoopid!");
   }

   public boolean isGlobal(String name)
   {
      for (Hashtable<String, Variable> curState : table)
      {
         if (curState.containsKey(name))
         {
            return curState.get(name).getScope() == ScopeType.kGlobal;
         }
      }

      throw new NoSuchElementException("It can't be global if it doesn't exist!");
   }

   public ArrayList<String> getTopLocals()
   {
      ArrayList<String> rtn = new ArrayList<String>();
      
      for (Variable var : table.get(0).values())
      {
         if (var.getScope() == ScopeType.kLocal)
         {
            rtn.add(var.getName());
         }
      }

      return rtn;
   }
}
