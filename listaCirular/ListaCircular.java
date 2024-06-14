package listaCirular;

// Clase de la lista circular enlazada
class ListaCircular {
    private Nodo last;

    // Constructor
    ListaCircular() {
        this.last = null;
    }

    // Crear un nuevo nodo
    private Nodo createNode(String nombre, int edad, String telefono) {
        return new Nodo(nombre, edad, telefono);
    }

    // Insertar nodo en la lista circular
    void insertNode(String nombre, int edad, String telefono) {
        Nodo newNode = createNode(nombre, edad, telefono);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    // Buscar un nodo en la lista circular
    Nodo searchNode(String nombre) {
        if (last == null)
            return null;
        Nodo temp = last.next;
        do {
            if (temp.nombre.equals(nombre))
                return temp;
            temp = temp.next;
        } while (temp != last.next);
        return null;
    }

    // Modificar un nodo en la lista circular
    void modifyNode(Nodo nodo, String nombre, int edad, String telefono) {
        nodo.nombre = nombre;
        nodo.edad = edad;
        nodo.telefono = telefono;
    }

    // Eliminar un nodo de la lista circular
    void deleteNode(String nombre) {
        if (last == null)
            return;
        Nodo current = last, previous = null;
        while (!current.nombre.equals(nombre)) {
            previous = current;
            current = current.next;
            if (current == last && !current.nombre.equals(nombre)) {
                System.out.println("Nodo con el nombre " + nombre + " no encontrado");
                return;
            }
        }
        if (current.next == current) {
            last = null;
        } else if (current == last) {
            previous.next = current.next;
            last = previous;
        } else {
            previous.next = current.next;
        }
    }

    // Imprime todos los nodos de la lista circular
    void printList() {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }
        Nodo temp = last.next;
        do {
            System.out.println("Nombre: " + temp.nombre + ", Edad: " + temp.edad + ", telefono: " + temp.telefono);
            temp = temp.next;
        } while (temp != last.next);
    }
}