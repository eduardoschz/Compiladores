package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%% 
{WHITE} {/*Ignore*/}
"int" {return INT;}
"String" {return STRING;}
"double" {return BOUBLE;}
"boolean" {return BOOLEAN;}
"," {return COMA;}
";" {return PUNTOCOMA;}
{L}({L}|{D})* {lexema=yytext(); return ID;}
. {return ERROR;}