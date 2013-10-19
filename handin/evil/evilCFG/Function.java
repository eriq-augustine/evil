package evil.evilCFG;

import java.util.ArrayList;
import java.util.Hashtable;
import evil.instruction.*;

public class Function extends Variable
{
   private ArrayList<String> params; //Cange later to be more than just Strings?
   private ArrayList<String> locals; //Change later?
   private BasicBlock body;
   private Hashtable<String, Variable> symbols;
   private Hashtable<String, Register> allocation;
   private Variable ret;

   public Function(BasicBlock body, Hashtable<String, Variable> symbols)
   {
      super("TEMP_NAME");
      this.body = body;
      this.symbols = symbols;
      ret = null;
   }

   public Function(String name, BasicBlock body, Hashtable<String, Variable> symbols)
   {
      super(name);
      this.body = body;
      this.symbols = symbols;
      ret = null;

      locals = new ArrayList<String>();
      params = new ArrayList<String>();
      allocation = new Hashtable<String, Register>();

      if (symbols != null)
      {
         for (Variable var : symbols.values())
         {
            if (var.getScope() == ScopeType.kLocal)
            {
               locals.add(var.getName());
               allocation.put(var.getName(), new Register());
            }
            else if(var.getScope() == ScopeType.kFormal)
            {
               allocation.put(var.getName(), new Register());
               params.add(var.getName());
            }
         }
      }
   }

   public boolean hasReturn()
   {
        return ret != null;
   }

   public void setReturn(Variable var)
   {
        ret = var; 
   }

   public Variable getReturn()
   {
      return ret;
   }

   public Hashtable<String, Register>  getRegisters()
   {
      return allocation;
   }

   public void setRegisters(Hashtable<String, Register> registers)
   {
      allocation = registers;
   }

   public Register findRegister(String lookUp)
   {
      return allocation.get(lookUp);
   }

   public ArrayList<String> getLocals()
   {
      return locals;
   }

   public ArrayList<String> getFormals()
   {
        return params;
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

   public void setLocals(ArrayList<String> locals)
   {
      this.locals = locals;
   }
}
