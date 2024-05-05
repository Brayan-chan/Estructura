package noPolaca;

import java.util.Scanner;

class Nodo {
    char dato;
    Nodo siguiente;

    Nodo(char dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

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

public class InfixToPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la expresión en notación infija:");
        String expresionInfija = scanner.nextLine();

        String expresionPolaca = convertirAnotacionPolaca(expresionInfija);

        System.out.println("La expresión en notación polaca es: " + expresionPolaca);

        scanner.close();
    }

    public static String convertirAnotacionPolaca(String expresionInfija) {
        StringBuilder expresionPolaca = new StringBuilder();
        Pila pila = new Pila();

        for (int i = expresionInfija.length() - 1; i >= 0; i--) {
            char caracter = expresionInfija.charAt(i);
            if (esOperando(caracter)) {
                expresionPolaca.insert(0, caracter);
            } else if (caracter == ')') {
                pila.push(caracter);
            } else if (caracter == '(') {
                while (!pila.isEmpty() && pila.peek() != ')') {
                    expresionPolaca.insert(0, pila.pop());
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && precedencia(pila.peek()) >= precedencia(caracter)) {
                    expresionPolaca.insert(0, pila.pop());
                }
                pila.push(caracter);
            }
        }

        while (!pila.isEmpty()) {
            expresionPolaca.insert(0, pila.pop());
        }

        return expresionPolaca.toString();
    }

    public static boolean esOperando(char caracter) {
        return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z') || (caracter >= '0' && caracter <= '9');
    }

    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
