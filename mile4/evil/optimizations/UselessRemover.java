/**
 * Eriq Augustine and Evan Ralston
 * Useless code remover.
 */

package evil.optimizations;

import evil.evilCFG.*;
import evil.instruction.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.BitSet;
import java.util.Stack;

public class UselessRemover
{
   private ArrayList<BasicBlock> allBlocks;

   private HashMap<InstructionInfo, BitSet> instInfoToBitSet;
   private HashMap<BitSet, InstructionInfo> bitSetToInstInfo;

   private HashMap<BlockInfo, BasicBlock> infoToBlock;
   private HashMap<BasicBlock, BlockInfo> blockToInfo;

   private int totalInst;

   public UselessRemover(ArrayList<BasicBlock> blks)
   {
      allBlocks = blks;
   }

   public void optimize()
   {
      ArrayList<ArrayList<BasicBlock>> allCFGs = BasicBlock.getAllCFGs();

      for (ArrayList<BasicBlock> cfg : allCFGs)
      {
         instInfoToBitSet = new HashMap<InstructionInfo, BitSet>();
         bitSetToInstInfo = new HashMap<BitSet, InstructionInfo>();

         blockToInfo = new HashMap<BasicBlock, BlockInfo>();
         infoToBlock = new HashMap<BlockInfo, BasicBlock>();

         totalInst = 0;

         markBlocks(cfg);

         genLocalInfo(cfg);
         propagate(cfg);

         //printReachingDefs(cfg);

         mark(cfg);

         //printReachingDefs(cfg);

         sweep(cfg);

         replaceInstructions(cfg);
      }
   }

   private void printReachingDefs(ArrayList<BasicBlock> cfg)
   {
      for (BasicBlock block : cfg)
      {
         System.out.println(block.getTag()  + ": ");
         
         for (Definition def : blockToInfo.get(block).reachingDefs)
         {
            System.out.println("   " + def);
         }
      }
   }

   private void genLocalInfo(ArrayList<BasicBlock> cfg)
   {
      for (BasicBlock block : cfg)
      {
         BlockInfo bInfo = blockToInfo.get(block);

         for (int i = bInfo.instructions.size() - 1; i >= 0; i--)
         {
            //System.err.println("Looking at: " + bInfo.instructions.get(i));
            for (Register trg : bInfo.instructions.get(i).instruction.getTargets())
            {
               Definition newDef = new Definition(bInfo.instructions.get(i), trg);

               if (!regInDefSet(trg, bInfo.kill))
               {
                  //System.err.println("Adding def: " + newDef);
                  bInfo.gen.add(newDef);
               }

               bInfo.kill.add(newDef);
            }
         }
      }
   }

   private void propagate(ArrayList<BasicBlock> cfg)
   {
      if (cfg.size() > 0)
      {
         boolean changed = true;

         while (changed)
         {
            changed = false;
            
            ArrayList<BasicBlock> topoOrder = cfg.get(0).getTopoCFG();
            for (BasicBlock block : topoOrder)
            {
               BlockInfo bInfo = blockToInfo.get(block);
               ArrayList<Definition> newReachingDefs = new ArrayList<Definition>();

               for (BasicBlock parent : block.getParents())
               {
                  BlockInfo pInfo = blockToInfo.get(parent);
                  //Parent is in CFG
                  assert(pInfo != null);

                  ArrayList<Definition> temp;
                  temp = minus(pInfo.reachingDefs, pInfo.kill);
                  temp = or(temp, pInfo.gen);

                  newReachingDefs = or(newReachingDefs, temp);

                  //System.out.println("Block: " + parent.getTag() + " kid of: " + block.getTag());
                  //System.out.println("K. OldReachDef: " + pInfo.reachingDefs);
                  //System.out.println();
                  //System.out.println("K. gen: " + pInfo.gen);
                  //System.out.println();
                  //System.out.println("K. kill: " + pInfo.kill);
                  //System.out.println();
               }

               if (!defSetEquals(newReachingDefs, bInfo.reachingDefs))
               {
                  changed = true;
                  bInfo.reachingDefs = newReachingDefs;
               }
                  
                  //System.out.println("Block: " + block.getTag());
                  //System.out.println("OldReachDef: " + bInfo.reachingDefs);
                  //System.out.println();
                  //System.out.println("NewReachDef: " + newReachingDefs);
                  //System.out.println();

            }
         }
      }
   }

