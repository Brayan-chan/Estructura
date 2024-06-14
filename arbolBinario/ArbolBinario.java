package arbolBinario;
import java.util.Scanner;

class Nodo {
    char valor;
    Nodo izquierda, derecha;

    Nodo(char item) {
        valor = item;
        izquierda = derecha = null;
    }
}

public class ArbolBinario {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Nodo raiz = construirArbol();
        imprimirPreorden(raiz);
    }

    public static Nodo construirArbol() {
        System.out.println("Ingrese el valor para el nodo raíz:");
        char valor = scanner.next().charAt(0);
        Nodo raiz = new Nodo(valor);
        construirArbolRecursivo(raiz, raiz, 1);
        return raiz;
    }

    public static void construirArbolRecursivo(Nodo nodo, Nodo raiz, int n) {
        System.out.println("¿Desea agregar un nodo a la izquierda de '" + nodo.valor + "'? (s/n)");
        char opcion = scanner.next().charAt(0);
        if (opcion == 's') {
            System.out.println("Ingrese el valor del nodo:");
            char valor = scanner.next().charAt(0);
            nodo.izquierda = new Nodo(valor);
            construirArbolRecursivo(nodo.izquierda, raiz, n + 1);
        }

        System.out.println("¿Desea agregar un nodo a la derecha de '" + nodo.valor + "'? (s/n)");
        opcion = scanner.next().charAt(0);
        if (opcion == 's') {
            System.out.println("Ingrese el valor del nodo:");
            char valor = scanner.next().charAt(0);
            nodo.derecha = new Nodo(valor);
            construirArbolRecursivo(nodo.derecha, raiz, n + 1);
        }

        if (n == 1) {
            System.out.println("¿Desea regresar al nodo raíz para agregar más nodos? (s/n)");
            opcion = scanner.next().charAt(0);
            if (opcion == 's') {
                construirArbolRecursivo(raiz, raiz, 1);
            }
        }
    }

    public static void imprimirPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            imprimirPreorden(nodo.izquierda);
            imprimirPreorden(nodo.derecha);
        }
    }
}
