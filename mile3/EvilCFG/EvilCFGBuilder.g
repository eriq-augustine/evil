tree grammar EvilCFGBuilder;

options
{
   ASTLabelType = CommonTree;
   tokenVocab = Evil;
}

@header
{
   package EvilCFG;

   import java.util.Hashtable;
}

program
   : 
   {
      System.out.println("Beginning CFG building");
      SymbolTable sym = new SymbolTable();
      StructTable structs = new StructTable();
   }
   ^(PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs]) 
   {
      System.out.println(sym);
      System.out.println(structs + "\n");

      System.out.println(((Function)(sym.get("main"))).getBody().fullToString());

      System.out.println("Finished CFG building");
   }
   ;

types[StructTable structs]
   : ^(TYPES types_sub[structs])
   | TYPES
   ;

types_sub[StructTable structs]
   : type_declaration[structs] types_sub[structs]
   |
   ;

type_declaration[StructTable structs]
   : ^(STRUCT id=ID 
      {
         Struct myStruct = new Struct($id.text);
         structs.add($id.text, myStruct);
      }
      struct_nested_decl[structs, myStruct]
      {
      }
      )
   ;

struct_nested_decl[StructTable structs, Struct myStruct]
   : (
        var=decl[structs]
        {
           myStruct.addField(var);
        }
     )+
   ;

decl[StructTable structs] returns [Variable var = null]
   : ^(DECL ^(TYPE ty=type[structs]) id=ID)
      {
         var=ty;
         var.setName($id.text);
      }
   ;

type[StructTable structs] returns [Variable var = null]
   : INT {var = new Primitive();}
   | BOOL {var= new Primitive();}
   | ^(STRUCT id=ID) {var = new Reference(structs.get($id.text));}
   ;

declarations[SymbolTable sym, StructTable structs]
   : ^(DECLS declaration[sym, structs]*)
   | 
   ;

declaration[SymbolTable sym, StructTable structs]
   : ^(DECLLIST ^(TYPE var=type[structs]) id_list[var, sym]) 
   ;

global_declarations[SymbolTable sym, StructTable structs]
   : ^(DECLS global_declaration[sym, structs]*)
   | 
   ;

global_declaration[SymbolTable sym, StructTable structs]
   : ^(DECLLIST ^(TYPE var=type[structs]) global_id_list[var, sym]) 
   ;

id_list[Variable var, SymbolTable sym]
  : (id=ID
      {
         Variable temp = var.copy();
         temp.setName($id.text);
         temp.setScope(ScopeType.kLocal);
         sym.add($id.text, temp);
      }
    )+
  ;

global_id_list[Variable var, SymbolTable sym]
  : (id=ID
      {
         Variable temp = var.copy();
         temp.setName($id.text);
         temp.setScope(ScopeType.kGlobal);
         sym.add($id.text, temp);
      }
    )+
  ;

functions[SymbolTable sym, StructTable structs]
   : ^(FUNCS 
      (
         {
         }
         fun=function[sym, structs]
         {
            sym.add(fun.getName(), fun);
         }
      )*
      )
   | 
   ;

function[SymbolTable sym, StructTable structs] returns [Function fun = null]
   : ^(FUN 
      {
      }
      id=ID
      {
         sym.newState();
         
         BasicBlock funEntry = new BasicBlock();
         BasicBlock body = new BasicBlock();

         //Add temperary function to state to top state to support recursion.
         sym.add($id.text, new Function($id.text, funEntry, null));

         funEntry.addInstruction(new FakeInstruction("ENTRY Block to: " + $id.text));
         funEntry.addInstruction(new Inst_jmp(body.getTag()));
      }
      parameters[sym, structs] 
      ^(RETTYPE return_type[structs]) 
      declarations[sym, structs] 
      statement_list[sym, structs, body]
      {
         //Remove the temp (recursion) function.
         sym.remove($id.text);

         Hashtable<String, Variable> scope = sym.removeState();
         BasicBlock end = new BasicBlock();
         
         //Return from function.
         end.addInstruction(new FakeInstruction("EXIT Block from: " + $id.text));
         end.addInstruction(new Inst_ret());
         
         funEntry.addKid(body);
         funEntry.addCommonEnd(end);

         fun = new Function($id.text, funEntry, scope);
      }
      )
   ;

