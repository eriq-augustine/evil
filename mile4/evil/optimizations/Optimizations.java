/**
 * Do optimizations plz.
 * Codename: Optimis Prime
 */

package evil.optimizations;

import java.util.ArrayList;

import evil.evilCFG.*;
import evil.instruction.*;

public class Optimizations
{
   private ArrayList<BasicBlock> allBlocks;

   public Optimizations()
   {
      allBlocks = BasicBlock.getAllBlocks();
   }

   public void optAll()
   {
      optMessage();
      
      optCopyProp();
      optUselessCode();

      optMessage();
   }

   public void optCopyProp()
   {
      CopyProp cp = new CopyProp(allBlocks);
      cp.optimize();
   }

   public void optUselessCode()
   {
      UselessRemover mrClean = new UselessRemover(allBlocks);
      mrClean.optimize();
   }

   //Message the cfg, prepare the cfg for optimizations, and clean it up after.
   // Remove useless jumps and merge mergeable blocks.
   // Remove duplicate code.
   public void optMessage()
   {
      Messager mess = new Messager(allBlocks);
      allBlocks = mess.optimize();
   }
}
