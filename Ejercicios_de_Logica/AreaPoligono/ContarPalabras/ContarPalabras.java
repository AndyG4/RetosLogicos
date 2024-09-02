public class ContarPalabras {
    public static void main(String[] args) {
        String palabras[] = {"Hola", "andy", "hola", "Felicidades", "Hola", "Andy"};

        for (int i = 0; i < palabras.length; i++) {
            int contador = 0;
            boolean yaContada = false;

            // Verificar si la palabra ya fue contada anteriormente
            for (int k = 0; k < i; k++) {
                if (palabras[i].equalsIgnoreCase(palabras[k])) {
                    yaContada = true;
                    break;
                }
            }

            // Si no ha sido contada, procedemos a contarla
            if (!yaContada) {
                for (int j = 0; j < palabras.length; j++) {
                    if (palabras[i].equalsIgnoreCase(palabras[j])) {
                        contador++;
                    }
                }

                // Imprimimos el resultado para la palabra actual
                System.out.println("La palabra: " + palabras[i] + ", se repite: " + contador + " veces");
            }
        }
    }
}
