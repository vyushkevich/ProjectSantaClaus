package factoria5.santaclaustoyfactory;

import java.util.Scanner;

public class ToyController {
    private ToyRepository toyRepository;

    public ToyController(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public void handleElfActions(Scanner scanner) {
        boolean running = true;
    
        while (running) {
            System.out.println("Gestor de juguetes (Tipo de sesión: Elfo)");
            System.out.println("1. Añadir juguete");
            System.out.println("2. Ver todos los juguetes");
            System.out.println("3. Eliminar juguete");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    handleAddToy(scanner);
                    break;
                case 2:
                    handleViewToys();
                    break;
                case 3:
                    handleDeleteToy(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Sesión cerrada correctamente.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    

    private void handleAddToy(Scanner scanner) {
        System.out.println("Para niño ...:");
        System.out.println("1. Bueno");
        System.out.println("2. Malo");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (option == 1) {
            System.out.print("Ingrese el título: ");
            String title = scanner.nextLine();
            System.out.print("Ingrese la marca: ");
            String brand = scanner.nextLine();
            System.out.print("Ingrese la edad recomendada: ");
            String age = scanner.nextLine();
            System.out.print("Ingrese la categoria: ");
            String category = scanner.nextLine();
            Toy toy = new Toy(title, brand, age, category);
            toyRepository.addGoodToy(toy);
            System.out.println("Juguete añadido con éxito.");
        } else if (option == 2) {
            System.out.print("Ingrese el título: ");
            String title = scanner.nextLine();
            System.out.print("Ingrese el contenido: ");
            String content = scanner.nextLine();
            Toy toy = new Toy(title, content);
            toyRepository.addBadToy(toy);
            System.out.println("Juguete añadido con éxito.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void handleViewToys() {
        System.out.println("Lista de juguetes:");
        toyRepository.getGoodToys().forEach(System.out::println);
        toyRepository.getBadToys().forEach(System.out::println);
    }

    private void handleDeleteToy(Scanner scanner) {
        System.out.print("Ingrese el identificador del juguete a eliminar: ");
        String identifier = scanner.nextLine();
        toyRepository.deleteToy(identifier);
        System.out.println("Juguete eliminado con éxito.");
    }
}
