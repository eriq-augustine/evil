// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 EvilTypeChecker.g 2010-04-12 11:30:38

   //Imports plz, we get List, ArrayList, and Stack for free.


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EvilTypeChecker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRUCT", "INT", "BOOL", "FUN", "VOID", "PRINT", "ENDL", "READ", "IF", "ELSE", "WHILE", "DELETE", "RETURN", "TRUE", "FALSE", "NEW", "NULL", "PROGRAM", "TYPES", "TYPE", "DECLS", "FUNCS", "DECL", "DECLLIST", "PARAMS", "RETTYPE", "BLOCK", "STMTS", "INVOKE", "ARGS", "NEG", "LBRACE", "RBRACE", "SEMI", "COMMA", "LPAREN", "RPAREN", "ASSIGN", "DOT", "AND", "OR", "EQ", "LT", "GT", "NE", "LE", "GE", "PLUS", "MINUS", "TIMES", "DIVIDE", "NOT", "ID", "INTEGER", "WS", "COMMENT"
    };
    public static final int LT=46;
    public static final int WHILE=14;
    public static final int LBRACE=35;
    public static final int STMTS=31;
    public static final int NEW=19;
    public static final int TYPES=22;
    public static final int NOT=55;
    public static final int AND=43;
    public static final int ID=56;
    public static final int EOF=-1;
    public static final int LPAREN=39;
    public static final int RETTYPE=29;
    public static final int TYPE=23;
    public static final int IF=12;
    public static final int RPAREN=40;
    public static final int DECLLIST=27;
    public static final int COMMA=38;
    public static final int RETURN=16;
    public static final int ARGS=33;
    public static final int PLUS=51;
    public static final int VOID=8;
    public static final int EQ=45;
    public static final int COMMENT=59;
    public static final int DOT=42;
    public static final int DIVIDE=54;
    public static final int NE=48;
    public static final int PARAMS=28;
    public static final int INTEGER=57;
    public static final int GE=50;
    public static final int RBRACE=36;
    public static final int NULL=20;
    public static final int ELSE=13;
    public static final int BOOL=6;
    public static final int STRUCT=4;
    public static final int INT=5;
    public static final int DELETE=15;
    public static final int MINUS=52;
    public static final int DECLS=24;
    public static final int TRUE=17;
    public static final int SEMI=37;
    public static final int PRINT=9;
    public static final int WS=58;
    public static final int ENDL=10;
    public static final int READ=11;
    public static final int DECL=26;
    public static final int BLOCK=30;
    public static final int NEG=34;
    public static final int OR=44;
    public static final int ASSIGN=41;
    public static final int GT=47;
    public static final int PROGRAM=21;
    public static final int FUNCS=25;
    public static final int INVOKE=32;
    public static final int FUN=7;
    public static final int TIMES=53;
    public static final int FALSE=18;
    public static final int LE=49;

    // delegates
    // delegators


        public EvilTypeChecker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public EvilTypeChecker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return EvilTypeChecker.tokenNames; }
    public String getGrammarFileName() { return "EvilTypeChecker.g"; }


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



    // $ANTLR start "program"
    // EvilTypeChecker.g:31:1: program : ^( PROGRAM types[structs] declarations[structs, env] functions[structs, env] ) ;
    public final void program() throws RecognitionException {
        try {
            // EvilTypeChecker.g:32:4: ( ^( PROGRAM types[structs] declarations[structs, env] functions[structs, env] ) )
            // EvilTypeChecker.g:32:6: ^( PROGRAM types[structs] declarations[structs, env] functions[structs, env] )
            {
             
                   State env = new State(); 
                   env.addState();
                   State structs = new State();
                   structs.addState();
                 
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program61); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_types_in_program63);
            types(structs);

            state._fsp--;

            pushFollow(FOLLOW_declarations_in_program66);
            declarations(structs, env);

            state._fsp--;

            pushFollow(FOLLOW_functions_in_program69);
            functions(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 

                     //System.out.println("Structs:");
                     //structs.print();
                     //System.out.println("Env:");
                     //env.print();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "types"
    // EvilTypeChecker.g:48:1: types[State structs] : ( ^( TYPES types_sub[structs] ) | TYPES );
    public final void types(State structs) throws RecognitionException {
        try {
            // EvilTypeChecker.g:49:4: ( ^( TYPES types_sub[structs] ) | TYPES )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==TYPES) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==DOWN) ) {
                    alt1=1;
                }
                else if ( ((LA1_1>=DECLS && LA1_1<=FUNCS)) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // EvilTypeChecker.g:49:6: ^( TYPES types_sub[structs] )
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types98); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        pushFollow(FOLLOW_types_sub_in_types100);
                        types_sub(structs);

                        state._fsp--;


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:50:6: TYPES
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types109); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "types"


    // $ANTLR start "types_sub"
    // EvilTypeChecker.g:53:1: types_sub[State structs] : ( type_declaration[structs] types_sub[structs] | );
    public final void types_sub(State structs) throws RecognitionException {
        try {
            // EvilTypeChecker.g:54:4: ( type_declaration[structs] types_sub[structs] | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==STRUCT) ) {
                alt2=1;
            }
            else if ( (LA2_0==UP) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // EvilTypeChecker.g:54:6: type_declaration[structs] types_sub[structs]
                    {
                    pushFollow(FOLLOW_type_declaration_in_types_sub125);
                    type_declaration(structs);

                    state._fsp--;

                    pushFollow(FOLLOW_types_sub_in_types_sub128);
                    types_sub(structs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:56:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "types_sub"


    // $ANTLR start "type_declaration"
    // EvilTypeChecker.g:61:1: type_declaration[State structs] : ^( STRUCT id= ID struct_nested_decl[structs, $id.text] ) ;
    public final void type_declaration(State structs) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilTypeChecker.g:62:4: ( ^( STRUCT id= ID struct_nested_decl[structs, $id.text] ) )
            // EvilTypeChecker.g:62:6: ^( STRUCT id= ID struct_nested_decl[structs, $id.text] )
            {
            match(input,STRUCT,FOLLOW_STRUCT_in_type_declaration154); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_declaration158); 
             
                     TypeStruct newStruct = new TypeStruct((id!=null?id.getText():null));
                     structs.add((id!=null?id.getText():null), newStruct);
                   
            pushFollow(FOLLOW_struct_nested_decl_in_type_declaration177);
            struct_nested_decl(structs, (id!=null?id.getText():null));

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "type_declaration"


    // $ANTLR start "struct_nested_decl"
    // EvilTypeChecker.g:74:1: struct_nested_decl[State structs, String id] : ( struct_decl[structs, id] )+ ;
    public final void struct_nested_decl(State structs, String id) throws RecognitionException {
        try {
            // EvilTypeChecker.g:75:4: ( ( struct_decl[structs, id] )+ )
            // EvilTypeChecker.g:75:6: ( struct_decl[structs, id] )+
            {
            // EvilTypeChecker.g:75:6: ( struct_decl[structs, id] )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==DECL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // EvilTypeChecker.g:75:7: struct_decl[structs, id]
            	    {
            	    pushFollow(FOLLOW_struct_decl_in_struct_nested_decl206);
            	    struct_decl(structs, id);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "struct_nested_decl"


    // $ANTLR start "struct_decl"
    // EvilTypeChecker.g:79:1: struct_decl[State structs, String structId] : ^( DECL ^( TYPE ty= type[structs] ) id= ID ) ;
    public final void struct_decl(State structs, String structId) throws RecognitionException {
        CommonTree id=null;
        Type ty = null;


        try {
            // EvilTypeChecker.g:80:4: ( ^( DECL ^( TYPE ty= type[structs] ) id= ID ) )
            // EvilTypeChecker.g:80:6: ^( DECL ^( TYPE ty= type[structs] ) id= ID )
            {
            match(input,DECL,FOLLOW_DECL_in_struct_decl227); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_struct_decl230); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_struct_decl234);
            ty=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_struct_decl240); 

            match(input, Token.UP, null); 

                     ((TypeStruct)(structs.get(structId))).addMember((id!=null?id.getText():null), ty);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "struct_decl"


    // $ANTLR start "decl"
    // EvilTypeChecker.g:88:1: decl[State structs, State env] returns [Type ty = null] : ^( DECL ^( TYPE typ= type[structs] ) id= ID ) ;
    public final Type decl(State structs, State env) throws RecognitionException {
        Type ty =  null;

        CommonTree id=null;
        Type typ = null;


        try {
            // EvilTypeChecker.g:89:4: ( ^( DECL ^( TYPE typ= type[structs] ) id= ID ) )
            // EvilTypeChecker.g:89:6: ^( DECL ^( TYPE typ= type[structs] ) id= ID )
            {
            match(input,DECL,FOLLOW_DECL_in_decl272); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_decl275); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_decl279);
            typ=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_decl285); 

            match(input, Token.UP, null); 

                     env.addFormal((id!=null?id.getText():null), typ);
                     ty = typ;
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ty;
    }
    // $ANTLR end "decl"


    // $ANTLR start "type"
    // EvilTypeChecker.g:97:1: type[State structs] returns [Type t = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
    public final Type type(State structs) throws RecognitionException {
        Type t =  null;

        CommonTree id=null;

        try {
            // EvilTypeChecker.g:98:4: ( INT | BOOL | ^( STRUCT id= ID ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt4=1;
                }
                break;
            case BOOL:
                {
                alt4=2;
                }
                break;
            case STRUCT:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // EvilTypeChecker.g:98:6: INT
                    {
                    match(input,INT,FOLLOW_INT_in_type315); 
                     t = new TypeInt(); 

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:99:6: BOOL
                    {
                    match(input,BOOL,FOLLOW_BOOL_in_type324); 
                     t = new TypeBool(); 

                    }
                    break;
                case 3 :
                    // EvilTypeChecker.g:100:6: ^( STRUCT id= ID )
                    {
                    match(input,STRUCT,FOLLOW_STRUCT_in_type334); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_type338); 

                    match(input, Token.UP, null); 

                             if (!structs.isDefined((id!=null?id.getText():null))) //If struct type is undefined.
                             {
                                error((id!=null?id.getLine():0), "use of undefined struct type '" + (id!=null?id.getText():null) + "'");
                             }
                             t = new TypeStruct((id!=null?id.getText():null));
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "type"


    // $ANTLR start "declarations"
    // EvilTypeChecker.g:111:1: declarations[State structs, State env] : ( ^( DECLS ( declaration[structs, env] )* ) | );
    public final void declarations(State structs, State env) throws RecognitionException {
        try {
            // EvilTypeChecker.g:112:4: ( ^( DECLS ( declaration[structs, env] )* ) | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DECLS) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNCS||LA6_0==STMTS) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // EvilTypeChecker.g:112:6: ^( DECLS ( declaration[structs, env] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_declarations365); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilTypeChecker.g:112:14: ( declaration[structs, env] )*
                        loop5:
                        do {
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==DECLLIST) ) {
                                alt5=1;
                            }


                            switch (alt5) {
                        	case 1 :
                        	    // EvilTypeChecker.g:112:14: declaration[structs, env]
                        	    {
                        	    pushFollow(FOLLOW_declaration_in_declarations367);
                        	    declaration(structs, env);

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop5;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:114:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declarations"


    // $ANTLR start "declaration"
    // EvilTypeChecker.g:118:1: declaration[State structs, State env] : ^( DECLLIST ^( TYPE tp= type[structs] ) id_list[env, tp] ) ;
    public final void declaration(State structs, State env) throws RecognitionException {
        Type tp = null;


        try {
            // EvilTypeChecker.g:119:4: ( ^( DECLLIST ^( TYPE tp= type[structs] ) id_list[env, tp] ) )
            // EvilTypeChecker.g:119:6: ^( DECLLIST ^( TYPE tp= type[structs] ) id_list[env, tp] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_declaration395); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_declaration398); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_declaration402);
            tp=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_id_list_in_declaration406);
            id_list(env, tp);

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "id_list"
    // EvilTypeChecker.g:122:1: id_list[State env, Type tp] : (id= ID )+ ;
    public final void id_list(State env, Type tp) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilTypeChecker.g:123:3: ( (id= ID )+ )
            // EvilTypeChecker.g:123:5: (id= ID )+
            {
            // EvilTypeChecker.g:123:5: (id= ID )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EvilTypeChecker.g:123:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list427); 

            	             if(env.isFormal((id!=null?id.getText():null)) || env.isLocal((id!=null?id.getText():null))) 
            	             {
            	                error((id!=null?id.getLine():0), "Redefinition of variable '"+(id!=null?id.getText():null)+"'");
            	             }
            	             else if(env.isFormal((id!=null?id.getText():null)))
            	             {
            	                error((id!=null?id.getLine():0), "Attempting to hide formal parameter '"+(id!=null?id.getText():null)+"'");
            	             }
            	             env.add((id!=null?id.getText():null), tp);
            	          

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "id_list"


    // $ANTLR start "functions"
    // EvilTypeChecker.g:140:1: functions[State structs, State env] : ^( FUNCS ( function[structs, env] )* ) ;
    public final void functions(State structs, State env) throws RecognitionException {
        try {
            // EvilTypeChecker.g:141:5: ( ^( FUNCS ( function[structs, env] )* ) )
            // EvilTypeChecker.g:141:7: ^( FUNCS ( function[structs, env] )* )
            {
            match(input,FUNCS,FOLLOW_FUNCS_in_functions461); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilTypeChecker.g:141:15: ( function[structs, env] )*
                loop8:
                do {
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==FUN) ) {
                        alt8=1;
                    }


                    switch (alt8) {
                	case 1 :
                	    // EvilTypeChecker.g:141:15: function[structs, env]
                	    {
                	    pushFollow(FOLLOW_function_in_functions463);
                	    function(structs, env);

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

                     if (!env.isDefined("main"))
                     {
                        error(0, "No main found.");
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "functions"


    // $ANTLR start "function"
    // EvilTypeChecker.g:151:1: function[State structs, State env] : ^( FUN id= ID params= parameters[structs, env, fun] ^( RETTYPE retType= return_type[structs] ) decs= declarations[structs, env] ty= statement_list[structs, env] ) ;
    public final void function(State structs, State env) throws RecognitionException {
        CommonTree id=null;
        Type retType = null;

        Type ty = null;


        try {
            // EvilTypeChecker.g:152:4: ( ^( FUN id= ID params= parameters[structs, env, fun] ^( RETTYPE retType= return_type[structs] ) decs= declarations[structs, env] ty= statement_list[structs, env] ) )
            // EvilTypeChecker.g:152:6: ^( FUN id= ID params= parameters[structs, env, fun] ^( RETTYPE retType= return_type[structs] ) decs= declarations[structs, env] ty= statement_list[structs, env] )
            {
            env.addState();
            match(input,FUN,FOLLOW_FUN_in_function499); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_function503); 
             TypeFun fun = new TypeFun((id!=null?id.getText():null)); 
            pushFollow(FOLLOW_parameters_in_function522);
            parameters(structs, env, fun);

            state._fsp--;

            match(input,RETTYPE,FOLLOW_RETTYPE_in_function533); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_return_type_in_function537);
            retType=return_type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
             fun.setReturn(retType); 
            pushFollow(FOLLOW_declarations_in_function557);
            declarations(structs, env);

            state._fsp--;

             
                     env.addFun((id!=null?id.getText():null), fun); 
                  
            pushFollow(FOLLOW_statement_list_in_function604);
            ty=statement_list(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 

                     if(!(ty.equals(fun.getReturn())))
                     {
                        if (ty instanceof TypeVoid)
                        {
                           error((id!=null?id.getLine():0), "Function '"+id.toString()+"' may not return");
                        }
                        else
                        {
                           error((id!=null?id.getLine():0), "Function '"+id.toString()+"' requires return type '"+retType.toString()+"' has return type '"+ty.toString()+"'");
                        }
                     }
                     env.removeState();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "parameters"
    // EvilTypeChecker.g:184:1: parameters[State structs, State env, TypeFun fun] : ^( PARAMS (ty= decl[structs, env] )* ) ;
    public final void parameters(State structs, State env, TypeFun fun) throws RecognitionException {
        Type ty = null;


        try {
            // EvilTypeChecker.g:185:4: ( ^( PARAMS (ty= decl[structs, env] )* ) )
            // EvilTypeChecker.g:185:6: ^( PARAMS (ty= decl[structs, env] )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_parameters641); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilTypeChecker.g:185:15: (ty= decl[structs, env] )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DECL) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // EvilTypeChecker.g:185:16: ty= decl[structs, env]
                	    {
                	    pushFollow(FOLLOW_decl_in_parameters646);
                	    ty=decl(structs, env);

                	    state._fsp--;

                	    fun.addParam(ty);

                	    }
                	    break;

                	default :
                	    break loop9;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "parameters"


    // $ANTLR start "return_type"
    // EvilTypeChecker.g:188:1: return_type[State structs] returns [Type t = null] : (ty= type[structs] | VOID );
    public final Type return_type(State structs) throws RecognitionException {
        Type t =  null;

        Type ty = null;


        try {
            // EvilTypeChecker.g:189:4: (ty= type[structs] | VOID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=STRUCT && LA10_0<=BOOL)) ) {
                alt10=1;
            }
            else if ( (LA10_0==VOID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // EvilTypeChecker.g:189:6: ty= type[structs]
                    {
                    pushFollow(FOLLOW_type_in_return_type674);
                    ty=type(structs);

                    state._fsp--;

                     t = ty; 

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:190:6: VOID
                    {
                    match(input,VOID,FOLLOW_VOID_in_return_type684); 
                     t = new TypeVoid(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "return_type"


    // $ANTLR start "statement"
    // EvilTypeChecker.g:193:1: statement[State structs, State env] returns [Type typ = new TypeVoid()] : (ty= block[structs, env] | assignment[structs, env] | print[structs, env] | read[structs, env] | ty= conditional[structs, env] | loop[structs, env] | delete[structs, env] | ty= ret[structs, env] | invocation[structs, env] );
    public final Type statement(State structs, State env) throws RecognitionException {
        Type typ =  new TypeVoid();

        Type ty = null;


        try {
            // EvilTypeChecker.g:194:4: (ty= block[structs, env] | assignment[structs, env] | print[structs, env] | read[structs, env] | ty= conditional[structs, env] | loop[structs, env] | delete[structs, env] | ty= ret[structs, env] | invocation[structs, env] )
            int alt11=9;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt11=1;
                }
                break;
            case ASSIGN:
                {
                alt11=2;
                }
                break;
            case PRINT:
                {
                alt11=3;
                }
                break;
            case READ:
                {
                alt11=4;
                }
                break;
            case IF:
                {
                alt11=5;
                }
                break;
            case WHILE:
                {
                alt11=6;
                }
                break;
            case DELETE:
                {
                alt11=7;
                }
                break;
            case RETURN:
                {
                alt11=8;
                }
                break;
            case INVOKE:
                {
                alt11=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // EvilTypeChecker.g:194:6: ty= block[structs, env]
                    {
                    pushFollow(FOLLOW_block_in_statement708);
                    ty=block(structs, env);

                    state._fsp--;


                          typ = ty;
                       

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:198:6: assignment[structs, env]
                    {
                    pushFollow(FOLLOW_assignment_in_statement721);
                    assignment(structs, env);

                    state._fsp--;


                          typ = new TypeVoid();
                       

                    }
                    break;
                case 3 :
                    // EvilTypeChecker.g:202:6: print[structs, env]
                    {
                    pushFollow(FOLLOW_print_in_statement734);
                    print(structs, env);

                    state._fsp--;


                          typ = new TypeVoid();
                       

                    }
                    break;
                case 4 :
                    // EvilTypeChecker.g:206:6: read[structs, env]
                    {
                    pushFollow(FOLLOW_read_in_statement747);
                    read(structs, env);

                    state._fsp--;


                          typ = new TypeVoid();
                       

                    }
                    break;
                case 5 :
                    // EvilTypeChecker.g:210:6: ty= conditional[structs, env]
                    {
                    pushFollow(FOLLOW_conditional_in_statement762);
                    ty=conditional(structs, env);

                    state._fsp--;


                          typ = ty;
                       

                    }
                    break;
                case 6 :
                    // EvilTypeChecker.g:214:6: loop[structs, env]
                    {
                    pushFollow(FOLLOW_loop_in_statement775);
                    loop(structs, env);

                    state._fsp--;


                          typ = new TypeVoid();
                       

                    }
                    break;
                case 7 :
                    // EvilTypeChecker.g:218:6: delete[structs, env]
                    {
                    pushFollow(FOLLOW_delete_in_statement788);
                    delete(structs, env);

                    state._fsp--;


                          typ = new TypeVoid();
                       

                    }
                    break;
                case 8 :
                    // EvilTypeChecker.g:222:6: ty= ret[structs, env]
                    {
                    pushFollow(FOLLOW_ret_in_statement803);
                    ty=ret(structs, env);

                    state._fsp--;


                          typ = ty;
                       

                    }
                    break;
                case 9 :
                    // EvilTypeChecker.g:226:6: invocation[structs, env]
                    {
                    pushFollow(FOLLOW_invocation_in_statement816);
                    invocation(structs, env);

                    state._fsp--;


                          typ = new TypeVoid();
                       

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return typ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "block"
    // EvilTypeChecker.g:232:1: block[State structs, State env] returns [Type typ = new TypeVoid()] : ^( BLOCK ty= statement_list[structs, env] ) ;
    public final Type block(State structs, State env) throws RecognitionException {
        Type typ =  new TypeVoid();

        Type ty = null;


        try {
            // EvilTypeChecker.g:233:4: ( ^( BLOCK ty= statement_list[structs, env] ) )
            // EvilTypeChecker.g:233:6: ^( BLOCK ty= statement_list[structs, env] )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block843); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_list_in_block847);
            ty=statement_list(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 
            typ=ty;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return typ;
    }
    // $ANTLR end "block"


    // $ANTLR start "statement_list"
    // EvilTypeChecker.g:236:1: statement_list[State structs,State env] returns [Type typ = new TypeVoid()] : ^( STMTS (ty= statement[structs, env] )* ) ;
    public final Type statement_list(State structs, State env) throws RecognitionException {
        Type typ =  new TypeVoid();

        Type ty = null;


        try {
            // EvilTypeChecker.g:237:4: ( ^( STMTS (ty= statement[structs, env] )* ) )
            // EvilTypeChecker.g:237:6: ^( STMTS (ty= statement[structs, env] )* )
            {
            match(input,STMTS,FOLLOW_STMTS_in_statement_list872); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilTypeChecker.g:237:16: (ty= statement[structs, env] )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==PRINT||(LA12_0>=READ && LA12_0<=IF)||(LA12_0>=WHILE && LA12_0<=RETURN)||LA12_0==BLOCK||LA12_0==INVOKE||LA12_0==ASSIGN) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // EvilTypeChecker.g:237:16: ty= statement[structs, env]
                	    {
                	    pushFollow(FOLLOW_statement_in_statement_list876);
                	    ty=statement(structs, env);

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

                     if (ty != null)
                     {
                        typ=ty;
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return typ;
    }
    // $ANTLR end "statement_list"


    // $ANTLR start "assignment"
    // EvilTypeChecker.g:246:1: assignment[State structs, State env] : ^(as= ASSIGN rTy= expression[structs, env] lTy= lvalue[structs, env] ) ;
    public final void assignment(State structs, State env) throws RecognitionException {
        CommonTree as=null;
        Type rTy = null;

        Type lTy = null;


        try {
            // EvilTypeChecker.g:247:4: ( ^(as= ASSIGN rTy= expression[structs, env] lTy= lvalue[structs, env] ) )
            // EvilTypeChecker.g:247:6: ^(as= ASSIGN rTy= expression[structs, env] lTy= lvalue[structs, env] )
            {
            as=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment907); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_assignment911);
            rTy=expression(structs, env);

            state._fsp--;

            pushFollow(FOLLOW_lvalue_in_assignment916);
            lTy=lvalue(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 

                     if (!(rTy.equals(lTy)))
                     {
                        error((as!=null?as.getLine():0), "Attempt to assign '" + rTy + "' to '" + lTy + "'");
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "lvalue"
    // EvilTypeChecker.g:256:1: lvalue[State structs, State env] returns [Type ty = null] : id= ID ( DOT member= ID )* ;
    public final Type lvalue(State structs, State env) throws RecognitionException {
        Type ty =  null;

        CommonTree id=null;
        CommonTree member=null;

        try {
            // EvilTypeChecker.g:257:4: (id= ID ( DOT member= ID )* )
            // EvilTypeChecker.g:257:6: id= ID ( DOT member= ID )*
            {
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue948); 
             
                    String name = (id!=null?id.getText():null);
                    ty = env.get(name); 
                    
                    if ((ty instanceof TypeStruct) || (ty instanceof TypeNull))
                    {
                       name = ((TypeStruct)(ty)).getName();
                    }
                 
            // EvilTypeChecker.g:267:6: ( DOT member= ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==DOT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EvilTypeChecker.g:267:7: DOT member= ID
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_lvalue963); 
            	    member=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue967); 

            	             //Ensure that name is now the name of the structure that is to be         // indexed into.
            	             if (!(ty instanceof TypeStruct))
            	             {
            	                error((id!=null?id.getLine():0), "Attempt to access member datum of non-struct value.");
            	             }

            	             ty = ((TypeStruct)(structs.get(name))).getMember((member!=null?member.getText():null));

            	             if (ty instanceof TypeStruct)
            	             {
            	                name = ((TypeStruct)(ty)).getName();
            	             }
            	          

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ty;
    }
    // $ANTLR end "lvalue"


    // $ANTLR start "print"
    // EvilTypeChecker.g:285:1: print[State structs, State env] : ^(p= PRINT exp= expression[structs, env] ( ENDL )? ) ;
    public final void print(State structs, State env) throws RecognitionException {
        CommonTree p=null;
        Type exp = null;


        try {
            // EvilTypeChecker.g:286:4: ( ^(p= PRINT exp= expression[structs, env] ( ENDL )? ) )
            // EvilTypeChecker.g:286:6: ^(p= PRINT exp= expression[structs, env] ( ENDL )? )
            {
            p=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_print1002); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_print1006);
            exp=expression(structs, env);

            state._fsp--;

            // EvilTypeChecker.g:286:45: ( ENDL )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ENDL) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // EvilTypeChecker.g:286:46: ENDL
                    {
                    match(input,ENDL,FOLLOW_ENDL_in_print1010); 

                    }
                    break;

            }


            match(input, Token.UP, null); 

                     if (!(exp instanceof TypeInt))
                     {
                        error((p!=null?p.getLine():0), "Attempt to print non-integer type: '" + exp + "'");
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "print"


    // $ANTLR start "read"
    // EvilTypeChecker.g:295:1: read[State structs, State env] : ^(r= READ l= lvalue[structs, env] ) ;
    public final void read(State structs, State env) throws RecognitionException {
        CommonTree r=null;
        Type l = null;


        try {
            // EvilTypeChecker.g:296:4: ( ^(r= READ l= lvalue[structs, env] ) )
            // EvilTypeChecker.g:296:6: ^(r= READ l= lvalue[structs, env] )
            {
            r=(CommonTree)match(input,READ,FOLLOW_READ_in_read1040); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_lvalue_in_read1044);
            l=lvalue(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 

                     if (!(l instanceof TypeInt))
                     {
                        error((r!=null?r.getLine():0), "Attempt to read into non-integer type: '" + l + "'");
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "read"


    // $ANTLR start "conditional"
    // EvilTypeChecker.g:305:1: conditional[State structs, State env] returns [Type ty = null] : ^(cond= IF guard= expression[structs, env] tp= block[structs, env] (typ= block[structs, env] )? ) ;
    public final Type conditional(State structs, State env) throws RecognitionException {
        Type ty =  null;

        CommonTree cond=null;
        Type guard = null;

        Type tp = null;

        Type typ = null;


        try {
            // EvilTypeChecker.g:306:4: ( ^(cond= IF guard= expression[structs, env] tp= block[structs, env] (typ= block[structs, env] )? ) )
            // EvilTypeChecker.g:306:6: ^(cond= IF guard= expression[structs, env] tp= block[structs, env] (typ= block[structs, env] )? )
            {
            cond=(CommonTree)match(input,IF,FOLLOW_IF_in_conditional1077); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_conditional1081);
            guard=expression(structs, env);

            state._fsp--;

            pushFollow(FOLLOW_block_in_conditional1086);
            tp=block(structs, env);

            state._fsp--;

            // EvilTypeChecker.g:306:70: (typ= block[structs, env] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==BLOCK) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // EvilTypeChecker.g:306:71: typ= block[structs, env]
                    {
                    pushFollow(FOLLOW_block_in_conditional1092);
                    typ=block(structs, env);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

                     if (!(guard instanceof TypeBool))
                     {
                        error((cond!=null?cond.getLine():0), "Attempt to guard conditional with non-bool type: '" + guard + "'");
                     }
                     
                     if((tp != null) && (typ != null) && !(tp instanceof TypeVoid) && !(typ instanceof TypeVoid))  
                     {
                        if (!(tp.equals(typ)))
                        {
                           error((cond!=null?cond.getLine():0), "Return type mismatch within conditional");
                        }

                        ty=tp;
                     }
                     else
                     {
                        ty = new TypeVoid();
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ty;
    }
    // $ANTLR end "conditional"


    // $ANTLR start "loop"
    // EvilTypeChecker.g:329:1: loop[State structs, State env] : ^(cond= WHILE guard1= expression[structs, env] block[structs, env] guard2= expression[structs, env] ) ;
    public final void loop(State structs, State env) throws RecognitionException {
        CommonTree cond=null;
        Type guard1 = null;

        Type guard2 = null;


        try {
            // EvilTypeChecker.g:330:4: ( ^(cond= WHILE guard1= expression[structs, env] block[structs, env] guard2= expression[structs, env] ) )
            // EvilTypeChecker.g:330:6: ^(cond= WHILE guard1= expression[structs, env] block[structs, env] guard2= expression[structs, env] )
            {
            cond=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_loop1123); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_loop1127);
            guard1=expression(structs, env);

            state._fsp--;

            pushFollow(FOLLOW_block_in_loop1130);
            block(structs, env);

            state._fsp--;

            pushFollow(FOLLOW_expression_in_loop1135);
            guard2=expression(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 

                     if (!(guard1 instanceof TypeBool))
                     {
                        error((cond!=null?cond.getLine():0), "Attempt to guard loop with non-bool type: '" + guard1 + "'");
                     }
                     
                     if (!(guard2 instanceof TypeBool))
                     {
                        error((cond!=null?cond.getLine():0), "Attempt to guard loop with non-bool type: '" + guard2 + "'");
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "loop"


    // $ANTLR start "delete"
    // EvilTypeChecker.g:344:1: delete[State structs, State env] : ^(d= DELETE exp= expression[structs, env] ) ;
    public final void delete(State structs, State env) throws RecognitionException {
        CommonTree d=null;
        Type exp = null;


        try {
            // EvilTypeChecker.g:345:4: ( ^(d= DELETE exp= expression[structs, env] ) )
            // EvilTypeChecker.g:345:6: ^(d= DELETE exp= expression[structs, env] )
            {
            d=(CommonTree)match(input,DELETE,FOLLOW_DELETE_in_delete1164); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_delete1168);
            exp=expression(structs, env);

            state._fsp--;


            match(input, Token.UP, null); 

                     if (!(exp instanceof TypeStruct))
                     {
                        error((d!=null?d.getLine():0), "Attempt to delete non-reference type: '" + exp + "'");
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delete"


    // $ANTLR start "ret"
    // EvilTypeChecker.g:354:1: ret[State structs, State env] returns [Type ty = null] : ^(r= RETURN (exp= expression[structs, env] )? ) ;
    public final Type ret(State structs, State env) throws RecognitionException {
        Type ty =  null;

        CommonTree r=null;
        Type exp = null;


        try {
            // EvilTypeChecker.g:355:4: ( ^(r= RETURN (exp= expression[structs, env] )? ) )
            // EvilTypeChecker.g:355:6: ^(r= RETURN (exp= expression[structs, env] )? )
            {
            r=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret1201); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilTypeChecker.g:355:17: (exp= expression[structs, env] )?
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=TRUE && LA16_0<=NULL)||LA16_0==INVOKE||LA16_0==NEG||(LA16_0>=DOT && LA16_0<=INTEGER)) ) {
                    alt16=1;
                }
                switch (alt16) {
                    case 1 :
                        // EvilTypeChecker.g:355:18: exp= expression[structs, env]
                        {
                        pushFollow(FOLLOW_expression_in_ret1206);
                        exp=expression(structs, env);

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

                     if (exp == null)
                     {
                        ty = new TypeVoid();
                     }
                     else if (exp instanceof TypeFun)
                     {
                        error((r!=null?r.getLine():0), "Attempt to return invocation");
                     }
                     else
                     {
                        ty=exp;
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ty;
    }
    // $ANTLR end "ret"


    // $ANTLR start "invocation"
    // EvilTypeChecker.g:373:1: invocation[State structs, State env] : ^( INVOKE id= ID args= arguments[structs, env] invocation_help[structs, env, $id.text, args, $id.line] ) ;
    public final void invocation(State structs, State env) throws RecognitionException {
        CommonTree id=null;
        ArrayList<Type> args = null;


        try {
            // EvilTypeChecker.g:374:4: ( ^( INVOKE id= ID args= arguments[structs, env] invocation_help[structs, env, $id.text, args, $id.line] ) )
            // EvilTypeChecker.g:374:6: ^( INVOKE id= ID args= arguments[structs, env] invocation_help[structs, env, $id.text, args, $id.line] )
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocation1236); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation1240); 
            pushFollow(FOLLOW_arguments_in_invocation1244);
            args=arguments(structs, env);

            state._fsp--;

            pushFollow(FOLLOW_invocation_help_in_invocation1254);
            invocation_help(structs, env, (id!=null?id.getText():null), args, (id!=null?id.getLine():0));

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "invocation"


    // $ANTLR start "invocation_help"
    // EvilTypeChecker.g:378:1: invocation_help[State structs, State env, String id, ArrayList<Type> gotArgs, int lineNum] returns [Type ty = null] : ;
    public final Type invocation_help(State structs, State env, String id, ArrayList<Type> gotArgs, int lineNum) throws RecognitionException {
        Type ty =  null;

        try {
            // EvilTypeChecker.g:379:4: ()
            // EvilTypeChecker.g:380:7: 
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

        }
        finally {
        }
        return ty;
    }
    // $ANTLR end "invocation_help"


    // $ANTLR start "expression"
    // EvilTypeChecker.g:423:1: expression[State structs, State env] returns [Type ty = null] : ( ^(op= ( AND | OR ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= ( EQ | LT | GT | NE | LE | GE ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= ( PLUS | MINUS ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= ( TIMES | DIVIDE ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= NOT operand= expression[structs, env] ) | ^(op= NEG operand= expression[structs, env] ) | ^(op= DOT operand= expression[structs, env] id= ID ) | ^( INVOKE id= ID gotArgs= arguments[structs, env] temp= invocation_help[structs, env, $id.text, gotArgs, $id.line] ) | id= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | NULL );
    public final Type expression(State structs, State env) throws RecognitionException {
        Type ty =  null;

        CommonTree op=null;
        CommonTree id=null;
        Type left = null;

        Type right = null;

        Type operand = null;

        ArrayList<Type> gotArgs = null;

        Type temp = null;


        try {
            // EvilTypeChecker.g:424:4: ( ^(op= ( AND | OR ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= ( EQ | LT | GT | NE | LE | GE ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= ( PLUS | MINUS ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= ( TIMES | DIVIDE ) left= expression[structs, env] right= expression[structs, env] ) | ^(op= NOT operand= expression[structs, env] ) | ^(op= NEG operand= expression[structs, env] ) | ^(op= DOT operand= expression[structs, env] id= ID ) | ^( INVOKE id= ID gotArgs= arguments[structs, env] temp= invocation_help[structs, env, $id.text, gotArgs, $id.line] ) | id= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | NULL )
            int alt17=14;
            switch ( input.LA(1) ) {
            case AND:
            case OR:
                {
                alt17=1;
                }
                break;
            case EQ:
            case LT:
            case GT:
            case NE:
            case LE:
            case GE:
                {
                alt17=2;
                }
                break;
            case PLUS:
            case MINUS:
                {
                alt17=3;
                }
                break;
            case TIMES:
            case DIVIDE:
                {
                alt17=4;
                }
                break;
            case NOT:
                {
                alt17=5;
                }
                break;
            case NEG:
                {
                alt17=6;
                }
                break;
            case DOT:
                {
                alt17=7;
                }
                break;
            case INVOKE:
                {
                alt17=8;
                }
                break;
            case ID:
                {
                alt17=9;
                }
                break;
            case INTEGER:
                {
                alt17=10;
                }
                break;
            case TRUE:
                {
                alt17=11;
                }
                break;
            case FALSE:
                {
                alt17=12;
                }
                break;
            case NEW:
                {
                alt17=13;
                }
                break;
            case NULL:
                {
                alt17=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // EvilTypeChecker.g:424:6: ^(op= ( AND | OR ) left= expression[structs, env] right= expression[structs, env] )
                    {
                    op=(CommonTree)input.LT(1);
                    if ( (input.LA(1)>=AND && input.LA(1)<=OR) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1315);
                    left=expression(structs, env);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1320);
                    right=expression(structs, env);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             if ( !(left instanceof TypeBool) || !(right instanceof TypeBool))
                             {
                                binaryRequires((op!=null?op.getLine():0), (op!=null?op.getText():null), "bool", "bool", left.toString(), right.toString());
                             }
                             ty = new TypeBool();
                          

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:432:6: ^(op= ( EQ | LT | GT | NE | LE | GE ) left= expression[structs, env] right= expression[structs, env] )
                    {
                    op=(CommonTree)input.LT(1);
                    if ( (input.LA(1)>=EQ && input.LA(1)<=GE) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1366);
                    left=expression(structs, env);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1371);
                    right=expression(structs, env);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             if ( !(left instanceof TypeInt) || !(right instanceof TypeInt) )
                             {
                                binaryRequires((op!=null?op.getLine():0), (op!=null?op.getText():null), "int", "int", left.toString(), right.toString());
                             }
                             ty = new TypeBool();
                          

                    }
                    break;
                case 3 :
                    // EvilTypeChecker.g:440:6: ^(op= ( PLUS | MINUS ) left= expression[structs, env] right= expression[structs, env] )
                    {
                    op=(CommonTree)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1401);
                    left=expression(structs, env);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1406);
                    right=expression(structs, env);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             if ( !(left instanceof TypeInt) || !(right instanceof TypeInt) )
                             {
                                binaryRequires((op!=null?op.getLine():0), (op!=null?op.getText():null), "int", "int", left.toString(), right.toString());
                             }
                             ty = new TypeInt();
                          

                    }
                    break;
                case 4 :
                    // EvilTypeChecker.g:448:6: ^(op= ( TIMES | DIVIDE ) left= expression[structs, env] right= expression[structs, env] )
                    {
                    op=(CommonTree)input.LT(1);
                    if ( (input.LA(1)>=TIMES && input.LA(1)<=DIVIDE) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1436);
                    left=expression(structs, env);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1441);
                    right=expression(structs, env);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             if ( !(left instanceof TypeInt) || !(right instanceof TypeInt) )
                             {
                                binaryRequires((op!=null?op.getLine():0), (op!=null?op.getText():null), "int", "int", left.toString(), right.toString());
                             }
                             ty = new TypeInt();
                          

                    }
                    break;
                case 5 :
                    // EvilTypeChecker.g:456:6: ^(op= NOT operand= expression[structs, env] )
                    {
                    op=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression1461); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1465);
                    operand=expression(structs, env);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             if (!(operand instanceof TypeBool))
                             {
                                error((op!=null?op.getLine():0), "Unary operator '" + (op!=null?op.getText():null) + "' requires bool operand, found '" + operand + "'");
                             }
                             ty = new TypeBool();
                          

                    }
                    break;
                case 6 :
                    // EvilTypeChecker.g:464:6: ^(op= NEG operand= expression[structs, env] )
                    {
                    op=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expression1485); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1489);
                    operand=expression(structs, env);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             if (!(operand instanceof TypeInt))
                             {
                                error((op!=null?op.getLine():0), "Negation requires int operand, found '" + operand + "'");
                             }
                             ty = new TypeInt();
                          

                    }
                    break;
                case 7 :
                    // EvilTypeChecker.g:472:6: ^(op= DOT operand= expression[structs, env] id= ID )
                    {
                    op=(CommonTree)match(input,DOT,FOLLOW_DOT_in_expression1509); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1513);
                    operand=expression(structs, env);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1518); 

                    match(input, Token.UP, null); 

                             if (!(operand instanceof TypeStruct))
                             {
                                error((id!=null?id.getLine():0), "Attempt to access member datum of non-struct value.");
                             }

                             operand =  (structs.get(((TypeStruct)operand).getName()));
                             if (operand == null || ((TypeStruct)(operand)).getMember((id!=null?id.getText():null)) == null)
                             {
                                error((id!=null?id.getLine():0), "Struct '" + ((TypeStruct)(operand)).getName() + "' has no member named: '" + (id!=null?id.getText():null) + "'");
                             }

                             ty = ((TypeStruct)operand).getMember((id!=null?id.getText():null));
                          

                    }
                    break;
                case 8 :
                    // EvilTypeChecker.g:487:6: ^( INVOKE id= ID gotArgs= arguments[structs, env] temp= invocation_help[structs, env, $id.text, gotArgs, $id.line] )
                    {
                    match(input,INVOKE,FOLLOW_INVOKE_in_expression1535); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1539); 
                    pushFollow(FOLLOW_arguments_in_expression1543);
                    gotArgs=arguments(structs, env);

                    state._fsp--;

                    pushFollow(FOLLOW_invocation_help_in_expression1556);
                    temp=invocation_help(structs, env, (id!=null?id.getText():null), gotArgs, (id!=null?id.getLine():0));

                    state._fsp--;


                             ty = temp;
                           

                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // EvilTypeChecker.g:493:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1583); 

                             if (!(env.isDefined((id!=null?id.getText():null))))
                             {
                                error((id!=null?id.getLine():0), "Use of undeclared variable: '" + (id!=null?id.getText():null) + "'");
                             }

                             ty = env.get((id!=null?id.getText():null));
                          

                    }
                    break;
                case 10 :
                    // EvilTypeChecker.g:502:6: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_expression1598); 

                             ty = new TypeInt();
                          

                    }
                    break;
                case 11 :
                    // EvilTypeChecker.g:506:6: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_expression1613); 

                             ty = new TypeBool();
                          

                    }
                    break;
                case 12 :
                    // EvilTypeChecker.g:510:6: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_expression1628); 

                             ty = new TypeBool();
                          

                    }
                    break;
                case 13 :
                    // EvilTypeChecker.g:514:6: ^( NEW id= ID )
                    {
                    match(input,NEW,FOLLOW_NEW_in_expression1644); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1648); 

                    match(input, Token.UP, null); 

                             if (!structs.isDefined((id!=null?id.getText():null))) //If struct type is undefined.
                             {
                                error((id!=null?id.getLine():0), "use of undefined struct type '" + (id!=null?id.getText():null) + "'");
                             }
                             ty = new TypeStruct((id!=null?id.getText():null));
                          

                    }
                    break;
                case 14 :
                    // EvilTypeChecker.g:522:6: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_expression1664); 

                             ty = new TypeNull();
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ty;
    }
    // $ANTLR end "expression"


    // $ANTLR start "arguments"
    // EvilTypeChecker.g:534:1: arguments[State structs, State env] returns [ArrayList<Type> args = new ArrayList<Type>()] : gotArgs= arg_list[structs, env] ;
    public final ArrayList<Type> arguments(State structs, State env) throws RecognitionException {
        ArrayList<Type> args =  new ArrayList<Type>();

        ArrayList<Type> gotArgs = null;


        try {
            // EvilTypeChecker.g:535:4: (gotArgs= arg_list[structs, env] )
            // EvilTypeChecker.g:535:6: gotArgs= arg_list[structs, env]
            {
            pushFollow(FOLLOW_arg_list_in_arguments1697);
            gotArgs=arg_list(structs, env);

            state._fsp--;

             args = gotArgs; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return args;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "arg_list"
    // EvilTypeChecker.g:538:1: arg_list[State structs, State env] returns [ArrayList<Type> args = new ArrayList<Type>()] : ( ^( ARGS (exp= expression[structs, env] )+ ) | ARGS );
    public final ArrayList<Type> arg_list(State structs, State env) throws RecognitionException {
        ArrayList<Type> args =  new ArrayList<Type>();

        Type exp = null;


        try {
            // EvilTypeChecker.g:539:4: ( ^( ARGS (exp= expression[structs, env] )+ ) | ARGS )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ARGS) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==DOWN) ) {
                    alt19=1;
                }
                else if ( (LA19_1==UP) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // EvilTypeChecker.g:539:6: ^( ARGS (exp= expression[structs, env] )+ )
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list1721); 

                    match(input, Token.DOWN, null); 
                    // EvilTypeChecker.g:539:13: (exp= expression[structs, env] )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=TRUE && LA18_0<=NULL)||LA18_0==INVOKE||LA18_0==NEG||(LA18_0>=DOT && LA18_0<=INTEGER)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // EvilTypeChecker.g:539:14: exp= expression[structs, env]
                    	    {
                    	    pushFollow(FOLLOW_expression_in_arg_list1726);
                    	    exp=expression(structs, env);

                    	    state._fsp--;

                    	    args.add(exp);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // EvilTypeChecker.g:540:6: ARGS
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list1739); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return args;
    }
    // $ANTLR end "arg_list"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAM_in_program61 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_in_program63 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_declarations_in_program66 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_functions_in_program69 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types98 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_sub_in_types100 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_declaration_in_types_sub125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_types_sub_in_types_sub128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type_declaration154 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type_declaration158 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_struct_nested_decl_in_type_declaration177 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_struct_decl_in_struct_nested_decl206 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_DECL_in_struct_decl227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_struct_decl230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_struct_decl234 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_struct_decl240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECL_in_decl272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_decl275 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_decl279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_decl285 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_type315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_type324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_declarations365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_declarations367 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_declaration395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_declaration398 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_declaration402 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_list_in_declaration406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_id_list427 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_FUNCS_in_functions461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_function_in_functions463 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_FUN_in_function499 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function503 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parameters_in_function522 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RETTYPE_in_function533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_return_type_in_function537 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_declarations_in_function557 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_statement_list_in_function604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_parameters641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_decl_in_parameters646 = new BitSet(new long[]{0x0000000004000008L});
    public static final BitSet FOLLOW_type_in_return_type674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_return_type684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_statement734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_statement762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_statement775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_in_statement788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_in_statement803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocation_in_statement816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_list_in_block847 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STMTS_in_statement_list872 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement_list876 = new BitSet(new long[]{0x000002014001DA08L});
    public static final BitSet FOLLOW_ASSIGN_in_assignment907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_assignment911 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_lvalue_in_assignment916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_lvalue948 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_DOT_in_lvalue963 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue967 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PRINT_in_print1002 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_print1006 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ENDL_in_print1010 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read1040 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_in_read1044 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_conditional1077 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditional1081 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_conditional1086 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_block_in_conditional1092 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_loop1123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_loop1127 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_loop1130 = new BitSet(new long[]{0x03FFFC05001E0000L});
    public static final BitSet FOLLOW_expression_in_loop1135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_in_delete1164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_delete1168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_ret1201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ret1206 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOKE_in_invocation1236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocation1240 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_arguments_in_invocation1244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_invocation_help_in_invocation1254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_expression1305 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1315 = new BitSet(new long[]{0x03FFFC05001E0000L});
    public static final BitSet FOLLOW_expression_in_expression1320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_expression1340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1366 = new BitSet(new long[]{0x03FFFC05001E0000L});
    public static final BitSet FOLLOW_expression_in_expression1371 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_expression1391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1401 = new BitSet(new long[]{0x03FFFC05001E0000L});
    public static final BitSet FOLLOW_expression_in_expression1406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_expression1426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1436 = new BitSet(new long[]{0x03FFFC05001E0000L});
    public static final BitSet FOLLOW_expression_in_expression1441 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression1461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1465 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expression1485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_expression1509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1513 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_expression1518 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOKE_in_expression1535 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expression1539 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_arguments_in_expression1543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_invocation_help_in_expression1556 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_expression1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_expression1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_expression1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_expression1644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expression1648 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_expression1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_list_in_arguments1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGS_in_arg_list1721 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_arg_list1726 = new BitSet(new long[]{0x03FFFC05001E0008L});
    public static final BitSet FOLLOW_ARGS_in_arg_list1739 = new BitSet(new long[]{0x0000000000000002L});

}