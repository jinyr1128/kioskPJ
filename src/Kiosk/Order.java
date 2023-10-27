package Kiosk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 주문을 나타내는 클래스
public class Order {

    // 전역 주문 ID (각 주문마다 고유한 ID를 생성하기 위함)
    private static int globalOrderId = 0;
    // 주문 ID
    private int orderId;
    // 주문에 포함된 상품 목록
    private List<Product> products = new ArrayList<>();
    // 주문이 생성된 시간
    private Date orderTime;
    // 주문이 완료된 시간
    private Date completionTime;
    // 고객의 요청사항
    private String request;

    // 생성자: 주문 ID와 주문 시간을 초기화하며 고객의 요청사항을 저장
    public Order(String request) {
        this.orderId = ++globalOrderId;
        this.orderTime = new Date();
        this.request = request;
    }

    // 상품을 주문에 추가하는 메서드
    public void addProduct(Product product) {
        this.products.add(product);
    }

    // 주문 ID를 반환하는 메서드
    public int getOrderId() {
        return orderId;
    }

    // 주문 시간을 반환하는 메서드
    public Date getOrderTime() {
        return orderTime;
    }

    // 주문 완료 시간을 반환하는 메서드
    public Date getCompletionTime() {
        return completionTime;
    }

    // 주문 완료 시간을 설정하는 메서드
    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    // 고객의 요청사항을 반환하는 메서드
    public String getRequest() {
        return request;
    }

    // 주문 시간을 형식화하여 문자열로 반환하는 메서드
    public String formattedOrderTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        return sdf.format(orderTime);
    }

    // 주문 완료 시간을 형식화하여 문자열로 반환하는 메서드
    public String formattedCompletionTime() {
        if (completionTime == null) return "Not Completed Yet";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        return sdf.format(completionTime);
    }

    // 주문의 총 가격을 계산하여 반환하는 메서드
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // 주문의 대기번호를 반환하는 메서드
    public int getWaitingNumber() {
        return this.orderId;
    }

    // 주문에 포함된 상품 목록을 문자열 형식으로 반환하는 메서드
    public String getProductListAsString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : this.products) {
            sb.append(product.getName()).append(", ");
        }
        // 마지막 ", " 제거
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    // 주문의 상세 정보를 문자열로 반환하는 메서드
    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("대기 번호: ").append(orderId).append("\n");
        details.append("주문 상품 목록:\n");
        for (Product product : products) {
            details.append("- ").append(product.getName()).append("\n");
        }
        details.append("주문 총 가격: ₩").append(getTotalPrice()).append("\n");
        details.append("요청 사항: ").append(request).append("\n");
        details.append("주문 일시: ").append(formattedOrderTime()).append("\n");
        return details.toString();
    }

    // 주문에 포함된 상품 목록을 반환하는 메서드
    public List<Product> getProducts() {
        return this.products;
    }

    // 완료된 주문의 상세 정보를 문자열로 반환하는 메서드
    public String getCompletedOrderDetails() {
        return getOrderDetails() + "완료주문 일시: " + formattedCompletionTime() + "\n";
    }
}
