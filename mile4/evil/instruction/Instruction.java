/**
 * Interface for instructions.
 */

package evil.instruction;

import java.util.ArrayList;

public abstract class Instruction
{
   private static int instId = 0;

   private int id;
   private ArrayList<Register> targets;
   private ArrayList<Register> sources;

   public Instruction()
   {
      id = instId++;

      targets = new ArrayList<Register>();
      sources = new ArrayList<Register>();
   }

   public void addTarget(Register trg)
   {
      targets.add(trg);
   }

   public void addSource(Register src)
   {
      sources.add(src);
   }

   protected void removeSource(Register reg)
   {
      sources.remove(reg);
   }

   protected void removeTarget(Register reg)
   {
      targets.remove(reg);
   }

   public ArrayList<Register> getSources()
   {
      return sources;
   }
   
   public ArrayList<Register> getTargets()
   {
      return targets;
   }

   public int getId()
   {
      return id;
   }

   public boolean equals(Object obj)
   {
      if (obj == null || !(this.getClass() == obj.getClass()))
      {
         return false;
      }

      return this.toString().equals(obj.toString());
   }

   public abstract String getOpcode();
   
   public abstract String getOp();
   
   public abstract String toString();

   public abstract void replaceSource(Register reg1, Register reg2);
}
