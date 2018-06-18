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
public class Biblioteca {
     private ListaLibros listaLibros;
     private ListaAutores listaAutores;
     private ListaTags listaTags;

    public ListaLibros getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ListaLibros listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ListaAutores getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(ListaAutores listaAutores) {
        this.listaAutores = listaAutores;
    }

    public ListaTags getListaTags() {
        return listaTags;
    }

    public void setListaTags(ListaTags listaTags) {
        this.listaTags = listaTags;
    }

    public Biblioteca() {
        this.listaLibros = new ListaLibros();
        this.listaAutores = new ListaAutores();
        this.listaTags = new ListaTags();
    }
    
     public void cargarAutores() {
        //Creo los autores
        String[] lineasAutores = ManejadorArchivosGenerico.leerArchivo("src/archivos/authors.csv");
        Autor autor;
        for (String l : lineasAutores) {
            String[] datos = l.split("\\|");
            autor = new Autor(Integer.valueOf(datos[0]), datos[1]);
            Nodo<Autor> nuevoNodoAutor = new Nodo<>(autor.getId(), autor);
            this.getListaAutores().insertarOrdenado(nuevoNodoAutor);
        }
    }

    public void cargarLibros() {
       //Creo los libros
        String[] lineasLibros = ManejadorArchivosGenerico.leerArchivo("src/archivos/books.csv");
        Libro libro;
        
        for (String l : lineasLibros) {
            String[] datos = l.split("\\|");
                int id = -1;
                String nombre = "";
                int anio = -1;
                Double puntaje = new Double(0.0);
                Double cantidadPuntaje = new Double(0.0);
                String ISBN = "";
        
               if(datos.length>=1 && datos[0]!=null && !datos[0].trim().equals(""))
                   id = Integer.valueOf(datos[0]);
               
               if(datos.length>=2 && datos[1]!=null && !datos[1].trim().equals(""))
                   nombre = datos[1];
               
               if(datos.length>=3 && datos[2]!=null && !datos[2].trim().equals(""))
                    anio = Integer.valueOf(datos[2]);
               
               if(datos.length>=4 && datos[3]!=null && !datos[3].trim().equals(""))
                    puntaje = Double.valueOf(datos[3]);
               
               if(datos.length>=5 && datos[4]!=null && !datos[4].trim().equals(""))
                    cantidadPuntaje = Double.valueOf(datos[4]);
               
               if(datos.length>=6 && datos[5]!=null && !datos[5].trim().equals(""))
                    ISBN = datos[5];

                libro = new Libro(id, nombre, anio, puntaje, cantidadPuntaje, ISBN);
                Nodo<Libro> nuevoNodoLibro = new Nodo<>(libro.getId(), libro);
               
                this.getListaLibros().insertarOrdenado(nuevoNodoLibro);
             
           

        }
        
    }

    public void cargarTags() {
        //Creo los tags
        String[] lineasTags = ManejadorArchivosGenerico.leerArchivo("src/archivos/tags.csv");
        Tag tag;
        for (String l : lineasTags) {
            Integer id = 0;
            String nombreTag = "";
            
            String[] datos = l.split("\\|");
            if(datos[0]!=null && !datos[0].equals(""))
                id=Integer.valueOf(datos[0].substring(1));
            
            if(datos.length>=2 && datos[1]!=null)
                nombreTag=datos[1];
           
            tag = new Tag(id, datos[1]);
            Nodo<Tag> nuevoNodoTag = new Nodo<>(tag.getId(), tag);
            this.getListaTags().insertarOrdenado(nuevoNodoTag);
        }
    }

