package arbolBinario;

public class Pila {
    Nodo Inicio;
    int tamanno;

    Pila() {
        this.Inicio = null;
        this.tamanno = 0;
    }

    void annadirPrincipio(Nodo nodo) {
        nodo.siguiente = Inicio;
        Inicio = nodo;
        tamanno++;
    }

    Nodo eliminar() {
        Nodo nodo = Inicio;
        Inicio = Inicio.siguiente;
        return nodo;
    }

    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.annadirPrincipio(new Nodo('2'));
        pila.annadirPrincipio(new Nodo('^'));
        pila.annadirPrincipio(new Nodo('3'));
        pila.annadirPrincipio(new Nodo('*'));
        pila.annadirPrincipio(new Nodo('('));
        pila.annadirPrincipio(new Nodo('5'));   
        pila.annadirPrincipio(new Nodo('-'));
        pila.annadirPrincipio(new Nodo('4'));
        pila.annadirPrincipio(new Nodo(')'));

        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);
        System.out.println(pila.eliminar().dato);

    }
}
