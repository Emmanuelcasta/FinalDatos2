/**
 * La clase Edge representa una arista en un grafo con un peso asociado.
 * Se usa en la lista de adyacencia para representar las conexiones entre los vértices.
 */
class Edge {
    
    /**
     * El vértice de destino de la arista.
     */
    int v;
    
    /**
     * El peso de la arista.
     */
    int w;
    
    /**
     * La siguiente arista en la lista de adyacencia.
     */
    Edge next;

    /**
     * Constructor para crear una nueva arista con un vértice de destino y un peso.
     *
     * @param v El vértice de destino.
     * @param w El peso de la arista.
     */
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
        this.next = null;
    }
}
