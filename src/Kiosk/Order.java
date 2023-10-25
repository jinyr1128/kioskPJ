package Kiosk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static int globalOrderId = 0;
    private int orderId;
    private List<Product> products = new ArrayList<>();
    private Date orderTime;
    private Date completionTime;
    private String request;

    public Order(String request) {
        this.orderId = ++globalOrderId;
        this.orderTime = new Date();
        this.request = request;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public String getRequest() {
        return request;
    }

    public String formattedOrderTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        return sdf.format(orderTime);
    }

    public String formattedCompletionTime() {
        if (completionTime == null) return "Not Completed Yet";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        return sdf.format(completionTime);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public int getWaitingNumber() {
        return this.orderId;
    }

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
    public List<Product> getProducts() {
        return this.products;
    }
    public String getCompletedOrderDetails() {
        return getOrderDetails() + "완료주문 일시: " + formattedCompletionTime() + "\n";
    }
}
