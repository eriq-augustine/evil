/**
 * A mapping of ILOC registers to sparc registers. 
 * Also contains information on spilled registers.
 */

package evil.sparc;

import evil.instruction.*;
import java.util.HashMap;
import java.util.ArrayList;

public class RegisterMap
{
   HashMap<Register, String> map;
   ArrayList<Register> spills;

   public RegisterMap(HashMap<Register, String> map, ArrayList<Register> spills)
   {
      this.map = map;
      this.spills = spills;
   }

   public String get(Register reg) throws SpillException
   {
      String rtn = null;

      rtn = map.get(reg);

      if (rtn == null) 
      {
         if(spills.contains(reg))
         {
            throw new SpillException(reg.toString());
         }

         throw new NoSuchRegisterException(reg.toString());
      }

      return rtn;
   }

   public int getNumSpills()
   {
      return spills.size();
   }

   public int getSpillIndex(Register reg)
   {
      return spills.indexOf(reg);
   }

   public boolean isSpill(Register reg)
   {
      return spills.contains(reg);
   }

   public class SpillException extends Exception
   {
      public SpillException(String regName)
      {
         super("Register: " + regName + " is spilled!");
      }
   }

   public class NoSuchRegisterException extends RuntimeException
   {
      public NoSuchRegisterException(String regName)
      {
         super("Register: " + regName + " does not exist.");
      }
   }
}
