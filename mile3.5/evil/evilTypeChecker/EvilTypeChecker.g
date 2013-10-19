tree grammar EvilTypeChecker;

options
{
   ASTLabelType = CommonTree;
   tokenVocab = Evil;
}

@header
{
   package evil.evilTypeChecker;
   //Imports plz, we get List, ArrayList, and Stack for free.
}

@members
{
   private void error(int line, String err)
   {
      System.err.println("Error on line " + line + ": " + err);
      System.exit(1);
   }

   private void binaryRequires(int line, String op, String eL, String eR, String gotL, String gotR)
   {
      System.err.println("Error on line " + line + ": Binary operator: "
       + op + " requires '" + eL + "' * '" + eR + "', got '"
       + gotL + "' * '" + gotR + "'");
      System.exit(1);
   }
}

program
   : { 
       System.out.println("Beginning Typechecking...");
       State env = new State(); 
       env.addState();
       State structs = new State();
       structs.addState();
     }
      ^(PROGRAM types[structs] declarations[structs, env] functions[structs, env]) 
      {
         //System.out.println("Structs:");
         //structs.print();
         //System.out.println("Env:");
         //env.print();
         System.out.println("Finished Typechecking... Congrats!");
      }

   ;

types[State structs]
   : ^(TYPES types_sub[structs])
   | TYPES
   ;

types_sub[State structs]
   : type_declaration[structs] types_sub[structs]
   |
   ;

//First add the new struct type to the state, then make sure any struct's within
// this struct are already defined.
//Make sure that structs are indexed in the State struct by its name.
type_declaration[State structs]
   : ^(STRUCT id=ID 
       { 
         TypeStruct newStruct = new TypeStruct($id.text);
         structs.add($id.text, newStruct);
       }
       struct_nested_decl[structs, $id.text]
      )
   ;

//This is ONLY used for structs
//Plan: Make struct Type be able to hold its own members, check to see if member is defined 
//       before inserting it.
struct_nested_decl[State structs, String id]
   : (struct_decl[structs, id])+
   ;

//Add member datum to the struct.
struct_decl[State structs, String structId]
   : ^(DECL ^(TYPE ty=type[structs]) id=ID)
      {
         ((TypeStruct)(structs.get(structId))).addMember($id.text, ty);
      }
   ;

//NOTE: This is only used for params
//Add the type to the state as a formal.
decl[State structs, State env] returns [Type ty = null]
   : ^(DECL ^(TYPE typ=type[structs]) id=ID)
      {
         env.addFormal($id.text, typ);
         ty = typ;
      }
   ;

//Return a Type representing the value.
type[State structs] returns [Type t = null]
   : INT { $t = new TypeInt(); }
   | BOOL { $t = new TypeBool(); }
   | ^(STRUCT id=ID)
      {
         if (!structs.isDefined($id.text)) //If struct type is undefined.
         {
            error($id.line, "use of undefined struct type '" + $id.text + "'");
         }
         $t = new TypeStruct($id.text);
      }
   ;

//global declarations, or declarations at top of functions.
declarations[State structs, State env]
   : ^(DECLS declaration[structs, env]*)
   | 
   ;

//Ex: int a;
//Ex: bool x, y, z;
declaration[State structs, State env]
   : ^(DECLLIST ^(TYPE tp=type[structs]) id_list[env, tp]) 
   ;

id_list[State env, Type tp]
  : (id=ID
      {
         if(env.isFormal($id.text) || env.isLocal($id.text)) 
         {
            error($id.line, "Redefinition of variable '"+$id.text+"'");
         }
         else if(env.isFormal($id.text))
         {
            error($id.line, "Attempting to hide formal parameter '"+$id.text+"'");
         }
         env.add($id.text, tp);
      }
    )+
  ;

//Functions declared at top of program
//Main must be one of these.
functions[State structs, State env]
    : ^(FUNCS function[structs, env]*)
      {
         if (!env.isDefined("main"))
         {
            error(0, "No main found.");
         }
      }
   ;

