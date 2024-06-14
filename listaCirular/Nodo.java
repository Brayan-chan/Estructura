package listaCirular;

// Define la estructura del nodo
class Nodo {
    String nombre;
    int edad;
    String telefono;
    Nodo next;

    // Constructor
    Nodo(String nombre, int edad, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.next = null;
    }
}