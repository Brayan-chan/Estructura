package listaDoblementeEnlazada;

public class ListaDoblementeEnlazada {

    // declarar apuntadores
    NodoDoble inicio;
    NodoDoble fin;

    // constructor para declarar inicio y fin como nulos
    public ListaDoblementeEnlazada() {
        inicio = fin = null;
    }

    // metodo para determinar si la lista esta vacia o no
    public boolean estaVacio() {
        return inicio == null; // si la cabeza esta vacia retorna true
    }

    // metodo para agregar nodos a la lista
    public void addNode(String info) {
        if (!estaVacio()) {
            fin = new NodoDoble(info, fin, null);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoDoble(info);
        }
    }

    // metodo para imprimir la lista de inicio a fin
    public void showListFromStart() {
        if (!estaVacio()) {
            String link = "<===>";
            NodoDoble auxiliary = inicio; // nodo auxiliar para poder recorrer la lista
            while (auxiliary != null) {
                link = link + "[" + auxiliary.info + "]" + "<===>";
                auxiliary = auxiliary.siguiente; // recorrer la lista
            }
            System.out.println(link);
        }
    }

    // metodo para imprimir la lista de fin a inicio
    public void showListFromEnd() {
        if (!estaVacio()) {
            String link = "<===>";
            NodoDoble auxiliary = fin; // nodo auxiliar para poder recorrer la lista
            while (auxiliary != null) {
                link = link + "[" + auxiliary.info + "]" + "<===>";
                auxiliary = auxiliary.anterior; // recorrer la lista
            }
            System.out.println(link);
        }
    }

    // metodo para mandar el elemento deseado hasta el final de la lista
    public void moveDataToEnd(String info) {
        // verificar si la lista no esta vacia
        if (!estaVacio()) {
            NodoDoble actual = inicio; // nodo auxiliar para recorrer la lista
            while (actual != null) {
                if (actual.info.equals(info)) {
                    // si la informacion coincide con el ultimo nodo
                    if (actual == fin) {
                        return;
                    }

                    // si la informacion coincide con la del primer nodo
                    if (actual == inicio) {
                        inicio = inicio.siguiente; // el principio de la lista es ahora el nodo siguiente
                        inicio.anterior = null;
                    } else {
                        actual.anterior.siguiente = actual.siguiente; // conectar nodo anterior con el siguiente
                        actual.siguiente.anterior = actual.anterior; // conectar nodo siguiente con el anterior
                    }
                    // conectar nodos con el final de la lista
                    actual.anterior = fin; // el link anterior apunta al nodo "final"
                    actual.siguiente = null; // el link sigueinte apunta a nulo
                    fin.siguiente = actual; // el nodo "final" apunta al que se movio de lugar
                    fin = actual; // actualizar el nodo final
                    return;

                }
                actual = actual.siguiente; // recorrer la lista
            }
        }
    }

    public static void main(String[] args) {
        ListaDoblementeEnlazada list = new ListaDoblementeEnlazada();

        // Checqr si la lita esta vacia
        System.out.println("¿Está la lista vacía? " + list.estaVacio());

        // Checqr si la lita esta vacia
        list.addNode("Node 1");
        list.addNode("Node 2");
        list.addNode("Node 3");

        // Checqr de nuevo si la lita esta vacia
        System.out.println("¿Está la lista vacía? " + list.estaVacio());
    }
}