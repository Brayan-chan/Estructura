package listaDoblementeEnlazada;

class NodoDoble {
    String info;
    NodoDoble siguiente;
    NodoDoble anterior;

    // Constructor para un nodo con datos y referencias a los nodos anterior y
    // siguiente
    public NodoDoble(String info, NodoDoble anterior, NodoDoble siguiente) {
        this.info = info;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    // Constructor para un nodo con solo datos (para el inicio y el final de la
    // lista)
    public NodoDoble(String info) {
        this(info, null, null);
    }
}