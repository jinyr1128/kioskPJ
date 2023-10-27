package Kiosk;

// 상품 정보를 관리하는 클래스로, Menu 클래스를 확장
public class Product extends Menu {

    // 상품의 가격
    private double price;
    // 상품의 카테고리 (예: Coffee, Tea, Toast 등)
    private String category;
    // 선택된 옵션 (예: 아이스, 샷 추가 등)
    private Option selectedOption;
    // 원래의 상품명 (옵션을 추가하기 전의 상품명)
    private String originalName;
    // 원래의 가격 (옵션을 추가하기 전의 가격)
    private double originalPrice;

    // 생성자: 상품의 이름, 설명, 가격, 카테고리를 초기화
    public Product(String name, String description, double price, String category) {
        super(name, description); // 부모 클래스(Menu)의 생성자 호출
        this.price = price;
        this.category = category;
        this.originalName = name;
        this.originalPrice = price;
    }

    // 선택된 옵션을 반환하는 메서드
    public Option getSelectedOption() {
        return this.selectedOption;
    }

    // 선택된 옵션을 설정하는 메서드
    public void setSelectedOption(Option option) {
        this.selectedOption = option;
    }

    // 옵션을 추가하여 새로운 상품 객체를 생성하는 메서드
    public Product withOption(Option option) {
        Product newProduct = new Product(this.originalName + "(" + option.getName() + ")",
                this.getDescription(),
                this.originalPrice + option.getPrice(),
                this.category);
        newProduct.setSelectedOption(option);
        return newProduct;
    }

    // 상품의 카테고리를 반환하는 메서드
    public String getCategory() {
        return category;
    }

    // 상품의 가격을 반환하는 메서드
    public double getPrice() {
        return price;
    }

    // 상품 정보를 문자열 형식으로 반환하는 메서드
    @Override
    public String toString() {
        return super.toString() + " | Price: ₩ " + price + "|";
    }
}
