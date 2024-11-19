package factoria5.santaclaustoyfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToyTest {

    @Test
    public void testToyCreation() {
        Toy goodToy = new Toy("LEGO Star Wars", "LEGO", "+18", "Construcción");
        assertNotNull(goodToy);
        assertEquals("LEGO Star Wars", goodToy.getTitle());
    }

    @Test
    public void testToyRepository() {
        ToyRepository repo = new ToyRepository();
        Toy toy = new Toy("LEGO Star Wars", "LEGO", "+18", "Construcción");
        repo.addGoodToy(toy);
        assertTrue(repo.getGoodToys().contains(toy));
    }
}
