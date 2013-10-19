/**
 * Generate sparc code from ILOC.
 */

package evil.sparc;

import evil.evilCFG.*;
import evil.instruction.*;
import java.io.*;
import java.util.HashMap;

public class SparcGenerator
{
   private final static String tab = "      ";
   private final static String nop = "nop";
   private final static int kTopOfFrame = 96;
   private final static int kDefaultStackSize = 112;

   private int firstSpillAddr;
   private SymbolTable sym;
   private StructTable structs;
   private BasicBlock cfg;
   private RegisterMap regMap;

   private PrintStream out;

   public SparcGenerator(SymbolTable sym, StructTable structs, BasicBlock cfg)
   {
      this.sym = sym;
      this.structs = structs;
      this.cfg = cfg;

      out = System.out;
   }

   public void generateSparc(PrintStream out, String fileName)
   {
      this.out = out;

      //BasicBlock.printRelations();

      writeHeader(fileName);
      translate();
   }

   //%o5 , %04, and %o3 are fair game.
   public void translate()
   {
      for (BasicBlock block : cfg)
      {
         //Need to write out header?
         if (block.isEntry())
         {
            //If this is not true bad things will happen, so just assert.
            assert(block.getTag().equals(block.getFunName()));

            writeFunctionHeader(block.getFunName());
            out.println(block.getTag() + ":");

            RegisterAllocator aligator = new RegisterAllocator(block);
            regMap = aligator.getMapping();

            //TODO: STACKSIZE
            //-800 is magic.
            int extraArgs = block.getMostArgs(sym);
            extraArgs = extraArgs > 6 ? extraArgs - 6 : 0;

            int stackSize = kDefaultStackSize + 
             (extraArgs * 4) + (regMap.getNumSpills() * 4);
            
            firstSpillAddr = kTopOfFrame + (extraArgs * 4);

            //Must allign on 8 to prevent warnings.
            stackSize = stackSize % 8 == 0 ? stackSize : stackSize + 4;
            
            out.println(tab + "save %sp, -" + stackSize + ", %sp");
         }
         else
         {
            out.println(block.getTag() + ":");
         }


         for (Instruction inst : block.getInstructions())
         {
            if (inst instanceof Inst_ret)
            {
               out.println(tab + "ret");
               out.println(tab + "restore");
            }
            //BEGIN ARITMETIC SECTION
            else if (inst instanceof Inst_add)
            {
               String src1 = getSource(((Inst_add)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_add)(inst)).getAddr1(), "%o4");
               String trg = getTarget(((Inst_add)(inst)).getAddr2(), "%o3");

               out.println(tab + "add " + src1 + ", " + src2 + ", " + trg);

               spillTarget(((Inst_add)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_addi)
            {
               String src1 = getSource(((Inst_addi)(inst)).getAddr0(), "%o5");
               int src2 = ((Inst_addi)(inst)).getAddr1();
               String trg = getTarget(((Inst_addi)(inst)).getAddr2(), "%o3");

               out.println(tab + "add " + src1 + ", " + src2 + ", " + trg);

               spillTarget(((Inst_addi)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_sub)
            {
               String src1 = getSource(((Inst_sub)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_sub)(inst)).getAddr1(), "%o4");
               String trg = getTarget(((Inst_sub)(inst)).getAddr2(), "%o3");

               out.println(tab + "sub " + src1 + ", " + src2 + ", " + trg);

               spillTarget(((Inst_sub)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_subi)
            {
               String src1 = getSource(((Inst_subi)(inst)).getAddr0(), "%o5");
               int src2 = ((Inst_subi)(inst)).getAddr1();
               String trg = getTarget(((Inst_subi)(inst)).getAddr2(), "%o3");

               out.println(tab + "sub " + src1 + ", " + src2 + ", " + trg);

               spillTarget(((Inst_subi)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_mult)
            {
               String src1 = getSource(((Inst_mult)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_mult)(inst)).getAddr1(), "%o4");
               String trg = getTarget(((Inst_mult)(inst)).getAddr2(), "%o3");

               //If these spill, it is still ok to use the o's
               out.println(tab + "sra " + src1 + ", %g0, " + "%o5");
               out.println(tab + "sra " + src2 + ", %g0, " + "%o4");
               out.println(tab + "mulx %o5, %o4, " + trg);

               spillTarget(((Inst_mult)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_multi)
            {
               String src1 = getSource(((Inst_multi)(inst)).getAddr0(), "%o5");
               int src2 = ((Inst_multi)(inst)).getAddr1();
               String trg = getTarget(((Inst_multi)(inst)).getAddr2(), "%o3");

               //If these spill, it is still ok to use the o's
               out.println(tab + "sra " + src1 + ", %g0, " + "%o5");
               out.println(tab + "mulx %o5, " + src2 + ", " + trg);

               spillTarget(((Inst_multi)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_div)
            {
               String src1 = getSource(((Inst_div)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_div)(inst)).getAddr1(), "%o4");
               String trg = getTarget(((Inst_div)(inst)).getAddr2(), "%o3");

               //If these spill, it is still ok to use the o's
               out.println(tab + "sra " + src1 + ", %g0, " + "%o5");
               out.println(tab + "sra " + src2 + ", %g0, " + "%o4");
               out.println(tab + "sdivx %o5, %o4, " + trg);

               spillTarget(((Inst_div)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_divi)
            {
               String src1 = getSource(((Inst_divi)(inst)).getAddr0(), "%o5");
               int src2 = ((Inst_divi)(inst)).getAddr1();
               String trg = getTarget(((Inst_divi)(inst)).getAddr2(), "%o3");

               //If these spill, it is still ok to use the o's
               out.println(tab + "sra " + src1 + ", %g0, " + "%o5");
               out.println(tab + "sdivx %o5, " + src2 + ", " + trg);

               spillTarget(((Inst_divi)(inst)).getAddr2(), trg);
            }
            //END ARITHMETIC SECTION
            //BEGIN BOOLEAN SECTION
            else if (inst instanceof Inst_and)
            {
               String src1 = getSource(((Inst_and)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_and)(inst)).getAddr1(), "%o4");
               String trg = getTarget(((Inst_and)(inst)).getAddr2(), "%o3");

               out.println(tab + "and " + src1 + ", " + src2 + ", " + trg);

               spillTarget(((Inst_and)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_or)
            {
               String src1 = getSource(((Inst_or)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_or)(inst)).getAddr1(), "%o4");
               String trg = getTarget(((Inst_or)(inst)).getAddr2(), "%o3");

               out.println(tab + "or " + src1 + ", " + src2 + ", " + trg);

               spillTarget(((Inst_or)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_xori)
            {
               String src = getSource(((Inst_xori)(inst)).getAddr0(), "%o5");
               String trg = getTarget(((Inst_xori)(inst)).getAddr2(), "%o3");

               out.println(tab + "mov " + ((Inst_xori)inst).getAddr1() + ", %o4");
               out.println(tab + "xor " + src + ", %o4, " + trg);

               spillTarget(((Inst_xori)(inst)).getAddr2(), trg);
            }
            //END BOOLEAN SECTION
            //BEGIN MOVE SECTION
            else if (inst instanceof Inst_mov)
            {
               //If a useless move.
               if (!isSameRegister(((Inst_mov)(inst)).getAddr0(), ((Inst_mov)(inst)).getAddr1()))
               {
                  String src = getSource(((Inst_mov)(inst)).getAddr0(), "%o5");
                  String trg = getTarget(((Inst_mov)(inst)).getAddr1(), "%o4");

                  out.println(tab + "mov " + src + ", " + trg);

                  spillTarget(((Inst_mov)(inst)).getAddr1(), trg);
               }
            }
            else if (inst instanceof Inst_moveq)
            {
               String both = getSource(((Inst_moveq)(inst)).getAddr1(), "%o5");

               out.println(tab + "move " + "%icc, " + ((Inst_moveq)inst).getAddr0() + ", " + both);

               spillTarget(((Inst_moveq)(inst)).getAddr1(), both);
            }
            else if (inst instanceof Inst_movne)
            {
               String both = getSource(((Inst_movne)(inst)).getAddr1(), "%o5");

               out.println(tab + "movne " + "%icc, " + ((Inst_movne)inst).getAddr0() + ", " + both);

               spillTarget(((Inst_movne)(inst)).getAddr1(), both);
            }
            else if (inst instanceof Inst_movle)
            {
               String both = getSource(((Inst_movle)(inst)).getAddr1(), "%o5");

               out.println(tab + "movle " + "%icc, " + ((Inst_movle)inst).getAddr0() + ", " + both);

               spillTarget(((Inst_movle)(inst)).getAddr1(), both);
            }
            else if (inst instanceof Inst_movge)
            {
               String both = getSource(((Inst_movge)(inst)).getAddr1(), "%o5");

               out.println(tab + "movge " + "%icc, " + ((Inst_movge)inst).getAddr0() + ", " + both);

               spillTarget(((Inst_movge)(inst)).getAddr1(), both);
            }
            else if (inst instanceof Inst_movgt)
            {
               String both = getSource(((Inst_movgt)(inst)).getAddr1(), "%o5");

               out.println(tab + "movg " + "%icc, " + ((Inst_movgt)inst).getAddr0() + ", " + both);

               spillTarget(((Inst_movgt)(inst)).getAddr1(), both);
            }
            else if (inst instanceof Inst_movlt)
            {
               String both = getSource(((Inst_movlt)(inst)).getAddr1(), "%o5");

               out.println(tab + "movl " + "%icc, " + ((Inst_movlt)inst).getAddr0() + ", " + both);

               spillTarget(((Inst_movlt)(inst)).getAddr1(), both);
            }
            //END MOVE SECTION
            //BEGIN COMPARISON SECTION
            else if (inst instanceof Inst_comp)
            {
               String src1 = getSource(((Inst_comp)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_comp)(inst)).getAddr1(), "%o4");

               out.println(tab + "cmp " + src1 + ", " + src2);
            }
            else if (inst instanceof Inst_compi)
            {
               String src = getSource(((Inst_compi)(inst)).getAddr0(), "%o5");

               out.println(tab + "cmp " + src + ", " + ((Inst_compi)inst).getAddr1());
            }
            //END COMPARISON SECTION
            //BEGIN BRANCH / JUMP SECTION
            else if (inst instanceof Inst_cbreq)
            {
               out.println(tab + "be " + ((Inst_cbreq)inst).getAddr0());
               out.println(tab + nop);
               out.println(tab + "ba " + ((Inst_cbreq)(inst)).getAddr1());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_cbrne)
            {
               out.println(tab + "bne " + ((Inst_cbrne)inst).getAddr0());
               out.println(tab + nop);
               out.println(tab + "ba " + ((Inst_cbrne)(inst)).getAddr1());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_cbrge)
            {
               out.println(tab + "bge " + ((Inst_cbrge)inst).getAddr0());
               out.println(tab + nop);
               out.println(tab + "ba " + ((Inst_cbrge)(inst)).getAddr1());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_cbrgt)
            {
               out.println(tab + "bg " + ((Inst_cbrgt)inst).getAddr0());
               out.println(tab + nop);
               out.println(tab + "ba " + ((Inst_cbrgt)(inst)).getAddr1());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_cbrle)
            {
               out.println(tab + "ble " + ((Inst_cbrle)inst).getAddr0());
               out.println(tab + nop);
               out.println(tab + "ba " + ((Inst_cbrle)(inst)).getAddr1());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_cbrlt)
            {
               out.println(tab + "bl " + ((Inst_cbrlt)inst).getAddr0());
               out.println(tab + nop);
               out.println(tab + "ba " + ((Inst_cbrlt)(inst)).getAddr1());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_jumpi)
            {
               out.println(tab + "ba " + ((Inst_jumpi)inst).getAddr0());
               out.println(tab + nop);
            }
            //END BRANCH SECTION
            //BEGIN FUNCTION CALLS //TODO: might not work
            else if (inst instanceof Inst_new)
            {
               String trg = getTarget(((Inst_new)(inst)).getAddr2(), "%o5");
               int allocatedSpace = structs.get(((Inst_new)inst).getAddr0()).getNumFields() * 4;
               allocatedSpace = allocatedSpace % 8 == 0 ? allocatedSpace : allocatedSpace + 4;

               out.println(tab + "mov " + allocatedSpace + ", %o0");
               out.println(tab + "call malloc");
               out.println(tab + nop);
               out.println(tab + "mov %o0, " + trg);


               spillTarget(((Inst_new)(inst)).getAddr2(), trg);
            }
            //TODO: is correct?
            else if (inst instanceof Inst_del)
            {
               String src = getSource(((Inst_del)(inst)).getAddr0(), "%o5");

               out.println(tab + "mov " + src + ", %o0");
               out.println(tab + "call free");
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_call)
            {
               out.println(tab + "call " + ((Inst_call)inst).getAddr0());
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_loadret)
            {
               String trg = getTarget(((Inst_loadret)(inst)).getAddr0(), "%o0");

               out.println(tab + "mov " + "%o0, " + trg);

               spillTarget(((Inst_loadret)(inst)).getAddr0(), trg);
            }
            else if (inst instanceof Inst_storeret)
            {
               String src = getSource(((Inst_storeret)(inst)).getAddr0(), "%o5");

               //Return register (one of them) is hardcoded in (%i0).
               out.println(tab + "mov " + src + ", %i0");
            }
            //END FUNCTION CALLS
            //BEGIN LOADS / STORES
            else if (inst instanceof Inst_loadinargument)
            {
               Inst_loadinargument temp = ((Inst_loadinargument)(inst));
               String trg = getTarget(temp.getAddr2(), "%o5");

               if (temp.getAddr1() < 6)
               {
                  out.println(tab + "mov " + "%i" + temp.getAddr1() + ", " + trg);
               }
               else
               {
                  int amountOver = temp.getAddr1() - 6;
                  int offset = kTopOfFrame + (amountOver * 4);
                  
                  out.println(tab + "ld [%fp+" + offset + "], " + trg);
               }
               
               spillTarget(temp.getAddr2(), trg);
            }
            //This still should be fine, even if both use "%o5".
            else if (inst instanceof Inst_storeoutargument)
            {
               Inst_storeoutargument temp = ((Inst_storeoutargument)(inst));
               if (temp.getAddr1() < 6)
               {
                  String src = getSource(temp.getAddr0(), "%o5");

                  out.println(tab + "mov " + src + ", %o" + temp.getAddr1());
               }
               else
               {
                  String src = getSource(temp.getAddr0(), "%i5");
                  int amountOver = temp.getAddr1() - 6;
                  int offset = kTopOfFrame + (amountOver * 4);
                  
                  out.println(tab + "st " + src + ", [%sp+" + offset + "]");
               }
            }
            else if (inst instanceof Inst_loadi)
            {
               String trg = getTarget(((Inst_loadi)(inst)).getAddr1(), "%o5");

               out.println(tab + "set " + ((Inst_loadi)(inst)).getAddr0() + ", " + trg);

               spillTarget(((Inst_loadi)(inst)).getAddr1(), trg);
            }
            else if (inst instanceof Inst_loadai)
            {
               String src = getSource(((Inst_loadai)(inst)).getAddr0(), "%o5");
               String trg = getSource(((Inst_loadai)(inst)).getAddr2(), "%o4");
               
               Inst_loadai temp = (Inst_loadai)(inst);

               if (temp.getExtraInfo().equals("._GLOBAL_."))
               {
                  //TODO make sure this is right.
                  out.println(tab + "ldsw " + "[" + src + "+0]" + trg);
               }
               else //Struct
               {
                  Struct st = structs.get(temp.getExtraInfo());
                  int fieldAddr = st.getFieldNum(temp.getAddr1()) * 4;

                  out.println(tab + "ldsw " + "[" + src + "+" + fieldAddr + "], " + trg);
               }

               spillTarget(((Inst_loadai)(inst)).getAddr2(), trg);
            }
            else if (inst instanceof Inst_storeai)
            {
               String src1 = getSource(((Inst_storeai)(inst)).getAddr0(), "%o5");
               String src2 = getSource(((Inst_storeai)(inst)).getAddr1(), "%o4");
               
               Inst_storeai temp = (Inst_storeai)(inst);

               if (temp.getExtraInfo().equals("._GLOBAL_."))
               {
                  //TODO make sure this is right.
                  System.out.println("TEST!");
                  out.println(tab + "stw " + src1 + ", [" + src2 + "+0]");
               }
               else //Struct
               {
                  Struct st = structs.get(temp.getExtraInfo());
                  int fieldAddr = st.getFieldNum(temp.getAddr2()) * 4;

                  out.println(tab + "stw " + src1 + ", [" + src2 + "+" + fieldAddr + "]");
               }
            }
            else if (inst instanceof Inst_storeglobal)
            {
               Inst_storeglobal temp = (Inst_storeglobal)inst;

               String src = getSource(temp.getAddr0(), "%o4");

               out.println(tab + "sethi %hi(" + temp.getAddr1() + "), %o5");
               out.println(tab + "or %o5, %lo(" + temp.getAddr1() + "), %o5");
               out.println(tab + "st " + src + ", [%o5]");
            }
            else if (inst instanceof Inst_loadglobal)
            {
               Inst_loadglobal temp = (Inst_loadglobal)inst;

               String trg = getTarget(temp.getAddr1(), "%o4");

               out.println(tab + "sethi %hi(" + temp.getAddr0() + "), %o5");
               out.println(tab + "or %o5, %lo(" + temp.getAddr0() + "), %o5");
               out.println(tab + "ld " + "[%o5], " + trg);

               spillTarget(temp.getAddr1(), trg);
            }
            //TODO: check command
            else if (inst instanceof Inst_computeglobaladdress)
            {
               Inst_computeglobaladdress temp = (Inst_computeglobaladdress)inst;

               String trg = getTarget(temp.getAddr1(), "%o4");

               out.println(tab + "sethi %hi(" + temp.getAddr0() + "), %o5");
               out.println(tab + "or %o5, %lo(" + temp.getAddr0() + "), %o5");
               out.println(tab + "mov %o5, " + trg);

               spillTarget(temp.getAddr1(), trg);
            }
            //END LOADS / STORES
            //BEGIN IO
            else if (inst instanceof Inst_print)
            {
               String src = getSource(((Inst_print)(inst)).getAddr0(), "%o4");
               
               out.println(tab + "sethi %hi(.LLC0), %o5");
               out.println(tab + "or %o5, %lo(.LLC0), %o0");
               out.println(tab + "mov " + src + ", %o1");
               out.println(tab + "call printf, 0");
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_println)
            {
               String src = getSource(((Inst_println)(inst)).getAddr0(), "%o4");
               
               out.println(tab + "sethi %hi(.LLC1), %o5");
               out.println(tab + "or %o5, %lo(.LLC1), %o0");
               out.println(tab + "mov " + src + ", %o1");
               out.println(tab + "call printf, 0");
               out.println(tab + nop);
            }
            else if (inst instanceof Inst_read)
            {
               String src = getSource(((Inst_read)(inst)).getAddr0(), "%o4");
               
               out.println(tab + "sethi %hi(.LLC2), %o5");
               out.println(tab + "or %o5, %lo(.LLC2), %o0");
               out.println(tab + "mov " + src + ", %o1");
               out.println(tab + "call scanf");
               out.println(tab + nop);
            }
            //ENDIO
            else if (inst instanceof FakeInstruction)
            {
               //Ignore fakes.
            }
            else
            {
               out.println("ILOC: " + inst);
            }
         }

         //Need to write tail?
         if (block.isExit())
         {
            out.println(tab + ".size " + block.getFunName() + ", .-" + block.getFunName());

            if (block.getFunName().equals("main"))
            {
               for (Variable var : sym.getGlobals())
               {
                  if (!var.isFunction())
                  {
                     out.println(tab + ".common " + var.getName() + ",4,4");
                  }
               }
            }
         }
      }
   }

   public void spillTarget(Register trg, String name)
   {
      if (regMap.isSpill(trg))
      {
         //Insert a store to the spill from the given register (name).
         int spillAddr = firstSpillAddr + (regMap.getSpillIndex(trg) * 4);
         out.println(tab + "st " + name + ", [%fp+" + spillAddr + "]");
      }
   }

   public boolean isSameRegister(Register a, Register b)
   {
      String aReg = null;
      String bReg = null;

      try
      {
         aReg = regMap.get(a);
         bReg = regMap.get(b);

         return aReg.equals(bReg);
      }
      catch (RegisterMap.SpillException ex)
      {
         return false;
      }
   }

   public String getTarget(Register trg, String name)
   {
      String rtn = null;

      try
      {
         rtn = regMap.get(trg);
      }
      catch (RegisterMap.SpillException ex)
      {
         rtn = name;
      }

      return rtn;
   }

   public String getSource(Register src, String name)
   {
      String rtn = null;

      try
      {
         rtn = regMap.get(src);
      }
      catch (RegisterMap.SpillException ex)
      {
         rtn = name;

         //Insert a load from the spill into the given register (name).
         int spillAddr = firstSpillAddr + (regMap.getSpillIndex(src) * 4);
         out.println(tab + "ld [%fp+" + spillAddr + "], " + name);
      }

      return rtn;
   }

   public void writeHeader(String fileName)
   {
      out.println("!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine\n");
      out.println(tab + ".file \"" + fileName + "\"");
      out.println(tab + ".section \".text\"");
      out.println();

      out.println(".LLC0:");
      out.println(tab + ".asciz \"%d \"");
      out.println(tab + ".section \".text\"");
      out.println();

      out.println(".LLC1:");
      out.println(tab + ".asciz \"%d\\n\"");
      out.println(tab + ".section \".text\"");
      out.println();

      out.println(".LLC2:");
      out.println(tab + ".asciz \"%d\"");
      out.println(tab + ".section \".text\"");

      //De we need this?
      /*
      for (Variable var : sym.getGlobals())
      {
         if (!var.isFunction())
         {
            out.println(tab + ".global " + var.getName());
            out.println(tab + ".section \".data\"");
            out.println(tab + ".align 4");
            out.println(tab + ".type " + var.getName() + ", #object");
            out.println(tab + ".size " + var.getName() + ", 4");
            out.println(var.getName() + ":");
            out.println(tab + ".long 5");

            out.println();
         }
      }
      */
   }

   public void writeFunctionHeader(String funName)
   {
      out.println();
      out.println(tab + ".align 4");
      out.println(tab + ".global " + funName);
      out.println(tab + ".type " + funName + ", #function");
      out.println(tab + ".proc 04");
   }
}