//New stackframe plz
function[State structs, State env]
   : {env.addState();}
     ^(FUN id=ID 
      { TypeFun fun = new TypeFun($id.text); }
      params=parameters[structs, env, fun] 
      ^(RETTYPE retType=return_type[structs])
      { fun.setReturn(retType); }
      decs=declarations[structs, env]
      //{System.out.println("test");} //This will execute before statemants are checked.
      //id_list will check to make sure decs don't hide params.
      // see example, will have to differntiate between normal variables and params (formals)
      //Add to fun table here so recursion can happen.
      { 
         env.addFun($id.text, fun); 
      }
      ty=statement_list[structs, env])
      {
         if(!(ty.equals(fun.getReturn())))
         {
            if (ty instanceof TypeVoid)
            {
               error($id.line, "Function '"+id.toString()+"' may not return");
            }
            else
            {
               error($id.line, "Function '"+id.toString()+"' requires return type '"+retType.toString()+"' has return type '"+ty.toString()+"'");
            }
         }
         env.removeState();
      }
         //Check that return matches declared type (or hapened at all of declared).
   ;

parameters[State structs, State env, TypeFun fun]
   : ^(PARAMS (ty=decl[structs, env] {fun.addParam(ty);})*)
   ;

return_type[State structs] returns [Type t = null]
   : ty=type[structs] { $t = ty; }
   | VOID { $t = new TypeVoid(); }
   ;

statement[State structs, State env] returns [Type typ = new TypeVoid()]
   : ty=block[structs, env]
   {
      typ = ty;
   }
   | assignment[structs, env]
   {
      typ = new TypeVoid();
   }
   | print[structs, env]
   {
      typ = new TypeVoid();
   }
   | read[structs, env]
   {
      typ = new TypeVoid();
   }
   | ty=conditional[structs, env]
   {
      typ = ty;
   }
   | loop[structs, env]
   {
      typ = new TypeVoid();
   }
   | delete[structs, env]
   {
      typ = new TypeVoid();
   }
   | ty=ret[structs, env]
   {
      typ = ty;
   }
   | invocation[structs, env]
   {
      typ = new TypeVoid();
   }
   ;

block[State structs, State env] returns [Type typ = new TypeVoid()]
   : ^(BLOCK ty=statement_list[structs, env]) {typ=ty;}
   ;

statement_list[State structs,State env] returns [Type typ = new TypeVoid()]
   : ^(STMTS ty=statement[structs, env]*) 
      {
         if (ty != null)
         {
            typ=ty;
         }
      }
   ;

assignment[State structs, State env]
   : ^(as=ASSIGN rTy=expression[structs, env] lTy=lvalue[structs, env])
      {
         if (!(rTy.equals(lTy)))
         {
            error($as.line, "Attempt to assign '" + rTy + "' to '" + lTy + "'");
         }
      }
   ;

lvalue[State structs, State env] returns [Type ty = null]
   : id=ID
      {
        String name = $id.text;
        ty = env.get(name);
      }
   | ^(DOT temp=lvalue[structs, env] member=ID)
      {
         if (!(temp instanceof TypeStruct))
         {
            error($member.line, "Attempt to access member datum of non-struct value.");
         }
        
         ty = ((TypeStruct)(structs.get(((TypeStruct)(temp)).getName()))).getMember($member.text);
      }
   ;

/*
lvalue[State structs, State env] returns [Type ty = null]
   : id=ID
     { 
        String name = $id.text;
        ty = env.get(name); 
        
        if ((ty instanceof TypeStruct) || (ty instanceof TypeNull))
        {
           name = ((TypeStruct)(ty)).getName();
        }
     }
     (DOT member=ID
      {
         System.err.println(name);
         //Ensure that name is now the name of the structure that is to be         // indexed into.
         if (!(ty instanceof TypeStruct))
         {
            error($id.line, "Attempt to access member datum of non-struct value.");
         }

         ty = ((TypeStruct)(structs.get(name))).getMember($member.text);

         if (ty instanceof TypeStruct)
         {
            name = ((TypeStruct)(ty)).getName();
         }
      }
     )*
   ;
*/
print[State structs, State env]
   : ^(p=PRINT exp=expression[structs, env] (ENDL)?)
      {
         if (!(exp instanceof TypeInt))
         {
            error($p.line, "Attempt to print non-integer type: '" + exp + "'");
         }
      }
   ;

