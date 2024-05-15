public class Vertex {
    public static final String cityName = null;
    int number;
    int distance;
    int pi;
    int positionInMinHeap;

    public Vertex(int number, int distance, int pi) {
        this.number = number;
        this.distance = distance;
        this.pi = pi;
        this.positionInMinHeap = -1;
    }

    public String toString() {
        return number + " " + distance + " " + pi + " " + positionInMinHeap;
    }
}

