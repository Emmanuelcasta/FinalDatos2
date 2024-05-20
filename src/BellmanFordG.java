import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BellmanFordG {
    public Vertex[] V;
    public Edge[] adj;

    public void addEdge(int u, int v, int w) {
        Edge e = new Edge(v, w);
        if (adj[u] == null) {
            adj[u] = e;
        } else {
            Edge current = adj[u];
            while (current.next != null) {
                current = current.next;
            }
            current.next = e;
        }
    }

    public void initializeSingleSource(int s) {
        for (int i = 1; i < V.length; i++) {
            V[i] = new Vertex(i, Integer.MAX_VALUE, -1);
        }
        V[s].distance = 0;
    }

    public void bellmanFord(int source, int destination) {
        initializeSingleSource(source);
    
        for (int i = 1; i < V.length; i++) {
            for (int j = 1; j < adj.length; j++) {
                Edge edge = adj[j];
                while (edge != null) {
                    int v = edge.v;
                    int w = edge.w;
                    if (V[j].distance != Integer.MAX_VALUE && V[v].distance > V[j].distance + w) {
                        V[v].distance = V[j].distance + w;
                        V[v].pi = j;
                    }
                    edge = edge.next;
                }
            }
        }

        // Check for negative cycles
        for (int j = 1; j < adj.length; j++) {
            Edge edge = adj[j];
            while (edge != null) {
                int v = edge.v;
                int w = edge.w;
                if (V[j].distance != Integer.MAX_VALUE && V[v].distance > V[j].distance + w) {
                    System.out.println("El grafo contiene un ciclo negativo");
                    return ;
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
        while (currentVertex != -1) {
            if (path.length() > 0) {
                path.insert(0, " -> ");
            }
            path.insert(0, currentVertex);
            currentVertex = V[currentVertex].pi;
        }
        System.out.println("El camino más corto desde " + source + " hasta " + destination + " es: ");
        System.out.println(path.toString());
        System.out.println("La distancia total es: " + V[destination].distance);
    }
}

