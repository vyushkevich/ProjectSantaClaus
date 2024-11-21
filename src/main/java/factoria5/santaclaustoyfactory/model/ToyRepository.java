package factoria5.santaclaustoyfactory.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyRepository {
    private List<Toy> toys;

    public ToyRepository() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public List<Toy> getAllToys() {
        return toys;  // Метод должен возвращать все игрушки
    }
    

    public void removeToy(int index) {
        if (index >= 0 && index < toys.size()) {
            toys.remove(index);
        }
    }

    public List<Toy> getGoodToys() {
        List<Toy> goodToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.isGoodToy()) {
                goodToys.add(toy);
            }
        }
        return goodToys;
    }

    public List<Toy> getBadToys() {
        List<Toy> badToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (!toy.isGoodToy()) {
                badToys.add(toy);
            }
        }
        return badToys;
    }

    public void saveToysToCSV() {
        try (FileWriter writer = new FileWriter("toys.csv")) {
            for (Toy toy : toys) {
                writer.append(toy.toString()).append("\n");
            }
            System.out.println("Toys saved to CSV file.");
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
        }
    }
}
