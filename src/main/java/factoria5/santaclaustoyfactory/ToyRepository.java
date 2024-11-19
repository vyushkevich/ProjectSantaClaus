package factoria5.santaclaustoyfactory;

import java.util.ArrayList;
import java.util.List;

public class ToyRepository {
    private List<Toy> goodToys = new ArrayList<>();
    private List<Toy> badToys = new ArrayList<>();

    public void addGoodToy(Toy toy) {
        goodToys.add(toy);
    }

    public void addBadToy(Toy toy) {
        badToys.add(toy);
    }

    public List<Toy> getGoodToys() {
        return goodToys;
    }

    public List<Toy> getBadToys() {
        return badToys;
    }

    public void deleteToy(String identifier) {
        goodToys.removeIf(toy -> toy.getTitle().equals(identifier));
        badToys.removeIf(toy -> toy.getTitle().equals(identifier));
    }

    public void saveToysToCSV(String filename) {
        // Логика для сохранения в CSV
    }
}
