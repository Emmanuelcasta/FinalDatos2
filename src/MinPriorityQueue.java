/**
 * MinPriorityQueue
 * <p>
 * Mantiene una cola de prioridad mínima de vértices basada en su distancia
 * desde el vértice fuente. Los vértices se almacenan en un array.
 * Esta estructura es utilizada para el algoritmo de Dijkstra.
 * </p>
 */
public class MinPriorityQueue {
    
    /**
     * Array que almacena los vértices en la cola de prioridad.
     */
    Vertex[] array;
    
    /**
     * Tamaño actual del heap.
     */
    int heapSize;

    /**
     * Constructor para crear una cola de prioridad mínima con una capacidad inicial.
     *
     * @param heapSize La capacidad inicial del heap.
     */
    public MinPriorityQueue(int heapSize) {
        array = new Vertex[heapSize + 1];
        this.heapSize = 0;
    }

    /**
     * Devuelve el índice del padre de un nodo en el heap.
     *
     * @param i El índice del nodo.
     * @return El índice del nodo padre.
     */
    public int parent(int i) {
        return i / 2;
    }

    /**
     * Devuelve el índice del hijo izquierdo de un nodo en el heap.
     *
     * @param i El índice del nodo.
     * @return El índice del hijo izquierdo.
     */
    public int left(int i) {
        return i * 2;
    }

    /**
     * Devuelve el índice del hijo derecho de un nodo en el heap.
     *
     * @param i El índice del nodo.
     * @return El índice del hijo derecho.
     */
    public int right(int i) {
        return i * 2 + 1;
    }

    /**
     * Intercambia dos nodos en el heap.
     *
     * @param i El índice del primer nodo.
     * @param j El índice del segundo nodo.
     */
    public void swap(int i, int j) {
        Vertex temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        array[i].positionInMinHeap = i;
        array[j].positionInMinHeap = j;
    }

    /**
     * Mantiene la propiedad de min-heap a partir de un índice dado.
     *
     * @param i El índice a partir del cual se mantiene la propiedad de min-heap.
     */
    public void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if (l <= heapSize && array[l].distance < array[i].distance) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= heapSize && array[r].distance < array[smallest].distance) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    /**
     * Devuelve el vértice con la menor distancia en el heap.
     *
     * @return El vértice con la menor distancia.
     */
    public Vertex minHeapMinimum() {
        if (this.heapSize < 1) {
            System.out.println("Heap underflow");
            System.exit(1);
        }
        return array[1];
    }

    /**
     * Extrae y devuelve el vértice con la menor distancia en el heap.
     *
     * @return El vértice con la menor distancia.
     */
    public Vertex extractMin() {
        Vertex min = minHeapMinimum();
        min.positionInMinHeap = -1;
        array[1] = array[heapSize];
        this.heapSize--;
        minHeapify(1);
        return min;
    }

    /**
     * Disminuye la clave (distancia) de un vértice en el heap.
     *
     * @param i El índice del vértice en el heap.
     * @param key La nueva distancia.
     */
    public void minHeapDecreaseKey(int i, int key) {
        if (key > array[i].distance) {
            System.out.println("New key is greater than current key");
            System.exit(1);
        }
        array[i].distance = key;
        while (i > 1 && array[parent(i)].distance > array[i].distance) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Inserta un nuevo vértice en el heap.
     *
     * @param v El vértice a insertar.
     */
    public void minHeapInsert(Vertex v) {
        this.heapSize++;
        if (this.heapSize + 1 > array.length) {
            System.out.println("Heap overflow");
            System.exit(1);
        }
        array[heapSize] = v;
        v.positionInMinHeap = heapSize;
        minHeapDecreaseKey(this.heapSize, v.distance);
    }

    /**
     * Verifica si el heap está vacío.
     *
     * @return true si el heap está vacío, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    /**
     * Imprime el contenido del heap.
     */
    public void printMinHeap() {
        for (int i = 1; i <= heapSize; i++) {
            System.out.println(array[i]);
        }
    }
}
