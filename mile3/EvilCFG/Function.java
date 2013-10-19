package EvilCFG;

import java.util.ArrayList;
import java.util.Hashtable;

public class Function extends Variable
{
   private ArrayList<String> params; //Cange later to be more than just Strings?
   private ArrayList<String> locals; //Change later?
   private BasicBlock body;
   private Hashtable<String, Variable> symbols;

   public Function(BasicBlock body, Hashtable<String, Variable> symbols)
   {
      super("TEMP_NAME");
      this.body = body;
      this.symbols = symbols;
   }

   public Function(String name, BasicBlock body, Hashtable<String, Variable> symbols)
   {
      super(name);
      this.body = body;
      this.symbols = symbols;
   }

   public BasicBlock getBody()
   {
      return body;
   }

   public Hashtable<String, Variable> getSymbols()
   {
      return symbols;
   }

   public boolean isFunction()
   {
      return true;
   }

   public Function copy()
   {
      throw new UnsupportedOperationException();
   }

   public String toString()
   {
      return ("Function: " + super.getName());
   }
}
