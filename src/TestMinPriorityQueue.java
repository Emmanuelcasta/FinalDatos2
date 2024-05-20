/**
 * La clase TestMinPriorityQueue proporciona un ejemplo de cómo utilizar la clase MinPriorityQueue.
 * Se insertan vértices, se extrae el mínimo, se disminuye la clave de un vértice y se inserta un nuevo vértice en el heap.
 */
public class TestMinPriorityQueue {

    /**
     * El método principal que demuestra las operaciones de la clase MinPriorityQueue.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        MinPriorityQueue mpq = new MinPriorityQueue(26);
        
        // Inserta 26 vértices en la cola de prioridad.
        for (int i = 1; i <= 26; i++) {
            mpq.minHeapInsert(new Vertex(i, i, -1)); // Cambia los valores según sea necesario.
        }

        System.out.println("Al crearlo, el heap queda así: ");
        mpq.printMinHeap();

        // Extrae el menor elemento.
        Vertex min = mpq.extractMin();
        System.out.print("El mínimo elemento es: ");
        System.out.println(min);
        System.out.println("Luego de extraer el mínimo, el heap queda así: ");
        mpq.printMinHeap();

        // Disminuye la clave de un elemento.
        mpq.minHeapDecreaseKey(4, 1);
        System.out.println("Luego de disminuir la clave del elemento 4, el heap queda así: ");
        mpq.printMinHeap();

        // Inserta un nuevo elemento.
        mpq.minHeapInsert(new Vertex(27, 4, -1));
        System.out.println("Luego de insertar el elemento 27, el heap queda así: ");
        mpq.printMinHeap();
    }
}
