public class TestG {
    public static void main(String [] args) {
        G g = new G();
        g.readGraph("graph1.txt");
        g.initializeSingleSource(1);
        g.printGraph();
        g.printVertices();
    }
}
