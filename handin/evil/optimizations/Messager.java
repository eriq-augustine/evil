/**
 * Do optimizations plz.
 * Codename: Optimis Prime
 */

package evil.optimizations;

import java.util.ArrayList;

import evil.evilCFG.*;
import evil.instruction.*;

public class Messager
{
   private ArrayList<BasicBlock> allBlocks;

   public Messager(ArrayList<BasicBlock> blks)
   {
      allBlocks = blks;
   }

   public ArrayList<BasicBlock> optimize()
   {
      combineBlocks();
      
      combineSingles();

      removeDuplicates();
      
      removeEmpty();

      removeDupRelations();

      return allBlocks;
   }

   //Remove any duplicate parent/child relations.
   //Usually a result of other transformations.
   private void removeDupRelations()
   {
      for (BasicBlock block : allBlocks)
      {
         ArrayList<BasicBlock> parents = new ArrayList<BasicBlock>();
         ArrayList<BasicBlock> kids = new ArrayList<BasicBlock>();

         for (BasicBlock parent : block.getParents())
         {
            if (!parents.contains(parent))
            {
               parents.add(parent);
            }
         }

         for (BasicBlock kid : block.getKids())
         {
            if (!kids.contains(kid))
            {
               kids.add(kid);
            }
         }

         block.setParents(parents);
         block.setKids(kids);
      }
   }

   //Remove unnecessary dupliates.
   private void removeDuplicates()
   {
      boolean changed = true;

      while (changed)
      {
         changed = false;

         for (BasicBlock block : allBlocks)
         {
            ArrayList<Instruction> goodInsts = new ArrayList<Instruction>();
            
            for (Instruction inst : block.getInstructions())
            {
               if (goodInsts.size() != 0 && uselessDuplicate(inst) &&
                goodInsts.get(goodInsts.size() - 1).equals(inst))
               {
                  changed = true;
               }
               else
               {
                  goodInsts.add(inst);
               }
            }

            block.setInstructions(goodInsts);
         }
      }
   }

   //This can be expanded, but I'm scared.
   //Is the instruction useless if duplicated?
   // Duped Adds are not always useless, moves are.
   private boolean uselessDuplicate(Instruction inst)
   {
      //If the instruction is arithmetic and the target is not a source, then the 
      // instruction is useless if duplicated.
      if (isArithmetic(inst))
      {
         assert(inst.getTargets().size() == 1);

         return (inst.getSources().contains(inst.getTargets().get(0)));
      }

      return inst instanceof Inst_mov ||
             inst instanceof Inst_del ||
             inst instanceof Inst_new ||
             inst instanceof Inst_ret; 
   }
   
   private boolean isArithmetic(Instruction inst)
   {
      return inst instanceof Inst_add ||
             inst instanceof Inst_sub ||
             inst instanceof Inst_mult ||
             inst instanceof Inst_div ||
             inst instanceof Inst_xori;
   }