parameters[SymbolTable sym, StructTable structs]
   : ^(PARAMS 
      (
         var=decl[structs]
         {
            var.setScope(ScopeType.kFormal);
            sym.add(var.getName(), var);
         }
      )*)
   ;

return_type[StructTable structs] returns [Variable var = null]
   : v=type[structs] {var = v;}
   | VOID
   ;

statement_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock]
   : ^(STMTS 
         {
            tempBlock = bBlock;
         }
         (
         tempBlock=statement[sym, structs, tempBlock]
         )*
      )
      {
         rtn = tempBlock;
      }
   ;

statement[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock]
   : tempBlock=block[sym, structs, bBlock] {rtn = tempBlock.getbBlock();}
   | tempBlock=assignment[sym, structs, bBlock]  {rtn = tempBlock.getbBlock();}
   | tempBlock=print[sym, structs, bBlock]  {rtn = tempBlock.getbBlock();}
   | read[sym, structs, bBlock]
   | tempBlock=conditional[sym, structs, bBlock] {rtn = tempBlock.getbBlock();}
   | tempBlock=loop[sym, structs, bBlock] {rtn = tempBlock.getbBlock();}
   | tempBlock=delete[sym, structs, bBlock]  {rtn = tempBlock.getbBlock();}
   | tempBlock=ret[sym, structs, bBlock]  {rtn = tempBlock.getbBlock();}
   | tempBlock=invocation[sym, structs, bBlock] {rtn = tempBlock.getbBlock();}
   ;

block[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn]
   : ^(BLOCK tempBlock=statement_list[sym, structs, bBlock])
      {
         rtn = tempBlock;
      }
   ;

