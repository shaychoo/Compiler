package IC.Parser;
import java_cup.runtime.*;

%%


%cup
%class Lexer
%public
%function next_token

%type Token
%line
%column
%scanerror LexicalError


%state YYINITIAL
%state COMMENT
%state COMMENTS
%state CLASS
%state STRING

%eofval{
	return new Token(sym.EOF,yyline ,  yycolumn,yytext());
%eofval}


ALPHA = [A-Za-z]

DIGIT = [1-9]
DIGIT0 = "0" | {DIGIT}
NUMBER =  {DIGIT0} | {DIGIT}({DIGIT0})*



ALPHA_NUMERIC = {ALPHA}|{DIGIT0}
IDENT = {ALPHA}({ALPHA_NUMERIC})*
NEW_LINE =\r\n|\n|\r
CLASS_ID = [A-Z]({ALPHA_NUMERIC})*
EMPTY_LINE = {NEW_LINE}+" "+{NEW_LINE}
ALPHA = [A-Za-z]

DIGIT = [1-9]
DIGIT0 = "0" | {DIGIT}
NUMBER =  {DIGIT0} | {DIGIT}({DIGIT0})*



ALPHA_NUMERIC = {ALPHA}|{DIGIT0}
IDENT = {ALPHA}({ALPHA_NUMERIC})*
NEW_LINE =\r\n|\n|\r
CLASS_ID = [A-Z]({ALPHA_NUMERIC})*
EMPTY_LINE = {NEW_LINE}+" "+{NEW_LINE}

%{
StringBuilder sb = new StringBuilder();

public int getLineNumber()
{
return yyline;
}

%}



%%


<YYINITIAL>  "//" { yybegin(COMMENT); }
<COMMENT> [^\n] { }
<COMMENT> [\n] { yybegin(YYINITIAL); }


<YYINITIAL> "/*" { yybegin(COMMENTS); }
<COMMENTS> . { }
<COMMENTS> "*/" { yybegin(YYINITIAL); }


<YYINITIAL> \" { yybegin(STRING);  sb = new StringBuilder(); }
<STRING> [^\"] { sb.append(yytext()); }
<STRING> \" {  yybegin(YYINITIAL); return new Token(sym.STRING ,yyline ,  yycolumn,sb.toString()); }

<YYINITIAL>{

        "("         { return new Token(sym.LP,yyline ,  yycolumn,yytext()); }
        ")"         { return new Token(sym.RP,yyline ,  yycolumn,yytext()); }
        "="         { return new Token(sym.ASSIGN,yyline ,  yycolumn,yytext()); }

        "boolean"   { return new Token(sym.BOOLEAN,yyline ,  yycolumn,yytext()); }
        "break"     { return new Token(sym.BREAK,yyline ,  yycolumn,yytext()); }
        ","         { return new Token(sym.COMMA,yyline ,  yycolumn,yytext()); }
        "continue"  { return new Token(sym.CONTINUE ,yyline ,  yycolumn,yytext()); }
        "/"         { return new Token(sym.DIVIDE ,yyline ,  yycolumn,yytext()); }
        "."         { return new Token(sym.DOT ,yyline ,  yycolumn,yytext()); }
        "=="        { return new Token(sym.EQUAL ,yyline ,  yycolumn,yytext()); }
        "extends"   { return new Token(sym.EXTENDS ,yyline ,  yycolumn,yytext()); }
        "false"     { return new Token(sym.FALSE ,yyline ,  yycolumn,yytext()); }
        "else"      { return new Token(sym.ELSE ,yyline ,  yycolumn,yytext()); }
        ">"         { return new Token(sym.GT ,yyline ,  yycolumn,yytext()); }
        ">="        { return new Token(sym.GTE ,yyline ,  yycolumn,yytext()); }
        "if"        { return new Token(sym.IF ,yyline ,  yycolumn,yytext()); }
        "int"       { return new Token(sym.INT ,yyline ,  yycolumn,yytext()); }

        "&&"        { return new Token(sym.LAND ,yyline ,  yycolumn,yytext()); }
        "["         { return new Token(sym.LB ,yyline ,  yycolumn,yytext()); }
        "{"         { return new Token(sym.LCBR ,yyline ,  yycolumn,yytext()); }
        "length"    { return new Token(sym.LENGTH ,yyline ,  yycolumn,yytext()); }
        "!"         { return new Token(sym.LENG ,yyline ,  yycolumn,yytext()); }
        "||"        { return new Token(sym.LOR ,yyline ,  yycolumn,yytext()); }
        "<"         { return new Token(sym.LT ,yyline ,  yycolumn,yytext()); }
        "<="        { return new Token(sym.LTE ,yyline ,  yycolumn,yytext()); }

        "-"         { return new Token(sym.MINUS ,yyline ,  yycolumn,yytext()); }
        "%"         { return new Token(sym.MOD ,yyline ,  yycolumn,yytext()); }
        "*"         { return new Token(sym.MULTIPLY ,yyline ,  yycolumn,yytext()); }
        "!="        { return new Token(sym.NEQUAL ,yyline ,  yycolumn,yytext()); }
        "null"      { return new Token(sym.NULL ,yyline ,  yycolumn,yytext()); }
        "+"         { return new Token(sym.PLUS ,yyline ,  yycolumn,yytext()); }
        "]"         { return new Token(sym.RB ,yyline ,  yycolumn,yytext()); }
        "}"         { return new Token(sym.RCBR ,yyline ,  yycolumn,yytext()); }
        "return"    { return new Token(sym.RETURN ,yyline ,  yycolumn,yytext()); }
        ";"         { return new Token(sym.SEMI ,yyline ,  yycolumn,yytext()); }
        "static"    { return new Token(sym.STATIC ,yyline ,  yycolumn,yytext()); }


        "class"     { return new Token(sym.CLASS ,yyline ,  yycolumn,yytext()); }
        "this"      { return new Token(sym.THIS ,yyline ,  yycolumn,yytext()); }
        "true"      { return new Token(sym.TRUE ,yyline ,  yycolumn,yytext()); }
        "void"      { return new Token(sym.VOID ,yyline ,  yycolumn,yytext()); }
        "while"     { return new Token(sym.WHILE ,yyline ,  yycolumn,yytext()); }


        {NUMBER}    { return new Token(sym.INTEGER ,yyline ,  yycolumn ,yytext()) ;}
        {CLASS_ID}  { return new Token(sym.CLASS_ID ,yyline ,  yycolumn ,yytext()) ;}
        {IDENT}     {return new Token(sym.INDET,yyline ,  yycolumn,yytext()); }
        " "         {  }
        {NEW_LINE}  {  }
        . {throw new LexicalError("Error! " + yyline + ": Lexical error: " +yytext() ); }

}






