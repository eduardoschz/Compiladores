/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aragon.ico;

import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class Expresion_ababb {

    private String cadena = "";

    private int aceptar = 1;
    private int error = 0;
    private int indice = 0;

    public static void main(String[] args) {
        Expresion_ababb obj = new Expresion_ababb();
        obj.cadena = JOptionPane.showInputDialog("Dame la cadena");
        if (obj.aceptar == obj.estado_A()) {
            JOptionPane.showMessageDialog(null, "Valida");
        } else {
            JOptionPane.showMessageDialog(null, "Invalida");
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
                return estado_D();
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
                return estado_E();
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
            case ' ':
                return aceptar;
            default:
                return error;
        }
    }

}
