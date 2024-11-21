package factoria5.santaclaustoyfactory;

import factoria5.santaclaustoyfactory.controller.ToyController;
import factoria5.santaclaustoyfactory.model.ToyRepository; // Импорт репозитория
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyControllerTest {
    private ToyController toyController;
    private ToyRepository toyRepository;

    @BeforeEach
    void setUp() {
        toyRepository = new ToyRepository(); // Создаем репозиторий
        toyController = new ToyController(toyRepository); // Передаем репозиторий в контроллер
    }

    @Test
    void testAddToyForGood() {
        toyController.addToyForGood();
        assertEquals(1, toyController.getAllToys().size()); // Проверяем количество игрушек
    }

    @Test
    void testAddToyForBad() {
        toyController.addToyForBad();
        assertEquals(1, toyController.getAllToys().size()); // Проверяем количество игрушек
    }   
}
