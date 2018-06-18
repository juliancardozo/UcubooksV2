/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class UCUBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      

        Biblioteca ucubooks = new Biblioteca();

         System.out.println("CARGANDO DATOS DE UCU BOOKS: ************************************************");
         ucubooks.cargarAutores(); 
         ucubooks.cargarLibros();
         ucubooks.cargarTags();

        //Nodo<Autor> buscarTest = ucubooks.getListaAutores().buscarEnListaOrdenada(359);
        //Nodo<Autor> buscarTest2 = ucubooks.getListaAutores().buscarEnListaOrdenada(12);
         System.out.println("id libros: ************************************************");
         ucubooks.getListaLibros().imprimir();
         System.out.println("id autores: ************************************************");
         ucubooks.getListaAutores().imprimir();
         System.out.println("id tags: ************************************************");
         ucubooks.getListaTags().imprimir();
         System.out.println("CARGADO FINALIZADA CON ÉXITO: ************************************************");

         System.out.println("ASOCIANDO LIBROS CON AUTORES: ************************************************");
         ucubooks.relacionarLibrosAutores();
         System.out.println("FIN ASOCIANDO LIBROS CON AUTORES: ************************************************");
        
         System.out.println("ASOCIANDO LIBROS CON TAGS: ************************************************");
         ucubooks.relacionarBookTag();
         System.out.println("FIN ASOCIANDO LIBROS CON AUTORES: ************************************************");
         
         
         //MENU PRINCIPAL
        boolean exit;
        do{
                System.out.println("·····························");
                System.out.println("---Bienvenidos a UCU Books---");
                System.out.println("·····························");
                System.out.println("");
                System.out.println("");
                System.out.println("1.  Mostrar últimas ediciones.");
                System.out.println("2.  Mostrar información detallada de un libro.");
                System.out.println("3.  Buscar libro por nombre.");
                System.out.println("4.  Buscar libro por año.");
                System.out.println("5.  Buscar libro por ISBN.");
                System.out.println("6.  Buscar libro por autores.");
                System.out.println("7.  Mostrar libros por autor.");
                System.out.println("8.  Mostrar libros de cierto género.");
                System.out.println("9.  Eliminar un autor.");
                System.out.println("10. Salir.");
                
                exit=false;
                Scanner sc=new Scanner(System.in);
                int choice=sc.nextInt();
                    switch(choice)
                    {   
                    case 1:
                        //Leer una palabra
                        System.out.println("Mostrar últimas ediciones de libros de ucubooks..");
                        System.out.println("\n");
                        Scanner sc1=new Scanner(System.in);
                        System.out.println("Ingrese el año a partir de cual quiere que le mostremos las ediciones.");
                        Integer anioDesde =sc1.nextInt();
                        ucubooks.mostrarUltimasEdicionesdeLibros(anioDesde);
                        
                        break;
                    case 2:
                        System.out.println("Mostrar información detallada de un libro.");
                        System.out.println("\n");
                        Scanner sc2=new Scanner(System.in);
                        System.out.println("Ingrese la clave del libro ...");
                        Integer idLibro =sc2.nextInt();
                        ucubooks.mostrarInfoDetalladaLibro(idLibro);
                        break;

                    case 3:

                        System.out.println("Buscar libros por nombre.");
                        System.out.println("\n");
                        Scanner sc3=new Scanner(System.in);
                        System.out.println("Ingrese nombre de los libros a buscar ...");
                        String nombre =sc3.next();
                        nombre += sc3.nextLine();
                        ucubooks.buscarLibrosPorNombre(nombre);
                        
                        break;
                    case 4:
                        System.out.println("Buscar libros por año.");
                        System.out.println("\n");
                        Scanner sc4=new Scanner(System.in);
                        System.out.println("Ingrese año de los libros a buscar ...");
                        Integer anio =sc4.nextInt();
                        ucubooks.buscarLibrosPorAnio(anio);
                        break;

                    case 5:
                       System.out.println("Buscar libros por ISBN.");
                        System.out.println("\n");
                        Scanner sc5=new Scanner(System.in);
                        System.out.println("Ingrese ISBN de los libros a buscar ...");
                        String isbn =sc5.next();
                        ucubooks.buscarLibrosPorISBN(isbn);
                        break;

                    case 6:
                        System.out.println("Buscar libros por autor.");
                        System.out.println("\n");
                        Scanner sc6=new Scanner(System.in);
                        System.out.println("Ingrese el autor para listar sus libros ...");
                        String nombreAutor =sc6.next();
                        nombreAutor += sc6.nextLine();
                        ucubooks.buscarLibroPorAutor(nombreAutor);
                        
                        break;

                    case 7:
                        System.out.println("Mostrar libros por autores.");
                        System.out.println("\n");
                        Scanner sc7=new Scanner(System.in);
                        System.out.println("Ingrese el autor para listar sus libros ...");
                        String nombreAutorMostrar =sc7.nextLine();
                        ucubooks.mostrarLibrosPorAutor(nombreAutorMostrar);
                        break;

                    case 8:

                        
                        System.out.println("Mostrar libros por género/tag");
                        System.out.println("\n");
                        Scanner sc8=new Scanner(System.in);
                        System.out.println("Ingrese el id tag para listar los libros de ese genero/tag...");
                        Integer claveTag =sc8.nextInt();
                        ucubooks.mostrarLibrosPorTag(claveTag);
                        break;

                    case 9:

                        
                        System.out.println("Eliminar autor y todos sus libros de ucubooks.");
                        System.out.println("\n");
                        Scanner sc9=new Scanner(System.in);
                        System.out.println("Ingrese el id del autor que quiere eliminar de ucuBooks junto a todos sus libros ...");
                        Integer claveAutorLibros =sc9.nextInt();
                        ucubooks.eliminarAutorConSusLibros(claveAutorLibros);
                        break;

                    
                    case 10:
                        System.out.println("Chau!");
                        System.out.println("\n");
                        exit = true;
                        break;
                         
                }
            }while(!exit);
    
         
         
         
            
    
      System.out.println("APAGANDO EL SISTEMA CORRECTAMENTE: ************************************************");
    }

   

}
