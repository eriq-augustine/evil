package EvilTypeChecker;

import java.util.ArrayList;

public class TypeFun implements Type
{
   private Type returnValue;
   private ArrayList<Type> params;
   private String funName;

   public TypeFun(String funName)
   {
      params = new ArrayList<Type>();
      this.funName = funName;
   }

   public void setReturn(Type t)
   {
      returnValue = t;
   }

   public void addParam(Type t)
   {
      params.add(t);
   }

   public ArrayList<Type> getParams()
   {
      return params;
   }

   public Type getReturn()
   {
      return returnValue;
   }

   public String toString()
   {
      String temp = new String();

      temp += (funName + "(");

      for (int i = 0; i < params.size(); i++)
      {
         temp += params.get(i);

         if (i != (params.size() - 1))
         {
            temp += ", ";
         }
      }

      temp += (") " + returnValue);

      return temp;
   }
}
