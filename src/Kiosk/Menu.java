package Kiosk;
// 키오스크의 메뉴 항목을 나타내는 클래스
public class Menu {
    private String name;
    private String description;
    // 생성자: 메뉴 이름과 설명을 초기화합니다.
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    // 메뉴 이름을 반환하는 메서드
    public String getName() {
        return name;
    }
    // 메뉴 설명을 반환하는 메서드
    public String getDescription() {
        return description;
    }
    // 객체를 문자열 형식으로 반환하는 메서드 (예: "아메리카노: 국민음료")
    @Override
    public String toString() {
        return name + ": " + description;
    }
}
