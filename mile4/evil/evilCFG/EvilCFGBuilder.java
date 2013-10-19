// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 EvilCFGBuilder.g 2010-06-09 19:23:15

   package evil.evilCFG;

   import evil.instruction.*;
   import java.util.Hashtable;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EvilCFGBuilder extends TreeParser {
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


        public EvilCFGBuilder(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public EvilCFGBuilder(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return EvilCFGBuilder.tokenNames; }
    public String getGrammarFileName() { return "EvilCFGBuilder.g"; }


       private static boolean _optFold;



    // $ANTLR start "buildCFG"
    // EvilCFGBuilder.g:22:1: buildCFG[boolean debug, boolean _optFold, SymbolTable sym, StructTable structs] returns [BasicBlock rtn] : temp= program[sym, structs] ;
    public final BasicBlock buildCFG(boolean debug, boolean _optFold, SymbolTable sym, StructTable structs) throws RecognitionException {
        BasicBlock rtn = null;

        BasicBlock temp = null;


        try {
            // EvilCFGBuilder.g:23:4: (temp= program[sym, structs] )
            // EvilCFGBuilder.g:24:4: temp= program[sym, structs]
            {

                  System.out.println("Beginning CFG building");
                  this._optFold = _optFold;
               
            pushFollow(FOLLOW_program_in_buildCFG67);
            temp=program(sym, structs);

            state._fsp--;


                  if (debug)
                  {
                     System.out.println(sym);
                     System.out.println(structs + "\n");

                     System.out.println(((Function)(sym.get("main"))).getBody().fullToString());
                  }

                  rtn = temp.getTopBlock();

                  System.out.println("Finished CFG building");
               

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "buildCFG"


    // $ANTLR start "program"
    // EvilCFGBuilder.g:44:1: program[SymbolTable sym, StructTable structs] returns [BasicBlock rtn] : ^( PROGRAM types[structs] global_declarations[sym, structs] temp= functions[sym, structs] ) ;
    public final BasicBlock program(SymbolTable sym, StructTable structs) throws RecognitionException {
        BasicBlock rtn = null;

        BasicBlock temp = null;


        try {
            // EvilCFGBuilder.g:45:4: ( ^( PROGRAM types[structs] global_declarations[sym, structs] temp= functions[sym, structs] ) )
            // EvilCFGBuilder.g:46:4: ^( PROGRAM types[structs] global_declarations[sym, structs] temp= functions[sym, structs] )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program98); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_types_in_program100);
            types(structs);

            state._fsp--;

            pushFollow(FOLLOW_global_declarations_in_program103);
            global_declarations(sym, structs);

            state._fsp--;

            pushFollow(FOLLOW_functions_in_program108);
            temp=functions(sym, structs);

            state._fsp--;


            match(input, Token.UP, null); 

                     rtn = temp;
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "program"


    // $ANTLR start "types"
    // EvilCFGBuilder.g:52:1: types[StructTable structs] : ( ^( TYPES types_sub[structs] ) | TYPES );
    public final void types(StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:53:4: ( ^( TYPES types_sub[structs] ) | TYPES )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==TYPES) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==DOWN) ) {
                    alt1=1;
                }
                else if ( (LA1_1==UP||(LA1_1>=DECLS && LA1_1<=FUNCS)) ) {
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
                    // EvilCFGBuilder.g:53:6: ^( TYPES types_sub[structs] )
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types136); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        pushFollow(FOLLOW_types_sub_in_types138);
                        types_sub(structs);

                        state._fsp--;


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:54:6: TYPES
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types147); 

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
    // EvilCFGBuilder.g:57:1: types_sub[StructTable structs] : ( type_declaration[structs] types_sub[structs] | );
    public final void types_sub(StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:58:4: ( type_declaration[structs] types_sub[structs] | )
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
                    // EvilCFGBuilder.g:58:6: type_declaration[structs] types_sub[structs]
                    {
                    pushFollow(FOLLOW_type_declaration_in_types_sub163);
                    type_declaration(structs);

                    state._fsp--;

                    pushFollow(FOLLOW_types_sub_in_types_sub166);
                    types_sub(structs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:60:4: 
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
    // EvilCFGBuilder.g:62:1: type_declaration[StructTable structs] : ^( STRUCT id= ID struct_nested_decl[structs, myStruct] ) ;
    public final void type_declaration(StructTable structs) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:63:4: ( ^( STRUCT id= ID struct_nested_decl[structs, myStruct] ) )
            // EvilCFGBuilder.g:63:6: ^( STRUCT id= ID struct_nested_decl[structs, myStruct] )
            {
            match(input,STRUCT,FOLLOW_STRUCT_in_type_declaration189); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_declaration193); 

                     Struct myStruct = new Struct((id!=null?id.getText():null));
                     structs.add((id!=null?id.getText():null), myStruct);
                  
            pushFollow(FOLLOW_struct_nested_decl_in_type_declaration210);
            struct_nested_decl(structs, myStruct);

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
    // EvilCFGBuilder.g:74:1: struct_nested_decl[StructTable structs, Struct myStruct] : (var= decl[structs] )+ ;
    public final void struct_nested_decl(StructTable structs, Struct myStruct) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:75:4: ( (var= decl[structs] )+ )
            // EvilCFGBuilder.g:75:6: (var= decl[structs] )+
            {
            // EvilCFGBuilder.g:75:6: (var= decl[structs] )+
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
            	    // EvilCFGBuilder.g:76:9: var= decl[structs]
            	    {
            	    pushFollow(FOLLOW_decl_in_struct_nested_decl255);
            	    var=decl(structs);

            	    state._fsp--;


            	               myStruct.addField(var);
            	            

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


    // $ANTLR start "decl"
    // EvilCFGBuilder.g:83:1: decl[StructTable structs] returns [Variable var = null] : ^( DECL ^( TYPE ty= type[structs] ) id= ID ) ;
    public final Variable decl(StructTable structs) throws RecognitionException {
        Variable var =  null;

        CommonTree id=null;
        Variable ty = null;


        try {
            // EvilCFGBuilder.g:84:4: ( ^( DECL ^( TYPE ty= type[structs] ) id= ID ) )
            // EvilCFGBuilder.g:84:6: ^( DECL ^( TYPE ty= type[structs] ) id= ID )
            {
            match(input,DECL,FOLLOW_DECL_in_decl295); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_decl298); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_decl302);
            ty=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_decl308); 

            match(input, Token.UP, null); 

                     var=ty;
                     var.setName((id!=null?id.getText():null));
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return var;
    }
    // $ANTLR end "decl"


    // $ANTLR start "type"
    // EvilCFGBuilder.g:91:1: type[StructTable structs] returns [Variable var = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
    public final Variable type(StructTable structs) throws RecognitionException {
        Variable var =  null;

        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:92:4: ( INT | BOOL | ^( STRUCT id= ID ) )
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
                    // EvilCFGBuilder.g:92:6: INT
                    {
                    match(input,INT,FOLLOW_INT_in_type337); 
                    var = new Primitive();

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:93:6: BOOL
                    {
                    match(input,BOOL,FOLLOW_BOOL_in_type346); 
                    var= new Primitive();

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:94:6: ^( STRUCT id= ID )
                    {
                    match(input,STRUCT,FOLLOW_STRUCT_in_type356); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_type360); 

                    match(input, Token.UP, null); 
                    var = new Reference(structs.get((id!=null?id.getText():null)));

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
        return var;
    }
    // $ANTLR end "type"


    // $ANTLR start "declarations"
    // EvilCFGBuilder.g:97:1: declarations[SymbolTable sym, StructTable structs] : ( ^( DECLS ( declaration[sym, structs] )* ) | );
    public final void declarations(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:98:4: ( ^( DECLS ( declaration[sym, structs] )* ) | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DECLS) ) {
                alt6=1;
            }
            else if ( (LA6_0==STMTS) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // EvilCFGBuilder.g:98:6: ^( DECLS ( declaration[sym, structs] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_declarations380); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilCFGBuilder.g:98:14: ( declaration[sym, structs] )*
                        loop5:
                        do {
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==DECLLIST) ) {
                                alt5=1;
                            }


                            switch (alt5) {
                        	case 1 :
                        	    // EvilCFGBuilder.g:98:14: declaration[sym, structs]
                        	    {
                        	    pushFollow(FOLLOW_declaration_in_declarations382);
                        	    declaration(sym, structs);

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
                    // EvilCFGBuilder.g:100:4: 
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
    // EvilCFGBuilder.g:102:1: declaration[SymbolTable sym, StructTable structs] : ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] ) ;
    public final void declaration(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:103:4: ( ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] ) )
            // EvilCFGBuilder.g:103:6: ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_declaration408); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_declaration411); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_declaration415);
            var=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_id_list_in_declaration419);
            id_list(var, sym);

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


    // $ANTLR start "global_declarations"
    // EvilCFGBuilder.g:106:1: global_declarations[SymbolTable sym, StructTable structs] : ( ^( DECLS ( global_declaration[sym, structs] )* ) | );
    public final void global_declarations(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:107:4: ( ^( DECLS ( global_declaration[sym, structs] )* ) | )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==DECLS) ) {
                alt8=1;
            }
            else if ( (LA8_0==UP||LA8_0==FUNCS) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // EvilCFGBuilder.g:107:6: ^( DECLS ( global_declaration[sym, structs] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_global_declarations439); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilCFGBuilder.g:107:14: ( global_declaration[sym, structs] )*
                        loop7:
                        do {
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==DECLLIST) ) {
                                alt7=1;
                            }


                            switch (alt7) {
                        	case 1 :
                        	    // EvilCFGBuilder.g:107:14: global_declaration[sym, structs]
                        	    {
                        	    pushFollow(FOLLOW_global_declaration_in_global_declarations441);
                        	    global_declaration(sym, structs);

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop7;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:109:4: 
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
    // $ANTLR end "global_declarations"


    // $ANTLR start "global_declaration"
    // EvilCFGBuilder.g:111:1: global_declaration[SymbolTable sym, StructTable structs] : ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] ) ;
    public final void global_declaration(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:112:4: ( ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] ) )
            // EvilCFGBuilder.g:112:6: ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_global_declaration467); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_global_declaration470); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_global_declaration474);
            var=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_global_id_list_in_global_declaration478);
            global_id_list(var, sym);

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
    // $ANTLR end "global_declaration"


    // $ANTLR start "id_list"
    // EvilCFGBuilder.g:115:1: id_list[Variable var, SymbolTable sym] : (id= ID )+ ;
    public final void id_list(Variable var, SymbolTable sym) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:116:3: ( (id= ID )+ )
            // EvilCFGBuilder.g:116:5: (id= ID )+
            {
            // EvilCFGBuilder.g:116:5: (id= ID )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // EvilCFGBuilder.g:116:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list499); 

            	             Variable temp = var.copy();
            	             temp.setName((id!=null?id.getText():null));
            	             temp.setScope(ScopeType.kLocal);
            	             sym.add((id!=null?id.getText():null), temp);
            	          

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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


    // $ANTLR start "global_id_list"
    // EvilCFGBuilder.g:126:1: global_id_list[Variable var, SymbolTable sym] : (id= ID )+ ;
    public final void global_id_list(Variable var, SymbolTable sym) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:127:3: ( (id= ID )+ )
            // EvilCFGBuilder.g:127:5: (id= ID )+
            {
            // EvilCFGBuilder.g:127:5: (id= ID )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // EvilCFGBuilder.g:127:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_global_id_list531); 

            	             Variable temp = var.copy();
            	             temp.setName((id!=null?id.getText():null));
            	             temp.setScope(ScopeType.kGlobal);
            	             sym.add((id!=null?id.getText():null), temp);
            	          

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // $ANTLR end "global_id_list"


    // $ANTLR start "functions"
    // EvilCFGBuilder.g:137:1: functions[SymbolTable sym, StructTable structs] returns [BasicBlock rtn] : ( ^( FUNCS (temp= function[sym, structs] )* ) | );
    public final BasicBlock functions(SymbolTable sym, StructTable structs) throws RecognitionException {
        BasicBlock rtn = null;

        BasicBlock temp = null;


        try {
            // EvilCFGBuilder.g:138:4: ( ^( FUNCS (temp= function[sym, structs] )* ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==FUNCS) ) {
                alt12=1;
            }
            else if ( (LA12_0==UP) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // EvilCFGBuilder.g:138:6: ^( FUNCS (temp= function[sym, structs] )* )
                    {
                    match(input,FUNCS,FOLLOW_FUNCS_in_functions566); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilCFGBuilder.g:139:7: (temp= function[sym, structs] )*
                        loop11:
                        do {
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==FUN) ) {
                                alt11=1;
                            }


                            switch (alt11) {
                        	case 1 :
                        	    // EvilCFGBuilder.g:140:10: temp= function[sym, structs]
                        	    {

                        	             
                        	    pushFollow(FOLLOW_function_in_functions599);
                        	    temp=function(sym, structs);

                        	    state._fsp--;


                        	                rtn = temp;
                        	             

                        	    }
                        	    break;

                        	default :
                        	    break loop11;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:149:4: 
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
        return rtn;
    }
    // $ANTLR end "functions"


    // $ANTLR start "function"
    // EvilCFGBuilder.g:151:1: function[SymbolTable sym, StructTable structs] returns [BasicBlock rtn = null] : ^( FUN id= ID parameters[sym, structs, funEntry] ^( RETTYPE returnVal= return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] ) ;
    public final BasicBlock function(SymbolTable sym, StructTable structs) throws RecognitionException {
        BasicBlock rtn =  null;

        CommonTree id=null;
        Variable returnVal = null;


        try {
            // EvilCFGBuilder.g:152:4: ( ^( FUN id= ID parameters[sym, structs, funEntry] ^( RETTYPE returnVal= return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] ) )
            // EvilCFGBuilder.g:152:6: ^( FUN id= ID parameters[sym, structs, funEntry] ^( RETTYPE returnVal= return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] )
            {
            match(input,FUN,FOLLOW_FUN_in_function655); 


                  

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_function674); 

                     sym.newState();
                     
                     BasicBlock funEntry = new BasicBlock((id!=null?id.getText():null));
                     BasicBlock body = new BasicBlock();

                     funEntry.addKid(body);
                     body.addParent(funEntry);

                     //Add temperary function to state to top state to support recursion.
                     Function tempFun = new Function((id!=null?id.getText():null), funEntry, null);
                     sym.add((id!=null?id.getText():null), tempFun);

                     funEntry.addInstruction(new FakeInstruction("ENTRY: " + (id!=null?id.getText():null)));

                  
            pushFollow(FOLLOW_parameters_in_function690);
            parameters(sym, structs, funEntry);

            state._fsp--;

            match(input,RETTYPE,FOLLOW_RETTYPE_in_function701); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_return_type_in_function705);
            returnVal=return_type(structs);

            state._fsp--;


            match(input, Token.UP, null); 

                     if (returnVal != null)
                     {
                        tempFun.setReturn(returnVal);
                     }
                  
            pushFollow(FOLLOW_declarations_in_function723);
            declarations(sym, structs);

            state._fsp--;


                     for (String local : sym.getTopLocals())
                     {
                        funEntry.addMapping(local, new Register());
                     }
                  
            pushFollow(FOLLOW_statement_list_in_function741);
            statement_list(sym, structs, body);

            state._fsp--;


                     //Remove the temp (recursion) function.
                     sym.remove((id!=null?id.getText():null));

                     Hashtable<String, Variable> scope = sym.removeState();
                     BasicBlock end = new BasicBlock();
                     
                     //Return from function.
                     end.addInstruction(new Inst_ret());
                     end.addInstruction(new FakeInstruction("EXIT: " + (id!=null?id.getText():null)));
                     
                     funEntry.addCommonEnd(end);

                     Function fun = new Function((id!=null?id.getText():null), funEntry, scope);
                     
                     if (returnVal != null)
                     {
                        fun.setReturn(returnVal);
                     }

                     //Initialize all local references to null (0).
                     for (Variable var : scope.values())
                     {
                        if (var.getScope() == ScopeType.kLocal && var.isReference())
                        {
                           funEntry.addInstruction(new Inst_loadi(0, funEntry.getMapping(var.getName())));
                        }
                     }
                  
                     funEntry.addInstruction(new Inst_jumpi(body.getTag()));
                     
                     sym.add(fun.getName(), fun);

                     rtn = funEntry;
                  

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "function"


    // $ANTLR start "parameters"
    // EvilCFGBuilder.g:226:1: parameters[SymbolTable sym, StructTable structs, BasicBlock funEntry] : ^( PARAMS (var= decl[structs] )* ) ;
    public final void parameters(SymbolTable sym, StructTable structs, BasicBlock funEntry) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:227:4: ( ^( PARAMS (var= decl[structs] )* ) )
            // EvilCFGBuilder.g:227:6: ^( PARAMS (var= decl[structs] )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_parameters775); 


                     int count = 0;
                  

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilCFGBuilder.g:231:7: (var= decl[structs] )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DECL) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // EvilCFGBuilder.g:232:10: var= decl[structs]
                	    {
                	    pushFollow(FOLLOW_decl_in_parameters805);
                	    var=decl(structs);

                	    state._fsp--;


                	                var.setScope(ScopeType.kFormal);
                	                sym.add(var.getName(), var);
                	                
                	                Register temp = new Register();
                	                funEntry.addMapping(var.getName(), temp);
                	             
                	                //Add loadinargs to entry block
                	                funEntry.addInstruction(new Inst_loadinargument(
                	                 var.getName(), count, temp));
                	                count++;
                	             

                	    }
                	    break;

                	default :
                	    break loop13;
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
    // EvilCFGBuilder.g:248:1: return_type[StructTable structs] returns [Variable var = null] : (v= type[structs] | VOID );
    public final Variable return_type(StructTable structs) throws RecognitionException {
        Variable var =  null;

        Variable v = null;


        try {
            // EvilCFGBuilder.g:249:4: (v= type[structs] | VOID )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=STRUCT && LA14_0<=BOOL)) ) {
                alt14=1;
            }
            else if ( (LA14_0==VOID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // EvilCFGBuilder.g:249:6: v= type[structs]
                    {
                    pushFollow(FOLLOW_type_in_return_type849);
                    v=type(structs);

                    state._fsp--;

                    var = v;

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:250:6: VOID
                    {
                    match(input,VOID,FOLLOW_VOID_in_return_type859); 

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
        return var;
    }
    // $ANTLR end "return_type"


    // $ANTLR start "statement_list"
    // EvilCFGBuilder.g:253:1: statement_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* ) ;
    public final BasicBlock statement_list(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:254:4: ( ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* ) )
            // EvilCFGBuilder.g:254:6: ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* )
            {
            match(input,STMTS,FOLLOW_STMTS_in_statement_list880); 


                        tempBlock = bBlock;
                     

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilCFGBuilder.g:258:10: (tempBlock= statement[sym, structs, tempBlock] )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==PRINT||(LA15_0>=READ && LA15_0<=IF)||(LA15_0>=WHILE && LA15_0<=RETURN)||LA15_0==BLOCK||LA15_0==INVOKE||LA15_0==ASSIGN) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // EvilCFGBuilder.g:259:10: tempBlock= statement[sym, structs, tempBlock]
                	    {
                	    pushFollow(FOLLOW_statement_in_statement_list916);
                	    tempBlock=statement(sym, structs, tempBlock);

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

                     rtn = tempBlock;
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "statement_list"


    // $ANTLR start "statement"
    // EvilCFGBuilder.g:267:1: statement[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : (tempBlock= block[sym, structs, bBlock] | tempBlock= assignment[sym, structs, bBlock] | tempBlock= print[sym, structs, bBlock] | read[sym, structs, bBlock] | tempBlock= conditional[sym, structs, bBlock] | tempBlock= loop[sym, structs, bBlock] | tempBlock= delete[sym, structs, bBlock] | tempBlock= ret[sym, structs, bBlock] | temp= invocation[sym, structs, bBlock] );
    public final BasicBlock statement(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        BasicBlock tempBlock = null;

        Warden temp = null;


        try {
            // EvilCFGBuilder.g:268:4: (tempBlock= block[sym, structs, bBlock] | tempBlock= assignment[sym, structs, bBlock] | tempBlock= print[sym, structs, bBlock] | read[sym, structs, bBlock] | tempBlock= conditional[sym, structs, bBlock] | tempBlock= loop[sym, structs, bBlock] | tempBlock= delete[sym, structs, bBlock] | tempBlock= ret[sym, structs, bBlock] | temp= invocation[sym, structs, bBlock] )
            int alt16=9;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt16=1;
                }
                break;
            case ASSIGN:
                {
                alt16=2;
                }
                break;
            case PRINT:
                {
                alt16=3;
                }
                break;
            case READ:
                {
                alt16=4;
                }
                break;
            case IF:
                {
                alt16=5;
                }
                break;
            case WHILE:
                {
                alt16=6;
                }
                break;
            case DELETE:
                {
                alt16=7;
                }
                break;
            case RETURN:
                {
                alt16=8;
                }
                break;
            case INVOKE:
                {
                alt16=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // EvilCFGBuilder.g:268:6: tempBlock= block[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_block_in_statement967);
                    tempBlock=block(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:269:6: tempBlock= assignment[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_assignment_in_statement979);
                    tempBlock=assignment(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:270:6: tempBlock= print[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_print_in_statement992);
                    tempBlock=print(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 4 :
                    // EvilCFGBuilder.g:271:6: read[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_read_in_statement1003);
                    read(sym, structs, bBlock);

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // EvilCFGBuilder.g:272:6: tempBlock= conditional[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_conditional_in_statement1013);
                    tempBlock=conditional(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 6 :
                    // EvilCFGBuilder.g:273:6: tempBlock= loop[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_loop_in_statement1025);
                    tempBlock=loop(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 7 :
                    // EvilCFGBuilder.g:274:6: tempBlock= delete[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_delete_in_statement1037);
                    tempBlock=delete(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 8 :
                    // EvilCFGBuilder.g:275:6: tempBlock= ret[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_ret_in_statement1050);
                    tempBlock=ret(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 9 :
                    // EvilCFGBuilder.g:276:6: temp= invocation[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_invocation_in_statement1063);
                    temp=invocation(sym, structs, bBlock);

                    state._fsp--;

                    rtn = temp.getbBlock();

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
        return rtn;
    }
    // $ANTLR end "statement"


    // $ANTLR start "block"
    // EvilCFGBuilder.g:279:1: block[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn] : ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] ) ;
    public final BasicBlock block(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn = null;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:280:4: ( ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:280:6: ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block1087); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_list_in_block1091);
            tempBlock=statement_list(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     rtn = tempBlock;
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "block"


    // $ANTLR start "assignment"
    // EvilCFGBuilder.g:286:1: assignment[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( ASSIGN tempBlock= expression[sym, structs, bBlock] lvalue_store[sym, structs, b, tempBlock.getReg()] ) ;
    public final BasicBlock assignment(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:287:4: ( ^( ASSIGN tempBlock= expression[sym, structs, bBlock] lvalue_store[sym, structs, b, tempBlock.getReg()] ) )
            // EvilCFGBuilder.g:287:6: ^( ASSIGN tempBlock= expression[sym, structs, bBlock] lvalue_store[sym, structs, b, tempBlock.getReg()] )
            {
            match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment1122); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_assignment1126);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


                     BasicBlock b = tempBlock.getbBlock();
                  
            pushFollow(FOLLOW_lvalue_store_in_assignment1144);
            lvalue_store(sym, structs, b, tempBlock.getReg());

            state._fsp--;


            match(input, Token.UP, null); 

                     rtn = tempBlock.getbBlock();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "print"
    // EvilCFGBuilder.g:297:1: print[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( PRINT tempBlock= expression[sym, structs, bBlock] (endl= ENDL )? ) ;
    public final BasicBlock print(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        CommonTree endl=null;
        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:298:4: ( ^( PRINT tempBlock= expression[sym, structs, bBlock] (endl= ENDL )? ) )
            // EvilCFGBuilder.g:298:6: ^( PRINT tempBlock= expression[sym, structs, bBlock] (endl= ENDL )? )
            {
            match(input,PRINT,FOLLOW_PRINT_in_print1175); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_print1179);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;

            // EvilCFGBuilder.g:298:57: (endl= ENDL )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ENDL) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // EvilCFGBuilder.g:298:58: endl= ENDL
                    {
                    endl=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print1185); 

                    }
                    break;

            }


            match(input, Token.UP, null); 

                     if (endl == null)
                     {
                        tempBlock.getbBlock().addInstruction(new Inst_print(tempBlock.getReg()));
                     }
                     else
                     {
                        tempBlock.getbBlock().addInstruction(new Inst_println(tempBlock.getReg()));
                     }
                     rtn = tempBlock.getbBlock();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "print"


    // $ANTLR start "read"
    // EvilCFGBuilder.g:313:1: read[SymbolTable sym, StructTable structs, BasicBlock bBlock] : ^( READ read_help[sym, structs, bBlock] ) ;
    public final void read(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:314:4: ( ^( READ read_help[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:314:6: ^( READ read_help[sym, structs, bBlock] )
            {
            match(input,READ,FOLLOW_READ_in_read1214); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_read_help_in_read1216);
            read_help(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                    sym.addGlobal("readMePrzButDontTouch");
                

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


    // $ANTLR start "read_help"
    // EvilCFGBuilder.g:320:1: read_help[SymbolTable sym, StructTable structs, BasicBlock bBlock] : (id= ID | ^( DOT srcStruct= lvalue_load[sym, structs, bBlock] id= ID ) );
    public final void read_help(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        CommonTree id=null;
        Register srcStruct = null;


        try {
            // EvilCFGBuilder.g:321:4: (id= ID | ^( DOT srcStruct= lvalue_load[sym, structs, bBlock] id= ID ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==DOT) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // EvilCFGBuilder.g:321:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_read_help1242); 

                             String name = "readMePrzButDontTouch";
                             Register reg = null;
                             
                             if (sym.isGlobal((id!=null?id.getText():null)))
                             {
                                reg = new Register();
                             }
                             else
                             {
                                reg = bBlock.getMapping((id!=null?id.getText():null));
                             }
                             
                             bBlock.addInstruction(new Inst_storeglobal(reg, name));
                             bBlock.addInstruction(new Inst_computeglobaladdress(name, reg));
                             bBlock.addInstruction(new Inst_read(reg));
                             bBlock.addInstruction(new Inst_loadglobal(name, reg));

                             if (sym.isGlobal((id!=null?id.getText():null)))
                             {
                                bBlock.addInstruction(new Inst_storeglobal(reg, (id!=null?id.getText():null)));
                             }
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:346:6: ^( DOT srcStruct= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_read_help1262); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_read_help1266);
                    srcStruct=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_read_help1271); 

                    match(input, Token.UP, null); 

                             String name = "readMePrzButDontTouch";
                             
                             Register temp = new Register();

                             bBlock.addInstruction(new Inst_storeglobal(temp, name));
                             bBlock.addInstruction(new Inst_computeglobaladdress(name, temp));
                             bBlock.addInstruction(new Inst_read(temp));
                             bBlock.addInstruction(new Inst_loadglobal(name, temp));

                             bBlock.addInstruction(new Inst_storeai(temp, srcStruct, (id!=null?id.getText():null), srcStruct.getExtraInfo()));
                             //bBlock.addInstruction(new Inst_storeai(temp, srcStruct, (id!=null?id.getText():null), "._GLOBAL_."));
                          

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
    // $ANTLR end "read_help"


    // $ANTLR start "conditional"
    // EvilCFGBuilder.g:362:1: conditional[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? ) ;
    public final BasicBlock conditional(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:363:4: ( ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? ) )
            // EvilCFGBuilder.g:363:6: ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? )
            {
            match(input,IF,FOLLOW_IF_in_conditional1301); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_conditional1315);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


                        //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD"));

                        BasicBlock thenBlock = new BasicBlock();
                        tempBlock.getbBlock().addKid(thenBlock);
                        thenBlock.getbBlock().addParent(tempBlock.getbBlock());
                        
                        //thenBlock.addInstruction(new FakeInstruction("THEN BEGIN"));
                     
            pushFollow(FOLLOW_block_in_conditional1339);
            block(sym, structs, thenBlock);

            state._fsp--;


                        BasicBlock elseBlock = null;
                     
            // EvilCFGBuilder.g:378:10: ( block[sym, structs, elseBlock] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==BLOCK) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // EvilCFGBuilder.g:379:13: block[sym, structs, elseBlock]
                    {

                                   elseBlock = new BasicBlock();
                                   tempBlock.getbBlock().addKid(elseBlock);
                                   elseBlock.addParent(tempBlock.getbBlock());
                                
                                  //elseBlock.addInstruction(new FakeInstruction("ELSE BEGIN"));
                                
                    pushFollow(FOLLOW_block_in_conditional1391);
                    block(sym, structs, elseBlock);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

                     BasicBlock follows = new BasicBlock();
                     tempBlock.addCommonEnd(follows);

                     //thenBlock.getbBlock().addKid(follows);
                     //follows.addParent(thenBlock.getbBlock());

                     if (elseBlock != null)
                     {
                        //elseBlock.getbBlock().addKid(follows);
                        //follows.addParent(elseBlock);

                        //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD. Contemplating: " + thenBlock.getTag() + ", " + elseBlock.getTag()));
                        tempBlock.addInstruction(new Inst_compi(tempBlock.getReg(), 1));
                        tempBlock.addInstruction(new Inst_cbreq(thenBlock.getTag(), elseBlock.getTag()));
                     }
                     else
                     {
                        tempBlock.getbBlock().addKid(follows);
                        follows.addParent(tempBlock.getbBlock());
                        
                        //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD. Contemplating: " + thenBlock.getTag()));
                        tempBlock.addInstruction(new Inst_compi(tempBlock.getReg(), 1));
                        tempBlock.addInstruction(new Inst_cbreq(thenBlock.getTag(), follows.getTag()));
                     }
                     
                     //tempBlock.addCommonEnd(follows);
                     
                     rtn = follows;
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "conditional"


    // $ANTLR start "loop"
    // EvilCFGBuilder.g:421:1: loop[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] ) ;
    public final BasicBlock loop(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden topGuardBlock = null;

        BasicBlock bodyEndBlock = null;

        Warden bottomGuardEndBlock = null;


        try {
            // EvilCFGBuilder.g:422:4: ( ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] ) )
            // EvilCFGBuilder.g:422:6: ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] )
            {
            match(input,WHILE,FOLLOW_WHILE_in_loop1441); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_loop1452);
            topGuardBlock=expression(sym, structs, bBlock);

            state._fsp--;


                     BasicBlock bodyBlock = new BasicBlock();
                     //bodyBlock.addInstruction(new FakeInstruction("WHILE BODY"));

                     topGuardBlock.getbBlock().addKid(bodyBlock);
                     bodyBlock.addParent(topGuardBlock.getbBlock());
                  
            pushFollow(FOLLOW_block_in_loop1492);
            bodyEndBlock=block(sym, structs, bodyBlock);

            state._fsp--;


                     BasicBlock bottomGuardBlock = new BasicBlock();
                     
                     bodyEndBlock.addInstruction(new Inst_jumpi(bottomGuardBlock.getTag()));

                     bodyEndBlock.addKid(bottomGuardBlock);
                     bottomGuardBlock.addParent(bodyEndBlock);
                  
            pushFollow(FOLLOW_expression_in_loop1526);
            bottomGuardEndBlock=expression(sym, structs, bottomGuardBlock);

            state._fsp--;


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
                  

            match(input, Token.UP, null); 

                     rtn = follows;
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "loop"


    // $ANTLR start "delete"
    // EvilCFGBuilder.g:472:1: delete[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( DELETE tempBlock= expression[sym, structs, bBlock] ) ;
    public final BasicBlock delete(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:473:4: ( ^( DELETE tempBlock= expression[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:473:6: ^( DELETE tempBlock= expression[sym, structs, bBlock] )
            {
            match(input,DELETE,FOLLOW_DELETE_in_delete1572); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_delete1576);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     //tempBlock.getbBlock().addInstruction(new FakeInstruction("DELETE"));
                     tempBlock.getbBlock().addInstruction(new Inst_del(tempBlock.getReg()));
                     rtn = tempBlock.getbBlock();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "delete"


    // $ANTLR start "ret"
    // EvilCFGBuilder.g:481:1: ret[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( RETURN (tempBlock= expression[sym, structs, bBlock] )? ) ;
    public final BasicBlock ret(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:482:4: ( ^( RETURN (tempBlock= expression[sym, structs, bBlock] )? ) )
            // EvilCFGBuilder.g:482:6: ^( RETURN (tempBlock= expression[sym, structs, bBlock] )? )
            {
            match(input,RETURN,FOLLOW_RETURN_in_ret1607); 


                     tempBlock = null;
                  

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilCFGBuilder.g:486:7: (tempBlock= expression[sym, structs, bBlock] )?
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=TRUE && LA20_0<=NULL)||LA20_0==INVOKE||LA20_0==NEG||(LA20_0>=DOT && LA20_0<=INTEGER)) ) {
                    alt20=1;
                }
                switch (alt20) {
                    case 1 :
                        // EvilCFGBuilder.g:486:8: tempBlock= expression[sym, structs, bBlock]
                        {
                        pushFollow(FOLLOW_expression_in_ret1627);
                        tempBlock=expression(sym, structs, bBlock);

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

                     if (tempBlock != null)
                     {
                        tempBlock.getbBlock().addInstruction(new Inst_storeret(tempBlock.getReg()));
                        tempBlock.getbBlock().addInstruction(new Inst_ret());
                        rtn = tempBlock.getbBlock();
                     }
                     else
                     {
                        bBlock.addInstruction(new Inst_ret());
                        rtn = bBlock;
                     }
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "ret"


    // $ANTLR start "invocation"
    // EvilCFGBuilder.g:502:1: invocation[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Warden ret = null] : ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] ) ;
    public final Warden invocation(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Warden ret =  null;

        CommonTree id=null;
        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:503:4: ( ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:503:6: ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] )
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocation1660); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation1664); 
            pushFollow(FOLLOW_arguments_in_invocation1668);
            tempBlock=arguments(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     tempBlock.addInstruction(new Inst_call(((Function)(sym.get((id!=null?id.getText():null)))).getBody().getTag()));
                     ret = new Warden(new Register(), tempBlock);

                     if (((Function)(sym.get((id!=null?id.getText():null)))).hasReturn())
                     {
                        tempBlock.addInstruction(new Inst_loadret(ret.getReg()));
                        ret.setExtraInfo((id!=null?id.getText():null));
                     }

                     /*Don't need to break block for invocation
                     //IF it is decided to have incocation split blocks,
                     // then make sure to look at expression!
                     newBlock = new BasicBlock();
                     tempBlock.addKid(newBlock);
                     newBlock.addParent(tempBlock);

                     tempBlock.addInstruction(new FakeInstruction("Jump to: " + newBlock.getTag()));
                     */
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end "invocation"


    // $ANTLR start "lvalue_store"
    // EvilCFGBuilder.g:529:1: lvalue_store[SymbolTable sym, StructTable structs, BasicBlock bBlock, Register val] : ( ^( DOT target= lvalue_load[sym, structs, bBlock] id= ID ) | id= ID );
    public final void lvalue_store(SymbolTable sym, StructTable structs, BasicBlock bBlock, Register val) throws RecognitionException {
        CommonTree id=null;
        Register target = null;


        try {
            // EvilCFGBuilder.g:530:4: ( ^( DOT target= lvalue_load[sym, structs, bBlock] id= ID ) | id= ID )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==DOT) ) {
                alt21=1;
            }
            else if ( (LA21_0==ID) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // EvilCFGBuilder.g:530:6: ^( DOT target= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_store1699); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_lvalue_store1703);
                    target=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_store1708); 

                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_storeai(val, target, (id!=null?id.getText():null), target.getExtraInfo()));
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:534:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_store1726); 

                             Register temp = null;

                             //If we are looking for a global
                             if (sym.isGlobal((id!=null?id.getText():null)))
                             {
                                bBlock.addInstruction(new Inst_storeglobal(val, (id!=null?id.getText():null)));
                             }
                             //ELSE If variable has a register already.
                             else if (bBlock.containsMapping((id!=null?id.getText():null)))
                             {
                                temp = bBlock.getMapping((id!=null?id.getText():null));
                                bBlock.addInstruction(new Inst_mov(val, temp));
                             }
                             //Else variable does not have a register yet.
                             else
                             {
                                temp = new Register();
                                bBlock.addMapping((id!=null?id.getText():null), temp);
                                bBlock.addInstruction(new Inst_mov(val, temp));
                             }
                          

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
    // $ANTLR end "lvalue_store"


    // $ANTLR start "lvalue_load"
    // EvilCFGBuilder.g:560:1: lvalue_load[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Register reg = null] : (id= ID | ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) | ^( DOT war= invocation[sym, structs, bBlock] id= ID ) );
    public final Register lvalue_load(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg =  null;

        CommonTree id=null;
        Register src = null;

        Warden war = null;


        try {
            // EvilCFGBuilder.g:561:4: (id= ID | ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) | ^( DOT war= invocation[sym, structs, bBlock] id= ID ) )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ID) ) {
                alt22=1;
            }
            else if ( (LA22_0==DOT) ) {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==DOWN) ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3==INVOKE) ) {
                        alt22=3;
                    }
                    else if ( (LA22_3==DOT||LA22_3==ID) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // EvilCFGBuilder.g:561:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_load1757); 

                             if (sym.isGlobal((id!=null?id.getText():null)))
                             {
                                //Load the gobal into a register and return that.
                                reg = new Register();

                                bBlock.addInstruction(new Inst_loadglobal((id!=null?id.getText():null), reg));
                             }
                             else
                             {
                                //Just need to get reg where address of reference is stored at.
                                reg = bBlock.getMapping((id!=null?id.getText():null));
                             }
                                
                             //If it is a reference, add information about the struct into the register.
                             if (sym.get((id!=null?id.getText():null)).isReference())
                             {
                                reg.setExtraInfo(((Reference)sym.get((id!=null?id.getText():null))).getStruct().getName());
                             }

                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:583:6: ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_load1773); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_lvalue_load1777);
                    src=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_load1782); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             //bBlock.addInstruction(new FakeInstruction("Loading member:" + (id!=null?id.getText():null) + " from structure at " + src + " to " + reg));

                             //Know that the left side (src) is a struct. 
                             //Note: This will never occur at the highet dot level (in the AST).
                             // So, the right hand (id) will also always be a struct.
                             Reference ref = (Reference)(structs.get(src.getExtraInfo()).getField((id!=null?id.getText():null)));
                             reg.setExtraInfo(ref.getStruct().getName());

                             bBlock.addInstruction(new Inst_loadai(src, (id!=null?id.getText():null), reg, src.getExtraInfo()));
                          

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:596:6: ^( DOT war= invocation[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_load1799); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_invocation_in_lvalue_load1803);
                    war=invocation(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_load1808); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             String structName = ((Reference) (((Function)(sym.get(war.getExtraInfo()))).getReturn())).getStruct().getName();
                             bBlock.addInstruction(new Inst_loadai(war.getReg(), (id!=null?id.getText():null), reg, structName));
                             reg.setExtraInfo(structName);
                          

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
        return reg;
    }
    // $ANTLR end "lvalue_load"


    // $ANTLR start "lvalue_exp"
    // EvilCFGBuilder.g:605:1: lvalue_exp[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Register reg = null] : ( ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) | ^( DOT war= invocation[sym, structs, bBlock] id= ID ) | ^( DOT NEW id= ID ) );
    public final Register lvalue_exp(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg =  null;

        CommonTree id=null;
        Register src = null;

        Warden war = null;


        try {
            // EvilCFGBuilder.g:606:4: ( ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) | ^( DOT war= invocation[sym, structs, bBlock] id= ID ) | ^( DOT NEW id= ID ) )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==DOT) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case NEW:
                        {
                        alt23=3;
                        }
                        break;
                    case INVOKE:
                        {
                        alt23=2;
                        }
                        break;
                    case DOT:
                    case ID:
                        {
                        alt23=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // EvilCFGBuilder.g:606:6: ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_exp1838); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_lvalue_exp1842);
                    src=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_exp1847); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             bBlock.addInstruction(new Inst_loadai(src, (id!=null?id.getText():null), reg, src.getExtraInfo()));
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:611:6: ^( DOT war= invocation[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_exp1864); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_invocation_in_lvalue_exp1868);
                    war=invocation(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_exp1873); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             bBlock.addInstruction(new Inst_loadai(war.getReg(), (id!=null?id.getText():null), reg, ((Reference)(((Function)(sym.get(war.getExtraInfo()))).getReturn())).getStruct().getName()   ));
                          

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:616:6: ^( DOT NEW id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_exp1890); 

                    match(input, Token.DOWN, null); 
                    match(input,NEW,FOLLOW_NEW_in_lvalue_exp1892); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_exp1896); 

                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             String fields = structs.get((id!=null?id.getText():null)).getFieldsString();

                             bBlock.addInstruction(new Inst_new((id!=null?id.getText():null), fields, temp, (id!=null?id.getText():null)));

                             reg = new Register();
                             //bBlock.addInstruction(new Inst_loadai(temp, (id!=null?id.getText():null), reg, "FIX IN EvilCFGBuilder"));
                             bBlock.addInstruction(new Inst_loadai(temp, (id!=null?id.getText():null), reg, (id!=null?id.getText():null)));
                          

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
        return reg;
    }
    // $ANTLR end "lvalue_exp"


    // $ANTLR start "expression"
    // EvilCFGBuilder.g:649:1: expression[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Warden rtn = null] : ( ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NOT exp1= expression[sym, structs, bBlock] ) | ^( NEG exp1= expression[sym, structs, bBlock] ) | ltmp= lvalue_exp[sym, structs, bBlock] | ^( NEW id= ID ) | itmp= invocation[sym, structs, bBlock] | id= ID | id= INTEGER | TRUE | FALSE | NULL );
    public final Warden expression(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Warden rtn =  null;

        CommonTree id=null;
        Warden exp1 = null;

        Warden exp2 = null;

        Register ltmp = null;

        Warden itmp = null;


        try {
            // EvilCFGBuilder.g:650:4: ( ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NOT exp1= expression[sym, structs, bBlock] ) | ^( NEG exp1= expression[sym, structs, bBlock] ) | ltmp= lvalue_exp[sym, structs, bBlock] | ^( NEW id= ID ) | itmp= invocation[sym, structs, bBlock] | id= ID | id= INTEGER | TRUE | FALSE | NULL )
            int alt24=22;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt24=1;
                }
                break;
            case OR:
                {
                alt24=2;
                }
                break;
            case EQ:
                {
                alt24=3;
                }
                break;
            case LT:
                {
                alt24=4;
                }
                break;
            case GT:
                {
                alt24=5;
                }
                break;
            case NE:
                {
                alt24=6;
                }
                break;
            case LE:
                {
                alt24=7;
                }
                break;
            case GE:
                {
                alt24=8;
                }
                break;
            case PLUS:
                {
                alt24=9;
                }
                break;
            case MINUS:
                {
                alt24=10;
                }
                break;
            case TIMES:
                {
                alt24=11;
                }
                break;
            case DIVIDE:
                {
                alt24=12;
                }
                break;
            case NOT:
                {
                alt24=13;
                }
                break;
            case NEG:
                {
                alt24=14;
                }
                break;
            case DOT:
                {
                alt24=15;
                }
                break;
            case NEW:
                {
                alt24=16;
                }
                break;
            case INVOKE:
                {
                alt24=17;
                }
                break;
            case ID:
                {
                alt24=18;
                }
                break;
            case INTEGER:
                {
                alt24=19;
                }
                break;
            case TRUE:
                {
                alt24=20;
                }
                break;
            case FALSE:
                {
                alt24=21;
                }
                break;
            case NULL:
                {
                alt24=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // EvilCFGBuilder.g:650:6: ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,AND,FOLLOW_AND_in_expression1935); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1939);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1944);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_and(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:656:6: ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,OR,FOLLOW_OR_in_expression1962); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1966);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1971);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_or(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:662:6: ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expression1989); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1993);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1998);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp)); //initilize temp = false
                             bBlock.addInstruction(new Inst_moveq(1, temp)); //if the condition codes are == move true to temp
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 4 :
                    // EvilCFGBuilder.g:670:6: ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,LT,FOLLOW_LT_in_expression2016); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2020);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2025);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             bBlock.addInstruction(new Inst_movlt(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 5 :
                    // EvilCFGBuilder.g:678:6: ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,GT,FOLLOW_GT_in_expression2043); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2047);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2052);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             bBlock.addInstruction(new Inst_movgt(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 6 :
                    // EvilCFGBuilder.g:686:6: ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,NE,FOLLOW_NE_in_expression2070); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2074);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2079);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             bBlock.addInstruction(new Inst_movne(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 7 :
                    // EvilCFGBuilder.g:694:6: ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,LE,FOLLOW_LE_in_expression2097); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2101);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2106);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             bBlock.addInstruction(new Inst_movle(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 8 :
                    // EvilCFGBuilder.g:702:6: ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,GE,FOLLOW_GE_in_expression2124); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2128);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2133);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_comp(exp1.getReg(), exp2.getReg()));
                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             bBlock.addInstruction(new Inst_movge(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 9 :
                    // EvilCFGBuilder.g:710:6: ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expression2151); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2155);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2160);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             //If both have constant, fold both.
                             if (_optFold && exp1.hasConstant() && exp2.hasConstant())
                             {
                                int newConstant = exp1.getConstant() + exp2.getConstant();
                                bBlock.addInstruction(new Inst_loadi(newConstant, temp));
                                rtn = new Warden(newConstant, temp, bBlock);
                             }
                             //If only 1 has constant, use that constant instead of a register.
                             else if (_optFold && exp1.hasConstant())
                             {
                                bBlock.addInstruction(new Inst_addi(exp2.getReg(), exp1.getConstant(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                             else if (_optFold && exp2.hasConstant())
                             {
                                bBlock.addInstruction(new Inst_addi(exp1.getReg(), exp2.getConstant(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                             //Aww :(  no constant folding.
                             else
                             {
                                bBlock.addInstruction(new Inst_add(exp1.getReg(), exp2.getReg(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                          

                    }
                    break;
                case 10 :
                    // EvilCFGBuilder.g:738:6: ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expression2178); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2182);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2187);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             //If both have constant, fold both.
                             if (_optFold && exp1.hasConstant() && exp2.hasConstant())
                             {
                                int newConstant = exp1.getConstant() - exp2.getConstant();
                                bBlock.addInstruction(new Inst_loadi(newConstant, temp));
                                rtn = new Warden(newConstant, temp, bBlock);
                             }
                             //If only 1 has constant, use that constant instead of a register.
                             // Watch sign, can only do one of the singles!
                             else if (_optFold && exp2.hasConstant())
                             {
                                bBlock.addInstruction(new Inst_subi(exp1.getReg(), exp2.getConstant(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                             //Aww :(  no constant folding.
                             else
                             {
                                bBlock.addInstruction(new Inst_sub(exp1.getReg(), exp2.getReg(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                          

                    }
                    break;
                case 11 :
                    // EvilCFGBuilder.g:762:6: ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expression2205); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2209);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2214);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             //If both have constant, fold both.
                             if (_optFold && exp1.hasConstant() && exp2.hasConstant())
                             {
                                int newConstant = exp1.getConstant() * exp2.getConstant();
                                bBlock.addInstruction(new Inst_loadi(newConstant, temp));
                                rtn = new Warden(newConstant, temp, bBlock);
                             }
                             //If only 1 has constant, use that constant instead of a register.
                             else if (_optFold && exp1.hasConstant())
                             {
                                bBlock.addInstruction(new Inst_multi(exp2.getReg(), exp1.getConstant(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                             else if (_optFold && exp2.hasConstant())
                             {
                                bBlock.addInstruction(new Inst_multi(exp1.getReg(), exp2.getConstant(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                             //Aww :(  no constant folding.
                             else
                             {
                                bBlock.addInstruction(new Inst_mult(exp1.getReg(), exp2.getReg(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                          

                    }
                    break;
                case 12 :
                    // EvilCFGBuilder.g:790:6: ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_expression2232); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2236);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2241);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             //If both have constant, fold both.
                             if (_optFold && exp1.hasConstant() && exp2.hasConstant())
                             {
                                int newConstant = exp1.getConstant() / exp2.getConstant();
                                bBlock.addInstruction(new Inst_loadi(newConstant, temp));
                                rtn = new Warden(newConstant, temp, bBlock);
                             }
                             //If only 1 has constant, use that constant instead of a register.
                             // Watch out, can only do one of the singles!
                             else if (_optFold && exp2.hasConstant())
                             {
                                bBlock.addInstruction(new Inst_divi(exp1.getReg(), exp2.getConstant(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                             //Aww :(  no constant folding.
                             else
                             {
                                bBlock.addInstruction(new Inst_div(exp1.getReg(), exp2.getReg(), temp));
                                rtn = new Warden(temp, bBlock);
                             }
                          

                    }
                    break;
                case 13 :
                    // EvilCFGBuilder.g:814:6: ^( NOT exp1= expression[sym, structs, bBlock] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expression2259); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2263);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_xori(exp1.getReg(), -1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 14 :
                    // EvilCFGBuilder.g:820:6: ^( NEG exp1= expression[sym, structs, bBlock] )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expression2281); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2285);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             
                             if (_optFold && exp1.hasConstant())
                             {
                                int newConstant = -1 * exp1.getConstant();
                                bBlock.addInstruction(new Inst_loadi(newConstant, temp));
                                rtn = new Warden(newConstant, temp, bBlock);
                             }
                             else
                             {
                                bBlock.addInstruction(new Inst_loadi(-1, temp));
                                bBlock.addInstruction(new Inst_mult(exp1.getReg(), temp, temp));
                                rtn = new Warden(temp, bBlock);
                             }
                          

                    }
                    break;
                case 15 :
                    // EvilCFGBuilder.g:837:6: ltmp= lvalue_exp[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_lvalue_exp_in_expression2304);
                    ltmp=lvalue_exp(sym, structs, bBlock);

                    state._fsp--;


                             rtn = new Warden(ltmp, bBlock);
                          

                    }
                    break;
                case 16 :
                    // EvilCFGBuilder.g:849:6: ^( NEW id= ID )
                    {
                    match(input,NEW,FOLLOW_NEW_in_expression2324); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2328); 

                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             String fields = structs.get((id!=null?id.getText():null)).getFieldsString();

                             bBlock.addInstruction(new Inst_new((id!=null?id.getText():null), fields, temp, (id!=null?id.getText():null)));

                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 17 :
                    // EvilCFGBuilder.g:858:6: itmp= invocation[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_invocation_in_expression2346);
                    itmp=invocation(sym, structs, bBlock);

                    state._fsp--;


                             rtn = itmp;
                          

                    }
                    break;
                case 18 :
                    // EvilCFGBuilder.g:862:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2365); 

                             Register temp;
                             if(!(sym.isGlobal((id!=null?id.getText():null))))
                             { 
                                temp = bBlock.getMapping((id!=null?id.getText():null));
                             }
                             else
                             {
                                temp = new Register();
                                bBlock.addInstruction(new Inst_loadglobal((id!=null?id.getText():null), temp));
                             }
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 19 :
                    // EvilCFGBuilder.g:876:6: id= INTEGER
                    {
                    id=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression2383); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(Integer.valueOf((id!=null?id.getText():null)), temp));
                             rtn = new Warden(Integer.valueOf((id!=null?id.getText():null)), temp, bBlock);
                          

                    }
                    break;
                case 20 :
                    // EvilCFGBuilder.g:882:6: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_expression2399); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 21 :
                    // EvilCFGBuilder.g:888:6: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_expression2415); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 22 :
                    // EvilCFGBuilder.g:894:6: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_expression2431); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             rtn = new Warden(temp, bBlock);
                          

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
        return rtn;
    }
    // $ANTLR end "expression"


    // $ANTLR start "arguments"
    // EvilCFGBuilder.g:902:1: arguments[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : tempBlock= arg_list[sym, structs, bBlock] ;
    public final BasicBlock arguments(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:903:4: (tempBlock= arg_list[sym, structs, bBlock] )
            // EvilCFGBuilder.g:903:6: tempBlock= arg_list[sym, structs, bBlock]
            {
            pushFollow(FOLLOW_arg_list_in_arguments2462);
            tempBlock=arg_list(sym, structs, bBlock);

            state._fsp--;

            rtn = tempBlock;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rtn;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "arg_list"
    // EvilCFGBuilder.g:906:1: arg_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : ( ^( ARGS (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+ ) | ARGS );
    public final BasicBlock arg_list(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:907:4: ( ^( ARGS (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+ ) | ARGS )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ARGS) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==DOWN) ) {
                    alt26=1;
                }
                else if ( (LA26_1==UP) ) {
                    alt26=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // EvilCFGBuilder.g:907:7: ^( ARGS (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+ )
                    {
                     
                             ArrayList<Register> argRegs = new ArrayList<Register>();
                          
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list2495); 


                             tempBlock = new Warden(new Register(), bBlock);
                          

                    match(input, Token.DOWN, null); 
                    // EvilCFGBuilder.g:914:7: (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=TRUE && LA25_0<=NULL)||LA25_0==INVOKE||LA25_0==NEG||(LA25_0>=DOT && LA25_0<=INTEGER)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // EvilCFGBuilder.g:914:8: tempBlock= expression[sym, structs, tempBlock.getbBlock()]
                    	    {
                    	    pushFollow(FOLLOW_expression_in_arg_list2516);
                    	    tempBlock=expression(sym, structs, tempBlock.getbBlock());

                    	    state._fsp--;


                    	             argRegs.add(tempBlock.getReg());
                    	             rtn = tempBlock.getbBlock();
                    	          

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    match(input, Token.UP, null); 

                             int count = 0;
                             for (Register reg : argRegs)
                             {
                                tempBlock.addInstruction(new Inst_storeoutargument(reg, count++)); 
                             }
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:927:6: ARGS
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list2550); 

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
        return rtn;
    }
    // $ANTLR end "arg_list"

    // Delegated rules


 

    public static final BitSet FOLLOW_program_in_buildCFG67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program98 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_in_program100 = new BitSet(new long[]{0x0000000003000008L});
    public static final BitSet FOLLOW_global_declarations_in_program103 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_functions_in_program108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_sub_in_types138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_declaration_in_types_sub163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_types_sub_in_types_sub166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type_declaration189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type_declaration193 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_struct_nested_decl_in_type_declaration210 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_decl_in_struct_nested_decl255 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_DECL_in_decl295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_decl298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_decl302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_decl308 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_type337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_type346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type360 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_declarations380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_declarations382 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_declaration408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_declaration411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_declaration415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_list_in_declaration419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_global_declarations439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_global_declaration_in_global_declarations441 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_global_declaration467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_global_declaration470 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_global_declaration474 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_global_id_list_in_global_declaration478 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_id_list499 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ID_in_global_id_list531 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_FUNCS_in_functions566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_function_in_functions599 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_FUN_in_function655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function674 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parameters_in_function690 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RETTYPE_in_function701 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_return_type_in_function705 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_declarations_in_function723 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_statement_list_in_function741 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_parameters775 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_decl_in_parameters805 = new BitSet(new long[]{0x0000000004000008L});
    public static final BitSet FOLLOW_type_in_return_type849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_return_type859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTS_in_statement_list880 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement_list916 = new BitSet(new long[]{0x000002014001DA08L});
    public static final BitSet FOLLOW_block_in_statement967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_statement992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_statement1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_statement1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_in_statement1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_in_statement1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocation_in_statement1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block1087 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_list_in_block1091 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_assignment1122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_assignment1126 = new BitSet(new long[]{0x0100040000000000L});
    public static final BitSet FOLLOW_lvalue_store_in_assignment1144 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRINT_in_print1175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_print1179 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ENDL_in_print1185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read1214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_read_help_in_read1216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_read_help1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_read_help1262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_read_help1266 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_read_help1271 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_conditional1301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditional1315 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_conditional1339 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_block_in_conditional1391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_loop1441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_loop1452 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_loop1492 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_loop1526 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_in_delete1572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_delete1576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_ret1607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ret1627 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOKE_in_invocation1660 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocation1664 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_arguments_in_invocation1668 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_store1699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_lvalue_store1703 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_store1708 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_lvalue_store1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_lvalue_load1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_lvalue_load1773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_lvalue_load1777 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_load1782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_load1799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_invocation_in_lvalue_load1803 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_load1808 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_exp1838 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_lvalue_exp1842 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_exp1847 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_exp1864 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_invocation_in_lvalue_exp1868 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_exp1873 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_exp1890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEW_in_lvalue_exp1892 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_exp1896 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expression1935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1939 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1944 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expression1962 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1966 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1971 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expression1989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1993 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1998 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expression2016 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2020 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2025 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expression2043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2047 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2052 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NE_in_expression2070 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2074 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2079 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expression2097 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2101 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2106 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expression2124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2128 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expression2151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2155 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expression2178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2182 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expression2205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2209 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_expression2232 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2236 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2241 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression2259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2263 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expression2281 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2285 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_lvalue_exp_in_expression2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_expression2324 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expression2328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_invocation_in_expression2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expression2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_expression2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_expression2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_expression2431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_list_in_arguments2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGS_in_arg_list2495 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_arg_list2516 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_ARGS_in_arg_list2550 = new BitSet(new long[]{0x0000000000000002L});

}