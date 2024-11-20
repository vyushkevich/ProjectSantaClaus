package factoria5.santaclaustoyfactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToyController toyController = new ToyController();

        System.out.println("Gestor de juguetes (Tipo de sesión: Santa)");
        System.out.println("1. Añadir juguete");
        System.out.println("2. Ver todos los juguetes");
        System.out.println("3. Eliminar un juguete");
        System.out.println("4. Salir");

        while (true) {
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Очистка строки ввода

            switch (option) {
                case 1:
                    toyController.addToy(scanner);
                    break;
                case 2:
                    toyController.viewAllToys();
                    break;
                case 3:
                    toyController.removeToy(scanner);
                    break;
                case 4:
                    System.out.println("¡Feliz Navidad!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }
}
