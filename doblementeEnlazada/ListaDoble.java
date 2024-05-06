package doblementeEnlazada;
import java.util.Scanner;

public class ListaDoble {
    static Scanner input = new Scanner(System.in);

    public class ListaDoblementeEnlazada {
        private Nodo lista;

        public ListaDoblementeEnlazada() {
            lista = null;
        }

        public void insertarALaLista(char info) { //metodo para insertar un nodo en la lista
            Nodo nuevoNodo = new Nodo(info);

            if (lista == null) {
                lista = nuevoNodo;
            } else {
                Nodo nodoActual = lista;

                while (nodoActual.siguiente != null) {
                    nodoActual = nodoActual.siguiente;
                }

                nodoActual.siguiente = nuevoNodo;
                nuevoNodo.anterior = nodoActual;
            }
        }

        public void moverAlFinal(char info) {
            Nodo nodoActual = lista;
        
            while (nodoActual != null) {
                if (nodoActual.info == info) {
                    // Eliminar el nodo actual de su posición actual
                    if (nodoActual.anterior != null) {
                        nodoActual.anterior.siguiente = nodoActual.siguiente;
                    } else {
                        lista = nodoActual.siguiente;
                    }
        
                    if (nodoActual.siguiente != null) {
                        nodoActual.siguiente.anterior = nodoActual.anterior;
                    }
        
                    // Mover el nodo al final de la lista
                    Nodo ultimoNodo = lista;
                    while (ultimoNodo.siguiente != null) {
                        ultimoNodo = ultimoNodo.siguiente;
                    }
                    ultimoNodo.siguiente = nodoActual;
                    nodoActual.anterior = ultimoNodo;
                    nodoActual.siguiente = null;
                    break;
                }
        
                nodoActual = nodoActual.siguiente;
            }
        }
        
        public void imprimirLista() {
            Nodo nodoActual = lista;

            while (nodoActual != null) {
                System.out.print(nodoActual.info + " "); // Imprimir el valor del nodo actual
                nodoActual = nodoActual.siguiente; // Mover al siguiente nodo
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListaDoble listaDoble = new ListaDoble();
        ListaDoblementeEnlazada lista = listaDoble.new ListaDoblementeEnlazada();
    
        // Insertar elementos en la lista
        System.out.println("Ingresa los caracteres a guardar en la lista (presiona 'q' para salir): ");
        char caracter; 
        do {
            String inputString = input.nextLine(); // Leer el input del usuario
            if(inputString.equalsIgnoreCase("q")) {
                break; // Si el usuario ingresa 'q', salir del bucle
            }
            caracter = inputString.charAt(0); // Convertir el input en un caracter
            lista.insertarALaLista(caracter);
        } while (true); // Bucle infinito
    
        System.out.println("Lista ingresada:");
        lista.imprimirLista();
    
        // Mover el nodo con información 'D' al final de la lista
        lista.moverAlFinal('D');
    
        System.out.println("Lista después de mover 'D' al final:");
        lista.imprimirLista();
    }
}