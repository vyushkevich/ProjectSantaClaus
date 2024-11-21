package factoria5.santaclaustoyfactory.controller;

import factoria5.santaclaustoyfactory.model.Toy;
import factoria5.santaclaustoyfactory.model.ToyRepository;

import java.util.List;
import java.util.Scanner;

public class ToyController {
    private ToyRepository toyRepository;

    // Конструктор
    public ToyController(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    // Добавление игрушки для хороших детей
    public void addToyForGood() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el título: ");
            String title = scanner.nextLine();
            System.out.print("Ingrese la marca: ");
            String brand = scanner.nextLine();
            System.out.print("Ingrese la edad recomendada: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese la categoría: ");
            String category = scanner.nextLine();

            toyRepository.addToy(new Toy(title, brand, age, category));
            System.out.println("Juguete añadido con éxito");
        }
    }

    // Добавление игрушки для плохих детей
    public void addToyForBad() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el título: ");
            String title = scanner.nextLine();
            System.out.print("Ingrese el contenido: ");
            String content = scanner.nextLine();

            toyRepository.addToy(new Toy(title, content, false));
            System.out.println("Juguete añadido con éxito");
        }
    }

    // Просмотр всех игрушек
    public List<Toy> getAllToys() {
        return toyRepository.getAllToys();
    }

    // Удаление игрушки
    public void deleteToy() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el identificador del juguete a eliminar: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("El identificador no puede estar vacío.");
                return;
            }

            try {
                int toyId = Integer.parseInt(input);
                if (toyId >= 0 && toyId < toyRepository.getAllToys().size()) {
                    toyRepository.removeToy(toyId);
                    System.out.println("Juguete eliminado con éxito.");
                } else {
                    System.out.println("ID de juguete no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    // Просмотр игрушек для хороших детей
    public void viewGoodToys() {
        List<Toy> goodToys = toyRepository.getGoodToys();
        System.out.println("Lista de juguetes para niños buenos:");
        for (Toy toy : goodToys) {
            System.out.println(toy);
        }
    }

    // Просмотр игрушек для плохих детей
    public void viewBadToys() {
        List<Toy> badToys = toyRepository.getBadToys();
        System.out.println("Lista de juguetes para niños malos:");
        for (Toy toy : badToys) {
            System.out.println(toy);
        }
    }

    // Сохранение игрушек в CSV
    public void saveToysToCSV() {
        System.out.println("Juguetes guardados en CSV.");
    }

    public Object viewToys() {
        throw new UnsupportedOperationException("Unimplemented method 'viewToys'");
    }
}
