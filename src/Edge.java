public class Edge {
    int v;      // destination vertex
    int w;      // weight
    Edge next;  // next edge in the list

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}