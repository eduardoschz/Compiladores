/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aragon.ico;

import aragon.ico.rangos.Rangos;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class LetraDigito {

    private String cadena = "";
    private boolean aceptar = false;
    private int error = 0;
    private int indice = 0;
    private int estado = 1;
    private char simbolo;

    public static void main(String[] args) {
        LetraDigito obj = new LetraDigito();
        Rangos rangos = new Rangos();
        obj.cadena = JOptionPane.showInputDialog(null, "Inserte la cadena", "Programa 2", JOptionPane.QUESTION_MESSAGE);
        obj.simbolo = obj.siguienteCaracter();

        while (obj.simbolo != ' ' || obj.error != 0) {
            switch (obj.estado) {
                case 1:
                    if (rangos.rangoaz_AZ(obj.simbolo)) {
                        obj.estado = 3;
                    } else if (rangos.rango09(obj.simbolo)) {
                        obj.estado = 2;

                    } else {
                        obj.error = 0;
                    }
                    break;
                case 2:

                    obj.error = 0;

                    break;
                case 3:
                    if (rangos.rangoaz_AZ(obj.simbolo)) {
                        obj.estado = 3;
                        obj.aceptar = true;
                    } else if (rangos.rango09(obj.simbolo)) {
                        obj.estado = 3;
                        obj.aceptar = true;
                    } else {
                        obj.error = 0;
                    }
                    break;
            }
            obj.simbolo = obj.siguienteCaracter();

        }
        if (!obj.aceptar) {
            JOptionPane.showMessageDialog(null, "Cadena Invalida", "Programa 2", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cadena Valida", "Programa 2", JOptionPane.INFORMATION_MESSAGE);

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
