package aragon.ico;


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eduardo
 */
public class Expresion_abcac {

    private String cadena = "";
    private int aceptar = 1;
    private int error = 0;
    private int indice = 0;

    public static void main(String[] args) {
        Expresion_abcac obj = new Expresion_abcac();
        obj.cadena = JOptionPane.showInputDialog(null, "Ingresa la cadena", "Programa 2", JOptionPane.QUESTION_MESSAGE);
        if (obj.aceptar == obj.estado_A()) {
            JOptionPane.showConfirmDialog(null, "Cadena valida", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showConfirmDialog(null, "Cadena invalida", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private char siguienteCaracter() {
        char c = ' ';
        if (indice < cadena.length()) {
            c = cadena.charAt(indice);
            indice++;
        }
        return c;
    }

    private int estado_A() {
        char c = siguienteCaracter();
        switch (c) {
            case 'a':
                return estado_B();
            case 'b':
                return estado_C();
            case 'c':
                return estado_D();
            default:
                return error;
        }
    }

    private int estado_B() {
        char c = siguienteCaracter();
        switch (c) {
            case 'a':
                return estado_B();
            case 'b':
                return estado_C();
            case 'c':
                return estado_E();
            case ' ':
                return aceptar;
            default:
                return error;
        }
    }

    private int estado_C() {
        char c = siguienteCaracter();
        switch (c) {
            case 'a':
                return estado_B();
            case 'b':
                return estado_C();
            case 'c':
                return estado_D();
            default:
                return error;
        }
    }

    private int estado_D() {
        char c = siguienteCaracter();
        switch (c) {
            case 'a':
                return estado_B();
            case 'b':
                return estado_C();
            case 'c':
                return estado_D();
            default:
                return error;
        }
    }

    private int estado_E() {
        char c = siguienteCaracter();
        switch (c) {
            case 'a':
                return estado_B();
            case 'b':
                return estado_C();
            case 'c':
                return estado_E();
            case ' ':
                return aceptar;
            default:
                return error;
        }
    }

}
