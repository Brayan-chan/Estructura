package notacionPolaca;
class Pila {
    Nodo cabeza;

    Pila() {
        this.cabeza = null;
    }

    void push(char dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    char pop() {
        if (cabeza == null)
            throw new IllegalStateException("La pila está vacía");
        
        char dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        return dato;
    }

    char peek() {
        if (cabeza == null)
            throw new IllegalStateException("La pila está vacía");
        
        return cabeza.dato;
    }

    boolean isEmpty() {
        return cabeza == null;
    }
}
