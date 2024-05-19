import java.util.Scanner;

public class TestG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        G g = new G();
        g.readGraph("src\\resources\\distanciasB.txt");

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
                    runBellmanFord(g, scanner);
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

    public static void runBellmanFord(G g, Scanner scanner) {
        System.out.println("Ingrese el número de la ciudad de origen:");
        int sourceNode = scanner.nextInt();
        System.out.println("Ingrese el número de la ciudad de destino:");
        int destinationNode = scanner.nextInt();
    
        // Toma la hora actual antes de la ejecución
        long startTime = System.nanoTime();
    
        BellmanFordG bellmanFordG = new BellmanFordG();
        bellmanFordG.V = g.V;
        bellmanFordG.adj = g.adj;
    
        bellmanFordG.bellmanFord(sourceNode, destinationNode);
    
        // Toma la hora actual después de la ejecución
        long endTime = System.nanoTime();
    
        // Calcula la duración y la imprime
        long duration = endTime - startTime;
        System.out.println("El proceso se demoró " + duration + " nanosegundos.");
    }

    public static void runDijkstra(G g, Scanner scanner) {
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
