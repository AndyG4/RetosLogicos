
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Banco> bancos = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static final String RESET = "\u001B[0m";
    public static final String TITLE = "\u001B[1;36m";
    public static final String HEADER = "\u001B[1;34m";
    public static final String SUCCESS = "\u001B[1;32m";
    public static final String WARNING = "\u001B[1;33m";
    public static final String COMMAND = "\u001B[1;35m";
    public static final String URL = "\u001B[1;34;4m";  // Azul subrayado
    public static final String BANNER = "\u001B[1;35m"; // Magenta brillante
    public static void main(String[] args) throws IOException {


        
        bancos.add(new Banco(new Persona("Juan Perez", 30), 1000.0, "123456789"));
        bancos.add(new Banco(new Persona("Maria Lopez", 25), 2000.0, "987654321"));
        bancos.add(new Banco(new Persona("Carlos Gomez", 40), 1500.0, "456789123"));
        bancos.add(new Banco(new Persona("Ana Torres", 35), 3000.0, "321654987"));
        bancos.add(new Banco(new Persona("Luis Ramirez", 28), 500.0, "159753456"));

        System.out.println(BANNER + "Bienvenido al Sistema Bancario" + RESET);
        System.out.println(TITLE + "Desarrollado por:" + RESET);

        System.out.println(BANNER + "      o      oooo   oooo ooooooooo   ooooo  oooo   ooooooo8        o88 " + RESET);
        System.out.println(BANNER + "     888      8888o  88   888    88o   888  88   o888    88      o8888 " + RESET);
        System.out.println(BANNER + "    8  88     88 888o88   888    888     888     888    oooo   o88 888 " + RESET);
        System.out.println(BANNER + "   8oooo88    88   8888   888    888     888     888o    88  o888oo888oo" + RESET);
        System.out.println(BANNER + " o88o  o888o o88o    88  o888ooo88      o888o     888ooo888       o888o" + RESET);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
  

        try(FileWriter writer = new FileWriter("C:\\Users\\elmic\\OneDrive\\Documentos\\Nueva carpeta (3)\\banco.txt")) {
                bancos.get(2).setBanco("Banco Nacional");
                imprimirClientes();
                writer.write(sb.toString());
                System.out.println(SUCCESS + "Datos guardados en banco.txt" + RESET);
        } catch (IOException e) {
            
        }
        

        personaMasRica();


       

while (true) {
        System.out.println(COMMAND + "Ingrese un comando (listar, salir, ayuda, p, clear, fecha, b, pobre): " + RESET);
            Scanner scanner = new Scanner(System.in);

    String comando = scanner.nextLine().trim().toLowerCase();

    switch (comando) {
        case "listar":
            imprimirClientes();
            break;
        case "salir":
            System.out.println(SUCCESS + "Saliendo del sistema..." + RESET);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
            break;
        case "ayuda":
            System.out.println(WARNING + "Comandos disponibles:" + RESET);
            System.out.println("  - listar: Muestra la lista de clientes y sus detalles.");
            System.out.println("  - salir: Cierra el programa.");
            System.out.println("  - ayuda: Muestra esta lista de comandos.");
            System.out.println("  - p: Muestra el cliente con mayor saldo.");
            System.out.println("  - clear: Limpia la consola.");
            System.out.println("  - fecha: Muestra la fecha actual desde el CMD.");
            System.out.println("  - b: Muestra el banner del sistema.");
            System.out.println("  - pobre: Muestra el cliente con menor saldo.");

            break;
        case "p":
            personaMasRica();
            break;
        case "clear":
            limpiarConsola();
            break;
        case "fecha":
            mostrarFechaDesdeCMD();
            break;
        case "b":
            imprimirBanner();
            break;
        case "mas pobre":
            mostrarMasPobre();
            break;
        default:
            System.out.println(WARNING + "Comando no reconocido. Escribe 'ayuda' para ver opciones." + RESET);
    }
}


        
    }

    public static void limpiarConsola() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (Exception e) {
        System.out.println("No se pudo limpiar la consola.");
    }
}

