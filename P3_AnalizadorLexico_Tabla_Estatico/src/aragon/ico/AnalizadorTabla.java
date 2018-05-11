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
public class AnalizadorTabla {

    private String cadena = "";
    private boolean aceptar = false;
    private int error = 0;
    private int indice = 0;
    private int estado = 1;
    private char simbolo;

    public static void main(String[] args) {
        AnalizadorTabla obj = new AnalizadorTabla();
        obj.cadena = JOptionPane.showInputDialog(null, "Insertar Cadena", "Programa 3", JOptionPane.QUESTION_MESSAGE);
        obj.simbolo = obj.siguienteCaracter();
        while (obj.simbolo != ' ' || obj.error != 0) {
            switch (obj.estado) {
                case 1:
                    switch (obj.simbolo) {
                        case 'a':
                            obj.estado = 2;
                            obj.aceptar = true;
                            break;
                        case 'b':
                            obj.estado = 3;
                            break;
                        case 'c':
                            obj.estado = 4;
                            break;
                        default:
                            obj.error = 0;
                            break;
                    }
                    break;
                case 2:
                    switch (obj.simbolo) {
                        case 'a':
                            obj.estado = 2;
                            obj.aceptar = true;
                            break;
                        case 'b':
                            obj.estado = 3;
                            break;
                        case 'c':
                            obj.estado = 5;
                            obj.aceptar = true;
                            break;
                        default:
                            obj.error = 0;
                            break;
                    }
                    break;
                case 3:
                    switch (obj.simbolo) {
                        case 'a':
                            obj.estado = 2;
                            obj.aceptar = true;
                            break;
                        case 'b':
                            obj.estado = 3;
                            break;
                        case 'c':
                            obj.estado = 4;
                            break;
                        default:
                            obj.error = 0;
                            break;
                    }
                    break;
                case 4:
                    if (obj.simbolo == 'a') {
                        obj.estado = 2;
                        obj.aceptar = true;
                    } else if (obj.simbolo == 'b') {
                        obj.estado = 3;
                    } else if (obj.simbolo == 'c') {
                        obj.estado = 4;
                    } else {
                        obj.error = 0;
                    }
                    break;
                case 5:
                    if (obj.simbolo == 'a') {
                        obj.estado = 2;
                        obj.aceptar = true;
                    } else if (obj.simbolo == 'b') {
                        obj.estado = 3;
                    } else if (obj.simbolo == 'c') {
                        obj.estado = 5;
                        obj.aceptar = true;
                    } else {
                        obj.error = 0;
                    }
                    break;
            }
            obj.simbolo = obj.siguienteCaracter();

        }
        if (!obj.aceptar) {
            JOptionPane.showMessageDialog(null, "Cadena invalida", "Programa 3", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cadena valida", "Programa 3", JOptionPane.INFORMATION_MESSAGE);

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

}