    public void relacionarLibrosAutores() {
        //Creo los tags
        //Lista libros this.getListaLibros();
        //Autores autores this.getListaAutores();
        
        String[] lineasRelacionLibroAutor = ManejadorArchivosGenerico.leerArchivo("src/archivos/bookauthors.csv");
        for (String relacionLibAutor : lineasRelacionLibroAutor) {
            String[] datos = relacionLibAutor.split("\\|");
            Integer idLibro = 0;
            Integer idAutor = 0;
            if(datos[0]!=null && !datos[0].equals(""))
                idLibro = Integer.valueOf(datos[0]);
            
            if(datos.length>=2 && datos[1]!=null && !datos[1].equals(""))
                idAutor = Integer.valueOf(datos[1]);
                
         
            //Encuentro nodoAutor y nodoLibro
            System.out.println("busca libro " + idLibro);
            Nodo<Libro> libroEncontrado = this.getListaLibros().buscarEnListaOrdenada(idLibro);
            Nodo<Autor> autorEncontrado = this.getListaAutores().buscarEnListaOrdenada(idAutor);
            
            if(autorEncontrado == null)
                System.out.println("no encontró autor " + idAutor);
            else {
                if (libroEncontrado == null)
                     System.out.println("no encontró libro " + idLibro);
                else {
                    //Agrego el autor a la lista de autores del libro encontrado
                    libroEncontrado.getDato().getAutores().insertarOrdenado(autorEncontrado);
                    System.out.println("cargó autor en el libro correctamente.");
                }
            }
            
        }
        
        System.out.println("FINAL RELACIONAR LIBROS CON AUTORES.");
    }
    
    
    public void relacionarBookTag(){
        String[] lineasRelacionLibroTag = ManejadorArchivosGenerico.leerArchivo("src/archivos/booktags.csv");
        for (String relacionLibTag : lineasRelacionLibroTag) {
            String[] datos = relacionLibTag.split("\\|");
            Integer idLibro = 0;
            Integer idTag = 0;
            if(datos[0]!=null && !datos[0].equals(""))
                idLibro = Integer.valueOf(datos[0]);
            
            if(datos.length>=2 && datos[1]!=null && !datos[1].equals(""))
                idTag = Integer.valueOf(datos[1]);
                
            //Encuentro nodoLibro y nodoTag
            Nodo<Libro> libroEncontrado = this.getListaLibros().buscarEnListaOrdenada(idLibro);
            Nodo<Tag> tagEncontrado = this.getListaTags().buscarEnListaOrdenada(idTag);
             
            if(libroEncontrado == null)
                System.out.println("no encontró libro " + idLibro);
            else {
                if (tagEncontrado == null)
                     System.out.println("no encontró tag " + idTag);
                else 
                    //Agrego el autor a la lista de autores del libro encontrado
                    libroEncontrado.getDato().getTags().insertarOrdenado(tagEncontrado);
                   
               
            }
        }   
    }

    void mostrarInfoDetalladaLibro(Integer idLibro) {
         Nodo<Libro> libroEncontrado = null;
         if(idLibro !=null){
                 libroEncontrado = this.getListaLibros().buscarEnListaOrdenada(idLibro);
                 if (libroEncontrado!=null){
                       System.out.println("");
                       System.out.println("Información del libro: ");
                       Libro libro = libroEncontrado.getDato();
                       System.out.println("Id: " + libro.getId());
                       System.out.println("Nombre: " + libro.getNombre());
                       System.out.println("Año: " + libro.getAnio());
                       System.out.println("Puntaje: " + libro.getPuntaje());
                       System.out.println("Cantidad de puntaje: " + libro.getCantidadPuntaje());
                       System.out.println("Autores: ");
                       mostrarInfoDetalladaAutores(libro.getAutores());
                       System.out.println("Tags: ");
                       mostrarInfoDetalladaTags(libro.getTags());
                   }   else {
                       System.out.println("No se encontró ningún libro con id ingresado. Por favor revisar. Id ingresado: " + idLibro);
                   }
         }
    }
    
    void mostrarInfoDetalladaAutores(Lista<Autor> lista){
        Lista<Autor> aux = null;
        if(lista!=null){
            aux = lista;
            Nodo<Autor> autorActual = aux.getPrimero();
            while (autorActual!=null){
                Autor datoAutor = autorActual.getDato();
                System.out.println("    Id Autor: " + datoAutor.getId());
                System.out.println("    Nombre Autor: " + datoAutor.getNombre());
                autorActual = autorActual.getSiguiente();
            }
        }
    }
    
    void mostrarInfoDetalladaTags(Lista<Tag> lista){
        Lista<Tag> aux = null;
        if(lista!=null){
            aux =lista;
            Nodo<Tag> tagActual = aux.getPrimero();
            while (tagActual!=null){
                Tag datoTag = tagActual.getDato();
                System.out.println("    Id Tag: " + datoTag.getId());
                System.out.println("    Nombre Tag: " + datoTag.getNombre());
                tagActual = tagActual.getSiguiente();
            }
        }
    }

     Lista<Libro> buscarLibrosPorNombre(String nombre) {
        Lista<Libro> auxLibros = this.getListaLibros();
        Lista<Libro> resultadoLibros = new Lista<>();
        Nodo<Libro> libroActual = auxLibros.getPrimero();
        while (libroActual!=null ){
            Libro datoLibro = libroActual.getDato();
            if (datoLibro.getNombre().toUpperCase().contains(nombre.toUpperCase())){
                System.out.println("Id Libro: " + datoLibro.getId());
                System.out.println("Nombre Libro: " + datoLibro.getNombre());
                System.out.println("");
                resultadoLibros.insertar(libroActual);
            }
            libroActual = libroActual.getSiguiente();
        }
        return resultadoLibros;
    }
    
