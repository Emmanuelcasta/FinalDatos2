public class TestMinPriorityQueue {
    public static void main(String [] args) {
    MinPriorityQueue mpq = new MinPriorityQueue(26);
    // Inserta tus 26 vértices aquí. Por ejemplo:
    for (int i = 1; i <= 26; i++) {
        mpq.minHeapInsert(new Vertex(i, i, -1)); // Cambia los valores según sea necesario
    }

    System.out.println("Al crearlo, el heap queda así: ");
    mpq.printMinHeap();

    // Extraer el menor elemento
    Vertex min = mpq.extractMin();
    System.out.print("El mínimo elemento es: ");
    System.out.println(min);
    System.out.println("Luego de extraer el mínimo, el heap queda así: ");
    mpq.printMinHeap();

    // Disminuir la clave de un elemento
    mpq.minHeapDecreaseKey(4, 1);
    System.out.println("Luego de disminuirla clave del elemento 4, el heap queda así: ");
    mpq.printMinHeap();

    // Insertar un elemento
    mpq.minHeapInsert(new Vertex(27, 4, -1));
    System.out.println("Luego de insertar el elemento 27, el heap queda así: ");   
    mpq.printMinHeap();
    }
}