package factoria5.santaclaustoyfactory.model;

public class Toy {
    private String name;
    private String description;
    private String type; // "Bueno" или "Malo"
    private int age; // Возраст ребёнка

    // Конструктор с возрастом
    public Toy(String name, String description, String type, int age) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.age = age;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    // Метод для текстового представления объекта
    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
