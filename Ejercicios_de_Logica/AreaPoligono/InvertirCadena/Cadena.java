public class Cadena {
    public static void main(String[] args) {
        String a = "Hola mundo";
        char invertir [] = a.toCharArray();

        for (int i = a.length()-1; i >= 0; i--) {
            System.out.print(Character.toString(invertir[i]));
        }
    }
}
