/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aragon.ico;

/**
 *
 * @author pc9
 */
public class AnalizadorSintactico3 {

    private String cadena = "( num + num ) + num ;";
    private String token;
    private int indice = 0;
    private boolean correcto = false;
    private boolean error = false;
    private int linea = 1;

    public static void main(String[] args) {
        AnalizadorSintactico3 app = new AnalizadorSintactico3();
        app.token = app.getToken();
        app.metodo_S();
        if (app.isError() && app.correcto) {
            System.out.println("Error de sintaxis");
        } else {
            System.out.println("Correcto");
        }
    }

    public String getToken() {
        String token = null;
        if (indice < cadena.split(" ").length) {
            token = cadena.split(" ")[indice];
            indice++;
        }
        return token;
    }

    private void metodo_S() {
        metodo_E();
        if (token != null && token.equals(";")) {
            correcto = true;
        } else {
            error = true;
        }
    }

    public void metodo_E() {
        if (token != null && token.equals("(")) {
            token = getToken();
            metodo_E();
            if (token != null && token.equals(")")) {
                token = getToken();
                if (token != null && !token.equals(";")) {
                    metodo_X();
                }
            } else {
                token = getToken();
                error = true;
            }
        } else if (token != null && token.equals("num")) {
            token = getToken();
            if (token != null && !token.equals(";")) {
                metodo_X();
            }
        }
//        } else {
//            token = getToken();
//            error = true;
//        }
    }

    private void metodo_X() {
        if (token != null && token.equals("*")) {
            token = getToken();
            metodo_E();
            if (token != null) {
                metodo_X();
            }

        } else if (token != null && token.equals("+")) {
            token = getToken();
            metodo_E();
            if (token != null) {
                metodo_X();
            }
        }
//        else {
//            token = getToken();
//            error = true;
//        }
    }

    public boolean isError() {
        return error;
    }

}
