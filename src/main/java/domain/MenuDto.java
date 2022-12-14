package domain;

public class MenuDto {

    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public MenuDto(int number, String name, Category category, int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
