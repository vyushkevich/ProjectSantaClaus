package factoria5.santaclaustoyfactory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToyRepositoryTest {

    private ToyRepository toyRepository;

    @BeforeEach
    void setUp() {
        toyRepository = new ToyRepository();
    }

    @Test
    void testAddToy() {
        Toy toy = new Toy("Car", "Red toy car", "Bueno", 5);
        toyRepository.addToy(toy);
        assertEquals(1, toyRepository.getAllToys().size(), "Toy should be added to the repository.");
    }

    @Test
    void testGetGoodToys() {
        Toy goodToy = new Toy("Car", "Red toy car", "Bueno", 5);
        Toy badToy = new Toy("Monster", "Scary monster toy", "Malo", 8);
        toyRepository.addToy(goodToy);
        toyRepository.addToy(badToy);

        List<Toy> goodToys = toyRepository.getGoodToys();
        assertEquals(1, goodToys.size(), "There should be one good toy in the repository.");
        assertEquals("Car", goodToys.get(0).getName(), "The good toy should be 'Car'.");
    }

    @Test
    void testGetBadToys() {
        Toy goodToy = new Toy("Car", "Red toy car", "Bueno", 5);
        Toy badToy = new Toy("Monster", "Scary monster toy", "Malo", 8);
        toyRepository.addToy(goodToy);
        toyRepository.addToy(badToy);

        List<Toy> badToys = toyRepository.getBadToys();
        assertEquals(1, badToys.size(), "There should be one bad toy in the repository.");
        assertEquals("Monster", badToys.get(0).getName(), "The bad toy should be 'Monster'.");
    }

    @Test
    void testRemoveToy() {
        Toy toy = new Toy("Car", "Red toy car", "Bueno", 5);
        toyRepository.addToy(toy);
        toyRepository.removeToy();
        assertTrue(toyRepository.getAllToys().isEmpty(), "The repository should be empty after removing the toy.");
    }

    @Test
    void testRemoveToyFromEmptyRepository() {
        toyRepository.removeToy();
        assertTrue(toyRepository.getAllToys().isEmpty(), "The repository should remain empty.");
    }

    @Test
    void testGetAllToys() {
        Toy toy1 = new Toy("Car", "Red toy car", "Bueno", 5);
        Toy toy2 = new Toy("Monster", "Scary monster toy", "Malo", 8);
        toyRepository.addToy(toy1);
        toyRepository.addToy(toy2);

        List<Toy> allToys = toyRepository.getAllToys();
        assertEquals(2, allToys.size(), "There should be two toys in the repository.");
    }
}
