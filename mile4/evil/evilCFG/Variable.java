package evil.evilCFG;

public abstract class Variable
{
   private String name;
   private ScopeType scope;

   public Variable(String name)
   {
      this.name = name;
      scope = ScopeType.kLocal;
   }
   
   public boolean isReference()
   {
      return false;
   }

   public boolean isPrimitive()
   {
      return false;
   }

   public boolean isFunction()
   {
      return false;
   }

   public String toString()
   {
      return name;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public void setScope(ScopeType scope)
   {
      this.scope = scope;
   }

   public ScopeType getScope()
   {
      return scope;
   }

   public Variable copy()
   {
      throw new UnsupportedOperationException();
   }
}
