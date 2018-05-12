/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class Ejemplo {

    public String cadena = JOptionPane.showInputDialog("Dame la cadena:");
    private int indice = 0;
    private int indice1;
    private boolean funciona = false;
    char c;
    private String[][] tabla = {{"AB", "AB", "e", "e", "e"},
    {"a", "A", "e", "e", "e"},
    {"e", "bCd", "e ", "e", "e"},
    {"e", "e", "C", " ", "e"}};
    private Object[] terminal = {"a", "b", "c", "d", ";"};
    private Object[] noTerminal = {"S", "A", "B", "C"};
    private Stack pilas = new Stack();
    private Object tmp;

    public void pila() {
        System.out.println(cadena);
        pilas.push(terminal[terminal.length - 1]);
        pilas.push(noTerminal[0]);
        c = get_Char();
        S(c);
        evaluar(c);
        funciona = true;
        int control = 0;
        Object tm, t;
        System.out.println(pilas);
        while (funciona == true) {
            switch (c) {
                case 'a':
                    tmp = terminal[0];
                    if (pilas.peek() == tmp) {
                        pilas.pop();
                        c = get_Char();
                        funciona = true;
                    } else {
                        funciona = false;
                    }
                    break;
                case 'b':
                    tmp = 'A';
                    tm = 'B';
                    t = 'b';
                    if (pilas.peek() == tmp) {
                        evaluar(c);
                        funciona = true;
                        control++;
                        if (control == 2) {
                            funciona = false;
                        }
                    } else if (pilas.peek() == tm) {
                        //pilas.pop();
                        evaluar2(c);
                    } else if (pilas.peek() == t) {
                        pilas.pop();
                        c = get_Char();
                        funciona = true;
                    } else {
                        funciona = false;
                    }
                    break;
                case 'c':
                    control = 0;
                    tmp = 'C';
                    tm = 'B';
                    t = 'c';
                    if (pilas.peek() == tm) {
                        evaluar2(c);
                        funciona = false;
                    } else if (pilas.peek() == tmp) {
                        //pilas.pop();
                        evaluar3(c);
                        funciona = false;
                        error();
                    } else if (pilas.peek() == t) {
                        pilas.pop();
                        c = get_Char();
                        funciona = true;
                    } else {
                        funciona = false;
                    }

                    break;
                case 'd':
                    tmp = 'B';
                    tm = 'C';
                    t = 'd';
                    if (pilas.peek() == tmp) {
                        pilas.pop();
                        evaluar2(c);
                        funciona = false;
                    } else if (pilas.peek() == tm) {
                        evaluar3(c);
                        funciona = true;
                    } else if (pilas.peek() == t) {
                        pilas.pop();
                        c = get_Char();
                        funciona = true;
                    } else {
                        funciona = false;
                        error();
                    }
                    break;
                case ';':
                    t = ';';
                    if (pilas.peek() == terminal[terminal.length - 1]) {
                        pilas.pop();
                        JOptionPane.showMessageDialog(null, "Cadena Correcta");

                    } else {
                        if (!pilas.empty()) {
                            error();
                        }
                    }
                    funciona = false;
                    break;
                default:

                    break;
            }
            System.out.println(pilas);
        }
    }

    public void S(char c) {
        indice = 1;
        switch (c) {
            case 'a': {
                pilas.pop();
                String cr = tabla[0][0];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;

                }
                break;
            }
            case 'b': {
                pilas.pop();
                String cr = tabla[0][1];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            }
            case 'c': {
                error();
                break;
            }
            case 'd': {
                error();
                break;
            }
            case ';':
                error();
                break;
            default:
                error();
                break;
        }
        System.out.println(pilas);
    }

    public void evaluar(char c) {
        Object ad;
        switch (c) {
            case 'a':
                ad = terminal[0];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'b':
                ad = noTerminal[1];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'c':
                error();
                break;
            case 'd':
                error();
                break;
            case ';':
            //error();
            default:
                error();
        }
        System.out.println(pilas);
    }

    public void evaluar2(char c) {
        Object ad;
        String f;
        indice = 1;
        switch (c) {
            case 'a':
                error();
                break;
            case 'b':
                pilas.pop();
                ad = tabla[2][1];
                System.out.println(ad);
                f = (String) ad;
                for (int i = 0; i < f.length(); i++) {
                    char[] t = f.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            case 'c':
                error();
                break;
            case 'd':
                error();
                break;
            case ';':
                funciona = false;
                //error();
                break;
            default:
                error();
        }

    }

    public void evaluar3(char c) {
        Object ad;
        switch (c) {
            case 'a':
                error();
                break;
            case 'b':
                error();
                break;
            case 'c':
                ad = noTerminal[3];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'd':
                pilas.pop();
                break;
            case ';':
                //error();
                break;
            default:
                error();
        }
    }

    public char get_Char() {
        char[] charCadena = cadena.toCharArray();
        char c = 0;
        if (indice1 < charCadena.length) {
            c = charCadena[indice1];
            indice1++;
        }
        return c;

    }

    public void error() {
        JOptionPane.showMessageDialog(null, "Error");
    }

    public static void main(String[] args) {
        Ejemplo app = new Ejemplo();
        app.pila();
    }
}
