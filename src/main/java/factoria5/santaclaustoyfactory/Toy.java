package factoria5.santaclaustoyfactory;

public class Toy {
    private String title;
    private String brand;
    private String recommendedAge;
    private String category;
    private String content;  // Для плохих детей

    public Toy(String title, String brand, String recommendedAge, String category) {
        this.title = title;
        this.brand = brand;
        this.recommendedAge = recommendedAge;
        this.category = category;
        this.content = null;
    }

    public Toy(String title, String content) {
        this.title = title;
        this.brand = null;
        this.recommendedAge = null;
        this.category = null;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getBrand() {
        return brand;
    }

    public String getRecommendedAge() {
        return recommendedAge;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        if (content != null) {
            return "Título: " + title + ", Contenido: " + content;
        } else {
            return "Título: " + title + ", Marca: " + brand + ", Edad Recomendada: " + recommendedAge + ", Categoria: " + category;
        }
    }
}
