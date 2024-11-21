package factoria5.santaclaustoyfactory.app;

import factoria5.santaclaustoyfactory.controller.ToyController;
import factoria5.santaclaustoyfactory.model.ToyRepository;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ToyRepository toyRepository = new ToyRepository();
            ToyController toyController = new ToyController(toyRepository);  // Передаем репозиторий
            App app = new App();

            while (true) {
                app.printMainMenu();
                int sessionType = app.getValidatedInput(scanner);

                switch (sessionType) {
                    case 1 -> app.elfoSession(toyController, scanner);
                    case 2 -> app.santaSession(toyController, scanner);
                    default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
        }
    }

    private void printMainMenu() {
        System.out.println("Iniciar sesión de trabajo como:");
        System.out.println("1. Elfo");
        System.out.println("2. Santa Claus");
        System.out.print("Seleccione una opción: ");
    }

    private void elfoSession(ToyController toyController, Scanner scanner) {
        while (true) {
            printElfoMenu();
            int option = getValidatedInput(scanner);

            switch (option) {
                case 1 -> addToySession(toyController, scanner);
                case 2 -> toyController.viewToys();
                case 3 -> toyController.deleteToy();
                case 4 -> {
                    System.out.println("Sesión cerrada correctamente.");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void printElfoMenu() {
        System.out.println("-----------");
        System.out.println("Gestor de juguetes (Tipo de sesión: Elfo)");
        System.out.println("1. Añadir juguete");
        System.out.println("2. Ver todos los juguetes");
        System.out.println("3. Eliminar juguete");
        System.out.println("4. Cerrar sesión");
        System.out.print("Seleccione una opción: ");
    }

    private void addToySession(ToyController toyController, Scanner scanner) {
        System.out.print("Ingrese el nombre del juguete: ");
        String name = scanner.nextLine();
    
        System.out.print("Ingrese la descripción del juguete: ");
        String description = scanner.nextLine();
    
        System.out.print("Ingrese la edad del niño (en años): ");
        int age = getValidatedInput(scanner);
    
        System.out.println("Para niño ...:");
        System.out.println("1. Bueno");
        System.out.println("2. Malo");
        System.out.print("Seleccione una opción: ");
        int toyType = getValidatedInput(scanner);
    
        switch (toyType) {
            case 1 -> toyController.addToyForGood(name, description, age);
            case 2 -> toyController.addToyForBad(name, description, age);
            default -> System.out.println("Opción no válida.");
        }
    }
    
    

    private void santaSession(ToyController toyController, Scanner scanner) {
        while (true) {
            printSantaMenu();
            int option = getValidatedInput(scanner);

            switch (option) {
                case 1 -> toyController.viewGoodToys();
                case 2 -> toyController.viewBadToys();
                case 3 -> toyController.saveToysToCSV();
                case 4 -> {
                    System.out.println("Sesión cerrada correctamente.");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void printSantaMenu() {
        System.out.println("-----------");
        System.out.println("Gestor de juguetes (Tipo de sesión: Santa)");
        System.out.println("1. Ver lista de juguetes niños buenos");
        System.out.println("2. Ver lista de juguetes niños malos");
        System.out.println("3. Guardar juguetes como CSV");
        System.out.println("4. Cerrar sesión");
        System.out.print("Seleccione una opción: ");
    }

    private int getValidatedInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
