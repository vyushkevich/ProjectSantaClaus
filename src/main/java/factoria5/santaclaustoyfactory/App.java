package factoria5.santaclaustoyfactory;
import factoria5.santaclaustoyfactory.controller.ToyController;
import factoria5.santaclaustoyfactory.repository.ToyRepository;
import factoria5.santaclaustoyfactory.repository.ToyRepositoryImpl;
import factoria5.santaclaustoyfactory.view.ConsoleView;

public class App {
    public static void main(String[] args) {

        ToyRepository repository = new ToyRepositoryImpl();

        ConsoleView view = new ConsoleView();

        ToyController controller = new ToyController(repository, view);
        
        controller.start();
    }
}