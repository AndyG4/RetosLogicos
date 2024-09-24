import java.util.Scanner;

public class OperacionBinarios {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Ingrese una operación binaria (por ejemplo, (1001)-(100), (1001)+(100), (1001)*(100)), o escriba 'exit' para salir:");

        while (true) {
            System.out.print("Operación: ");
            input = scanner.nextLine();

            // Finaliza el programa si se ingresa "exit"
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Saliendo del programa.");
                break;
            }

            // Eliminar paréntesis y espacios
            input = input.replaceAll("[()\\s]", "");

            // Determinar el tipo de operación
            char operator;
            if (input.contains("+")) {
                operator = '+';
            } else if (input.contains("-")) {
                operator = '-';
            } else if (input.contains("*")) {
                operator = '*';
            } else {
                System.out.println("Operación no válida. Intente de nuevo.");
                continue;
            }

            // Dividir la cadena según el operador
            String[] parts = input.split("[+\\-*]");
            if (parts.length != 2) {
                System.out.println("Error en la entrada. Intente de nuevo.");
                continue;
            }

            // Convertir binarios a enteros
            int num1 = Integer.parseInt(parts[0], 2);
            int num2 = Integer.parseInt(parts[1], 2);
            int result = 0;

            // Realizar la operación según el operador
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
            }

            // Convertir el resultado a binario
            String binaryResult = Integer.toBinaryString(result);

            // Mostrar el procedimiento
            System.out.println("Procedimiento:");
            System.out.println("1. Primer número (binario): " + parts[0] + " = " + num1 + " (decimal)");
            System.out.println("2. Segundo número (binario): " + parts[1] + " = " + num2 + " (decimal)");
            System.out.print("3. Operación: " + num1 + " " + operator + " " + num2 + " = " + result + " (decimal)");
            System.out.println(" = " + binaryResult + " (binario)");

            // Mostrar el resultado
            System.out.println("Resultado binario: " + binaryResult);
        }

        scanner.close();
    }
}
