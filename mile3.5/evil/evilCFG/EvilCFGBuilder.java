// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 evilCFG/EvilCFGBuilder.g 2010-05-05 11:44:19

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
    public String getGrammarFileName() { return "evilCFG/EvilCFGBuilder.g"; }



    // $ANTLR start "buildCFG"
    // evilCFG/EvilCFGBuilder.g:17:1: buildCFG[boolean debug] returns [SymbolTable rtn] : program[sym, structs] ;
    public final SymbolTable buildCFG(boolean debug) throws RecognitionException {
        SymbolTable rtn = null;

        try {
            // evilCFG/EvilCFGBuilder.g:18:4: ( program[sym, structs] )
            // evilCFG/EvilCFGBuilder.g:19:4: program[sym, structs]
            {

                  System.out.println("Beginning CFG building");
                  SymbolTable sym = new SymbolTable();
                  StructTable structs = new StructTable();
               
            pushFollow(FOLLOW_program_in_buildCFG59);
            program(sym, structs);

            state._fsp--;


                  if (debug)
                  {
                     System.out.println(sym);
                     System.out.println(structs + "\n");

                     System.out.println(((Function)(sym.get("main"))).getBody().fullToString());
                  }

                  rtn = sym;

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
    // evilCFG/EvilCFGBuilder.g:40:1: program[SymbolTable sym, StructTable structs] : ^( PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs] ) ;
    public final void program(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // evilCFG/EvilCFGBuilder.g:41:4: ( ^( PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs] ) )
            // evilCFG/EvilCFGBuilder.g:42:4: ^( PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs] )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program87); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_types_in_program89);
            types(structs);

            state._fsp--;

            pushFollow(FOLLOW_global_declarations_in_program92);
            global_declarations(sym, structs);

            state._fsp--;

            pushFollow(FOLLOW_functions_in_program95);
            functions(sym, structs);

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
    // $ANTLR end "program"


    // $ANTLR start "types"
    // evilCFG/EvilCFGBuilder.g:45:1: types[StructTable structs] : ( ^( TYPES types_sub[structs] ) | TYPES );
    public final void types(StructTable structs) throws RecognitionException {
        try {
            // evilCFG/EvilCFGBuilder.g:46:4: ( ^( TYPES types_sub[structs] ) | TYPES )
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
                    // evilCFG/EvilCFGBuilder.g:46:6: ^( TYPES types_sub[structs] )
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types115); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        pushFollow(FOLLOW_types_sub_in_types117);
                        types_sub(structs);

                        state._fsp--;


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:47:6: TYPES
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types126); 

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
    // evilCFG/EvilCFGBuilder.g:50:1: types_sub[StructTable structs] : ( type_declaration[structs] types_sub[structs] | );
    public final void types_sub(StructTable structs) throws RecognitionException {
        try {
            // evilCFG/EvilCFGBuilder.g:51:4: ( type_declaration[structs] types_sub[structs] | )
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
                    // evilCFG/EvilCFGBuilder.g:51:6: type_declaration[structs] types_sub[structs]
                    {
                    pushFollow(FOLLOW_type_declaration_in_types_sub142);
                    type_declaration(structs);

                    state._fsp--;

                    pushFollow(FOLLOW_types_sub_in_types_sub145);
                    types_sub(structs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:53:4: 
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
    // evilCFG/EvilCFGBuilder.g:55:1: type_declaration[StructTable structs] : ^( STRUCT id= ID struct_nested_decl[structs, myStruct] ) ;
    public final void type_declaration(StructTable structs) throws RecognitionException {
        CommonTree id=null;

        try {
            // evilCFG/EvilCFGBuilder.g:56:4: ( ^( STRUCT id= ID struct_nested_decl[structs, myStruct] ) )
            // evilCFG/EvilCFGBuilder.g:56:6: ^( STRUCT id= ID struct_nested_decl[structs, myStruct] )
            {
            match(input,STRUCT,FOLLOW_STRUCT_in_type_declaration168); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_declaration172); 

                     Struct myStruct = new Struct((id!=null?id.getText():null));
                     structs.add((id!=null?id.getText():null), myStruct);
                  
            pushFollow(FOLLOW_struct_nested_decl_in_type_declaration189);
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
    // evilCFG/EvilCFGBuilder.g:67:1: struct_nested_decl[StructTable structs, Struct myStruct] : (var= decl[structs] )+ ;
    public final void struct_nested_decl(StructTable structs, Struct myStruct) throws RecognitionException {
        Variable var = null;


        try {
            // evilCFG/EvilCFGBuilder.g:68:4: ( (var= decl[structs] )+ )
            // evilCFG/EvilCFGBuilder.g:68:6: (var= decl[structs] )+
            {
            // evilCFG/EvilCFGBuilder.g:68:6: (var= decl[structs] )+
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
            	    // evilCFG/EvilCFGBuilder.g:69:9: var= decl[structs]
            	    {
            	    pushFollow(FOLLOW_decl_in_struct_nested_decl234);
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
    // evilCFG/EvilCFGBuilder.g:76:1: decl[StructTable structs] returns [Variable var = null] : ^( DECL ^( TYPE ty= type[structs] ) id= ID ) ;
    public final Variable decl(StructTable structs) throws RecognitionException {
        Variable var =  null;

        CommonTree id=null;
        Variable ty = null;


        try {
            // evilCFG/EvilCFGBuilder.g:77:4: ( ^( DECL ^( TYPE ty= type[structs] ) id= ID ) )
            // evilCFG/EvilCFGBuilder.g:77:6: ^( DECL ^( TYPE ty= type[structs] ) id= ID )
            {
            match(input,DECL,FOLLOW_DECL_in_decl274); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_decl277); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_decl281);
            ty=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_decl287); 

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
    // evilCFG/EvilCFGBuilder.g:84:1: type[StructTable structs] returns [Variable var = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
    public final Variable type(StructTable structs) throws RecognitionException {
        Variable var =  null;

        CommonTree id=null;

        try {
            // evilCFG/EvilCFGBuilder.g:85:4: ( INT | BOOL | ^( STRUCT id= ID ) )
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
                    // evilCFG/EvilCFGBuilder.g:85:6: INT
                    {
                    match(input,INT,FOLLOW_INT_in_type316); 
                    var = new Primitive();

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:86:6: BOOL
                    {
                    match(input,BOOL,FOLLOW_BOOL_in_type325); 
                    var= new Primitive();

                    }
                    break;
                case 3 :
                    // evilCFG/EvilCFGBuilder.g:87:6: ^( STRUCT id= ID )
                    {
                    match(input,STRUCT,FOLLOW_STRUCT_in_type335); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_type339); 

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
    // evilCFG/EvilCFGBuilder.g:90:1: declarations[SymbolTable sym, StructTable structs] : ( ^( DECLS ( declaration[sym, structs] )* ) | );
    public final void declarations(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // evilCFG/EvilCFGBuilder.g:91:4: ( ^( DECLS ( declaration[sym, structs] )* ) | )
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
                    // evilCFG/EvilCFGBuilder.g:91:6: ^( DECLS ( declaration[sym, structs] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_declarations359); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // evilCFG/EvilCFGBuilder.g:91:14: ( declaration[sym, structs] )*
                        loop5:
                        do {
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==DECLLIST) ) {
                                alt5=1;
                            }


                            switch (alt5) {
                        	case 1 :
                        	    // evilCFG/EvilCFGBuilder.g:91:14: declaration[sym, structs]
                        	    {
                        	    pushFollow(FOLLOW_declaration_in_declarations361);
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
                    // evilCFG/EvilCFGBuilder.g:93:4: 
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
    // evilCFG/EvilCFGBuilder.g:95:1: declaration[SymbolTable sym, StructTable structs] : ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] ) ;
    public final void declaration(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // evilCFG/EvilCFGBuilder.g:96:4: ( ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] ) )
            // evilCFG/EvilCFGBuilder.g:96:6: ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_declaration387); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_declaration390); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_declaration394);
            var=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_id_list_in_declaration398);
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
    // evilCFG/EvilCFGBuilder.g:99:1: global_declarations[SymbolTable sym, StructTable structs] : ( ^( DECLS ( global_declaration[sym, structs] )* ) | );
    public final void global_declarations(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // evilCFG/EvilCFGBuilder.g:100:4: ( ^( DECLS ( global_declaration[sym, structs] )* ) | )
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
                    // evilCFG/EvilCFGBuilder.g:100:6: ^( DECLS ( global_declaration[sym, structs] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_global_declarations418); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // evilCFG/EvilCFGBuilder.g:100:14: ( global_declaration[sym, structs] )*
                        loop7:
                        do {
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==DECLLIST) ) {
                                alt7=1;
                            }


                            switch (alt7) {
                        	case 1 :
                        	    // evilCFG/EvilCFGBuilder.g:100:14: global_declaration[sym, structs]
                        	    {
                        	    pushFollow(FOLLOW_global_declaration_in_global_declarations420);
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
                    // evilCFG/EvilCFGBuilder.g:102:4: 
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
    // evilCFG/EvilCFGBuilder.g:104:1: global_declaration[SymbolTable sym, StructTable structs] : ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] ) ;
    public final void global_declaration(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // evilCFG/EvilCFGBuilder.g:105:4: ( ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] ) )
            // evilCFG/EvilCFGBuilder.g:105:6: ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_global_declaration446); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_global_declaration449); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_global_declaration453);
            var=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_global_id_list_in_global_declaration457);
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
    // evilCFG/EvilCFGBuilder.g:108:1: id_list[Variable var, SymbolTable sym] : (id= ID )+ ;
    public final void id_list(Variable var, SymbolTable sym) throws RecognitionException {
        CommonTree id=null;

        try {
            // evilCFG/EvilCFGBuilder.g:109:3: ( (id= ID )+ )
            // evilCFG/EvilCFGBuilder.g:109:5: (id= ID )+
            {
            // evilCFG/EvilCFGBuilder.g:109:5: (id= ID )+
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
            	    // evilCFG/EvilCFGBuilder.g:109:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list478); 

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
    // evilCFG/EvilCFGBuilder.g:119:1: global_id_list[Variable var, SymbolTable sym] : (id= ID )+ ;
    public final void global_id_list(Variable var, SymbolTable sym) throws RecognitionException {
        CommonTree id=null;

        try {
            // evilCFG/EvilCFGBuilder.g:120:3: ( (id= ID )+ )
            // evilCFG/EvilCFGBuilder.g:120:5: (id= ID )+
            {
            // evilCFG/EvilCFGBuilder.g:120:5: (id= ID )+
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
            	    // evilCFG/EvilCFGBuilder.g:120:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_global_id_list510); 

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
    // evilCFG/EvilCFGBuilder.g:130:1: functions[SymbolTable sym, StructTable structs] : ( ^( FUNCS (fun= function[sym, structs] )* ) | );
    public final void functions(SymbolTable sym, StructTable structs) throws RecognitionException {
        Function fun = null;


        try {
            // evilCFG/EvilCFGBuilder.g:131:4: ( ^( FUNCS (fun= function[sym, structs] )* ) | )
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
                    // evilCFG/EvilCFGBuilder.g:131:6: ^( FUNCS (fun= function[sym, structs] )* )
                    {
                    match(input,FUNCS,FOLLOW_FUNCS_in_functions541); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // evilCFG/EvilCFGBuilder.g:132:7: (fun= function[sym, structs] )*
                        loop11:
                        do {
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==FUN) ) {
                                alt11=1;
                            }


                            switch (alt11) {
                        	case 1 :
                        	    // evilCFG/EvilCFGBuilder.g:133:10: fun= function[sym, structs]
                        	    {

                        	             
                        	    pushFollow(FOLLOW_function_in_functions574);
                        	    fun=function(sym, structs);

                        	    state._fsp--;


                        	                sym.add(fun.getName(), fun);
                        	             

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
                    // evilCFG/EvilCFGBuilder.g:142:4: 
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
    // $ANTLR end "functions"


    // $ANTLR start "function"
    // evilCFG/EvilCFGBuilder.g:144:1: function[SymbolTable sym, StructTable structs] returns [Function fun = null] : ^( FUN id= ID parameters[sym, structs, funEntry] ^( RETTYPE returnVal= return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] ) ;
    public final Function function(SymbolTable sym, StructTable structs) throws RecognitionException {
        Function fun =  null;

        CommonTree id=null;
        Variable returnVal = null;


        try {
            // evilCFG/EvilCFGBuilder.g:145:4: ( ^( FUN id= ID parameters[sym, structs, funEntry] ^( RETTYPE returnVal= return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] ) )
            // evilCFG/EvilCFGBuilder.g:145:6: ^( FUN id= ID parameters[sym, structs, funEntry] ^( RETTYPE returnVal= return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] )
            {
            match(input,FUN,FOLLOW_FUN_in_function630); 


                  

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_function649); 

                     sym.newState();
                     
                     BasicBlock funEntry = new BasicBlock((id!=null?id.getText():null));
                     BasicBlock body = new BasicBlock();

                     funEntry.addKid(body);
                     body.addParent(funEntry);

                     //Add temperary function to state to top state to support recursion.
                     sym.add((id!=null?id.getText():null), new Function((id!=null?id.getText():null), funEntry, null));

                     funEntry.addInstruction(new FakeInstruction("ENTRY: " + (id!=null?id.getText():null)));

                  
            pushFollow(FOLLOW_parameters_in_function665);
            parameters(sym, structs, funEntry);

            state._fsp--;

            match(input,RETTYPE,FOLLOW_RETTYPE_in_function676); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_return_type_in_function680);
            returnVal=return_type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_declarations_in_function690);
            declarations(sym, structs);

            state._fsp--;

            pushFollow(FOLLOW_statement_list_in_function700);
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

                     fun = new Function((id!=null?id.getText():null), funEntry, scope);
                     
                     if (returnVal != null)
                     {
                        fun.setReturn();
                     }
                  
                     //Add loadinargs to entry block
                     int count = 0;
                     for (String formal : fun.getFormals())
                     {
                        funEntry.addInstruction(new Inst_loadinargument(
                         formal, count, funEntry.getMapping(formal)));
                         count++;
                     }

                     funEntry.addInstruction(new Inst_jumpi(body.getTag()));
                  

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return fun;
    }
    // $ANTLR end "function"


    // $ANTLR start "parameters"
    // evilCFG/EvilCFGBuilder.g:202:1: parameters[SymbolTable sym, StructTable structs, BasicBlock funEntry] : ^( PARAMS (var= decl[structs] )* ) ;
    public final void parameters(SymbolTable sym, StructTable structs, BasicBlock funEntry) throws RecognitionException {
        Variable var = null;


        try {
            // evilCFG/EvilCFGBuilder.g:203:4: ( ^( PARAMS (var= decl[structs] )* ) )
            // evilCFG/EvilCFGBuilder.g:203:6: ^( PARAMS (var= decl[structs] )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_parameters734); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // evilCFG/EvilCFGBuilder.g:204:7: (var= decl[structs] )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DECL) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // evilCFG/EvilCFGBuilder.g:205:10: var= decl[structs]
                	    {
                	    pushFollow(FOLLOW_decl_in_parameters756);
                	    var=decl(structs);

                	    state._fsp--;


                	                var.setScope(ScopeType.kFormal);
                	                sym.add(var.getName(), var);
                	                
                	                Register temp = new Register();
                	                funEntry.addMapping(var.getName(), temp);
                	             

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
    // evilCFG/EvilCFGBuilder.g:216:1: return_type[StructTable structs] returns [Variable var = null] : (v= type[structs] | VOID );
    public final Variable return_type(StructTable structs) throws RecognitionException {
        Variable var =  null;

        Variable v = null;


        try {
            // evilCFG/EvilCFGBuilder.g:217:4: (v= type[structs] | VOID )
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
                    // evilCFG/EvilCFGBuilder.g:217:6: v= type[structs]
                    {
                    pushFollow(FOLLOW_type_in_return_type800);
                    v=type(structs);

                    state._fsp--;

                    var = v;

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:218:6: VOID
                    {
                    match(input,VOID,FOLLOW_VOID_in_return_type810); 

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
    // evilCFG/EvilCFGBuilder.g:221:1: statement_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* ) ;
    public final BasicBlock statement_list(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        BasicBlock tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:222:4: ( ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* ) )
            // evilCFG/EvilCFGBuilder.g:222:6: ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* )
            {
            match(input,STMTS,FOLLOW_STMTS_in_statement_list831); 


                        tempBlock = bBlock;
                     

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // evilCFG/EvilCFGBuilder.g:226:10: (tempBlock= statement[sym, structs, tempBlock] )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==PRINT||(LA15_0>=READ && LA15_0<=IF)||(LA15_0>=WHILE && LA15_0<=RETURN)||LA15_0==BLOCK||LA15_0==INVOKE||LA15_0==ASSIGN) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // evilCFG/EvilCFGBuilder.g:227:10: tempBlock= statement[sym, structs, tempBlock]
                	    {
                	    pushFollow(FOLLOW_statement_in_statement_list867);
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
    // evilCFG/EvilCFGBuilder.g:235:1: statement[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : (tempBlock= block[sym, structs, bBlock] | tempBlock= assignment[sym, structs, bBlock] | tempBlock= print[sym, structs, bBlock] | read[sym, structs, bBlock] | tempBlock= conditional[sym, structs, bBlock] | tempBlock= loop[sym, structs, bBlock] | tempBlock= delete[sym, structs, bBlock] | tempBlock= ret[sym, structs, bBlock] | temp= invocation[sym, structs, bBlock] );
    public final BasicBlock statement(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        BasicBlock tempBlock = null;

        Warden temp = null;


        try {
            // evilCFG/EvilCFGBuilder.g:236:4: (tempBlock= block[sym, structs, bBlock] | tempBlock= assignment[sym, structs, bBlock] | tempBlock= print[sym, structs, bBlock] | read[sym, structs, bBlock] | tempBlock= conditional[sym, structs, bBlock] | tempBlock= loop[sym, structs, bBlock] | tempBlock= delete[sym, structs, bBlock] | tempBlock= ret[sym, structs, bBlock] | temp= invocation[sym, structs, bBlock] )
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
                    // evilCFG/EvilCFGBuilder.g:236:6: tempBlock= block[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_block_in_statement918);
                    tempBlock=block(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:237:6: tempBlock= assignment[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_assignment_in_statement930);
                    tempBlock=assignment(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 3 :
                    // evilCFG/EvilCFGBuilder.g:238:6: tempBlock= print[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_print_in_statement943);
                    tempBlock=print(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 4 :
                    // evilCFG/EvilCFGBuilder.g:239:6: read[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_read_in_statement954);
                    read(sym, structs, bBlock);

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // evilCFG/EvilCFGBuilder.g:240:6: tempBlock= conditional[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_conditional_in_statement964);
                    tempBlock=conditional(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 6 :
                    // evilCFG/EvilCFGBuilder.g:241:6: tempBlock= loop[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_loop_in_statement976);
                    tempBlock=loop(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 7 :
                    // evilCFG/EvilCFGBuilder.g:242:6: tempBlock= delete[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_delete_in_statement988);
                    tempBlock=delete(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 8 :
                    // evilCFG/EvilCFGBuilder.g:243:6: tempBlock= ret[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_ret_in_statement1001);
                    tempBlock=ret(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 9 :
                    // evilCFG/EvilCFGBuilder.g:244:6: temp= invocation[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_invocation_in_statement1014);
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
    // evilCFG/EvilCFGBuilder.g:247:1: block[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn] : ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] ) ;
    public final BasicBlock block(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn = null;

        BasicBlock tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:248:4: ( ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] ) )
            // evilCFG/EvilCFGBuilder.g:248:6: ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block1038); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_list_in_block1042);
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
    // evilCFG/EvilCFGBuilder.g:254:1: assignment[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( ASSIGN tempBlock= expression[sym, structs, bBlock] lvalue_store[sym, structs, b, tempBlock.getReg()] ) ;
    public final BasicBlock assignment(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:255:4: ( ^( ASSIGN tempBlock= expression[sym, structs, bBlock] lvalue_store[sym, structs, b, tempBlock.getReg()] ) )
            // evilCFG/EvilCFGBuilder.g:255:6: ^( ASSIGN tempBlock= expression[sym, structs, bBlock] lvalue_store[sym, structs, b, tempBlock.getReg()] )
            {
            match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment1073); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_assignment1077);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


                     BasicBlock b = tempBlock.getbBlock();
                  
            pushFollow(FOLLOW_lvalue_store_in_assignment1095);
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
    // evilCFG/EvilCFGBuilder.g:265:1: print[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( PRINT tempBlock= expression[sym, structs, bBlock] (endl= ENDL )? ) ;
    public final BasicBlock print(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        CommonTree endl=null;
        Warden tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:266:4: ( ^( PRINT tempBlock= expression[sym, structs, bBlock] (endl= ENDL )? ) )
            // evilCFG/EvilCFGBuilder.g:266:6: ^( PRINT tempBlock= expression[sym, structs, bBlock] (endl= ENDL )? )
            {
            match(input,PRINT,FOLLOW_PRINT_in_print1126); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_print1130);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;

            // evilCFG/EvilCFGBuilder.g:266:57: (endl= ENDL )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ENDL) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // evilCFG/EvilCFGBuilder.g:266:58: endl= ENDL
                    {
                    endl=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print1136); 

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
    // evilCFG/EvilCFGBuilder.g:281:1: read[SymbolTable sym, StructTable structs, BasicBlock bBlock] : ^( READ reg= lvalue_load[sym, structs, bBlock] ) ;
    public final void read(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg = null;


        try {
            // evilCFG/EvilCFGBuilder.g:282:4: ( ^( READ reg= lvalue_load[sym, structs, bBlock] ) )
            // evilCFG/EvilCFGBuilder.g:282:6: ^( READ reg= lvalue_load[sym, structs, bBlock] )
            {
            match(input,READ,FOLLOW_READ_in_read1165); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_lvalue_load_in_read1169);
            reg=lvalue_load(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     //bBlock.addInstruction(new Inst_read(reg));
                     bBlock.addInstruction(new FakeInstruction("READING"));
                  

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
    // evilCFG/EvilCFGBuilder.g:289:1: conditional[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? ) ;
    public final BasicBlock conditional(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:290:4: ( ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? ) )
            // evilCFG/EvilCFGBuilder.g:290:6: ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? )
            {
            match(input,IF,FOLLOW_IF_in_conditional1200); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_conditional1214);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


                        //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD"));

                        BasicBlock thenBlock = new BasicBlock();
                        tempBlock.getbBlock().addKid(thenBlock);
                        thenBlock.getbBlock().addParent(tempBlock.getbBlock());
                        
                        //thenBlock.addInstruction(new FakeInstruction("THEN BEGIN"));
                     
            pushFollow(FOLLOW_block_in_conditional1238);
            block(sym, structs, thenBlock);

            state._fsp--;


                        BasicBlock elseBlock = null;
                     
            // evilCFG/EvilCFGBuilder.g:305:10: ( block[sym, structs, elseBlock] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==BLOCK) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // evilCFG/EvilCFGBuilder.g:306:13: block[sym, structs, elseBlock]
                    {

                                   elseBlock = new BasicBlock();
                                   tempBlock.addKid(elseBlock);
                                   elseBlock.addParent(tempBlock.getbBlock());
                                
                                  //elseBlock.addInstruction(new FakeInstruction("ELSE BEGIN"));
                                
                    pushFollow(FOLLOW_block_in_conditional1290);
                    block(sym, structs, elseBlock);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

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
    // evilCFG/EvilCFGBuilder.g:338:1: loop[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] ) ;
    public final BasicBlock loop(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden topGuardBlock = null;

        BasicBlock bodyEndBlock = null;

        Warden bottomGuardEndBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:339:4: ( ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] ) )
            // evilCFG/EvilCFGBuilder.g:339:6: ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] )
            {
            match(input,WHILE,FOLLOW_WHILE_in_loop1340); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_loop1351);
            topGuardBlock=expression(sym, structs, bBlock);

            state._fsp--;


                     BasicBlock bodyBlock = new BasicBlock();
                     //bodyBlock.addInstruction(new FakeInstruction("WHILE BODY"));

                     topGuardBlock.getbBlock().addKid(bodyBlock);
                     bodyBlock.addParent(topGuardBlock.getbBlock());
                  
            pushFollow(FOLLOW_block_in_loop1391);
            bodyEndBlock=block(sym, structs, bodyBlock);

            state._fsp--;


                     BasicBlock bottomGuardBlock = new BasicBlock();
                     
                     bodyEndBlock.addInstruction(new Inst_jumpi(bottomGuardBlock.getTag()));

                     bodyEndBlock.addKid(bottomGuardBlock);
                     bottomGuardBlock.addParent(bodyBlock);
                  
            pushFollow(FOLLOW_expression_in_loop1425);
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
    // evilCFG/EvilCFGBuilder.g:389:1: delete[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( DELETE tempBlock= expression[sym, structs, bBlock] ) ;
    public final BasicBlock delete(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:390:4: ( ^( DELETE tempBlock= expression[sym, structs, bBlock] ) )
            // evilCFG/EvilCFGBuilder.g:390:6: ^( DELETE tempBlock= expression[sym, structs, bBlock] )
            {
            match(input,DELETE,FOLLOW_DELETE_in_delete1471); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_delete1475);
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
    // evilCFG/EvilCFGBuilder.g:398:1: ret[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( RETURN (tempBlock= expression[sym, structs, bBlock] )? ) ;
    public final BasicBlock ret(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:399:4: ( ^( RETURN (tempBlock= expression[sym, structs, bBlock] )? ) )
            // evilCFG/EvilCFGBuilder.g:399:6: ^( RETURN (tempBlock= expression[sym, structs, bBlock] )? )
            {
            match(input,RETURN,FOLLOW_RETURN_in_ret1506); 


                     tempBlock = null;
                  

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // evilCFG/EvilCFGBuilder.g:403:7: (tempBlock= expression[sym, structs, bBlock] )?
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=TRUE && LA19_0<=NULL)||LA19_0==INVOKE||LA19_0==NEG||(LA19_0>=DOT && LA19_0<=INTEGER)) ) {
                    alt19=1;
                }
                switch (alt19) {
                    case 1 :
                        // evilCFG/EvilCFGBuilder.g:403:8: tempBlock= expression[sym, structs, bBlock]
                        {
                        pushFollow(FOLLOW_expression_in_ret1526);
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
    // evilCFG/EvilCFGBuilder.g:419:1: invocation[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Warden ret = null] : ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] ) ;
    public final Warden invocation(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Warden ret =  null;

        CommonTree id=null;
        BasicBlock tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:420:4: ( ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] ) )
            // evilCFG/EvilCFGBuilder.g:420:6: ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] )
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocation1559); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation1563); 
            pushFollow(FOLLOW_arguments_in_invocation1567);
            tempBlock=arguments(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     tempBlock.addInstruction(new Inst_call(((Function)(sym.get((id!=null?id.getText():null)))).getBody().getTag()));
                     ret = new Warden(new Register(), tempBlock);

                     if (((Function)(sym.get((id!=null?id.getText():null)))).hasReturn())
                     {
                        tempBlock.addInstruction(new Inst_loadret(ret.getReg()));
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
    // evilCFG/EvilCFGBuilder.g:444:1: lvalue_store[SymbolTable sym, StructTable structs, BasicBlock bBlock, Register val] : ( ^( DOT target= lvalue_load[sym, structs, bBlock] id= ID ) | id= ID );
    public final void lvalue_store(SymbolTable sym, StructTable structs, BasicBlock bBlock, Register val) throws RecognitionException {
        CommonTree id=null;
        Register target = null;


        try {
            // evilCFG/EvilCFGBuilder.g:445:4: ( ^( DOT target= lvalue_load[sym, structs, bBlock] id= ID ) | id= ID )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==DOT) ) {
                alt20=1;
            }
            else if ( (LA20_0==ID) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // evilCFG/EvilCFGBuilder.g:445:6: ^( DOT target= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_store1597); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_lvalue_store1601);
                    target=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_store1606); 

                    match(input, Token.UP, null); 

                             bBlock.addInstruction(new Inst_storeai(val, target, (id!=null?id.getText():null)));
                          

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:449:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_store1624); 

                             Register temp = null;

                             //If we are looking for a global
                             if (sym.get((id!=null?id.getText():null)).getScope() == ScopeType.kGlobal)
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
    // evilCFG/EvilCFGBuilder.g:475:1: lvalue_load[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Register reg = null] : (id= ID | ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) );
    public final Register lvalue_load(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg =  null;

        CommonTree id=null;
        Register src = null;


        try {
            // evilCFG/EvilCFGBuilder.g:476:4: (id= ID | ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID) ) {
                alt21=1;
            }
            else if ( (LA21_0==DOT) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // evilCFG/EvilCFGBuilder.g:476:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_load1655); 

                             //Just need to get reg where address of reference is stored at.
                             reg = bBlock.getMapping((id!=null?id.getText():null));
                          

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:481:6: ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_load1671); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_lvalue_load1675);
                    src=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_load1680); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             //bBlock.addInstruction(new FakeInstruction("Loading member:" + (id!=null?id.getText():null) + " from structure at " + src + " to " + reg));
                             bBlock.addInstruction(new Inst_loadai(src, (id!=null?id.getText():null), reg));
                          

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
    // evilCFG/EvilCFGBuilder.g:489:1: lvalue_exp[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Register reg = null] : ( ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) | ^( DOT war= invocation[sym, structs, bBlock] id= ID ) | ^( DOT NEW id= ID ) );
    public final Register lvalue_exp(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg =  null;

        CommonTree id=null;
        Register src = null;

        Warden war = null;


        try {
            // evilCFG/EvilCFGBuilder.g:490:4: ( ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID ) | ^( DOT war= invocation[sym, structs, bBlock] id= ID ) | ^( DOT NEW id= ID ) )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==DOT) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case NEW:
                        {
                        alt22=3;
                        }
                        break;
                    case DOT:
                    case ID:
                        {
                        alt22=1;
                        }
                        break;
                    case INVOKE:
                        {
                        alt22=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

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
                    // evilCFG/EvilCFGBuilder.g:490:6: ^( DOT src= lvalue_load[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_exp1710); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lvalue_load_in_lvalue_exp1714);
                    src=lvalue_load(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_exp1719); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             //bBlock.addInstruction(new FakeInstruction("Loading member:" + (id!=null?id.getText():null) + " from structure at " + src + " to " + reg));
                             bBlock.addInstruction(new Inst_loadai(src, (id!=null?id.getText():null), reg));
                          

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:496:6: ^( DOT war= invocation[sym, structs, bBlock] id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_exp1736); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_invocation_in_lvalue_exp1740);
                    war=invocation(sym, structs, bBlock);

                    state._fsp--;

                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_exp1745); 

                    match(input, Token.UP, null); 

                             reg = new Register();
                             bBlock.addInstruction(new Inst_loadai(war.getReg(), (id!=null?id.getText():null), reg));
                          

                    }
                    break;
                case 3 :
                    // evilCFG/EvilCFGBuilder.g:501:6: ^( DOT NEW id= ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_lvalue_exp1762); 

                    match(input, Token.DOWN, null); 
                    match(input,NEW,FOLLOW_NEW_in_lvalue_exp1764); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue_exp1768); 

                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             String fields = structs.get((id!=null?id.getText():null)).getFieldsString();

                             bBlock.addInstruction(new Inst_new((id!=null?id.getText():null), fields, temp));

                             reg = new Register();
                             bBlock.addInstruction(new Inst_loadai(temp, (id!=null?id.getText():null), reg));
                          

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
    // evilCFG/EvilCFGBuilder.g:533:1: expression[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Warden rtn = null] : ( ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NOT exp1= expression[sym, structs, bBlock] ) | ^( NEG exp1= expression[sym, structs, bBlock] ) | ltmp= lvalue_exp[sym, structs, bBlock] | ^( NEW id= ID ) | itmp= invocation[sym, structs, bBlock] | id= ID | id= INTEGER | TRUE | FALSE | NULL );
    public final Warden expression(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Warden rtn =  null;

        CommonTree id=null;
        Warden exp1 = null;

        Warden exp2 = null;

        Register ltmp = null;

        Warden itmp = null;


        try {
            // evilCFG/EvilCFGBuilder.g:534:4: ( ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NOT exp1= expression[sym, structs, bBlock] ) | ^( NEG exp1= expression[sym, structs, bBlock] ) | ltmp= lvalue_exp[sym, structs, bBlock] | ^( NEW id= ID ) | itmp= invocation[sym, structs, bBlock] | id= ID | id= INTEGER | TRUE | FALSE | NULL )
            int alt23=22;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt23=1;
                }
                break;
            case OR:
                {
                alt23=2;
                }
                break;
            case EQ:
                {
                alt23=3;
                }
                break;
            case LT:
                {
                alt23=4;
                }
                break;
            case GT:
                {
                alt23=5;
                }
                break;
            case NE:
                {
                alt23=6;
                }
                break;
            case LE:
                {
                alt23=7;
                }
                break;
            case GE:
                {
                alt23=8;
                }
                break;
            case PLUS:
                {
                alt23=9;
                }
                break;
            case MINUS:
                {
                alt23=10;
                }
                break;
            case TIMES:
                {
                alt23=11;
                }
                break;
            case DIVIDE:
                {
                alt23=12;
                }
                break;
            case NOT:
                {
                alt23=13;
                }
                break;
            case NEG:
                {
                alt23=14;
                }
                break;
            case DOT:
                {
                alt23=15;
                }
                break;
            case NEW:
                {
                alt23=16;
                }
                break;
            case INVOKE:
                {
                alt23=17;
                }
                break;
            case ID:
                {
                alt23=18;
                }
                break;
            case INTEGER:
                {
                alt23=19;
                }
                break;
            case TRUE:
                {
                alt23=20;
                }
                break;
            case FALSE:
                {
                alt23=21;
                }
                break;
            case NULL:
                {
                alt23=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // evilCFG/EvilCFGBuilder.g:534:6: ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,AND,FOLLOW_AND_in_expression1807); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1811);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1816);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_and(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:540:6: ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,OR,FOLLOW_OR_in_expression1834); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1838);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1843);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_or(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 3 :
                    // evilCFG/EvilCFGBuilder.g:546:6: ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expression1861); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1865);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1870);
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
                    // evilCFG/EvilCFGBuilder.g:554:6: ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,LT,FOLLOW_LT_in_expression1888); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1892);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1897);
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
                    // evilCFG/EvilCFGBuilder.g:562:6: ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,GT,FOLLOW_GT_in_expression1915); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1919);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1924);
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
                    // evilCFG/EvilCFGBuilder.g:570:6: ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,NE,FOLLOW_NE_in_expression1942); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1946);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1951);
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
                    // evilCFG/EvilCFGBuilder.g:578:6: ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,LE,FOLLOW_LE_in_expression1969); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1973);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1978);
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
                    // evilCFG/EvilCFGBuilder.g:586:6: ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,GE,FOLLOW_GE_in_expression1996); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2000);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2005);
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
                    // evilCFG/EvilCFGBuilder.g:594:6: ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expression2023); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2027);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2032);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_add(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 10 :
                    // evilCFG/EvilCFGBuilder.g:600:6: ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expression2050); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2054);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2059);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_sub(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 11 :
                    // evilCFG/EvilCFGBuilder.g:606:6: ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expression2077); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2081);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2086);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_mult(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 12 :
                    // evilCFG/EvilCFGBuilder.g:612:6: ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_expression2104); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2108);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2113);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_div(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 13 :
                    // evilCFG/EvilCFGBuilder.g:618:6: ^( NOT exp1= expression[sym, structs, bBlock] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expression2131); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2135);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_xori(exp1.getReg(), -1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 14 :
                    // evilCFG/EvilCFGBuilder.g:624:6: ^( NEG exp1= expression[sym, structs, bBlock] )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expression2153); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2157);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(-1, temp));
                             bBlock.addInstruction(new Inst_mult(exp1.getReg(), temp, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 15 :
                    // evilCFG/EvilCFGBuilder.g:631:6: ltmp= lvalue_exp[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_lvalue_exp_in_expression2176);
                    ltmp=lvalue_exp(sym, structs, bBlock);

                    state._fsp--;


                             rtn = new Warden(ltmp, bBlock);
                          

                    }
                    break;
                case 16 :
                    // evilCFG/EvilCFGBuilder.g:643:6: ^( NEW id= ID )
                    {
                    match(input,NEW,FOLLOW_NEW_in_expression2196); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2200); 

                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             String fields = structs.get((id!=null?id.getText():null)).getFieldsString();

                             bBlock.addInstruction(new Inst_new((id!=null?id.getText():null), fields, temp));

                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 17 :
                    // evilCFG/EvilCFGBuilder.g:652:6: itmp= invocation[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_invocation_in_expression2218);
                    itmp=invocation(sym, structs, bBlock);

                    state._fsp--;


                             rtn = itmp;
                          

                    }
                    break;
                case 18 :
                    // evilCFG/EvilCFGBuilder.g:656:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2237); 

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
                    // evilCFG/EvilCFGBuilder.g:670:6: id= INTEGER
                    {
                    id=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression2255); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(Integer.valueOf((id!=null?id.getText():null)), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 20 :
                    // evilCFG/EvilCFGBuilder.g:676:6: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_expression2271); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 21 :
                    // evilCFG/EvilCFGBuilder.g:682:6: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_expression2287); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 22 :
                    // evilCFG/EvilCFGBuilder.g:688:6: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_expression2303); 
                    rtn = new Warden(new Register(), bBlock);

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
    // evilCFG/EvilCFGBuilder.g:691:1: arguments[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : tempBlock= arg_list[sym, structs, bBlock] ;
    public final BasicBlock arguments(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        BasicBlock tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:692:4: (tempBlock= arg_list[sym, structs, bBlock] )
            // evilCFG/EvilCFGBuilder.g:692:6: tempBlock= arg_list[sym, structs, bBlock]
            {
            pushFollow(FOLLOW_arg_list_in_arguments2327);
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
    // evilCFG/EvilCFGBuilder.g:695:1: arg_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : ( ^( ARGS (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+ ) | ARGS );
    public final BasicBlock arg_list(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        Warden tempBlock = null;


        try {
            // evilCFG/EvilCFGBuilder.g:696:4: ( ^( ARGS (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+ ) | ARGS )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ARGS) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==DOWN) ) {
                    alt25=1;
                }
                else if ( (LA25_1==UP) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // evilCFG/EvilCFGBuilder.g:696:6: ^( ARGS (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+ )
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list2351); 


                             int count = 0;
                             tempBlock = new Warden(new Register(), bBlock);
                          

                    match(input, Token.DOWN, null); 
                    // evilCFG/EvilCFGBuilder.g:701:7: (tempBlock= expression[sym, structs, tempBlock.getbBlock()] )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=TRUE && LA24_0<=NULL)||LA24_0==INVOKE||LA24_0==NEG||(LA24_0>=DOT && LA24_0<=INTEGER)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // evilCFG/EvilCFGBuilder.g:701:8: tempBlock= expression[sym, structs, tempBlock.getbBlock()]
                    	    {
                    	    pushFollow(FOLLOW_expression_in_arg_list2372);
                    	    tempBlock=expression(sym, structs, tempBlock.getbBlock());

                    	    state._fsp--;


                    	             tempBlock.addInstruction(new Inst_storeoutargument(tempBlock.getReg(), count++)); 
                    	             rtn = tempBlock.getbBlock();
                    	          

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // evilCFG/EvilCFGBuilder.g:707:6: ARGS
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list2398); 

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


 

    public static final BitSet FOLLOW_program_in_buildCFG59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_in_program89 = new BitSet(new long[]{0x0000000003000008L});
    public static final BitSet FOLLOW_global_declarations_in_program92 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_functions_in_program95 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types115 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_sub_in_types117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_declaration_in_types_sub142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_types_sub_in_types_sub145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type_declaration168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type_declaration172 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_struct_nested_decl_in_type_declaration189 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_decl_in_struct_nested_decl234 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_DECL_in_decl274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_decl277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_decl281 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_decl287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_type316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_type325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type339 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_declarations359 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_declarations361 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_declaration387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_declaration390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_declaration394 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_list_in_declaration398 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_global_declarations418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_global_declaration_in_global_declarations420 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_global_declaration446 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_global_declaration449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_global_declaration453 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_global_id_list_in_global_declaration457 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_id_list478 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ID_in_global_id_list510 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_FUNCS_in_functions541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_function_in_functions574 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_FUN_in_function630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function649 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parameters_in_function665 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RETTYPE_in_function676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_return_type_in_function680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_declarations_in_function690 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_statement_list_in_function700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_parameters734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_decl_in_parameters756 = new BitSet(new long[]{0x0000000004000008L});
    public static final BitSet FOLLOW_type_in_return_type800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_return_type810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTS_in_statement_list831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement_list867 = new BitSet(new long[]{0x000002014001DA08L});
    public static final BitSet FOLLOW_block_in_statement918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_statement943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_statement964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_statement976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_in_statement988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_in_statement1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocation_in_statement1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block1038 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_list_in_block1042 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_assignment1073 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_assignment1077 = new BitSet(new long[]{0x0100040000000000L});
    public static final BitSet FOLLOW_lvalue_store_in_assignment1095 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRINT_in_print1126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_print1130 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ENDL_in_print1136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read1165 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_read1169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_conditional1200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditional1214 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_conditional1238 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_block_in_conditional1290 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_loop1340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_loop1351 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_loop1391 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_loop1425 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_in_delete1471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_delete1475 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_ret1506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ret1526 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOKE_in_invocation1559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocation1563 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_arguments_in_invocation1567 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_store1597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_lvalue_store1601 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_store1606 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_lvalue_store1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_lvalue_load1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_lvalue_load1671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_lvalue_load1675 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_load1680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_exp1710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_load_in_lvalue_exp1714 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_exp1719 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_exp1736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_invocation_in_lvalue_exp1740 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_exp1745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_lvalue_exp1762 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEW_in_lvalue_exp1764 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue_exp1768 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expression1807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1811 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1816 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expression1834 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1838 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expression1861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1865 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1870 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expression1888 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1892 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1897 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expression1915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1919 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1924 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NE_in_expression1942 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1946 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1951 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expression1969 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1973 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1978 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expression1996 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2000 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2005 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expression2023 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2027 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2032 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expression2050 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2054 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2059 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expression2077 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2081 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2086 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_expression2104 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2108 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression2113 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression2131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expression2153 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_lvalue_exp_in_expression2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_expression2196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expression2200 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_invocation_in_expression2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expression2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_expression2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_expression2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_expression2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_list_in_arguments2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGS_in_arg_list2351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_arg_list2372 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_ARGS_in_arg_list2398 = new BitSet(new long[]{0x0000000000000002L});

}