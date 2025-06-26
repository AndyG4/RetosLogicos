import java.security.*;

public class Hash {
    public static final  String COLOR = "\u001B[32m"; 
    public static final  String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String ITALIC = "\u001B[3m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";
    public static final String BOLD_RED = "\u001B[1;31m";
    public static final String BOLD_GREEN = "\u001B[1;32m";
    public static final String BOLD_YELLOW = "\u001B[1;33m";
    public static void main(String[] args){

        System.out.println("=".repeat(50));
        System.out.println(" ".repeat(21)+COLOR+"Hashing "+RESET);
        System.out.println("=".repeat(50));

        cuadrado();
        String sa = hashing("pilin");
        System.out.println("Hash SHA3-256: " + BOLD_RED+sa+ RESET);
        System.out.println("=".repeat(sa.length()+21));
        System.out.println(" ".repeat(21)+COLOR+"Fin del programa "+RESET);

        
    }



    public static String hashing(String texto){
        String salida = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA3-512");
            byte [] hash = digest.digest(texto.getBytes());
            StringBuilder hexString = new StringBuilder();  

            for(byte b : hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1)  hexString.append('0');
                hexString.append(hex);
            }
            salida = hexString.toString().trim();

        } catch (NoSuchAlgorithmException e) {
        }
        return salida;
    }   

public static void cuadrado() {
    int ancho = 50; // Ancho del cuadro

    String mensaje = "Este es el sha3-256";
    int padding = (50 - mensaje.length()) / 2;
    System.out.println("|" + " ".repeat(padding) + mensaje + " ".repeat(50 - mensaje.length() - padding) + "|");

   for (int i = 0; i < 9; i++) {
        if (i == 2) { 
            String texto = "Texto dentro del cuadro";
            int paddinga = (ancho - texto.length()) / 2;
            System.out.println("|" + " ".repeat(paddinga) +COLOR+ texto +RESET + 
                               " ".repeat(ancho - texto.length() - paddinga) + "|");
        } else if (i == 4) {
            String texto = "pilin";
            int paddinga = (ancho - texto.length()) / 2;
                System.out.println("|" + " ".repeat(paddinga) +COLOR+ texto +RESET + 
                               " ".repeat(ancho - texto.length() - paddinga) + "|");
        } else {
            System.out.println("|" + " ".repeat(ancho) + "|");
        }
    }

    // Línea inferior
    System.out.println("_".repeat(52)); // 50 espacios + 2 bordes (|)

    // Espacio extra
    System.out.println("\n\n\n");
}

}
