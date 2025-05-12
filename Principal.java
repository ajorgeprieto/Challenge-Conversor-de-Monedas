import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n===== CONVERSOR DE MONEDAS CHALLENGE ALURA G8 =====");
            System.out.println("1. De Soles          =======> Dólares");
            System.out.println("2. De Dólares        ======> Soles");
            System.out.println("3. De Real de Brasil ======> Dólares");
            System.out.println("4. De Dólares        ======> Real de Brasil");
            System.out.println("5. De Won            ======> Dólares");
            System.out.println("6. De Dólares        ======> Won");
            System.out.println("7. Salir del Conversor del CHALLENGE DE ALURA G8");
            System.out.println("=====================================================");
            System.out.print("\nSeleccione una opción (1-7): ");


            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion >= 1 && opcion <= 6) {
                    System.out.print("Ingrese el monto de la moneda a convertir: ");
                    double monto = scanner.nextDouble();

                    String from = "", to = "";

                    switch (opcion) {
                        case 1: from = "PEN"; to = "USD"; break;
                        case 2: from = "USD"; to = "PEN"; break;
                        case 3: from = "BRL"; to = "USD"; break;
                        case 4: from = "USD"; to = "BRL"; break;
                        case 5: from = "KRW"; to = "USD"; break;
                        case 6: from = "USD"; to = "KRW"; break;
                    }

                    double resultado = conversor.convertir(from, to, monto);
                    System.out.printf("Resultado: %.2f %s = %.2f %s%n", monto, from, resultado, to);
                } else if (opcion != 7) {
                    System.out.println("Por favor ingrese un número válido entre 1 y 7.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine();
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrió un error al conectar con la API: " + e.getMessage());
            }
        }

        System.out.println("Gracias por usar el conversor del CHALLENGE DE ALURA G8.");
        scanner.close();
    }
}

