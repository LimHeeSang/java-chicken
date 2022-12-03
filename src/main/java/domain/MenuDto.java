package domain;

public class MenuDto {

    private final String name;
    private final Category category;
    private final int count;
    private final int price;

    public MenuDto(String name, Category category, int count, int price) {
        this.name = name;
        this.category = category;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
