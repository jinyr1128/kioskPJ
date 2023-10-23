package Kiosk;

public class Product extends Menu {
    private double price;
    private String category;
    private Option selectedOption;
    private String originalName;
    private double originalPrice;

    public Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
        this.originalName = name;
        this.originalPrice = price;
    }

    public Option getSelectedOption() {
        return this.selectedOption;
    }

    public void setSelectedOption(Option option) {
        this.selectedOption = option;
    }

    public Product withOption(Option option) {
        Product newProduct = new Product(this.originalName + "(" + option.getName() + ")",
                this.getDescription(),
                this.originalPrice + option.getPrice(),
                this.category);
        newProduct.setSelectedOption(option);
        return newProduct;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " | Price: ₩ " + price + "|";
    }
}
