public class Rando {
    private static final String GREEN  = "\033[0;32m";
    private static final String RESET  = "\033[0m";
    private static final String RED    = "\033[0;31m";
    private static final String YELLOW = "\033[0;33m";
    private static final String BLUE   = "\033[0;34m";

    static boolean encontrado = true;
    static String[][] matriz;
    static String[] array = new String[50];
    
    // Variables para la animación de la barra
    static int posicion = 0;
    static int direccion = 1;
    static boolean grande = true;
    static String bolaAnterior = " ";

    public static void main(String[] args) throws InterruptedException {
        matriz = new String[5][5];
        // Inicializar barra
        for (int i = 0; i < array.length; i++) {
            array[i] = " ";
        }
        jugar();
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    static void rellenar() throws InterruptedException {
        // Limpiar matriz
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matriz[i][j] = " ";

        // Posiciones aleatorias
        int rx = random(0, 4), ry = random(0, 4);
        int ox = random(0, 4), oy = random(0, 4);
        while (rx == ox && ry == oy) {
            ox = random(0, 4);
            oy = random(0, 4);
        }

        matriz[rx][ry] = GREEN + "R" + RESET; // Ratón
        matriz[ox][oy] = RED   + "G" + RESET; // Gato

        encontrado = !(rx == ox && ry == oy);
        Thread.sleep(16);
    }

    static void imprimir() {
        // Limpiar pantalla y mover cursor a inicio
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Imprimir tablero
        System.out.println(GREEN + "╔" + "═══╦".repeat(4) + "═══╗" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.print(BLUE + "║" + RESET);
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + matriz[i][j] + " ");
                System.out.print(j < 4 ? BLUE + "║" + RESET : "");
            }
            System.out.println(BLUE + "║" + RESET);
            
            if (i < 4) {
                System.out.println(BLUE + "╠" + "═══╬".repeat(4) + "═══╣" + RESET);
            }
        }
        System.out.println(GREEN + "╚" + "═══╩".repeat(4) + "═══╝" + RESET);
        System.out.println(BLUE + "GATO VS RATON" + RESET);
        
        // Imprimir barra de animación
        System.out.print("  ");
        for (String s : array) {
            System.out.print(s);
        }
        System.out.println();
    }

    static void actualizar() throws InterruptedException {
        rellenar();
        actualizarBarra();  // Actualiza la posición de la bola
        imprimir();
        Thread.sleep(100);
    }

    static void jugar() throws InterruptedException {
        while (encontrado) {
            actualizar();
        }
        System.out.println(RED + "\n¡Valió roña, el gato atrapó al ratón!" + RESET);
    }

    // Actualiza la posición de la bola en la barra
    static void actualizarBarra() {
        // Restaurar posición anterior
        array[posicion] = bolaAnterior;
        
        // Calcular nueva posición
        posicion += direccion;
        
        // Cambiar dirección en bordes
        if (posicion >= array.length - 1) {
            direccion = -1;
            posicion = array.length - 2;
        } else if (posicion <= 0) {
            direccion = 1;
            posicion = 1;
        }
        
        // Alternar tamaño
        grande = !grande;
        String bolaActual;
        if (grande) {
            bolaActual = BLUE + "O" + RESET;
        } else {
            bolaActual = YELLOW + "o" + RESET;
        }
        
        // Guardar estado actual para la siguiente iteración
        bolaAnterior = array[posicion];
        array[posicion] = bolaActual;
    }
}