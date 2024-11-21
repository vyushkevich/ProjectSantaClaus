package factoria5.santaclaustoyfactory.controller;

import factoria5.santaclaustoyfactory.model.Toy;
import factoria5.santaclaustoyfactory.model.ToyRepository;

public class ToyController {

    private final ToyRepository toyRepository;

    public ToyController(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public void viewToys() {
        System.out.println("Lista de juguetes:");
        for (Toy toy : toyRepository.getAllToys()) {
            System.out.println(toy);
        }
    }

    public void addToyForGood(String name, String description, int age) {
        Toy toy = new Toy(name, description, "Bueno", age);
        toyRepository.addToy(toy);
        System.out.println("Juguete añadido para niños buenos: " + toy);
    }
    
    public void addToyForBad(String name, String description, int age) {
        Toy toy = new Toy(name, description, "Malo", age);
        toyRepository.addToy(toy);
        System.out.println("Juguete añadido para niños malos: " + toy);
    }
    
    

    public void deleteToy() {
        System.out.println("Eliminando juguete...");
        toyRepository.removeToy();
    }

    public void viewGoodToys() {
        System.out.println("Lista de juguetes para niños buenos:");
        for (Toy toy : toyRepository.getGoodToys()) {
            System.out.println(toy);
        }
    }

    public void viewBadToys() {
        System.out.println("Lista de juguetes para niños malos:");
        for (Toy toy : toyRepository.getBadToys()) {
            System.out.println(toy);
        }
    }

    public void saveToysToCSV() {
        System.out.println("Guardando juguetes como CSV...");
        // Логика для сохранения в CSV
    }

    public Object getAllToys() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllToys'");
    }
}
