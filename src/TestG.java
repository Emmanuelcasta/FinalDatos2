import java.util.Scanner;

public class TestG {
    public static void main(String[] args) {
        G g = new G();
        g.readGraph("src\\resources\\distancias.txt");
        Scanner scanner = new Scanner(System.in);
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

        scanner.close();
    }
}