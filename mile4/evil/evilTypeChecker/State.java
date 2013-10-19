package evil.evilTypeChecker;

import java.util.LinkedList;

public class State
{
   private LinkedList<SymbolTable> states;

   public State()
   {
      states = new LinkedList<SymbolTable>();
   }

   public void addState()
   {
      states.addFirst(new SymbolTable());
   }

   public void removeState()
   {
      states.removeFirst();
   }

   public void addFun(String s, Type ty)
   {
      states.get(states.size()-1).addLocal(s, ty);
   }

   public boolean isDefined(String s)
   {
      for(int i = 0; i < states.size(); i++)
      {
         if(states.get(i).isDefined(s))
         {
            return true;
         }
      }
      return false;
   }

   public Type get(String s)
   {
      for(SymbolTable st : states)
      {
         if(st.isDefined(s))
         {
            return st.get(s);
         }
      }
      return null;
   }

   public boolean isFormal(String s)
   {
      return states.get(0).isFormal(s);
   }

   public boolean isLocal(String s)
   {
      return states.get(0).isLocal(s);
   }

   public void add(String s, Type t)
   {
      states.get(0).addLocal(s, t);
   }

   public void addFormal(String s, Type t)
   {
      states.get(0).addFormal(s, t);
   }

   public void print()
   {
      int count = 0;
      for (SymbolTable i : states)
      {
         System.out.println(count + ": ");
         i.print();
      }
   }
}
