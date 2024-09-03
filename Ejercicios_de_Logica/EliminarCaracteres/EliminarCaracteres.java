public class EliminarCaracteres {
    public static void main(String[] args) {
        String a = "CaracteresunoDos";
        String b = "CaracterDosAlfrEDo";
       
        String resultado1 = eliminarCaracteresComunes(a, b);
        String resultado2 = eliminarCaracteresComunes(b, a);

        System.out.println(resultado1);
        System.out.println(resultado2);
    }

    static String eliminarCaracteresComunes(String a, String b) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            boolean contiene = false;
            for (int j = 0; j < b.length(); j++) {
                if (c == b.charAt(j)) {
                    contiene = true;
                    break;
                }
            }
            if (!contiene) {
                out.append(c);
            }
        }

        return out.toString();
    }
}
