package fes.aragon.implementacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Gramatica {
    
    private Lexico lexico;
    private Tokens token;
    private Reader lector;
    private String resultados = "";
    private int linea = 1;
    private boolean correcto = true;

    // Contructor
    public Gramatica(File archivo) throws FileNotFoundException, IOException{ 
            lector = new BufferedReader(new FileReader(archivo));
            lexico = new Lexico(lector);
    }
    
    public void programa() throws IOException{
        token = lexico.yylex();
            // System.out.println(token);
            if (token != null) {
                sentencias();
            }
    }

    public void sentencias() throws IOException{
        System.out.println("Sentencias...");
        do {            
            asignacion();
            if (token != Tokens.PUNTOCOMA) {
                errorSintactico();
            }
            else{
                resultados = resultados + "\n Linea " + linea + ": correcta.";
                linea++;
            }
            token = lexico.yylex();
        } while (token != null && correcto != false);
    }

    public void asignacion() throws IOException{
        System.out.println("asignacion...");
        if (token == Tokens.ID) {
            token = lexico.yylex();
            System.out.println(token);
            if (token == Tokens.IGUAL) {
                token = lexico.yylex();
                System.out.println(token);
                expresion();
            }
        }
        else{
            errorSintactico();
        }
    }

    public void expresion() throws IOException{
        System.out.println("expresion...");
        if (token == Tokens.ID || token == Tokens.NUM) {
            token = lexico.yylex();
            System.out.println(token);
            if (token == Tokens.RESTA || token == token.SUMA) {
                token = lexico.yylex();
                System.out.println(token);
                expresion();
            }
        }
        else {
            errorSintactico();
        }
    }

    private void errorSintactico() throws IOException {
        System.out.println("Hay un error...");
        /*while (token != Tokens.PUNTOCOMA) {   
            System.out.println(token);*/
            resultados = resultados + "\n Linea " + linea + ": incorrecta.";
            /*linea++;
            token = lexico.yylex();
        }*/
        correcto = false;
    }

    public String getResultados() {
        return resultados;
    }
    
    
}
