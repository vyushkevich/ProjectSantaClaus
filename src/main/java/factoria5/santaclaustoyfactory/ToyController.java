package factoria5.santaclaustoyfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyController {
    private final List<Toy> toys = new ArrayList<>();

    public void addToy(Scanner scanner) {
        System.out.print("Introduce el nombre del juguete: ");
        String name = scanner.nextLine();
        Toy toy = new Toy(name);
        toys.add(toy);
        System.out.println("Juguete añadido: " + name);
    }

    public void viewAllToys() {
        if (toys.isEmpty()) {
            System.out.println("No hay juguetes.");
            return;
        }
        System.out.println("Lista de juguetes:");
        for (Toy toy : toys) {
            System.out.println("- " + toy.getName());
        }
    }

    public void removeToy(Scanner scanner) {
        System.out.print("Introduce el nombre del juguete a eliminar: ");
        String name = scanner.nextLine();
        toys.removeIf(toy -> toy.getName().equals(name));
        System.out.println("Juguete eliminado: " + name);
    }
}
