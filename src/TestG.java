public class TestG {
    public static void main(String [] args) {
        G g = new G();
        g.readGraph("src\\resources\\graphNew.txt");
        g.initializeSingleSource(1);
        g.printGraph();
        g.printVertices();
    }
}
