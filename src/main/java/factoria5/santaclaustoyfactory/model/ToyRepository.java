package factoria5.santaclaustoyfactory.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToyRepository {

    private final List<Toy> toys;
    private static final String CSV_FILE_PATH = "src/main/resources/toy_list.csv";

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    public List<Toy> getAllToys() {
        return toys;
    }

    public List<Toy> getGoodToys() {
        List<Toy> goodToys = new ArrayList<>();
        for (Toy toy : toys) {
            if ("Bueno".equals(toy.getType())) {
                goodToys.add(toy);
            }
        }
        return goodToys;
    }

    public List<Toy> getBadToys() {
        List<Toy> badToys = new ArrayList<>();
        for (Toy toy : toys) {
            if ("Malo".equals(toy.getType())) {
                badToys.add(toy);
            }
        }
        return badToys;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy() {
        if (!toys.isEmpty()) {
            toys.remove(toys.size() - 1);
            System.out.println("Último juguete eliminado.");
        } else {
            System.out.println("No hay juguetes para eliminar.");
        }
    }

    // Сохранение игрушек в CSV файл
    public void saveToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (Toy toy : toys) {
                writer.write(String.format("%s,%s,%s,%d%n", 
                        toy.getName(), 
                        toy.getDescription(), 
                        toy.getType(), 
                        toy.getAge()));
            }
            System.out.println("Lista de juguetes guardada en " + CSV_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al guardar la lista de juguetes: " + e.getMessage());
        }
    }

    // Загрузка игрушек из CSV файла
    public void loadFromCSV() {
        toys.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    String name = fields[0];
                    String description = fields[1];
                    String type = fields[2];
                    int age = Integer.parseInt(fields[3]);
                    toys.add(new Toy(name, description, type, age));
                }
            }
            System.out.println("Lista de juguetes cargada desde " + CSV_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al cargar la lista de juguetes: " + e.getMessage());
        }
    }
}
