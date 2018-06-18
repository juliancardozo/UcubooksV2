/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

/**
 *
 * @author Usuario
 */
public class Autor {
    private Comparable id;
    private String nombre;

    public Autor(Comparable id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Comparable getId() {
        return id;
    }

    public void setId(Comparable id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
