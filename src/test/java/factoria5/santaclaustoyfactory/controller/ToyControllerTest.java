package factoria5.santaclaustoyfactory.controller;

import factoria5.santaclaustoyfactory.model.Toy;
import factoria5.santaclaustoyfactory.repository.ToyRepository;
import factoria5.santaclaustoyfactory.view.ConsoleView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class ToyControllerTest {

    private ToyController toyController;
    private ToyRepository toyRepository;
    private ConsoleView consoleView;
    private List<Toy> toyList;

    @BeforeEach
    public void setUp() {
        toyList = new ArrayList<>();
        toyRepository = mock(ToyRepository.class);
        consoleView = mock(ConsoleView.class);
        toyController = new ToyController(toyRepository, consoleView);
    }

    @Test
    public void testDeleteToy_Success() {
        Toy toy = mock(Toy.class);//+
        when(toy.getId()).thenReturn("1");//+
        toyList.add(toy);
        when(toyRepository.removeById("1")).thenReturn(true);

        toyController.deleteToy("1");

        verify(toyRepository).removeById("1");
        verify(consoleView).showMessage("Toy deleted successfully.");
    }


    @Test
    public void testDeleteToy_Failure() {
        when(toyRepository.removeById("2")).thenReturn(false);

        toyController.deleteToy("2");

        verify(consoleView).showMessage("Toy not found.");
    }
}
