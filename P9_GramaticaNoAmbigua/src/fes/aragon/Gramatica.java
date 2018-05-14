/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author makin
 */
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
    

    public void sentencia() throws IOException{
        System.out.println("Sentencia....");
        getToken();
        do {            
            if (correcto != false) {
                expresion();
            }
        } while (token != null && correcto);
    }

    public void expresion() throws IOException{
        System.out.println("Expresion....");
        tipos();
        formato();
        if (correcto != false) {
            if (token != Tokens.PUNTOCOMA) {
                errorSintactico();
            }
            else{
                resultados = resultados + "Linea: " + linea + ": correcta. \n";
                linea++;
            }
        }
        getToken();
    }
    
    public void tipos() throws IOException{
        System.out.println("tipos....");
        if (correcto != false) {
            if (token == Tokens.BOOLEAN || token == Tokens.BOUBLE || token == Tokens.INT || token == Tokens.STRING) {
                getToken();
            }
            else{
                errorSintactico();
            }
        }
    }
    
    public void formato() throws IOException{
        System.out.println("Formato....");
        if (correcto != false) {
            if (token == Tokens.ID) {
                getToken(); 
                switch(token){
                    case COMA:
                        getToken();
                        formato();
                        break;
                        
                    case PUNTOCOMA:
                        break;
                        
                    default:
                        errorSintactico();
                        break;
                }
            }
            else{
                errorSintactico();
            }
        }
    }

    private void errorSintactico() throws IOException {
        System.out.println("Hay un error...");
        /*while (token != Tokens.PUNTOCOMA) {   
            System.out.println(token);*/
            resultados = resultados + "Linea " + linea + ": incorrecta.\n";
            /*linea++;
            getToken();
        }*/
        correcto = false;
    }

    public String getResultados() {
        return resultados;
    }
    
    public void getToken() throws IOException{
        token = lexico.yylex();
        System.out.println("Token: " + token);
    }
    
}
