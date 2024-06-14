package listaCirular;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircular list = new ListaCircular();
        Scanner scanner = new Scanner(System.in);
        String nombre, telefono;
        int edad, option;
        do {
            // Mostrar las opciones del menu
            System.out.println("\n1. Insertar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Modificar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Imprimir todos los estudiantes");
            System.out.println("6. Salir \n");
            System.out.print("Selecciona una opcion: ");

            try {
                // Leer la opción seleccionada por el usuario   
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Ingresa el nombred del estudiante: ");
                        nombre = scanner.next();
                        System.out.print("Ingresa la edad del estudiante: ");
                        edad = scanner.nextInt();
                        System.out.print("Ingresa el telefono del estudiante: ");
                        telefono = scanner.next();
                        list.insertNode(nombre, edad, telefono);
                        System.out.println("Estudiante insertado");
                        break;
                    case 2:
                        System.out.print("Ingresa el nombre del estudiante a buscar: ");
                        nombre = scanner.next();
                        Nodo found = list.searchNode(nombre);
                        if (found != null) {
                            System.out.println("Estudiante encontrado: " + found.nombre + ", " + found.edad + ", " + found.telefono);
                        } else {
                            System.out.println("Estudiante no encontrado");
                        }
                        break;
                    case 3:
                        System.out.print("Ingresa el nombre del estudiante a modificar: ");
                        nombre = scanner.next();
                        Nodo toModify = list.searchNode(nombre);
                        if (toModify != null) {
                            System.out.print("Ingresa el nuevo nombre de el estudiante: ");
                            nombre = scanner.next();
                            System.out.print("Ingresa la nueva edad de el estudiante: ");
                            edad = scanner.nextInt();
                            System.out.print("Ingresa el nuevo telefono del estudiante: ");
                            telefono = scanner.next();
                            list.modifyNode(toModify, nombre, edad, telefono);
                            System.out.println("Estudiante modificado");
                        } else {
                            System.out.println("Estudiante no encontrado");
                        }
                        break;
                    case 4:
                        System.out.print("Ingresa el nombre del estudiante a eliminar: ");
                        nombre = scanner.next();
                        list.deleteNode(nombre);
                        break;
                    case 5:
                        System.out.println("\nImprimir todos los estudiantes:");
                        list.printList();
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (InputMismatchException e) {
                // Manejar excepciones de tipo InputMismatchException
                System.out.println("Entrada invalida. Por favor ingresa un numero.");
                scanner.next(); // Limpia el buffer del scanner
                option = 0; // Reinicia la opción
            } catch (Exception e) {
                // Manejar excepciones generales
                System.out.println("Un error inesperado ha ocurrido: " + e.getMessage());
                option = 0; // Reinicia la opción
            }
        } while (option != 6);
        scanner.close();
    }
}