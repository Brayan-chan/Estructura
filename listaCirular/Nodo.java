package listaCirular;

// Define la estructura del nodo
class Nodo {
    String name;
    int age;
    String phone;
    Nodo next;

    // Constructor
    Nodo(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.next = null;
    }
}