   private void combineSingles()
   {
      boolean changed = true;

      while (changed)
      {
         changed = false;

         for (BasicBlock block : allBlocks)
         {
            boolean isExit = false;
            boolean isValid = true;

            for (Instruction inst : block.getInstructions())
            {
               if (inst instanceof FakeInstruction &&
                inst.getOp().contains("EXIT: "))
                {
                  isExit = true;
                  break;
                }
            }

            for (BasicBlock parent : block.getParents())
            {
               if (parent.getKids().size() != 1)
               {
                  isValid = false;
               }
            }

            //If a single instruction or sinlge non-fake instruction
            if (isValid && 
             ((block.getInstructions().size() == 1 && !isExit) ||
             (block.getInstructions().size() == 2 && isExit)))
            {
               Instruction inst = block.getInstructions().get(0);

               //It better be a jump or a ret
               assert(inst instanceof Inst_jumpi || inst instanceof Inst_ret);

               //Procedure for combining single instruction blocks.
               // 1. Remove the jump (final instruction) from its parents.
               // 2. Add the single instruction to its parents'.
               // 3. Remove the single from its parents' kids.
               // 4. Add the single's kids to its parents' kids.
               // 5. Remove the single from its kids' parents.
               // 6. Add the single's parents to its kids' parents.
               // 7. Remove the non-fake instruction from the block.
               // NOTE: DO NOT remove this block, it may be an exit block.
               // DO NOT do 3 - 6 if this block is an exit.
               
               for (BasicBlock parent : block.getParents())
               {
                  ArrayList<Instruction> insts = parent.getInstructions();
                  
                  //1
                  Instruction temp = insts.remove(insts.size() - 1);
                  assert(temp instanceof Inst_jumpi);

                  //2
                  insts.add(inst);

                  if (!isExit)
                  {
                     //3
                     parent.getKids().remove(block);

                     //4
                     parent.getKids().addAll(block.getKids());
                  }
               }

               if (!isExit)
               {
                  for (BasicBlock kid : block.getKids())
                  {
                     //5
                     kid.getParents().remove(block);

                     //6
                     kid.getParents().addAll(block.getParents());
                  }
               }

               //7
               block.getInstructions().remove(inst);

               changed = true;
               break;
            }
         }
      }
   }

   //This is just a pre-caution. This situation should never arise.
   private void removeEmpty()
   {
      boolean changed = true;

      while (changed)
      {
         changed = false;

         for (BasicBlock block : allBlocks)
         {
            //If block is empty and not an exit.
            if (!block.isExit() && block.getInstructions().size() == 0)
            {
               //Procedure for removing an empty block.
               // 1. Add the empty's kids to the parents' kids.
               // 2. Remove the empty from the parents' kids.
               // 3. Add the empty's parents to the empty's kids' parents.
               // 4. Remove the empty from the empty's kids' parents.
               // 5. Remove the empty from the list of all blocks.

               //1 and 2
               for (BasicBlock parent : block.getParents())
               {
                  parent.getKids().addAll(block.getKids());
                  parent.getKids().remove(block);
               }

               //3 and 4
               for (BasicBlock kid : block.getKids())
               {
                  kid.getParents().addAll(block.getParents());
                  kid.getParents().remove(block);
               }

               //5
               allBlocks.remove(block);
               
               changed = true;

               break;
            }
         }
      }
   }

   //Message the cfg.
   // Remove useless jumps and merge mergeable blocks.
   private void combineBlocks()
   {
      boolean changed = true;

      while (changed)
      {
         changed = false;

         for (BasicBlock block : allBlocks)
         {
            ArrayList<BasicBlock> kids = block.getKids();
         
            //If the block has a single kid, and that kid has only one parent (the
            // current block).
            if (kids.size() == 1 && kids.get(0).getParents().size() == 1)
            {
               BasicBlock kid = kids.get(0);
               assert(block.equals(kid.getParents().get(0)));

               //These two blocks can be combined.
               //Combine procedure:
               // 1. Remove the jump from the end of the parent.
               // 2. Copy the kid's instructions to the parent.
               //     (Including the kid's jump).
               // 3. Remove the kid from the parent's list of kids.
               // 4. Remove the kid from the kid's childrens' parents
               // 5. Add the kid's children to the parent's kids.
               // 6. Add the parent to the kid's children's parents
               // 7. Remove the kid from the list of blocks.

               //1
               Instruction temp = 
                block.getInstructions().remove(block.getInstructions().size() - 1);
               assert(temp instanceof Inst_jumpi);

               //2
               block.getInstructions().addAll(kid.getInstructions());

               //3
               kids.remove(kid);

               //4
               for (BasicBlock grandKid : kid.getKids())
               {
                  grandKid.getParents().remove(kid);
               }

               //5
               kids.addAll(kid.getKids());

               //6
               for (BasicBlock grandKid : kid.getKids())
               {
                  grandKid.getParents().add(block);
               }

               //7
               allBlocks.remove(kid);

               changed = true;
               
               //WE must break from the for if we removed a block.
               break;
            }
         }
      }
   }
}
