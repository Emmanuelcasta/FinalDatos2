public class TestG {
    public static void main(String [] args) {
        G g = new G();
        g.readGraph("src\\resources\\distancias.txt");
        g.initializeSingleSource(1);
        g.printGraph();
        //g.printVertices();
        g.printShortestDistances();
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