   private boolean defSetEquals(ArrayList<Definition> a, ArrayList<Definition> b)
   {
      if (a.size() != b.size())
      {
         return false;
      }

      for (Definition def : a)
      {
         if (!b.contains(def))
         {
            return false;
         }
      }
      
      for (Definition def : b)
      {
         if (!a.contains(def))
         {
            return false;
         }
      }

      return true;
   }

   private boolean regInDefSet(Register reg, ArrayList<Definition> defs)
   {
      for (Definition def : defs)
      {
         // '=='s is fine for regs.
         if (def.reg == reg)
         {
            return true;
         }
      }

      return false;
   }

   private void replaceInstructions(ArrayList<BasicBlock> cfg)
   {
      for (BasicBlock block : cfg)
      {
         ArrayList<Instruction> insts = new ArrayList<Instruction>();

         for (InstructionInfo instInfo : blockToInfo.get(block).instructions)
         {
            //Extra mark check. Totally unnecessary.
            if (instInfo.marked)
            {
               insts.add(instInfo.instruction);
            }
         }

         block.setInstructions(insts);
      }
   }

   private void mark(ArrayList<BasicBlock> cfg)
   {
      BitSet worklist = new BitSet(cfg.size());

      for (BasicBlock block : cfg)
      {
         BlockInfo bInfo = blockToInfo.get(block);

         for (InstructionInfo inst : bInfo.instructions)
         {
            inst.marked = false;

            if (isCritical(inst.instruction))
            {
               inst.marked = true;
               
               //System.err.println("Critical: " + inst);

               worklist.or(instInfoToBitSet.get(inst));
            }
         }
      }

      while (worklist.cardinality() > 0)
      {
         int currInst = worklist.nextSetBit(0);

         BitSet temp = new BitSet();
         temp.set(currInst);

         worklist.andNot(temp);
         InstructionInfo instInfo = bitSetToInstInfo.get(temp);

         for (Register reg : instInfo.instruction.getSources())
         {
            for (InstructionInfo def : getDefs(cfg, instInfo.instruction, reg))
            {
                if (!def.marked)
                {
                   def.marked = true;
                   
                   worklist.or(instInfoToBitSet.get(def));

                   //System.out.println("Adding: " + def + " because of: " + reg);
                }
            }
         }
      }
   }

   private ArrayList<InstructionInfo> getDefs(ArrayList<BasicBlock> cfg, Instruction inst, Register reg)
   {
      ArrayList<InstructionInfo> insts = new ArrayList<InstructionInfo>();

      BasicBlock block = null;
      int position = 0;

      //Find block that instruction is located in.
      for (BasicBlock blk : cfg)
      {
         position = 0;
         for (Instruction instruction : blk.getInstructions())
         {
            // '==' is correct
            if (inst == instruction)
            {
               block = blk;
               break;
            }
            position++;
         }

         if (block != null)
         {
            break;
         }
      }

      //Found block that instruction resides in.
      assert(block != null);

      //System.err.println("Instruction: " + inst + ", defined in block: " + block.getTag());
      //System.err.println("Block: " + block.getTag() + " has defs:\n" + blockToInfo.get(block).reachingDefs);

      //If the register was defined directly above the instruction, than that is its definition
      // otherwise, it is any reaching def that contains it.
      for (position = position - 1; position >= 0; position--)
      {
         InstructionInfo instInfo = blockToInfo.get(block).instructions.get(position);
         if (instInfo.instruction.getTargets().contains(reg))
         {
            insts.add(instInfo);
            break;
         }
      }

      if (insts.size() == 0)
      {
         //Add all defs for that reg.
         for (Definition def : blockToInfo.get(block).reachingDefs)
         {
            //System.err.println("Examining: " + def + ", for " + reg);
            // '==' is correct
            if (def.reg == reg)
            {
               insts.add(def.inst);
            }
         }
      }

      //System.err.println("On: " + inst);
      //System.err.println("  For " + reg + ", found defs: " + insts);

      return insts;
   }

   //Not load
   private boolean isCritical(Instruction inst)
   {
      return inst instanceof Inst_ret ||
             inst instanceof Inst_call ||
             inst instanceof Inst_cbreq ||
             inst instanceof Inst_cbrge ||
             inst instanceof Inst_cbrgt ||
             inst instanceof Inst_cbrle ||
             inst instanceof Inst_cbrlt ||
             inst instanceof Inst_cbrne ||
             inst instanceof Inst_comp ||
             inst instanceof Inst_compi ||
             inst instanceof Inst_computeglobaladdress ||
             inst instanceof Inst_del ||
             inst instanceof Inst_jumpi ||
             inst instanceof Inst_moveq ||
             inst instanceof Inst_movge ||
             inst instanceof Inst_movgt ||
             inst instanceof Inst_movle ||
             inst instanceof Inst_movlt ||
             inst instanceof Inst_movne ||
             inst instanceof Inst_new ||
             inst instanceof Inst_read ||
             inst instanceof Inst_print ||
             inst instanceof Inst_println ||
             inst instanceof Inst_storeai ||
             inst instanceof Inst_storeglobal ||
             inst instanceof Inst_storeoutargument ||
             inst instanceof Inst_storeret ||
             inst instanceof FakeInstruction; 
   }

