/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ico.aragon;


public class Tabla {
    private String nombre;
    private String PI;
    private String PD;
    private int id;

    public Tabla() {
    }

    public Tabla(String nombre, int id, String PI, String PD) {
        this.nombre = nombre;
        this.PI = PI;
        this.PD = PD;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPI() {
        return PI;
    }

    public void setPI(String PI) {
        this.PI = PI;
    }
    
    public String getPD() {
        return PD;
    }

    public void setPD(String PD) {
        this.PD = PD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
