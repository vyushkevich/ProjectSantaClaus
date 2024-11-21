package factoria5.santaclaustoyfactory.model;

public class Toy {
    private String title;
    private String brand;
    private int age;
    private String category;
    private String content;
    private boolean isGoodToy;

    // Конструктор для хороших игрушек
    public Toy(String title, String brand, int age, String category) {
        this.title = title;
        this.brand = brand;
        this.age = age;
        this.category = category;
        this.isGoodToy = true;
    }

    // Конструктор для плохих игрушек
    public Toy(String title, String content, boolean isGoodToy) {
        this.title = title;
        this.content = content;
        this.isGoodToy = isGoodToy;
    }

    public String getTitle() {
        return title;
    }

    public String getBrand() {
        return brand;
    }

    public int getAge() {
        return age;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public boolean isGoodToy() {
        return isGoodToy;
    }

    @Override
    public String toString() {
        if (isGoodToy) {
            return "Toy [title=" + title + ", brand=" + brand + ", age=" + age + ", category=" + category + "]";
        } else {
            return "Toy [title=" + title + ", content=" + content + "]";
        }
    }
}
