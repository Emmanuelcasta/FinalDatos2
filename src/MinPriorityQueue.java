/**
 * MinPriorityQueue
 * Keep a min priority queue of vertices based on their distance from the source vertex
 * The vertices are stored in an array
 * This is used for Dijkstra's algorithm
 */

 public class MinPriorityQueue {
    Vertex [] array;
    int heapSize;

    public MinPriorityQueue(int heapSize) {
        array = new Vertex[heapSize+1];
        this.heapSize = 0;
    }

    public int parent(int i) {
        return i/2;
    }

    public int left(int i) {
        return i * 2;
    }

    public int right(int i) {
        return i * 2 + 1;
    }

    public void swap(int i, int j) {
        Vertex temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        array[i].positionInMinHeap = i;
        array[j].positionInMinHeap = j;
    }

    public void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if(l <= heapSize && array[l].distance < array[i].distance) {
            smallest = l;
        } else {
            smallest = i;
        }
        if(r <= heapSize && array[r].distance < array[smallest].distance) {
            smallest = r;
        }
        if(smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    
    public Vertex minHeapMinimum() {
        if(this.heapSize < 1) {
            System.out.println("Heap underflow");
            System.exit(1);
        }
        return array[1];
    }
    
    public Vertex extractMin() {
        Vertex min = minHeapMinimum();
        min.positionInMinHeap = -1;
        array[1] = array[heapSize];
        this.heapSize--;
        minHeapify(1);
        return min;
    }

    public void minHeapDecreaseKey(int i, int key) {    
        if(key > array[i].distance) {
            System.out.println("New key is greater than current key");
            System.exit(1);
        }
        array[i].distance = key;
        while(i > 1 && array[parent(i)].distance > array[i].distance) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void minHeapInsert(Vertex v) {
        this.heapSize++;
        if(this.heapSize + 1 > array.length) {
            System.out.println("Heap overflow");
            System.exit(1);
        }
        array[heapSize] = v;
        v.positionInMinHeap = heapSize;
        minHeapDecreaseKey(this.heapSize, v.distance);
    }

    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    public void printMinHeap() {
        for(int i = 1; i <= heapSize; i++) {
            System.out.println(array[i]);
        }
    }
}