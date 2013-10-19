tree grammar EvilTreeParser;

options
{
   ASTLabelType = CommonTree;
   tokenVocab = Evil;
}

/*
error [String err]
   : {System.err.println($err); System.exit(1);}
   ;
*/

program
   : ^(PROGRAM types declarations functions) 
   ;

types
   : ^(TYPES types_sub)
   | TYPES
   ;

types_sub
   : type_declaration types_sub
   |
   ;

type_declaration
   : ^(STRUCT ID nested_decl)
   ;

nested_decl
   : (decl)+
   ;

decl
   : ^(DECL ^(TYPE type) ID)
   ;

type
   : INT
   | BOOL
   | ^(STRUCT ID)
   ;

declarations
   : ^(DECLS declaration*)
   | 
   ;

declaration
   : ^(DECLLIST ^(TYPE type) id_list) 
   ;

id_list
  : ID+
  ;

functions
   : ^(FUNCS function*)
   | 
   ;

function
   : ^(FUN ID parameters ^(RETTYPE return_type) declarations statement_list)
   ;

parameters
   : ^(PARAMS decl*)
   ;

return_type
   : type
   | VOID
   ;

statement
   : block
   | assignment
   | print
   | read
   | conditional
   | loop
   | delete
   | ret
   | invocation
   ;

block
   : ^(BLOCK statement_list)
   ;

statement_list
   : ^(STMTS statement*)
   ;

assignment
   : ^(ASSIGN expression lvalue)
   ;

print
   : ^(PRINT expression (ENDL)?)
   ;

read
   : ^(READ lvalue)
   ;

conditional
   : ^(IF expression block (block)?)
   ;

loop
   : ^(WHILE expression block expression)
   ;

delete
   : ^(DELETE expression)
   ;

ret
   : ^(RETURN expression)
   ;

invocation
   : ^(INVOKE ID arguments)
   ;

lvalue
   : ID (DOT ID)*
   ;

expression
   //: ((AND | OR) expression)
   : ^((AND | OR) expression expression)
   | ^((EQ | LT | GT | NE | LE | GE) expression expression)
   | ^((PLUS | MINUS) expression expression)
   | ^((TIMES | DIVIDE) expression expression)
   | ^(NOT expression)
   | ^(NEG expression)
   | ^(DOT expression ID)
   | ^(INVOKE ID arguments)
   | ID
   | INTEGER
   | TRUE
   | FALSE
   | ^(NEW ID)
   | NULL
   ;

selector
   : ^(DOT expression ID)
   ;

/*
expression
   : boolterm ((AND | OR) boolterm)*
   ;

boolterm
   : simple ((EQ | LT | GT | NE | LE | GE) simple)?
   ;

simple
   : term (((PLUS | MINUS)) term)*
   ;

term
   : unary ((TIMES | DIVIDE) unary)*
   ;

unary
   : odd_not
   | odd_neg
   | selector
   ;

odd_not
   : even_not
   | ^(NOT selector)
   ;

even_not
   : odd_not
   | selector
   ;

odd_neg
   : even_neg
   | ^(NEG selector)
   ;

even_neg
   : odd_neg
   | selector
   ;

selector
   : factor (^(DOT ID))*
   ;


factor
   //: expression
   : ^(INVOKE ID arguments)
   | ID
   | INTEGER
   | TRUE
   | FALSE
   | ^(NEW ID)
   | NULL
   ;
*/

arguments
   : arg_list
   ;

arg_list
   : ^(ARGS expression+)
   | ARGS
   ;
