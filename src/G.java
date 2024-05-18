import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class G {
    // Set of vertices
    Vertex[] V;
    // Adjacency list
    Edge[] adj;

    public void addEdge(int u, int v, int w) {
        Edge e = new Edge(v, w);
        e.next = adj[u];
        adj[u] = e;
    }

    public void initializeSingleSource(int s) {
        for (int i = 1; i < V.length; i++) {
            V[i] = new Vertex(i, Integer.MAX_VALUE, -1);
        }
        V[s].distance = 0;
    }

    public boolean relax(int u, int v, int w) {
        if (V[v].distance > V[u].distance + w) {
            V[v].distance = V[u].distance + w;
            V[v].pi = u;
            return true;
        }
        return false;
    }

    public void dijkstra(int source, int destination) {
        initializeSingleSource(source);
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue(V.length);
        for (int i = 1; i < V.length; i++) {
            minPriorityQueue.minHeapInsert(V[i]);
        }

        while (!minPriorityQueue.isEmpty()) {
            Vertex u = minPriorityQueue.extractMin();
            Edge edge = adj[u.number];
            while (edge != null) {
                int v = edge.v;
                int w = edge.w;
                if (relax(u.number, v, w)) {
                    minPriorityQueue.minHeapDecreaseKey(V[v].positionInMinHeap, V[v].distance);
                }
                edge = edge.next;
            }
        }
        printShortestPath(source, destination);
    }

    public void readGraph(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
    
            // Leer el número de vértices y el número de aristas
            int n = sc.nextInt();
            int m = sc.nextInt();
    
            // Inicializar el array de vértices y la lista de adyacencia
            this.V = new Vertex[n + 1];
            this.adj = new Edge[n + 1];
    
            // Leer las aristas y agregarlas al grafo
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                addEdge(u, v, w);
            }
    
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printShortestPath(int source, int destination) {
        StringBuilder path = new StringBuilder();
        int currentVertex = destination;
        while (V[currentVertex].pi != -1) {
            path.insert(0, currentVertex);
            if (V[currentVertex].pi != -1) {
                path.insert(0, " -> ");
            }
            currentVertex = V[currentVertex].pi;
        }
        path.insert(0, currentVertex);
        System.out.println("El camino más corto desde " + source + " hasta " + destination + " es: ");
        System.out.println(path.toString());
        System.out.println("La distancia total es: " + V[destination].distance);
    }
}