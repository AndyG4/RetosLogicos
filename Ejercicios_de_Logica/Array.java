import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Array {
    public static String[] array = new String[20];
    public static int pos1 = 0;
    static int pos2 = array.length - 1;
    static int direccion = 1;
    static int direccion2 = -1;
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String BLUE = "\033[34m";
    
    public static void main(String[] args) throws InterruptedException {
        // Limpiar pantalla una única vez al inicio
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Iniciar animación de Array en un hilo separado
        new Thread(() -> play()).start();
        
        // Iniciar animación de Matriz en el hilo principal
        Matriz matriz = new Matriz();
        matriz.play();
    }

    public static String hora() {
        return ZonedDateTime.now(ZoneId.of("America/Mexico_City"))
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public static void play() {
        while (true) {
            rellenar();
            imprimir();
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rellenar() {
        for (int i = 0; i < array.length; i++) {
            array[i] = " ";
        }
        array[pos1] = ".";
        array[pos2] = BLUE + "-" + RESET;

        pos1 += direccion;
        if (pos1 >= array.length - 1 || pos1 <= 0) {
            direccion *= -1;
        }
        pos2 += direccion2;
        if (pos2 >= array.length - 1 || pos2 <= 0) {
            direccion2 *= -1;
        }
    }

    public static void imprimir() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        String animacion = sb.toString() + "  " + hora();
        // Posicionar en línea 1 y sobrescribir
        System.out.print("\033[1;0H" + animacion);
        System.out.flush();
    }
}

class Matriz {
    public static String[][] matriz = new String[5][5];
    public static int pos1 = 0; 
    public static int pos3 = 0;
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";

    public static void rellenar() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "     "; // Espacios para mantener formato
            }
        }
        matriz[pos1][pos3] = RED + "  X  " + RESET;
    }
    
    public static void imprimir() {
        // Posicionar en línea 3 antes de imprimir
        System.out.print("\033[3;0H");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        System.out.flush();
    }

    public static void play() throws InterruptedException {
        int estado = 0;
        pos1 = 0;
        pos3 = 0;

        while (true) { 
            rellenar();
            imprimir();
            Thread.sleep(33);
            
            switch(estado) {
                case 0: pos3++; break;
                case 1: pos1++; break;
                case 2: pos3--; break;
                case 3: pos1--; break;
            }
            
            if (estado == 0 && pos3 == matriz[0].length - 1) estado = 1;
            else if (estado == 1 && pos1 == matriz.length - 1) estado = 2;
            else if (estado == 2 && pos3 == 0) estado = 3;
            else if (estado == 3 && pos1 == 0) estado = 0;
        }
    }
}