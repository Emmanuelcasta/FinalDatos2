import java.util.Scanner;
public class TestG {
    public static void main(String [] args) {
        G g = new G();
        g.readGraph("src\\resources\\distancias.txt");
        g.initializeSingleSource(1);
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el número de la ciudad de origen");
        int sourceNode = sc.nextInt();
        System.out.println("ingrese el número de la ciudad de destino");
        int destinationNode = sc.nextInt();
        

        //toma la hora actual antes de la ejecucuón
        long startTime = System.currentTimeMillis();
        g.dijkstra(sourceNode,destinationNode);
        
        //toma la hora actual después de la ejecucuón
        long endTime = System.currentTimeMillis();

        //calcula el tiempo de ejecución
        long duration = (endTime - startTime);
        System.out.println("Tiempo de ejecución: "+duration+" milisegundos");
        sc.close();
    }
    //Arauca por 1 
    //Armenia por 2
    //Barranquilla por 3
    //Bogota por 4 
    //Bucaramanga por 5 
    //Cali por 6 
    //Cartagena por 7 
    //Cucuta por 8 
    //Florencia por 9
    //Ibague por 10
    //Manizales por 11
    //Medellin por 12
    //Monteria por 13
    //Mocoa por 14
    //Neiva por 15
    //Pasto por 16 
    //Pereira por 17 
    //Popayan por 18 
    //Quibdo por 19 
    //Riohacha por 20 
    //Santa Marta por 21
    //Sincelejo por 22 
    //Tunja por 23 
    //Valledupar por 24 
    //Villavicencio por 25
    //Yopal por 26 
}
