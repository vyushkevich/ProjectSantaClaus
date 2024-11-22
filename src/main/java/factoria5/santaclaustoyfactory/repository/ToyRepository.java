package factoria5.santaclaustoyfactory.repository;

import factoria5.santaclaustoyfactory.model.Toy;
import java.util.List;

public interface ToyRepository {
 
    void add(Toy toy);

    boolean removeById(String id);

    List<Toy> getAll();

    Toy findById(String id);
}