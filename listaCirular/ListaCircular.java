package listaCirular;

// Clase de la lista circular enlazada
class ListaCircular {
    private Nodo last;

    // Constructor
    ListaCircular() {
        this.last = null;
    }

    // Crear un nuevo nodo
    private Nodo createNode(String name, int age, String phone) {
        return new Nodo(name, age, phone);
    }

    // Insertar nodo en la lista circular
    void insertNode(String name, int age, String phone) {
        Nodo newNode = createNode(name, age, phone);
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
    Nodo searchNode(String name) {
        if (last == null)
            return null;
        Nodo temp = last.next;
        do {
            if (temp.name.equals(name))
                return temp;
            temp = temp.next;
        } while (temp != last.next);
        return null;
    }

    // Modificar un nodo en la lista circular
    void modifyNode(Nodo nodo, String name, int age, String phone) {
        nodo.name = name;
        nodo.age = age;
        nodo.phone = phone;
    }

    // Eliminar un nodo de la lista circular
    void deleteNode(String name) {
        if (last == null)
            return;
        Nodo current = last, previous = null;
        while (!current.name.equals(name)) {
            previous = current;
            current = current.next;
            if (current == last && !current.name.equals(name)) {
                System.out.println("Node with the name " + name + " not found");
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
            System.out.println("Name: " + temp.name + ", Age: " + temp.age + ", Phone: " + temp.phone);
            temp = temp.next;
        } while (temp != last.next);
    }
}