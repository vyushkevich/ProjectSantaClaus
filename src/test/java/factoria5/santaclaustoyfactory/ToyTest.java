package factoria5.santaclaustoyfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyTest {
    @Test
    void testToyCreation() {
        Toy toy = new Toy("Carro");
        assertEquals("Carro", toy.getName());
    }

    @Test
    void testSetName() {
        Toy toy = new Toy("Muñeca");
        toy.setName("Pelota");
        assertEquals("Pelota", toy.getName());
    }
}
