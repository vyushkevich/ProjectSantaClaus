package factoria5.santaclaustoyfactory.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleViewTest {

    @Test
    void testDisplayMainMenu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConsoleView view = new ConsoleView();
        view.displayMainMenu();

        String expectedOutput = "Log in to work as:\n" +
                "1. Elf\n" +
                "2. Santa Claus\n" +
                "3. Exit\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDisplayMenuForElf() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConsoleView view = new ConsoleView();
        view.displayMenuForElf();

        String expectedOutput = "Toy Manager (Session Type: Elf)\n" +
                "1. Add toy\n" +
                "2. See all toys\n" +
                "3. Delete toy\n" +
                "4. Sign out\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDisplayMenuForSanta() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConsoleView view = new ConsoleView();
        view.displayMenuForSanta();

        String expectedOutput = "Toy Manager (Session Type: Santa)\n" +
                "1. See list of GOOD children's toys\n" +
                "2. See list of BAD children's toys\n" +
                "3. Save list of all toys (.csv)\n" +
                "4. Sign out\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
