public class TestMinPriorityQueue {
    public static void main(String [] args) {
        MinPriorityQueue mpq = new MinPriorityQueue(5);
        mpq.minHeapInsert(new Vertex(1, 8, -1));
        mpq.minHeapInsert(new Vertex(2, 3, -1));
        mpq.minHeapInsert(new Vertex(3, 2, -1));
        mpq.minHeapInsert(new Vertex(4, 9, -1));
        mpq.minHeapInsert(new Vertex(5, 1, -1));

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
        mpq.minHeapInsert(new Vertex(6, 4, -1));
        System.out.println("Luego de insertar el elemento 4, el heap queda así: ");   
        mpq.printMinHeap();
    }

}
