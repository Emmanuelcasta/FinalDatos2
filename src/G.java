import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class G {
    // Set of vertices
    Vertex [] V;
    // Adjacency list
    Edge [] adj;

    public void addEdge(int u, int v, int w) {
        Edge e = new Edge(v, w);
        e.next = adj[u];
        adj[u] = e;
    }

    public void initializeSingleSource(int s) {
        for(int i = 1; i < V.length; i++) {
            V[i] = new Vertex(i, Integer.MAX_VALUE, -1);
        }
        V[s].distance = 0;
    }

    public boolean relax(int u, int v, int w) {
        if(V[v].distance > V[u].distance + w) {
            V[v].distance = V[u].distance + w;
            V[v].pi = u;
            return true;
        }
        return false;
    }

    public void readGraph(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int n = sc.nextInt();
            int m = sc.nextInt();

            this.V = new Vertex[n+1];
            this.adj = new Edge[n+1];
            for(int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                addEdge(u, v, w);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printGraph() {
        for(int i = 1; i < adj.length; i++) {
            System.out.print(i + ": ");
            Edge e = adj[i];
            while(e != null) {
                System.out.print(e.v + " " + e.w + "; ");
                e = e.next;
            }
            System.out.println();
        }
    }

    public void printVertices() {
        for(int i = 1; i < V.length; i++) {
            System.out.println(V[i]);
        }
    }
    
}

