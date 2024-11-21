package factoria5.santaclaustoyfactory.model;

import java.util.ArrayList;
import java.util.List;

public class ToyRepository {

    private final List<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    public List<Toy> getAllToys() {
        return toys;
    }

    public List<Toy> getGoodToys() {
        List<Toy> goodToys = new ArrayList<>();
        for (Toy toy : toys) {
            if ("Bueno".equals(toy.getType())) { // Исправлено сравнение
                goodToys.add(toy);
            }
        }
        return goodToys;
    }
    
    public List<Toy> getBadToys() {
        List<Toy> badToys = new ArrayList<>();
        for (Toy toy : toys) {
            if ("Malo".equals(toy.getType())) { // Исправлено сравнение
                badToys.add(toy);
            }
        }
        return badToys;
    }
    
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy() {
        if (!toys.isEmpty()) {
            toys.remove(toys.size() - 1);  // Удаляем последний элемент в списке
            System.out.println("Último juguete eliminado.");
        } else {
            System.out.println("No hay juguetes para eliminar.");
        }
    }
}
