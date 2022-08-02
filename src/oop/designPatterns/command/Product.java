package command;

public class Product {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void increasePrice(int amount) {
        this.setPrice(this.getPrice() + amount);
    }

    public void decreasePrice(int amount) {
        this.setPrice(this.getPrice() - amount);
    }

    @Override
    public String toString() {
        return String.format("Current price for the %s product is %d$.%n", this.name, this.price);
    }
}