read[State structs, State env]
   : ^(r=READ l=lvalue[structs, env])
      {
         if (!(l instanceof TypeInt))
         {
            error($r.line, "Attempt to read into non-integer type: '" + l + "'");
         }
      }
   ;

conditional[State structs, State env] returns [Type ty = null]
   : ^(cond=IF guard=expression[structs, env] tp=block[structs, env] (typ=block[structs, env])?)
      {
         if (!(guard instanceof TypeBool))
         {
            error($cond.line, "Attempt to guard conditional with non-bool type: '" + guard + "'");
         }
         
         if((tp != null) && (typ != null) && !(tp instanceof TypeVoid) && !(typ instanceof TypeVoid))  
         {
            if (!(tp.equals(typ)))
            {
               error($cond.line, "Return type mismatch within conditional");
            }

            ty=tp;
         }
         else
         {
            ty = new TypeVoid();
         }
      }
   ;

loop[State structs, State env]
   : ^(cond=WHILE guard1=expression[structs, env] block[structs, env] guard2=expression[structs, env])
      {
         if (!(guard1 instanceof TypeBool))
         {
            error($cond.line, "Attempt to guard loop with non-bool type: '" + guard1 + "'");
         }
         
         if (!(guard2 instanceof TypeBool))
         {
            error($cond.line, "Attempt to guard loop with non-bool type: '" + guard2 + "'");
         }
      }
   ;

delete[State structs, State env]
   : ^(d=DELETE exp=expression[structs, env])
      {
         if (!(exp instanceof TypeStruct))
         {
            error($d.line, "Attempt to delete non-reference type: '" + exp + "'");
         }
      }
   ;

ret[State structs, State env] returns [Type ty = null]
   : ^(r=RETURN (exp=expression[structs, env])?)
      {
         if (exp == null)
         {
            ty = new TypeVoid();
         }
         else if (exp instanceof TypeFun)
         {
            error($r.line, "Attempt to return invocation");
         }
         else
         {
            ty=exp;
         }
      }
   ;


invocation[State structs, State env]
   : ^(INVOKE id=ID args=arguments[structs, env]
       invocation_help[structs, env, $id.text, args, $id.line])
   ;

invocation_help[State structs, State env, String id, ArrayList<Type> gotArgs, int lineNum] returns [Type ty = null]
   :
      {
         if (!(env.isDefined(id)))
         {
            error(lineNum, "Use of undeclared variable: '" + id + "'");
         }

         if (!(env.get(id) instanceof TypeFun))
         {
            error(lineNum, "Attempt to invoke non-function '" + id + "'");
         }

         ArrayList<Type> expectedArgs = ((TypeFun)env.get(id)).getParams();
         
         if (expectedArgs.size() < gotArgs.size())
         {
            error(lineNum, "Too many arguments for invocation of '" + id + "'");
         }
         else if (expectedArgs.size() > gotArgs.size())
         {
            error(lineNum, "Too few arguments for invocation of '" + id + "'");
         }

         int count = 0;
         while (count < expectedArgs.size())
         {
            Type expected = expectedArgs.get(count);
            Type got = gotArgs.get(count);

            if (!expected.equals(got))
            {
               if( !(expected instanceof TypeStruct) && !(got instanceof TypeNull)  )
               {
                  error(lineNum, "Type mismatch on argument #" + (count + 1) + " for invocation of '" + id + "'");
               }
            }
            
            count++;
         }

         ty = ((TypeFun)env.get(id)).getReturn();
      }
   ;