static void mostrarMasPobre(){
    Banco maspobre = bancos.get(0);
    for (Banco banco : bancos) {
        if (banco.getSaldo() < maspobre.getSaldo()) {
            maspobre = banco;
        }
    }
    System.out.println(SUCCESS + "Cliente más pobre: " + maspobre.getCliente().getNombre() + " con saldo de " + maspobre.getSaldo() + RESET);
}
public static void mostrarFechaDesdeCMD() {
    try {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "date /T"); // Solo muestra la fecha sin pedir modificarla
        pb.redirectErrorStream(true); // Une la salida de error y estándar
        Process proceso = pb.start();

        Scanner scanner = new Scanner(proceso.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine()); // Muestra la salida línea por línea
        }
        scanner.close();
        proceso.waitFor();
    } catch (Exception e) {
        System.out.println("No se pudo obtener la fecha desde el CMD.");
    }
}


    static void imprimirClientes() {
        
        sb.append(BANNER).append("Lista de Clientes:").append(RESET).append("\n");
        System.out.println(SUCCESS + "Lista de Clientes:" + SUCCESS);
        for (Banco banco : bancos) {
            sb.append(BANNER).append("-".repeat(40)).append(RESET).append("\n");
            sb.append(HEADER).append(banco.getCliente().getNombre()).append(RESET).append("\n");
            sb.append("  Edad: ").append(banco.getCliente().getEdad()).append("\n");
            sb.append("  Saldo: ").append(banco.getSaldo()).append("\n");
            sb.append("  Cuenta: ").append(banco.getCuenta()).append("\n");
            sb.append("  Banco: ").append(banco.getBanco()).append("\n");
            sb.append(BANNER).append("-".repeat(40)).append(RESET).append("\n");


            System.out.println("\u001B[1;35m" + "-".repeat(40) + "\u001B[0m");
            System.out.println(HEADER + banco.getCliente().getNombre() + RESET);
            System.out.println("  Edad: " + banco.getCliente().getEdad());
            System.out.println("  Saldo: " + banco.getSaldo());
            System.out.println("  Cuenta: " + banco.getCuenta());
            System.out.println("  Banco: " + banco.getBanco());
            System.out.println("\u001B[1;35m" + "-".repeat(40) + "\u001B[0m");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        

    }
    static void personaMasRica() {
        Banco bancoMasRico = bancos.get(0);
        for (Banco banco : bancos) {
            if (banco.getSaldo() > bancoMasRico.getSaldo()) {
                bancoMasRico = banco;
            }
        }
        System.out.println(SUCCESS + "Cliente más rico: " + bancoMasRico.getCliente().getNombre() + " con saldo de " + bancoMasRico.getSaldo() + RESET);
    }

    static void imprimirBanner() {
        System.out.println(BANNER + "Bienvenido al Sistema Bancario" + RESET);
        System.out.println(TITLE + "Desarrollado por:" + RESET);
        System.out.println(BANNER + "      o      oooo   oooo ooooooooo   ooooo  oooo   ooooooo8        o88 " + RESET);
        System.out.println(BANNER + "     888      8888o  88   888    88o   888  88   o888    88      o8888 " + RESET);
        System.out.println(BANNER + "    8  88     88 888o88   888    888     888     888    oooo   o88 888 " + RESET);
        System.out.println(BANNER + "   8oooo88    88   8888   888    888     888     888o    88  o888oo888oo" + RESET);
        System.out.println(BANNER + " o88o  o888o o88o    88  o888ooo88      o888o     888ooo888       o888o" + RESET);
        System.out.println(BANNER + "-".repeat(40) + RESET);
    }
    
}

class Persona{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

class Banco{
    private Persona cliente;
    private double saldo;
    private String cuenta;
    private String banco = "Banco Central";

    public Banco(Persona cliente, double saldo, String cuenta) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }
    public Persona getCliente() {
        return cliente;
    }
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getCuenta() {
        return cuenta;
    }
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    @Override
    public String toString() {
        return "Banco{" +
                "cliente=" + cliente +
                ", saldo=" + saldo +
                ", cuenta='" + cuenta + '\'' +
                ", banco='" + banco + '\'' +
                '}';
    }

}