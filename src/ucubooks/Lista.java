package ucubooks;


public class Lista<T> implements ILista<T> {

    Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public Lista(Nodo<T> unNodo) {
        this.primero = unNodo;
    }



    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> resultado = null;
        if (esVacia()) {
            return resultado;
        } else {
            Nodo<T> aux = getPrimero();
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    //return aux;
                    resultado = aux.clonar();
                }
                aux = aux.getSiguiente();
                
            }
        }
        return resultado;
    }
    
    public boolean existe(Comparable clave) {
        if (esVacia()) {
            return false;
        } else {
            Nodo<T> aux = getPrimero();
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;
    }
    
    
    @Override
    public void insertar(Nodo<T> unNodo) {
            
        if(!existe(unNodo.getEtiqueta())){
            if(primero==null){
                    primero=unNodo;
                } else {
                    Nodo<T> aux = primero;
                    while (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(unNodo);
                }
        }
    }
    
    
    public Nodo<T> buscarEnListaOrdenada(Comparable clave) {
        Nodo<T> resultado = null;
        if (esVacia()) {
            return resultado;
        } else {
            Nodo<T> aux = getPrimero();
            while ((aux != null) && (aux.getEtiqueta().compareTo(clave) != 1)) {
                if (aux.getEtiqueta().equals(clave)) {
                    resultado = aux.clonar();
                }
                aux = aux.getSiguiente();
            }
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            Nodo aux = getPrimero();
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

   @Override
    public boolean eliminar(Comparable clave) {
        if (primero==null) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = getPrimero();
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta() + " ";
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux;
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = getPrimero();
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }
    
     public boolean insertarOrdenado(Nodo<T> unNodo){        
        
          if(!existe(unNodo.getEtiqueta())){
         
                Nodo auxiliar = primero;        
               // Si la lista se encuentra vacia, entonces inserta el Nodo al principio.
               if (esVacia() == true){
                   primero = unNodo;
                   return true;
               }else{
                   while (auxiliar!= null){
                       if (unNodo.compareTo(auxiliar.getEtiqueta())<=0){//si es menor al primer elemento
                           unNodo.setSiguiente(primero);
                           primero = unNodo;
                           return true;
                       }else if(unNodo.compareTo(auxiliar.getEtiqueta())> 0 && auxiliar.getSiguiente()== null){
                           //Si el elemento es mayor al ultimo elemento de la lista, se insertara al final.
                           auxiliar.setSiguiente(unNodo);
                           return true;                   
                       }else{
                           //Si el elemento se encuentra en el medio de la lista.
                           if (unNodo.compareTo(auxiliar.getEtiqueta())> 0 && unNodo.compareTo(auxiliar.getSiguiente().getEtiqueta())<=0){
                               unNodo.setSiguiente(auxiliar.getSiguiente());
                               auxiliar.setSiguiente(unNodo);
                               return true;
                           }

                       }           
                       auxiliar = auxiliar.getSiguiente();
                       }           
               }
               return false;
              }
            return false;
          
    }

    @Override
    public Nodo<T> quitarPrimero() {
        
        if(!this.esVacia()){
            Nodo<T> aux = this.primero;
            this.primero = this.primero.getSiguiente();
            return aux;
        } else {
            return null;
        }
    }
}
