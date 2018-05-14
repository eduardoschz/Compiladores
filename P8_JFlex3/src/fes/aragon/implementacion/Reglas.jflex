package fes.aragon.implementacion;
import static fes.aragon.implementacion.Tokens.*;
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
"=" {return IGUAL;}
"+" {return SUMA;}
"-" {return RESTA;}
";" {return PUNTOCOMA;}
{L}({L}|{D})* {lexema=yytext(); return ID;}
("(-"{D}+")")|{D}+ {lexema=yytext(); return NUM;}
. {return ERROR;}