assignment[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : ^(ASSIGN tempBlock=expression[sym, structs, bBlock] 
      {
         BasicBlock b = tempBlock.getbBlock();
      }
      reg=lvalue[sym, structs, b])
      {
         tempBlock.getbBlock().addInstruction(new Inst_mov(tempBlock.getReg(), reg)); 
         rtn = tempBlock.getbBlock();
      }
   ;

print[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : ^(PRINT tempBlock=expression[sym, structs, bBlock] (ENDL)?)
      {
         tempBlock.getbBlock().addInstruction(new Inst_print(tempBlock.getReg()));
         rtn = tempBlock.getbBlock();
      }
   ;

read[SymbolTable sym, StructTable structs, BasicBlock bBlock]
   : ^(READ reg=lvalue[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_read(reg));
      }
   ;

conditional[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : ^(IF 
         tempBlock=expression[sym, structs, bBlock] 
         {
            //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD"));

            BasicBlock thenBlock = new BasicBlock();
            tempBlock.getbBlock().addKid(thenBlock);
            thenBlock.getbBlock().addParent(tempBlock.getbBlock());
            
            //thenBlock.addInstruction(new FakeInstruction("THEN BEGIN"));
         }
         block[sym, structs, thenBlock] 
         {
            BasicBlock elseBlock = null;
         }
         (
            {
               elseBlock = new BasicBlock();
               tempBlock.addKid(elseBlock);
               elseBlock.addParent(tempBlock.getbBlock());
            
              //elseBlock.addInstruction(new FakeInstruction("ELSE BEGIN"));
            }
            block[sym, structs, elseBlock]
         )?
      )
      {
         BasicBlock follows = new BasicBlock();
         tempBlock.addCommonEnd(follows);
         if (elseBlock != null)
         {
            //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD. Contemplating: " + thenBlock.getTag() + ", " + elseBlock.getTag()));
            tempBlock.addInstruction(new Inst_compi(tempBlock.getReg(), 1));
            tempBlock.addInstruction(new Inst_cbreq(thenBlock.getTag(), elseBlock.getTag()));
         }
         else
         {
            //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD. Contemplating: " + thenBlock.getTag()));
            tempBlock.addInstruction(new Inst_compi(tempBlock.getReg(), 1));
            tempBlock.addInstruction(new Inst_cbreq(thenBlock.getTag(), follows.getTag()));
         }
         
         tempBlock.addCommonEnd(follows);
         
         rtn = follows;
      }
   ;

loop[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : ^(WHILE 
      topGuardBlock=expression[sym, structs, bBlock]
      {
         BasicBlock bodyBlock = new BasicBlock();
         //bodyBlock.addInstruction(new FakeInstruction("WHILE BODY"));

         topGuardBlock.getbBlock().addKid(bodyBlock);
         bodyBlock.addParent(topGuardBlock.getbBlock());
      }
      //Note the difference between the bodyBlock and the bodyEndBlock
      // to jump into the body, you must jump to the bodyBlock, to jump out of it (to guard)
      // you must jump out from the bodyEndBlock.
      bodyEndBlock=block[sym, structs, bodyBlock] 
      {
         BasicBlock bottomGuardBlock = new BasicBlock();
         
         bodyEndBlock.addInstruction(new Inst_jmp(bottomGuardBlock.getTag()));

         bodyEndBlock.addKid(bottomGuardBlock);
         bottomGuardBlock.addParent(bodyBlock);
      }
      //See not above about the need for an end and beginning block.
      // This applys on any cycle.
      bottomGuardEndBlock=expression[sym, structs, bottomGuardBlock]
      {
         BasicBlock follows = new BasicBlock();
         //follows.addInstruction(new FakeInstruction("WHILE FOLLOWS"));
         
         bottomGuardEndBlock.getbBlock().addKid(bodyBlock);
         bodyBlock.addParent(bottomGuardEndBlock.getbBlock());

         bottomGuardEndBlock.addKid(follows);
         follows.addParent(bottomGuardEndBlock.getbBlock());

         topGuardBlock.addKid(follows);
         follows.addParent(topGuardBlock.getbBlock());
         
         //bottomGuardBlock.addInstruction(new FakeInstruction("WHILE BOTTOM GUARD. Will loop-back (" + bodyBlock.getTag() + "), or follow (" + follows.getTag() + ")"));
         bottomGuardBlock.addInstruction(new Inst_compi(bottomGuardEndBlock.getReg(), 1));
         bottomGuardBlock.addInstruction(new Inst_cbreq(bodyBlock.getTag(), follows.getTag()));
         //topGuardBlock.addInstruction(new FakeInstruction("WHILE TOP GUARD. Will loop (" + bodyBlock.getTag() + "), or follow (" + follows.getTag() + ")"));
         topGuardBlock.addInstruction(new Inst_compi(topGuardBlock.getReg(), 1));
         topGuardBlock.addInstruction(new Inst_cbreq(bodyBlock.getTag(), follows.getTag()));
      }
      )
      {
         rtn = follows;
      }
   ;

delete[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : ^(DELETE tempBlock=expression[sym, structs, bBlock])
      {
         //tempBlock.getbBlock().addInstruction(new FakeInstruction("DELETE"));
         tempBlock.getbBlock().addInstruction(new Inst_del(tempBlock.getReg()));
         rtn = tempBlock.getbBlock();
      }
   ;

ret[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : ^(RETURN tempBlock=expression[sym, structs, bBlock])
      {
         tempBlock.getbBlock().addInstruction(new Inst_ret());
         rtn = tempBlock.getbBlock();
      }
   ;

invocation[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock ret = null]
   : ^(INVOKE id=ID tempBlock=arguments[sym, structs, bBlock])
      {
         tempBlock.addInstruction(new Inst_call(((Function)(sym.get($id.text))).getBody().getTag() + " ("+((Function)(sym.get($id.text))).getName()+")"));

         /*Don't need to break block for invocation
         //IF it is decided to have incocation split blocks,
         // then make sure to look at expression!
         newBlock = new BasicBlock();
         tempBlock.addKid(newBlock);
         newBlock.addParent(tempBlock);

         tempBlock.addInstruction(new FakeInstruction("Jump to: " + newBlock.getTag()));
         */

         ret = tempBlock;
      }
   ;

lvalue[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Register reg = null]
   : ID (DOT ID)+
      {
         reg = new Register();
         bBlock.addInstruction(new FakeInstruction(reg.toString() + " has the result from lvalue w/ dots"));
      }
   | ID
      {
         reg = new Register();
         bBlock.addInstruction(new FakeInstruction(reg.toString() + " has the result from lvalue w/out dots"));
      }
   ;

//BE AWARE: Because invocation does not split the block, these expression
// returns do not have to have the expression call checked. If invocation
// decides to split blocks, make sure to change this.
expression[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Warden rtn = null]
   : ^(AND exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_and(exp1.getReg(), exp2.getReg(), temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(OR exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_or(exp1.getReg(), exp2.getReg(), temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(EQ exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp)); //initilize temp = false
         bBlock.addInstruction(new Inst_moveq(1, temp)); //if the condition codes are == move true to temp
         rtn = new Warden(temp, bBlock);
      }
   | ^(LT exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp));
         bBlock.addInstruction(new Inst_movlt(1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(GT exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp));
         bBlock.addInstruction(new Inst_movgt(1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(NE exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp));
         bBlock.addInstruction(new Inst_movne(1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(LE exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp));
         bBlock.addInstruction(new Inst_movle(1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(GE exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp));
         bBlock.addInstruction(new Inst_movge(1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(PLUS exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_add(exp1.getReg(), exp2.getReg(), temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(MINUS exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_sub(exp1.getReg(), exp2.getReg(), temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(TIMES exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_mult(exp1.getReg(), exp2.getReg(), temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(DIVIDE exp1=expression[sym, structs, bBlock] exp2=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_div(exp1.getReg(), exp2.getReg(), temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(NOT exp1=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_xori(exp1.getReg(), -1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(NEG exp1=expression[sym, structs, bBlock])
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(-1, temp));
         bBlock.addInstruction(new Inst_mult(exp1.getReg(), temp, temp));
         rtn = new Warden(temp, bBlock);
      }
   | ^(DOT expression[sym, structs, bBlock] ID)
      {
         Register temp = new Register();
         //bBlock.addInstruction(new FakeInstruction("DOTED RVALUE")); //TODO: change to add a dRightVal instruction
         rtn = new Warden(temp, bBlock);
      }
   //| ^(INVOKE ID arguments)
   | ^(NEW id=ID)
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_new($id.text, new Register()));
         rtn = new Warden(temp, bBlock);
      }
   | tempBlock=invocation[sym, structs, bBlock] 
      {
         rtn = new Warden(new Register(), tempBlock);
      }
   | id=ID 
      {
         Register temp = new Register();
         if(sym.isGlobal($id.text))
         {  
            //TODO: load from memory
         }
         else
         {
            //TODO: move from register
         }
         rtn = new Warden(temp, bBlock);
      }
   | id=INTEGER 
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(Integer.valueOf($id.text), temp));
         rtn = new Warden(temp, bBlock);
      }
   | TRUE 
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(1, temp));
         rtn = new Warden(temp, bBlock);
      }
   | FALSE 
      {
         Register temp = new Register();
         bBlock.addInstruction(new Inst_loadi(0, temp));
         rtn = new Warden(temp, bBlock);
      }
   | NULL {rtn = new Warden(new Register(), bBlock);}
   ;

arguments[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null]
   : tempBlock=arg_list[sym, structs, bBlock] {rtn = tempBlock;}
   ;

arg_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock]
   : ^(ARGS (tempBlock=expression[sym, structs, bBlock])+)
      {
         tempBlock.addInstruction(new Inst_loadinarg(tempBlock.getReg())); 
         rtn = tempBlock.getbBlock();
      }
   | ARGS
   ;
