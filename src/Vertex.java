/**
 * La clase Vertex representa un vértice en un grafo con propiedades adicionales utilizadas
 * en algoritmos de caminos más cortos como Dijkstra y Bellman-Ford.
 */
public class Vertex {
    
    /**
     * El nombre de la ciudad asociada con el vértice.
     * Actualmente, este valor es null.
     */
    public static final String cityName = null;

    /** El número del vértice. */
    int number;

    /** La distancia desde el vértice fuente en algoritmos de caminos más cortos. */
    int distance;

    /** El predecesor del vértice en el camino más corto. */
    int pi;

    /** La posición del vértice en el heap mínimo. */
    int positionInMinHeap;

    /**
     * Constructor para inicializar un vértice con su número, distancia inicial y predecesor.
     *
     * @param number El número del vértice.
     * @param distance La distancia desde el vértice fuente. Se inicializa a un valor alto (como Integer.MAX_VALUE) para representar el infinito.
     * @param pi El predecesor del vértice en el camino más corto. Se inicializa a -1.
     */
    public Vertex(int number, int distance, int pi) {
        this.number = number;
        this.distance = distance;
        this.pi = pi;
        this.positionInMinHeap = -1;
    }

    /**
     * Devuelve una representación en cadena del vértice.
     * 
     * @return Una cadena que contiene el número del vértice, la distancia, el predecesor y la posición en el heap.
     */
    public String toString() {
        return number + " " + distance + " " + pi + " " + positionInMinHeap;
    }
}
