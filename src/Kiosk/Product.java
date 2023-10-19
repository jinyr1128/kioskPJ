package Kiosk;

public class Product extends Menu {
    private double price;
    private String category;

    public Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " | Price: ₩ " + price +"|" ;
    }
}