    Lista<Libro> buscarLibrosPorAnio(Integer anio) {
        Lista<Libro> auxLibros = this.getListaLibros();
        Lista<Libro> resultadoLibros = new Lista<>();
        Nodo<Libro> libroActual = auxLibros.getPrimero();
        while (libroActual!=null ){
            Libro datoLibro = libroActual.getDato();
            if (datoLibro.getAnio()==anio){
                System.out.println("Id Libro: " + datoLibro.getId());
                System.out.println("Nombre Libro: " + datoLibro.getNombre());
                System.out.println("Año Libro: " + datoLibro.getAnio());
                System.out.println("");
                Nodo<Libro> paraInsertar = libroActual.clonar();
                resultadoLibros.insertarOrdenado(paraInsertar);
            }
            libroActual = libroActual.getSiguiente();
        }
         return resultadoLibros;
    }

    Lista<Libro> buscarLibrosPorISBN(String isbn) {
        Lista<Libro> auxLibros = this.getListaLibros();
        Lista<Libro> resultadoLibros = new Lista<>();
        Nodo<Libro> libroActual = auxLibros.getPrimero();
        while (libroActual!=null ){
            Libro datoLibro = libroActual.getDato();
            if (datoLibro.getISBN().toUpperCase().contains(isbn.toUpperCase())){
                System.out.println("Id Libro: " + datoLibro.getId());
                System.out.println("Nombre Libro: " + datoLibro.getNombre());
                System.out.println("Año Libro: " + datoLibro.getAnio());
                 System.out.println("ISBN: " + datoLibro.getISBN());
                System.out.println("");
                 resultadoLibros.insertar(libroActual);
            }
            libroActual = libroActual.getSiguiente();
        }
        return resultadoLibros;
    }

    void mostrarLibrosPorAutor(String nombreAutor) {
        
        //Nodo<Autor> autor = this.getListaAutores().buscarEnListaOrdenada(claveAutor);
        Lista<Libro> auxLibros = this.getListaLibros();
        Nodo<Libro> libroActual = auxLibros.getPrimero();
        while (libroActual!=null ){
            Libro datoLibro = libroActual.getDato();
            Lista<Autor> autoresDelLibro = datoLibro.getAutores();
              Nodo<Autor> nodoAutor = autoresDelLibro.getPrimero();
              while (nodoAutor != null){
                if (nodoAutor.getDato().getNombre().toUpperCase().contains(nombreAutor.toUpperCase())){
                System.out.println("Autor Id: " + nodoAutor.getDato().getId());
                System.out.println("Autor Nombre: " + nodoAutor.getDato().getNombre());
                System.out.println("");
                System.out.println("Id Libro: " + datoLibro.getId());
                System.out.println("Nombre Libro: " + datoLibro.getNombre());
                System.out.println("Año Libro: " + datoLibro.getAnio());
                System.out.println("");
            }
            nodoAutor = nodoAutor.getSiguiente();
            }
            libroActual = libroActual.getSiguiente();
        }
    }
    
    Lista<Libro> buscarLibroPorAutor(String nombre) {
         //Nodo<Autor> autor = this.getListaAutores().buscarEnListaOrdenada(claveAutor);
        Lista<Libro> auxLibros = this.getListaLibros();
        Lista<Libro> resultadoLibros = new Lista<>();
        Nodo<Libro> libroActual = auxLibros.getPrimero();
        while (libroActual!=null ){
            Libro datoLibro = libroActual.getDato();
            Lista<Autor> autoresDelLibro = datoLibro.getAutores();
              Nodo<Autor> nodoAutor = autoresDelLibro.getPrimero();
              while (nodoAutor != null){
                if (nodoAutor.getDato().getNombre().toUpperCase().contains(nombre.toUpperCase())){
                    System.out.println("Autor Id: " + nodoAutor.getDato().getId());
                    System.out.println("Autor Nombre: " + nodoAutor.getDato().getNombre());
                    System.out.println("");
                    System.out.println("Id Libro: " + datoLibro.getId());
                    System.out.println("Nombre Libro: " + datoLibro.getNombre());
                    System.out.println("Año Libro: " + datoLibro.getAnio());
                    System.out.println("");
                    Nodo<Libro> paraInsertar = libroActual.clonar();
                    resultadoLibros.insertar(paraInsertar);
                } 
                nodoAutor = nodoAutor.getSiguiente();
              }
              libroActual = libroActual.getSiguiente();
            }
         return resultadoLibros;
    }

