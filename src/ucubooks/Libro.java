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
public class Libro {
    
    private Comparable id;
    private String nombre;
    private int anio;
    private Double puntaje;
    private Double cantidadPuntaje;
    private String ISBN;
    private Lista<Autor> autores;
    private Lista<Tag> tags;

    public Lista<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Lista<Autor> autores) {
        this.autores = autores;
    }

    public Lista<Tag> getTags() {
        return tags;
    }

    public void setTags(Lista<Tag> tags) {
        this.tags = tags;
    }

    public Libro(Comparable id, String nombre, int anio, double puntaje, double cantidadPuntaje, String ISBN) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.puntaje = puntaje;
        this.cantidadPuntaje = cantidadPuntaje;
        this.ISBN = ISBN;
        this.autores = new Lista<>();
        this.tags = new Lista<>();
        
    }
    
      public Libro(Comparable id, String nombre, int anio,String ISBN) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.ISBN = ISBN;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public double getCantidadPuntaje() {
        return cantidadPuntaje;
    }

    public void setCantidadPuntaje(double cantidadPuntaje) {
        this.cantidadPuntaje = cantidadPuntaje;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

   

   

    
    
    
}
