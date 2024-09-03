public class Dominio {
    public static void main(String[] args) {
        String a = "{ [ a * ( c + d ) ] - 5 }";
        String b = "{ [ a *  c + d ) ] - 5 }";

        System.out.println(equilibrada(a));
        System.out.println(equilibrada(b));
    }

    static boolean equilibrada(String a){
        a = a.replaceAll("[^\\{\\}\\(\\)\\[\\]]", "");
        while (a.contains("{}")||a.contains("()")||a.contains("[]")) { 
           a= a.replace("()", "");
           a= a.replace("{}", "");
           a= a.replace("[]", "");
        }

        return a.isEmpty();
    }
}
