package notacionPolaca;

import java.util.Scanner;

public class notacionPolaca {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese la expresión en notación infija:");
        String expresionInfija = input.nextLine();

        String expresionPolaca = convertirAnotacionPolaca(expresionInfija);

        System.out.println("La expresión en notación polaca es: " + expresionPolaca);

        input.close();
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
