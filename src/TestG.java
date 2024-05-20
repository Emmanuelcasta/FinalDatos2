import java.util.Scanner;

/**
 * La clase TestG proporciona un menú para seleccionar y ejecutar algoritmos 
 * de caminos más cortos, incluyendo el algoritmo de Bellman-Ford y el algoritmo de Dijkstra.
 */
public class TestG {
    
    /**
     * Método principal que inicia el programa y proporciona un menú para seleccionar 
     * los algoritmos de caminos más cortos.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        G g = new G();
        BellmanFordG B = new BellmanFordG();
        
        int choice;
        do {
            System.out.println("Seleccione el algoritmo para encontrar el camino más corto:");
            System.out.println("1. Algoritmo de Bellman-Ford");
            System.out.println("2. Algoritmo de Dijkstra");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runBellmanFord(B, scanner);
                    break;
                case 2:
                    runDijkstra(g, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

    /**
     * Ejecuta el algoritmo de Bellman-Ford para encontrar el camino más corto entre 
     * dos nodos en un grafo leído desde un archivo.
     *
     * @param B El objeto BellmanFordG que contiene el grafo.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public static void runBellmanFord(BellmanFordG B, Scanner scanner) {
        B.readGraph("src\\resources\\graphNew.txt");
        System.out.println("Ingrese el número de la ciudad de origen:");
        int sourceNode = scanner.nextInt();
        System.out.println("Ingrese el número de la ciudad de destino:");
        int destinationNode = scanner.nextInt();

        // Toma la hora actual antes de la ejecución
        long startTime = System.nanoTime();

        BellmanFordG graph = new BellmanFordG();
        graph.V = B.V;
        graph.adj = B.adj;

        graph.bellmanFord(sourceNode, destinationNode);

        // Toma la hora actual después de la ejecución
        long endTime = System.nanoTime();

        // Calcula la duración y la imprime
        long duration = endTime - startTime;
        System.out.println("El proceso se demoró " + duration + " nanosegundos.");
    }

    /**
     * Ejecuta el algoritmo de Dijkstra para encontrar el camino más corto entre 
     * dos nodos en un grafo leído desde un archivo.
     *
     * @param g El objeto G que contiene el grafo.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public static void runDijkstra(G g, Scanner scanner) {
        g.readGraph("src\\resources\\graphNew.txt");
        System.out.println("Ingrese el número de la ciudad de origen:");
        int sourceNode = scanner.nextInt();
        System.out.println("Ingrese el número de la ciudad de destino:");
        int destinationNode = scanner.nextInt();

        // Toma la hora actual antes de la ejecución
        long startTime = System.nanoTime();

        g.dijkstra(sourceNode, destinationNode);

        // Toma la hora actual después de la ejecución
        long endTime = System.nanoTime();

        // Calcula la duración y la imprime
        long duration = endTime - startTime;
        System.out.println("El proceso se demoró " + duration + " nanosegundos.");
    }
}
