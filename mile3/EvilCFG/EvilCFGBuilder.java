// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 EvilCFGBuilder.g 2010-04-30 09:03:31

   package EvilCFG;

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



    // $ANTLR start "program"
    // EvilCFGBuilder.g:16:1: program : ^( PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs] ) ;
    public final void program() throws RecognitionException {
        try {
            // EvilCFGBuilder.g:17:4: ( ^( PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs] ) )
            // EvilCFGBuilder.g:18:4: ^( PROGRAM types[structs] global_declarations[sym, structs] functions[sym, structs] )
            {

                  System.out.println("Beginning CFG building");
                  SymbolTable sym = new SymbolTable();
                  StructTable structs = new StructTable();
               
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program56); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_types_in_program58);
            types(structs);

            state._fsp--;

            pushFollow(FOLLOW_global_declarations_in_program61);
            global_declarations(sym, structs);

            state._fsp--;

            pushFollow(FOLLOW_functions_in_program64);
            functions(sym, structs);

            state._fsp--;


            match(input, Token.UP, null); 

                  System.out.println(sym);
                  System.out.println(structs + "\n");

                  System.out.println(((Function)(sym.get("main"))).getBody().fullToString());

                  System.out.println("Finished CFG building");
               

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
    // EvilCFGBuilder.g:34:1: types[StructTable structs] : ( ^( TYPES types_sub[structs] ) | TYPES );
    public final void types(StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:35:4: ( ^( TYPES types_sub[structs] ) | TYPES )
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
                    // EvilCFGBuilder.g:35:6: ^( TYPES types_sub[structs] )
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types89); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        pushFollow(FOLLOW_types_sub_in_types91);
                        types_sub(structs);

                        state._fsp--;


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:36:6: TYPES
                    {
                    match(input,TYPES,FOLLOW_TYPES_in_types100); 

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
    // EvilCFGBuilder.g:39:1: types_sub[StructTable structs] : ( type_declaration[structs] types_sub[structs] | );
    public final void types_sub(StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:40:4: ( type_declaration[structs] types_sub[structs] | )
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
                    // EvilCFGBuilder.g:40:6: type_declaration[structs] types_sub[structs]
                    {
                    pushFollow(FOLLOW_type_declaration_in_types_sub116);
                    type_declaration(structs);

                    state._fsp--;

                    pushFollow(FOLLOW_types_sub_in_types_sub119);
                    types_sub(structs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:42:4: 
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
    // EvilCFGBuilder.g:44:1: type_declaration[StructTable structs] : ^( STRUCT id= ID struct_nested_decl[structs, myStruct] ) ;
    public final void type_declaration(StructTable structs) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:45:4: ( ^( STRUCT id= ID struct_nested_decl[structs, myStruct] ) )
            // EvilCFGBuilder.g:45:6: ^( STRUCT id= ID struct_nested_decl[structs, myStruct] )
            {
            match(input,STRUCT,FOLLOW_STRUCT_in_type_declaration142); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_declaration146); 

                     Struct myStruct = new Struct((id!=null?id.getText():null));
                     structs.add((id!=null?id.getText():null), myStruct);
                  
            pushFollow(FOLLOW_struct_nested_decl_in_type_declaration163);
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
    // EvilCFGBuilder.g:56:1: struct_nested_decl[StructTable structs, Struct myStruct] : (var= decl[structs] )+ ;
    public final void struct_nested_decl(StructTable structs, Struct myStruct) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:57:4: ( (var= decl[structs] )+ )
            // EvilCFGBuilder.g:57:6: (var= decl[structs] )+
            {
            // EvilCFGBuilder.g:57:6: (var= decl[structs] )+
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
            	    // EvilCFGBuilder.g:58:9: var= decl[structs]
            	    {
            	    pushFollow(FOLLOW_decl_in_struct_nested_decl208);
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
    // EvilCFGBuilder.g:65:1: decl[StructTable structs] returns [Variable var = null] : ^( DECL ^( TYPE ty= type[structs] ) id= ID ) ;
    public final Variable decl(StructTable structs) throws RecognitionException {
        Variable var =  null;

        CommonTree id=null;
        Variable ty = null;


        try {
            // EvilCFGBuilder.g:66:4: ( ^( DECL ^( TYPE ty= type[structs] ) id= ID ) )
            // EvilCFGBuilder.g:66:6: ^( DECL ^( TYPE ty= type[structs] ) id= ID )
            {
            match(input,DECL,FOLLOW_DECL_in_decl248); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_decl251); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_decl255);
            ty=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_decl261); 

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
    // EvilCFGBuilder.g:73:1: type[StructTable structs] returns [Variable var = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
    public final Variable type(StructTable structs) throws RecognitionException {
        Variable var =  null;

        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:74:4: ( INT | BOOL | ^( STRUCT id= ID ) )
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
                    // EvilCFGBuilder.g:74:6: INT
                    {
                    match(input,INT,FOLLOW_INT_in_type290); 
                    var = new Primitive();

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:75:6: BOOL
                    {
                    match(input,BOOL,FOLLOW_BOOL_in_type299); 
                    var= new Primitive();

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:76:6: ^( STRUCT id= ID )
                    {
                    match(input,STRUCT,FOLLOW_STRUCT_in_type309); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_type313); 

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
    // EvilCFGBuilder.g:79:1: declarations[SymbolTable sym, StructTable structs] : ( ^( DECLS ( declaration[sym, structs] )* ) | );
    public final void declarations(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:80:4: ( ^( DECLS ( declaration[sym, structs] )* ) | )
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
                    // EvilCFGBuilder.g:80:6: ^( DECLS ( declaration[sym, structs] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_declarations333); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilCFGBuilder.g:80:14: ( declaration[sym, structs] )*
                        loop5:
                        do {
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==DECLLIST) ) {
                                alt5=1;
                            }


                            switch (alt5) {
                        	case 1 :
                        	    // EvilCFGBuilder.g:80:14: declaration[sym, structs]
                        	    {
                        	    pushFollow(FOLLOW_declaration_in_declarations335);
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
                    // EvilCFGBuilder.g:82:4: 
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
    // EvilCFGBuilder.g:84:1: declaration[SymbolTable sym, StructTable structs] : ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] ) ;
    public final void declaration(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:85:4: ( ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] ) )
            // EvilCFGBuilder.g:85:6: ^( DECLLIST ^( TYPE var= type[structs] ) id_list[var, sym] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_declaration361); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_declaration364); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_declaration368);
            var=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_id_list_in_declaration372);
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
    // EvilCFGBuilder.g:88:1: global_declarations[SymbolTable sym, StructTable structs] : ( ^( DECLS ( global_declaration[sym, structs] )* ) | );
    public final void global_declarations(SymbolTable sym, StructTable structs) throws RecognitionException {
        try {
            // EvilCFGBuilder.g:89:4: ( ^( DECLS ( global_declaration[sym, structs] )* ) | )
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
                    // EvilCFGBuilder.g:89:6: ^( DECLS ( global_declaration[sym, structs] )* )
                    {
                    match(input,DECLS,FOLLOW_DECLS_in_global_declarations392); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilCFGBuilder.g:89:14: ( global_declaration[sym, structs] )*
                        loop7:
                        do {
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==DECLLIST) ) {
                                alt7=1;
                            }


                            switch (alt7) {
                        	case 1 :
                        	    // EvilCFGBuilder.g:89:14: global_declaration[sym, structs]
                        	    {
                        	    pushFollow(FOLLOW_global_declaration_in_global_declarations394);
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
                    // EvilCFGBuilder.g:91:4: 
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
    // EvilCFGBuilder.g:93:1: global_declaration[SymbolTable sym, StructTable structs] : ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] ) ;
    public final void global_declaration(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:94:4: ( ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] ) )
            // EvilCFGBuilder.g:94:6: ^( DECLLIST ^( TYPE var= type[structs] ) global_id_list[var, sym] )
            {
            match(input,DECLLIST,FOLLOW_DECLLIST_in_global_declaration420); 

            match(input, Token.DOWN, null); 
            match(input,TYPE,FOLLOW_TYPE_in_global_declaration423); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_type_in_global_declaration427);
            var=type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_global_id_list_in_global_declaration431);
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
    // EvilCFGBuilder.g:97:1: id_list[Variable var, SymbolTable sym] : (id= ID )+ ;
    public final void id_list(Variable var, SymbolTable sym) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:98:3: ( (id= ID )+ )
            // EvilCFGBuilder.g:98:5: (id= ID )+
            {
            // EvilCFGBuilder.g:98:5: (id= ID )+
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
            	    // EvilCFGBuilder.g:98:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list452); 

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
    // EvilCFGBuilder.g:108:1: global_id_list[Variable var, SymbolTable sym] : (id= ID )+ ;
    public final void global_id_list(Variable var, SymbolTable sym) throws RecognitionException {
        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:109:3: ( (id= ID )+ )
            // EvilCFGBuilder.g:109:5: (id= ID )+
            {
            // EvilCFGBuilder.g:109:5: (id= ID )+
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
            	    // EvilCFGBuilder.g:109:6: id= ID
            	    {
            	    id=(CommonTree)match(input,ID,FOLLOW_ID_in_global_id_list484); 

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
    // EvilCFGBuilder.g:119:1: functions[SymbolTable sym, StructTable structs] : ( ^( FUNCS (fun= function[sym, structs] )* ) | );
    public final void functions(SymbolTable sym, StructTable structs) throws RecognitionException {
        Function fun = null;


        try {
            // EvilCFGBuilder.g:120:4: ( ^( FUNCS (fun= function[sym, structs] )* ) | )
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
                    // EvilCFGBuilder.g:120:6: ^( FUNCS (fun= function[sym, structs] )* )
                    {
                    match(input,FUNCS,FOLLOW_FUNCS_in_functions515); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // EvilCFGBuilder.g:121:7: (fun= function[sym, structs] )*
                        loop11:
                        do {
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==FUN) ) {
                                alt11=1;
                            }


                            switch (alt11) {
                        	case 1 :
                        	    // EvilCFGBuilder.g:122:10: fun= function[sym, structs]
                        	    {

                        	             
                        	    pushFollow(FOLLOW_function_in_functions548);
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
                    // EvilCFGBuilder.g:131:4: 
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
    // EvilCFGBuilder.g:133:1: function[SymbolTable sym, StructTable structs] returns [Function fun = null] : ^( FUN id= ID parameters[sym, structs] ^( RETTYPE return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] ) ;
    public final Function function(SymbolTable sym, StructTable structs) throws RecognitionException {
        Function fun =  null;

        CommonTree id=null;

        try {
            // EvilCFGBuilder.g:134:4: ( ^( FUN id= ID parameters[sym, structs] ^( RETTYPE return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] ) )
            // EvilCFGBuilder.g:134:6: ^( FUN id= ID parameters[sym, structs] ^( RETTYPE return_type[structs] ) declarations[sym, structs] statement_list[sym, structs, body] )
            {
            match(input,FUN,FOLLOW_FUN_in_function604); 


                  

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_function623); 

                     sym.newState();
                     
                     BasicBlock funEntry = new BasicBlock();
                     BasicBlock body = new BasicBlock();

                     //Add temperary function to state to top state to support recursion.
                     sym.add((id!=null?id.getText():null), new Function((id!=null?id.getText():null), funEntry, null));

                     funEntry.addInstruction(new FakeInstruction("ENTRY Block to: " + (id!=null?id.getText():null)));
                     funEntry.addInstruction(new Inst_jmp(body.getTag()));
                  
            pushFollow(FOLLOW_parameters_in_function639);
            parameters(sym, structs);

            state._fsp--;

            match(input,RETTYPE,FOLLOW_RETTYPE_in_function650); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_return_type_in_function652);
            return_type(structs);

            state._fsp--;


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_declarations_in_function663);
            declarations(sym, structs);

            state._fsp--;

            pushFollow(FOLLOW_statement_list_in_function673);
            statement_list(sym, structs, body);

            state._fsp--;


                     //Remove the temp (recursion) function.
                     sym.remove((id!=null?id.getText():null));

                     Hashtable<String, Variable> scope = sym.removeState();
                     BasicBlock end = new BasicBlock();
                     
                     //Return from function.
                     end.addInstruction(new FakeInstruction("EXIT Block from: " + (id!=null?id.getText():null)));
                     end.addInstruction(new Inst_ret());
                     
                     funEntry.addKid(body);
                     funEntry.addCommonEnd(end);

                     fun = new Function((id!=null?id.getText():null), funEntry, scope);
                  

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
    // EvilCFGBuilder.g:173:1: parameters[SymbolTable sym, StructTable structs] : ^( PARAMS (var= decl[structs] )* ) ;
    public final void parameters(SymbolTable sym, StructTable structs) throws RecognitionException {
        Variable var = null;


        try {
            // EvilCFGBuilder.g:174:4: ( ^( PARAMS (var= decl[structs] )* ) )
            // EvilCFGBuilder.g:174:6: ^( PARAMS (var= decl[structs] )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_parameters707); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilCFGBuilder.g:175:7: (var= decl[structs] )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DECL) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // EvilCFGBuilder.g:176:10: var= decl[structs]
                	    {
                	    pushFollow(FOLLOW_decl_in_parameters729);
                	    var=decl(structs);

                	    state._fsp--;


                	                var.setScope(ScopeType.kFormal);
                	                sym.add(var.getName(), var);
                	             

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
    // EvilCFGBuilder.g:184:1: return_type[StructTable structs] returns [Variable var = null] : (v= type[structs] | VOID );
    public final Variable return_type(StructTable structs) throws RecognitionException {
        Variable var =  null;

        Variable v = null;


        try {
            // EvilCFGBuilder.g:185:4: (v= type[structs] | VOID )
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
                    // EvilCFGBuilder.g:185:6: v= type[structs]
                    {
                    pushFollow(FOLLOW_type_in_return_type773);
                    v=type(structs);

                    state._fsp--;

                    var = v;

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:186:6: VOID
                    {
                    match(input,VOID,FOLLOW_VOID_in_return_type783); 

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
    // EvilCFGBuilder.g:189:1: statement_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* ) ;
    public final BasicBlock statement_list(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:190:4: ( ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* ) )
            // EvilCFGBuilder.g:190:6: ^( STMTS (tempBlock= statement[sym, structs, tempBlock] )* )
            {
            match(input,STMTS,FOLLOW_STMTS_in_statement_list804); 


                        tempBlock = bBlock;
                     

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // EvilCFGBuilder.g:194:10: (tempBlock= statement[sym, structs, tempBlock] )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==PRINT||(LA15_0>=READ && LA15_0<=IF)||(LA15_0>=WHILE && LA15_0<=RETURN)||LA15_0==BLOCK||LA15_0==INVOKE||LA15_0==ASSIGN) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // EvilCFGBuilder.g:195:10: tempBlock= statement[sym, structs, tempBlock]
                	    {
                	    pushFollow(FOLLOW_statement_in_statement_list840);
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
    // EvilCFGBuilder.g:203:1: statement[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : (tempBlock= block[sym, structs, bBlock] | tempBlock= assignment[sym, structs, bBlock] | tempBlock= print[sym, structs, bBlock] | read[sym, structs, bBlock] | tempBlock= conditional[sym, structs, bBlock] | tempBlock= loop[sym, structs, bBlock] | tempBlock= delete[sym, structs, bBlock] | tempBlock= ret[sym, structs, bBlock] | tempBlock= invocation[sym, structs, bBlock] );
    public final BasicBlock statement(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:204:4: (tempBlock= block[sym, structs, bBlock] | tempBlock= assignment[sym, structs, bBlock] | tempBlock= print[sym, structs, bBlock] | read[sym, structs, bBlock] | tempBlock= conditional[sym, structs, bBlock] | tempBlock= loop[sym, structs, bBlock] | tempBlock= delete[sym, structs, bBlock] | tempBlock= ret[sym, structs, bBlock] | tempBlock= invocation[sym, structs, bBlock] )
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
                    // EvilCFGBuilder.g:204:6: tempBlock= block[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_block_in_statement891);
                    tempBlock=block(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:205:6: tempBlock= assignment[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_assignment_in_statement903);
                    tempBlock=assignment(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:206:6: tempBlock= print[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_print_in_statement916);
                    tempBlock=print(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 4 :
                    // EvilCFGBuilder.g:207:6: read[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_read_in_statement927);
                    read(sym, structs, bBlock);

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // EvilCFGBuilder.g:208:6: tempBlock= conditional[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_conditional_in_statement937);
                    tempBlock=conditional(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 6 :
                    // EvilCFGBuilder.g:209:6: tempBlock= loop[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_loop_in_statement949);
                    tempBlock=loop(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 7 :
                    // EvilCFGBuilder.g:210:6: tempBlock= delete[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_delete_in_statement961);
                    tempBlock=delete(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 8 :
                    // EvilCFGBuilder.g:211:6: tempBlock= ret[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_ret_in_statement974);
                    tempBlock=ret(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

                    }
                    break;
                case 9 :
                    // EvilCFGBuilder.g:212:6: tempBlock= invocation[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_invocation_in_statement987);
                    tempBlock=invocation(sym, structs, bBlock);

                    state._fsp--;

                    rtn = tempBlock.getbBlock();

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
    // EvilCFGBuilder.g:215:1: block[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn] : ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] ) ;
    public final BasicBlock block(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn = null;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:216:4: ( ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:216:6: ^( BLOCK tempBlock= statement_list[sym, structs, bBlock] )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block1011); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_list_in_block1015);
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
    // EvilCFGBuilder.g:222:1: assignment[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( ASSIGN tempBlock= expression[sym, structs, bBlock] reg= lvalue[sym, structs, b] ) ;
    public final BasicBlock assignment(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;

        Register reg = null;


        try {
            // EvilCFGBuilder.g:223:4: ( ^( ASSIGN tempBlock= expression[sym, structs, bBlock] reg= lvalue[sym, structs, b] ) )
            // EvilCFGBuilder.g:223:6: ^( ASSIGN tempBlock= expression[sym, structs, bBlock] reg= lvalue[sym, structs, b] )
            {
            match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment1046); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_assignment1050);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


                     BasicBlock b = tempBlock.getbBlock();
                  
            pushFollow(FOLLOW_lvalue_in_assignment1070);
            reg=lvalue(sym, structs, b);

            state._fsp--;


            match(input, Token.UP, null); 

                     tempBlock.getbBlock().addInstruction(new Inst_mov(tempBlock.getReg(), reg)); 
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
    // EvilCFGBuilder.g:234:1: print[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( PRINT tempBlock= expression[sym, structs, bBlock] ( ENDL )? ) ;
    public final BasicBlock print(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:235:4: ( ^( PRINT tempBlock= expression[sym, structs, bBlock] ( ENDL )? ) )
            // EvilCFGBuilder.g:235:6: ^( PRINT tempBlock= expression[sym, structs, bBlock] ( ENDL )? )
            {
            match(input,PRINT,FOLLOW_PRINT_in_print1101); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_print1105);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;

            // EvilCFGBuilder.g:235:57: ( ENDL )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ENDL) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // EvilCFGBuilder.g:235:58: ENDL
                    {
                    match(input,ENDL,FOLLOW_ENDL_in_print1109); 

                    }
                    break;

            }


            match(input, Token.UP, null); 

                     tempBlock.getbBlock().addInstruction(new Inst_print(tempBlock.getReg()));
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
    // EvilCFGBuilder.g:242:1: read[SymbolTable sym, StructTable structs, BasicBlock bBlock] : ^( READ reg= lvalue[sym, structs, bBlock] ) ;
    public final void read(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg = null;


        try {
            // EvilCFGBuilder.g:243:4: ( ^( READ reg= lvalue[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:243:6: ^( READ reg= lvalue[sym, structs, bBlock] )
            {
            match(input,READ,FOLLOW_READ_in_read1137); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_lvalue_in_read1141);
            reg=lvalue(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     bBlock.addInstruction(new Inst_read(reg));
                  

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
    // EvilCFGBuilder.g:249:1: conditional[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? ) ;
    public final BasicBlock conditional(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:250:4: ( ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? ) )
            // EvilCFGBuilder.g:250:6: ^( IF tempBlock= expression[sym, structs, bBlock] block[sym, structs, thenBlock] ( block[sym, structs, elseBlock] )? )
            {
            match(input,IF,FOLLOW_IF_in_conditional1172); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_conditional1186);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


                        //tempBlock.addInstruction(new FakeInstruction("CONDITIONAL GUARD"));

                        BasicBlock thenBlock = new BasicBlock();
                        tempBlock.getbBlock().addKid(thenBlock);
                        thenBlock.getbBlock().addParent(tempBlock.getbBlock());
                        
                        //thenBlock.addInstruction(new FakeInstruction("THEN BEGIN"));
                     
            pushFollow(FOLLOW_block_in_conditional1210);
            block(sym, structs, thenBlock);

            state._fsp--;


                        BasicBlock elseBlock = null;
                     
            // EvilCFGBuilder.g:265:10: ( block[sym, structs, elseBlock] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==BLOCK) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EvilCFGBuilder.g:266:13: block[sym, structs, elseBlock]
                    {

                                   elseBlock = new BasicBlock();
                                   tempBlock.addKid(elseBlock);
                                   elseBlock.addParent(tempBlock.getbBlock());
                                
                                  //elseBlock.addInstruction(new FakeInstruction("ELSE BEGIN"));
                                
                    pushFollow(FOLLOW_block_in_conditional1262);
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
    // EvilCFGBuilder.g:298:1: loop[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] ) ;
    public final BasicBlock loop(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden topGuardBlock = null;

        BasicBlock bodyEndBlock = null;

        Warden bottomGuardEndBlock = null;


        try {
            // EvilCFGBuilder.g:299:4: ( ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] ) )
            // EvilCFGBuilder.g:299:6: ^( WHILE topGuardBlock= expression[sym, structs, bBlock] bodyEndBlock= block[sym, structs, bodyBlock] bottomGuardEndBlock= expression[sym, structs, bottomGuardBlock] )
            {
            match(input,WHILE,FOLLOW_WHILE_in_loop1312); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_loop1323);
            topGuardBlock=expression(sym, structs, bBlock);

            state._fsp--;


                     BasicBlock bodyBlock = new BasicBlock();
                     //bodyBlock.addInstruction(new FakeInstruction("WHILE BODY"));

                     topGuardBlock.getbBlock().addKid(bodyBlock);
                     bodyBlock.addParent(topGuardBlock.getbBlock());
                  
            pushFollow(FOLLOW_block_in_loop1363);
            bodyEndBlock=block(sym, structs, bodyBlock);

            state._fsp--;


                     BasicBlock bottomGuardBlock = new BasicBlock();
                     
                     bodyEndBlock.addInstruction(new Inst_jmp(bottomGuardBlock.getTag()));

                     bodyEndBlock.addKid(bottomGuardBlock);
                     bottomGuardBlock.addParent(bodyBlock);
                  
            pushFollow(FOLLOW_expression_in_loop1397);
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
    // EvilCFGBuilder.g:349:1: delete[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( DELETE tempBlock= expression[sym, structs, bBlock] ) ;
    public final BasicBlock delete(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:350:4: ( ^( DELETE tempBlock= expression[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:350:6: ^( DELETE tempBlock= expression[sym, structs, bBlock] )
            {
            match(input,DELETE,FOLLOW_DELETE_in_delete1443); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_delete1447);
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
    // EvilCFGBuilder.g:358:1: ret[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : ^( RETURN tempBlock= expression[sym, structs, bBlock] ) ;
    public final BasicBlock ret(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:359:4: ( ^( RETURN tempBlock= expression[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:359:6: ^( RETURN tempBlock= expression[sym, structs, bBlock] )
            {
            match(input,RETURN,FOLLOW_RETURN_in_ret1478); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_ret1482);
            tempBlock=expression(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     tempBlock.getbBlock().addInstruction(new Inst_ret());
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
    // $ANTLR end "ret"


    // $ANTLR start "invocation"
    // EvilCFGBuilder.g:366:1: invocation[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock ret = null] : ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] ) ;
    public final BasicBlock invocation(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock ret =  null;

        CommonTree id=null;
        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:367:4: ( ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] ) )
            // EvilCFGBuilder.g:367:6: ^( INVOKE id= ID tempBlock= arguments[sym, structs, bBlock] )
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocation1513); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation1517); 
            pushFollow(FOLLOW_arguments_in_invocation1521);
            tempBlock=arguments(sym, structs, bBlock);

            state._fsp--;


            match(input, Token.UP, null); 

                     tempBlock.addInstruction(new Inst_call(((Function)(sym.get((id!=null?id.getText():null)))).getBody().getTag() + " ("+((Function)(sym.get((id!=null?id.getText():null)))).getName()+")"));

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


    // $ANTLR start "lvalue"
    // EvilCFGBuilder.g:385:1: lvalue[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Register reg = null] : ( ID ( DOT ID )+ | ID );
    public final Register lvalue(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Register reg =  null;

        try {
            // EvilCFGBuilder.g:386:4: ( ID ( DOT ID )+ | ID )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==UP) ) {
                    alt20=2;
                }
                else if ( (LA20_1==DOT) ) {
                    alt20=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // EvilCFGBuilder.g:386:6: ID ( DOT ID )+
                    {
                    match(input,ID,FOLLOW_ID_in_lvalue1551); 
                    // EvilCFGBuilder.g:386:9: ( DOT ID )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==DOT) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // EvilCFGBuilder.g:386:10: DOT ID
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_lvalue1554); 
                    	    match(input,ID,FOLLOW_ID_in_lvalue1556); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                             reg = new Register();
                             bBlock.addInstruction(new FakeInstruction(reg.toString() + " has the result from lvalue w/ dots"));
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:391:6: ID
                    {
                    match(input,ID,FOLLOW_ID_in_lvalue1573); 

                             reg = new Register();
                             bBlock.addInstruction(new FakeInstruction(reg.toString() + " has the result from lvalue w/out dots"));
                          

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
    // $ANTLR end "lvalue"


    // $ANTLR start "expression"
    // EvilCFGBuilder.g:401:1: expression[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [Warden rtn = null] : ( ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NOT exp1= expression[sym, structs, bBlock] ) | ^( NEG exp1= expression[sym, structs, bBlock] ) | ^( DOT expression[sym, structs, bBlock] ID ) | ^( NEW id= ID ) | tempBlock= invocation[sym, structs, bBlock] | id= ID | id= INTEGER | TRUE | FALSE | NULL );
    public final Warden expression(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        Warden rtn =  null;

        CommonTree id=null;
        Warden exp1 = null;

        Warden exp2 = null;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:402:4: ( ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] ) | ^( NOT exp1= expression[sym, structs, bBlock] ) | ^( NEG exp1= expression[sym, structs, bBlock] ) | ^( DOT expression[sym, structs, bBlock] ID ) | ^( NEW id= ID ) | tempBlock= invocation[sym, structs, bBlock] | id= ID | id= INTEGER | TRUE | FALSE | NULL )
            int alt21=22;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt21=1;
                }
                break;
            case OR:
                {
                alt21=2;
                }
                break;
            case EQ:
                {
                alt21=3;
                }
                break;
            case LT:
                {
                alt21=4;
                }
                break;
            case GT:
                {
                alt21=5;
                }
                break;
            case NE:
                {
                alt21=6;
                }
                break;
            case LE:
                {
                alt21=7;
                }
                break;
            case GE:
                {
                alt21=8;
                }
                break;
            case PLUS:
                {
                alt21=9;
                }
                break;
            case MINUS:
                {
                alt21=10;
                }
                break;
            case TIMES:
                {
                alt21=11;
                }
                break;
            case DIVIDE:
                {
                alt21=12;
                }
                break;
            case NOT:
                {
                alt21=13;
                }
                break;
            case NEG:
                {
                alt21=14;
                }
                break;
            case DOT:
                {
                alt21=15;
                }
                break;
            case NEW:
                {
                alt21=16;
                }
                break;
            case INVOKE:
                {
                alt21=17;
                }
                break;
            case ID:
                {
                alt21=18;
                }
                break;
            case INTEGER:
                {
                alt21=19;
                }
                break;
            case TRUE:
                {
                alt21=20;
                }
                break;
            case FALSE:
                {
                alt21=21;
                }
                break;
            case NULL:
                {
                alt21=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // EvilCFGBuilder.g:402:6: ^( AND exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,AND,FOLLOW_AND_in_expression1605); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1609);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1614);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_and(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:408:6: ^( OR exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,OR,FOLLOW_OR_in_expression1632); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1636);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1641);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_or(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 3 :
                    // EvilCFGBuilder.g:414:6: ^( EQ exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expression1659); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1663);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1668);
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
                    // EvilCFGBuilder.g:422:6: ^( LT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,LT,FOLLOW_LT_in_expression1686); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1690);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1695);
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
                    // EvilCFGBuilder.g:430:6: ^( GT exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,GT,FOLLOW_GT_in_expression1713); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1717);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1722);
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
                    // EvilCFGBuilder.g:438:6: ^( NE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,NE,FOLLOW_NE_in_expression1740); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1744);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1749);
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
                    // EvilCFGBuilder.g:446:6: ^( LE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,LE,FOLLOW_LE_in_expression1767); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1771);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1776);
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
                    // EvilCFGBuilder.g:454:6: ^( GE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,GE,FOLLOW_GE_in_expression1794); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1798);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1803);
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
                    // EvilCFGBuilder.g:462:6: ^( PLUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expression1821); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1825);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1830);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_add(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 10 :
                    // EvilCFGBuilder.g:468:6: ^( MINUS exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expression1848); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1852);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1857);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_sub(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 11 :
                    // EvilCFGBuilder.g:474:6: ^( TIMES exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expression1875); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1879);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1884);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_mult(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 12 :
                    // EvilCFGBuilder.g:480:6: ^( DIVIDE exp1= expression[sym, structs, bBlock] exp2= expression[sym, structs, bBlock] )
                    {
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_expression1902); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1906);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1911);
                    exp2=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_div(exp1.getReg(), exp2.getReg(), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 13 :
                    // EvilCFGBuilder.g:486:6: ^( NOT exp1= expression[sym, structs, bBlock] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expression1929); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1933);
                    exp1=expression(sym, structs, bBlock);

                    state._fsp--;


                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_xori(exp1.getReg(), -1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 14 :
                    // EvilCFGBuilder.g:492:6: ^( NEG exp1= expression[sym, structs, bBlock] )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expression1951); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1955);
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
                    // EvilCFGBuilder.g:499:6: ^( DOT expression[sym, structs, bBlock] ID )
                    {
                    match(input,DOT,FOLLOW_DOT_in_expression1973); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1975);
                    expression(sym, structs, bBlock);

                    state._fsp--;

                    match(input,ID,FOLLOW_ID_in_expression1978); 

                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             //bBlock.addInstruction(new FakeInstruction("DOTED RVALUE")); //TODO: change to add a dRightVal instruction
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 16 :
                    // EvilCFGBuilder.g:506:6: ^( NEW id= ID )
                    {
                    match(input,NEW,FOLLOW_NEW_in_expression1999); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2003); 

                    match(input, Token.UP, null); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_new((id!=null?id.getText():null), new Register()));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 17 :
                    // EvilCFGBuilder.g:512:6: tempBlock= invocation[sym, structs, bBlock]
                    {
                    pushFollow(FOLLOW_invocation_in_expression2021);
                    tempBlock=invocation(sym, structs, bBlock);

                    state._fsp--;


                             rtn = new Warden(new Register(), tempBlock);
                          

                    }
                    break;
                case 18 :
                    // EvilCFGBuilder.g:516:6: id= ID
                    {
                    id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2040); 

                             Register temp = new Register();
                             if(sym.isGlobal((id!=null?id.getText():null)))
                             {  
                                //TODO: load from memory
                             }
                             else
                             {
                                //TODO: move from register
                             }
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 19 :
                    // EvilCFGBuilder.g:529:6: id= INTEGER
                    {
                    id=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression2058); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(Integer.valueOf((id!=null?id.getText():null)), temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 20 :
                    // EvilCFGBuilder.g:535:6: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_expression2074); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(1, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 21 :
                    // EvilCFGBuilder.g:541:6: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_expression2090); 

                             Register temp = new Register();
                             bBlock.addInstruction(new Inst_loadi(0, temp));
                             rtn = new Warden(temp, bBlock);
                          

                    }
                    break;
                case 22 :
                    // EvilCFGBuilder.g:547:6: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_expression2106); 
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
    // EvilCFGBuilder.g:550:1: arguments[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = null] : tempBlock= arg_list[sym, structs, bBlock] ;
    public final BasicBlock arguments(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  null;

        BasicBlock tempBlock = null;


        try {
            // EvilCFGBuilder.g:551:4: (tempBlock= arg_list[sym, structs, bBlock] )
            // EvilCFGBuilder.g:551:6: tempBlock= arg_list[sym, structs, bBlock]
            {
            pushFollow(FOLLOW_arg_list_in_arguments2130);
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
    // EvilCFGBuilder.g:554:1: arg_list[SymbolTable sym, StructTable structs, BasicBlock bBlock] returns [BasicBlock rtn = bBlock] : ( ^( ARGS (tempBlock= expression[sym, structs, bBlock] )+ ) | ARGS );
    public final BasicBlock arg_list(SymbolTable sym, StructTable structs, BasicBlock bBlock) throws RecognitionException {
        BasicBlock rtn =  bBlock;

        Warden tempBlock = null;


        try {
            // EvilCFGBuilder.g:555:4: ( ^( ARGS (tempBlock= expression[sym, structs, bBlock] )+ ) | ARGS )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ARGS) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==DOWN) ) {
                    alt23=1;
                }
                else if ( (LA23_1==UP) ) {
                    alt23=2;
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
                    // EvilCFGBuilder.g:555:6: ^( ARGS (tempBlock= expression[sym, structs, bBlock] )+ )
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list2154); 

                    match(input, Token.DOWN, null); 
                    // EvilCFGBuilder.g:555:13: (tempBlock= expression[sym, structs, bBlock] )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>=TRUE && LA22_0<=NULL)||LA22_0==INVOKE||LA22_0==NEG||(LA22_0>=DOT && LA22_0<=INTEGER)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // EvilCFGBuilder.g:555:14: tempBlock= expression[sym, structs, bBlock]
                    	    {
                    	    pushFollow(FOLLOW_expression_in_arg_list2159);
                    	    tempBlock=expression(sym, structs, bBlock);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    match(input, Token.UP, null); 

                             tempBlock.addInstruction(new Inst_loadinarg(tempBlock.getReg())); 
                             rtn = tempBlock.getbBlock();
                          

                    }
                    break;
                case 2 :
                    // EvilCFGBuilder.g:560:6: ARGS
                    {
                    match(input,ARGS,FOLLOW_ARGS_in_arg_list2178); 

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


 

    public static final BitSet FOLLOW_PROGRAM_in_program56 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_in_program58 = new BitSet(new long[]{0x0000000003000008L});
    public static final BitSet FOLLOW_global_declarations_in_program61 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_functions_in_program64 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types89 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_types_sub_in_types91 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPES_in_types100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_declaration_in_types_sub116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_types_sub_in_types_sub119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type_declaration142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type_declaration146 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_struct_nested_decl_in_type_declaration163 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_decl_in_struct_nested_decl208 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_DECL_in_decl248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_decl251 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_decl255 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_decl261 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_type290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_type299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_type309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_type313 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_declarations333 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_declarations335 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_declaration361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_declaration364 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_declaration368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_list_in_declaration372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLS_in_global_declarations392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_global_declaration_in_global_declarations394 = new BitSet(new long[]{0x0000000008000008L});
    public static final BitSet FOLLOW_DECLLIST_in_global_declaration420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_global_declaration423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_global_declaration427 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_global_id_list_in_global_declaration431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_id_list452 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ID_in_global_id_list484 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_FUNCS_in_functions515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_function_in_functions548 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_FUN_in_function604 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function623 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parameters_in_function639 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RETTYPE_in_function650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_return_type_in_function652 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_declarations_in_function663 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_statement_list_in_function673 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_parameters707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_decl_in_parameters729 = new BitSet(new long[]{0x0000000004000008L});
    public static final BitSet FOLLOW_type_in_return_type773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_return_type783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTS_in_statement_list804 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement_list840 = new BitSet(new long[]{0x000002014001DA08L});
    public static final BitSet FOLLOW_block_in_statement891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_statement916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_statement937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_statement949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_in_statement961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_in_statement974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocation_in_statement987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block1011 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_list_in_block1015 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_assignment1046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_assignment1050 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_lvalue_in_assignment1070 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRINT_in_print1101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_print1105 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ENDL_in_print1109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read1137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lvalue_in_read1141 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_conditional1172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditional1186 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_conditional1210 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_block_in_conditional1262 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_loop1312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_loop1323 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_block_in_loop1363 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_loop1397 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_in_delete1443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_delete1447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_ret1478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ret1482 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOKE_in_invocation1513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocation1517 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_arguments_in_invocation1521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_lvalue1551 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_DOT_in_lvalue1554 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_lvalue1556 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ID_in_lvalue1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_expression1605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1609 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1614 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expression1632 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1636 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expression1659 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1663 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1668 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expression1686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1690 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expression1713 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1717 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NE_in_expression1740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1744 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1749 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expression1767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1771 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1776 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expression1794 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1798 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1803 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expression1821 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1825 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1830 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expression1848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1852 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expression1875 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1879 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_expression1902 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1906 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_expression_in_expression1911 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression1929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1933 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expression1951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1955 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_expression1973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1975 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ID_in_expression1978 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEW_in_expression1999 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expression2003 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_invocation_in_expression2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expression2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_expression2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_expression2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_expression2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_list_in_arguments2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGS_in_arg_list2154 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_arg_list2159 = new BitSet(new long[]{0x03FFFE05401FDA08L});
    public static final BitSet FOLLOW_ARGS_in_arg_list2178 = new BitSet(new long[]{0x0000000000000002L});

}