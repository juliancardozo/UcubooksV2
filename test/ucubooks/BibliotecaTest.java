/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class BibliotecaTest {
    
    private Biblioteca instance;
    
    public BibliotecaTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Biblioteca();
         instance.cargarAutores(); 
         instance.cargarLibros();
         instance.cargarTagsTest();
         instance.relacionarLibrosAutores();
         
         
    }

    /**
     * Test of mostrarInfoDetalladaLibro method, of class Biblioteca.
     */
    @Test
    public void testMostrarInfoDetalladaLibro() {
        System.out.println("testMostrarInfoDetalladaLibro");
        Integer idLibro = null;
        instance.mostrarInfoDetalladaLibro(idLibro);
       
    }

    /**
     * Test of mostrarInfoDetalladaAutores method, of class Biblioteca.
     */
    @Test
    public void testMostrarInfoDetalladaAutores() {
        System.out.println("testMostrarInfoDetalladaAutores");
        Lista<Autor> lista = null;
        instance.mostrarInfoDetalladaAutores(lista);
       
    }

    /**
     * Test of mostrarInfoDetalladaTags method, of class Biblioteca.
     */
    @Test
    public void testMostrarInfoDetalladaTags() {
        System.out.println("testMostrarInfoDetalladaTags");
        Lista<Tag> lista = null;
        instance.mostrarInfoDetalladaTags(lista);
      
    }

    /**
     * Test of buscarLibrosPorNombre method, of class Biblioteca.
     */
    @Test
    public void testBuscarLibrosPorNombre() {
        System.out.println("testBuscarLibrosPorNombre");
        String nombre = "erika";
        Libro libro1 = new Libro(6195, "Amerika", 1927,3.73,14500,"s805210644/9780805210640");
        Nodo<Libro> nodoLibro1 = new Nodo<>(libro1.getId(),libro1);
        Lista<Libro> expResult = new Lista<>();
        expResult.insertar(nodoLibro1);
        Lista<Libro> result = instance.buscarLibrosPorNombre(nombre);
        assertEquals(expResult.primero.getEtiqueta(), result.primero.getEtiqueta());
       
    }

    /**
     * Test of buscarLibrosPorAnio method, of class Biblioteca.
     */
    @Test
    public void testBuscarLibrosPorAnio() {
        System.out.println("testBuscarLibrosPorAnio");
       Integer anio = 2017;
        Libro libro1 = new Libro(7467, "The Girl Before", 2017,3.7,14500,"425285049/9780425285050");
        Nodo<Libro> nodoLibro1 = new Nodo<>(libro1.getId(),libro1);
        Libro libro2 = new Libro(7560, "Caraval", 2017,3.73,14500,"1250095255/9781250095250");
        Nodo<Libro> nodoLibro2 = new Nodo<>(libro2.getId(),libro2);
        Libro libro3 = new Libro(8282, "Faithful", 2017,3.73,14500,"1476799202/9781476799210");
        Nodo<Libro> nodoLibro3 = new Nodo<>(libro3.getId(),libro3);
        Libro libro4 = new Libro(8685, "Behind Her Eyes", 2017,3.73,14500,"125011117X/9781250111170");
        Nodo<Libro> nodoLibro4 = new Nodo<>(libro4.getId(),libro4);
        Libro libro5 = new Libro(9569, "The Hate U Give", 2017,3.73,14500,"62498533/9780062498530");
        Nodo<Libro> nodoLibro5 = new Nodo<>(libro5.getId(),libro5);
        Libro libro6 = new Libro(9580, "Egomaniac", 2017,3.73,14500,"1682309819/9781682309810");
        Nodo<Libro> nodoLibro6 = new Nodo<>(libro6.getId(),libro6);
        Libro libro7 = new Libro(5884, "Norse Mythology", 2017,3.73,14500,"");
        Nodo<Libro> nodoLibro7 = new Nodo<>(libro7.getId(),libro7);
        Libro libro8 = new Libro(9392, "Lincoln in the Bardo", 2017,3.73,14500,"812995341/9780812995340");
        Nodo<Libro> nodoLibro8 = new Nodo<>(libro8.getId(),libro8);
        Lista<Libro> expResult = new Lista<>();
        expResult.insertar(nodoLibro1);
        expResult.insertar(nodoLibro2);
        expResult.insertar(nodoLibro3);
        expResult.insertar(nodoLibro4);
        expResult.insertar(nodoLibro5);
        expResult.insertar(nodoLibro6);
        expResult.insertar(nodoLibro7);
        expResult.insertar(nodoLibro8);
        Lista<Libro> result = new Lista<>();
        result = instance.buscarLibrosPorAnio(anio);
        assertEquals(expResult.cantElementos(), result.cantElementos());
    }

    /**
     * Test of buscarLibrosPorISBN method, of class Biblioteca.
     */
    @Test
    public void testBuscarLibrosPorISBN() {
        System.out.println("testBuscarLibrosPorISBN");
        String isbn = "812995341/9780812995340";
        Libro libro8 = new Libro(9392, "Lincoln in the Bardo", 2017,3.73,14500,"812995341/9780812995340");
        Nodo<Libro> nodoLibro8 = new Nodo<>(libro8.getId(),libro8);
        Lista<Libro> expResult = new Lista<>();
        expResult.insertar(nodoLibro8);
        Lista<Libro> result = instance.buscarLibrosPorISBN(isbn);
        assertEquals(expResult.primero.getEtiqueta(), result.primero.getEtiqueta());
      
    }

    /**
     * Test of mostrarLibrosPorAutor method, of class Biblioteca.
     */
    @Test
    public void testMostrarLibrosPorAutor() {
        System.out.println("testMostrarLibrosPorAutor");
        String claveAutor = null;
        instance.mostrarLibrosPorAutor(claveAutor);

    }

    /**
     * Test of buscarLibroPorAutor method, of class Biblioteca.
     */
    @Test
    public void testBuscarLibroPorAutor() {
        System.out.println("testBuscarLibroPorAutor");
        String nombreAutor = "Lee";  
       Libro libro1 = new Libro(4, "To Kill a Mockingbird", 1960,4.25,3198671,"61120081/9780061120080");
        Nodo<Libro> nodoLibro1 = new Nodo<>(libro1.getId(),libro1);
        Lista<Libro> expResult = new Lista<>();
        expResult.insertar(nodoLibro1);
        Lista<Libro> result = instance.buscarLibroPorAutor(nombreAutor);
        assertEquals(expResult.cantElementos(), result.cantElementos());
       
    }

    /**
     * Test of mostrarLibrosPorTag method, of class Biblioteca.
     */
    @Test
    public void testMostrarLibrosPorTag() {
        System.out.println("mostrarLibrosPorTag");
        Integer claveTag = null;
        instance.mostrarLibrosPorTag(claveTag);
       
    }

    /**
     * Test of eliminarAutorConSusLibros method, of class Biblioteca.
     */
    @Test
    public void testEliminarAutorConSusLibros() {
        System.out.println("eliminarAutorConSusLibros");
        Integer claveAutorLibros = 2505;
        Lista<Libro> resultBefore = instance.getListaLibros();
        Integer cantidadElementosAntes = resultBefore.cantElementos();
        instance.eliminarAutorConSusLibros(claveAutorLibros);
        Lista<Libro> resultAfter = instance.getListaLibros();
       // result = instance.buscarLibrosPorAnio(anio);
        assertEquals(5, cantidadElementosAntes - resultAfter.cantElementos());
      
    }

    /**
     * Test of mostrarUltimasEdicionesdeLibros method, of class Biblioteca.
     */
    @Test
    public void testMostrarUltimasEdicionesdeLibros() {
        System.out.println("mostrarUltimasEdicionesdeLibros");
        Integer anioDesde = null;
        instance.mostrarUltimasEdicionesdeLibros(anioDesde);
        
    }
    
}