   private void sweep(ArrayList<BasicBlock> cfg)
   {
      for (BasicBlock block : cfg)
      {
         BlockInfo bInfo = blockToInfo.get(block);
         ArrayList<InstructionInfo> goodInsts = new ArrayList<InstructionInfo>();

         for (InstructionInfo inst : bInfo.instructions)
         {
            if (inst.marked)
            {
               goodInsts.add(inst);
            }
         }

         bInfo.instructions = goodInsts;
      }
   }

   private void markBlocks(ArrayList<BasicBlock> cfg)
   {
      int ndx = 0;

      for (BasicBlock block : cfg)
      {
         ArrayList<InstructionInfo> insts = new ArrayList<InstructionInfo>();
         for (Instruction inst : block.getInstructions())
         {
            InstructionInfo newInst = new InstructionInfo(inst, false);
            insts.add(newInst);
            
            BitSet temp = new BitSet();
            temp.set(ndx++);
         
            instInfoToBitSet.put(newInst, temp);
            bitSetToInstInfo.put(temp, newInst);
         }

         BlockInfo newInfo = new BlockInfo(block, false, insts);
         
         blockToInfo.put(block, newInfo);
         infoToBlock.put(newInfo, block);
      }

      totalInst = ndx;
   }

   private ArrayList<Definition> minus(ArrayList<Definition> src, ArrayList<Definition> other)
   {
      ArrayList<Definition> ret = new ArrayList<Definition>();
   
      for (Definition def : src)
      {
         if (!other.contains(def) && !ret.contains(def))
         {
            ret.add(def);
         }
      }

      return ret;
   }

   private ArrayList<Definition> and(ArrayList<Definition> src, ArrayList<Definition> other)
   {
      ArrayList<Definition> ret = new ArrayList<Definition>();

      for (Definition a : src)
      {
         for (Definition b : other)
         {
            if (a.equals(b) && !ret.contains(a))
            {
               ret.add(a);
            }
         }
      }

      return ret;
   }

   private ArrayList<Definition> or(ArrayList<Definition> src, ArrayList<Definition> other)
   {
      ArrayList<Definition> ret = new ArrayList<Definition>(src);

      for (Definition def : other)
      {
         if (!ret.contains(def))
         {
            ret.add(def);
         }
      }

      return ret;
   }

   private class BlockInfo
   {
      public BasicBlock block;
      public boolean marked;
      public ArrayList<InstructionInfo> instructions;
      public ArrayList<Definition> gen;
      public ArrayList<Definition> kill;
      public ArrayList<Definition> reachingDefs;

      public BlockInfo(BasicBlock block, boolean marked, ArrayList<InstructionInfo> insts)
      {
         this.block = block;
         this.marked = marked;

         instructions = insts;

         gen = new ArrayList<Definition>();
         kill = new ArrayList<Definition>();
         reachingDefs = new ArrayList<Definition>();
      }
   }

   private class Definition
   {
      public InstructionInfo inst;
      public Register reg;

      public Definition(InstructionInfo inst, Register reg)
      {
         this.inst = inst;
         this.reg = reg;
      }

      public boolean equals(Object other)
      {
         if (other == null || !(other instanceof Definition))
         {
            return false;
         }

         Definition def = (Definition)(other);

         return inst.equals(def.inst) && reg.equals(def.reg);
      }

      public String toString()
      {
         return "" + reg + " defined in: " + inst;
      }
   }

   private class InstructionInfo
   {
      public Instruction instruction;
      public boolean marked;

      public InstructionInfo(Instruction inst, boolean marked)
      {
         instruction = inst;
         this.marked = marked;
      }

      public boolean equals(Object other)
      {
         if (other == null || !(other instanceof InstructionInfo))
         {
            return false;
         }

         return instruction == ((InstructionInfo)(other)).instruction;
         //return instruction == other;
         //return instruction.equals( ((InstructionInfo)(other)).instruction);
      }

      public String toString()
      {
         return "" + instruction + " marked=" + marked;
      }
   }
}
