public class Matriz {
    public  static  String[][] matriz = new String[5][5];
    public static int pos1 = 0; 
    public static int pos3 = 0;
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    

    public Matriz() {
        
    }
    public static void rellenar() {
        // Rellenar la matriz con coordenadas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "";
            }
        }
        // Colocar 'X' centrada en la posición actual
        matriz[pos1][pos3] = RED + "  X  " + RESET;
    }
    
    public static void imprimir() {
        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
            System.out.flush();
        }
    }

    public static void play() throws InterruptedException {
        int estado = 0; // 0: derecha, 1: abajo, 2: izquierda, 3: arriba
        pos1 = 0;
        pos3 = 0;

        while (true) { 
            // Limpiar pantalla para animación
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            rellenar();
            imprimir();
            Thread.sleep(100);
            
            // Actualizar posición según el estado
            switch(estado) {
                case 0: pos3++; break; // Derecha
                case 1: pos1++; break; // Abajo
                case 2: pos3--; break; // Izquierda
                case 3: pos1--; break; // Arriba
            }
            
            // Cambiar estado al llegar a las esquinas
            if (estado == 0 && pos3 == matriz[0].length - 1) estado = 1;
            else if (estado == 1 && pos1 == matriz.length - 1) estado = 2;
            else if (estado == 2 && pos3 == 0) estado = 3;
            else if (estado == 3 && pos1 == 0) estado = 0;
        }
    }
}