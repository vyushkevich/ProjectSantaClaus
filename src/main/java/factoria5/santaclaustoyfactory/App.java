package factoria5.santaclaustoyfactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ToyRepository toyRepository = new ToyRepository();
            ToyController toyController = new ToyController(toyRepository);

            System.out.println("Iniciar sesión de trabajo como:");
            System.out.println("1. Elfo");
            System.out.println("2. Santa Claus");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            if (option == 1) {
                toyController.handleElfActions(scanner); // Передаем объект Scanner
            } else if (option == 2) {
                System.out.println("Gestor de juguetes (Tipo de sesión: Santa)");
                // Логика для действий Санты
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