expression[State structs, State env] returns [Type ty = null]
   : ^(op=(AND | OR) left=expression[structs, env] right=expression[structs, env])
      {
         if ( !(left instanceof TypeBool) || !(right instanceof TypeBool))
         {
            binaryRequires($op.line, $op.text, "bool", "bool", left.toString(), right.toString());
         }
         ty = new TypeBool();
      }
   | ^(op=(EQ | LT | GT | NE | LE | GE) left=expression[structs, env] right=expression[structs, env])
      {
         if ( !(left instanceof TypeInt) || !(right instanceof TypeInt) )
         {
            binaryRequires($op.line, $op.text, "int", "int", left.toString(), right.toString());
         }
         ty = new TypeBool();
      }
   | ^(op=(PLUS | MINUS) left=expression[structs, env] right=expression[structs, env])
      {
         if ( !(left instanceof TypeInt) || !(right instanceof TypeInt) )
         {
            binaryRequires($op.line, $op.text, "int", "int", left.toString(), right.toString());
         }
         ty = new TypeInt();
      }
   | ^(op=(TIMES | DIVIDE) left=expression[structs, env] right=expression[structs, env])
      {
         if ( !(left instanceof TypeInt) || !(right instanceof TypeInt) )
         {
            binaryRequires($op.line, $op.text, "int", "int", left.toString(), right.toString());
         }
         ty = new TypeInt();
      }
   | ^(op=NOT operand=expression[structs, env])
      {
         if (!(operand instanceof TypeBool))
         {
            error($op.line, "Unary operator '" + $op.text + "' requires bool operand, found '" + operand + "'");
         }
         ty = new TypeBool();
      }
   | ^(op=NEG operand=expression[structs, env])
      {
         if (!(operand instanceof TypeInt))
         {
            error($op.line, "Negation requires int operand, found '" + operand + "'");
         }
         ty = new TypeInt();
      }
   | ^(op=DOT operand=expression[structs, env] id=ID)
      {
         if (!(operand instanceof TypeStruct))
         {
            error($id.line, "Attempt to access member datum of non-struct value.");
         }

         operand =  (structs.get(((TypeStruct)operand).getName()));
         if (operand == null || ((TypeStruct)(operand)).getMember($id.text) == null)
         {
            error($id.line, "Struct '" + ((TypeStruct)(operand)).getName() + "' has no member named: '" + $id.text + "'");
         }

         ty = ((TypeStruct)operand).getMember($id.text);
      }
   | ^(INVOKE id=ID gotArgs=arguments[structs, env] 
       temp=invocation_help[structs, env, $id.text, gotArgs, $id.line]
       {
         ty = temp;
       }
      )
   | id=ID
      {
         if (!(env.isDefined($id.text)))
         {
            error($id.line, "Use of undeclared variable: '" + $id.text + "'");
         }

         ty = env.get($id.text);
      }
   | INTEGER
      {
         ty = new TypeInt();
      }
   | TRUE
      {
         ty = new TypeBool();
      }
   | FALSE
      {
         ty = new TypeBool();
      }
   | ^(NEW id=ID)
      {
         if (!structs.isDefined($id.text)) //If struct type is undefined.
         {
            error($id.line, "use of undefined struct type '" + $id.text + "'");
         }
         ty = new TypeStruct($id.text);
      }
   | NULL
      {
         ty = new TypeNull();
      }
   ;

/*
selector
   : ^(DOT expression[structs, env] ID)
   ;
*/

arguments[State structs, State env] returns [ArrayList<Type> args = new ArrayList<Type>()]
   : gotArgs=arg_list[structs, env] { args = gotArgs; }
   ;

arg_list[State structs, State env] returns [ArrayList<Type> args = new ArrayList<Type>()]
   : ^(ARGS (exp=expression[structs, env] {args.add(exp);})+)
   | ARGS
   ;
