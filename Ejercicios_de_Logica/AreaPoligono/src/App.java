public class App {
    public static void main(String[] args) throws Exception {
        
        Cuadrado(20, 3);
        Triangulo(20, 3);
        Rectangulo(20, 3);
    }
    static void Cuadrado(int b, int c){
        double Cuadrado = b*c;
        System.out.println("Cuadrado: "+Cuadrado);
    }
    static void Triangulo(int b, int c){
        double Triangulo = (0.5)*b*c;
        System.out.println("Triangulo: "+Triangulo);

    }
    static void Rectangulo(int b, int c){
        double reactangulo = b*c;
        System.out.println("Rectangulo: "+reactangulo);
    }
    
}