    void mostrarLibrosPorTag(Integer claveTag) {
        //Nodo<Autor> autor = this.getListaAutores().buscarEnListaOrdenada(claveAutor);
        Lista<Libro> auxLibros = this.getListaLibros();
        Nodo<Libro> libroActual = auxLibros.getPrimero();
        while (libroActual!=null ){
            Libro datoLibro = libroActual.getDato();
            Nodo<Tag> nodoTag = datoLibro.getTags().buscar(claveTag);
            if (nodoTag != null){
                System.out.println("Tag Id: " + nodoTag.getDato().getId());
                System.out.println("Tag Nombre: " + nodoTag.getDato().getNombre());
                System.out.println("");
                System.out.println("Id Libro: " + datoLibro.getId());
                System.out.println("Nombre Libro: " + datoLibro.getNombre());
                System.out.println("Año Libro: " + datoLibro.getAnio());
                System.out.println("");
            }
            libroActual = libroActual.getSiguiente();
        }
    }

    void eliminarAutorConSusLibros(Integer claveAutorLibros) {
        /*
        Si vacía entonces O(1)
Devolver false O(1)
SiNo
nodoRecorrer  Libros.primero O(1)
Mientras nodoRecorrer <> nulo O(n)
Si nodoRecorrer.autor.id = idAutor O(1)
Quitar(nodoRecorrer) O(1)
quitoLibro  true O(1)
Fin si
nodoRecorrer  nodoRecorrer.siguiente O(1)
Fin mientras
nodoRecorrerAutores  Autores.primero O(1)
Mientras nodoRecorrerAutores <> nulo O(n)
Si nodoRecorrerAutores.id = idAutor O(1)
Quitar(nodoRecorrerAutores) O(1)
quitoAutor  true O(1)
Fin si
Fin mientras
Si quitoLibro and quitoAutor O(1)
Devolver true; O(1)
        */
        
        Lista<Libro> listaLibrosAuxiliar = this.getListaLibros();
        
        if(listaLibrosAuxiliar.esVacia())
            System.err.println("La lista libros esta vacia.");
        else{
            Nodo<Libro> nodoRecorrerLibros = listaLibrosAuxiliar.primero;
            while(nodoRecorrerLibros!=null){
                  Lista<Autor> listaAutoresRecorrer = nodoRecorrerLibros.getDato().getAutores();
                  if (!listaAutoresRecorrer.esVacia()){
                      Nodo<Autor> autorEncontrado = listaAutoresRecorrer.buscarEnListaOrdenada(claveAutorLibros);
                      if (autorEncontrado != null){
                          //Elimino el libro de la lista de libros
                          this.listaLibros.eliminar(nodoRecorrerLibros.getEtiqueta());
                          System.err.println("Eliminó el libro " + nodoRecorrerLibros.getEtiqueta());
                      } 
                  }
                  //System.err.println("Esta recorriendo los libros... " + nodoRecorrerLibros.getEtiqueta());
                  nodoRecorrerLibros = nodoRecorrerLibros.getSiguiente();
                   
            }
            //Elimino el autor de la lista de autores
            System.err.println("Elimino el autor de la lista de autores... " + claveAutorLibros);
            this.listaAutores.eliminar(claveAutorLibros);
            //System.err.println("TRANCA ACA ");
        }
        
       
        
        
    }

    void mostrarUltimasEdicionesdeLibros(Integer anioDesde) {
       Lista<Libro> auxLibros = null;
        if(anioDesde!=null){
            auxLibros =this.getListaLibros();
            Nodo<Libro> libroActual = auxLibros.getPrimero();
            while (libroActual!=null ){
                Libro datoLibro = libroActual.getDato();
                if (datoLibro.getAnio()>=anioDesde){
                    System.out.println("Id Libro: " + datoLibro.getId());
                    System.out.println("Nombre Libro: " + datoLibro.getNombre());
                    System.out.println("Año Libro: " + datoLibro.getAnio());
                    System.out.println("");
                }
                libroActual = libroActual.getSiguiente();
            }
        }
    }

    void cargarTagsTest() {
        //Creo los tags para test, es el archivo
        //original pero hasta la linea 100 para 
        //no enlentecer la carga de los casos de test.
        String[] lineasTags = ManejadorArchivosGenerico.leerArchivo("src/archivos/tagsTest.csv");
        Tag tag;
        for (String l : lineasTags) {
            Integer id = 0;
            String nombreTag = "";
            
            String[] datos = l.split("\\|");
            if(datos[0]!=null && !datos[0].equals(""))
                id=Integer.valueOf(datos[0].substring(1));
            
            if(datos.length>=2 && datos[1]!=null)
                nombreTag=datos[1];
           
            tag = new Tag(id, datos[1]);
            Nodo<Tag> nuevoNodoTag = new Nodo<>(tag.getId(), tag);
            this.getListaTags().insertarOrdenado(nuevoNodoTag);
        }
    }   
}
