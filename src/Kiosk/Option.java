package Kiosk;
// 상품에 추가할 수 있는 옵션을 나타내는 클래스
public class Option {
    private String name;
    private double price;
    // 생성자: 옵션의 이름과 가격을 초기화합니다.
    public Option(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    // 객체를 문자열 형식으로 반환하는 메서드 (예: "아이스 (₩0.5)")
    @Override
    public String toString() {
        return name + " (₩" + price + ")";
    }
}