package listaCirular;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircular list = new ListaCircular();
        Scanner scanner = new Scanner(System.in);
        String name, phone;
        int age, option;
        do {
            // Mostrar las opciones del menu
            System.out.println("\n1. Insert student");
            System.out.println("2. Search student");
            System.out.println("3. Modify student");
            System.out.println("4. Delete student");
            System.out.println("5. Print all students");
            System.out.println("6. Exit \n");
            System.out.print("Select an option: ");

            try {
                // Leer la opción seleccionada por el usuario   
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter the student's name: ");
                        name = scanner.next();
                        System.out.print("Enter the student's age: ");
                        age = scanner.nextInt();
                        System.out.print("Enter the student's phone: ");
                        phone = scanner.next();
                        list.insertNode(name, age, phone);
                        System.out.println("Student inserted");
                        break;
                    case 2:
                        System.out.print("Enter the name of the student to search: ");
                        name = scanner.next();
                        Nodo found = list.searchNode(name);
                        if (found != null) {
                            System.out.println("Student found: " + found.name + ", " + found.age + ", " + found.phone);
                        } else {
                            System.out.println("Student not found");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the name of the student to modify: ");
                        name = scanner.next();
                        Nodo toModify = list.searchNode(name);
                        if (toModify != null) {
                            System.out.print("Enter the new name of the student: ");
                            name = scanner.next();
                            System.out.print("Enter the new age of the student: ");
                            age = scanner.nextInt();
                            System.out.print("Enter the new phone of the student: ");
                            phone = scanner.next();
                            list.modifyNode(toModify, name, age, phone);
                            System.out.println("Student modified");
                        } else {
                            System.out.println("Student not found");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the name of the student to delete: ");
                        name = scanner.next();
                        list.deleteNode(name);
                        break;
                    case 5:
                        System.out.println("\nPrinting all students:");
                        list.printList();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (InputMismatchException e) {
                // Manejar excepciones de tipo InputMismatchException
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Limpia el buffer del scanner
                option = 0; // Reinicia la opción
            } catch (Exception e) {
                // Manejar excepciones generales
                System.out.println("An unexpected error occurred: " + e.getMessage());
                option = 0; // Reinicia la opción
            }
        } while (option != 6);
        scanner.close();
    }
}