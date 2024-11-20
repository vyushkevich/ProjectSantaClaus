package factoria5.santaclaustoyfactory;

import java.util.ArrayList;
import java.util.List;

public class ToyRepository {
    private final List<Toy> toys = new ArrayList<>();

    public void add(Toy toy) {
        toys.add(toy);
    }

    public List<Toy> getAll() {
        return new ArrayList<>(toys);
    }

    public void remove(String name) {
        toys.removeIf(toy -> toy.getName().equals(name));
    }
}
