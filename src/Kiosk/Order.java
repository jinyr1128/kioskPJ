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

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Order ID: ").append(orderId).append("\n");
        for (Product product : products) {
            details.append(product.getName()).append("\n");
        }
        details.append("Request: ").append(request).append("\n");
        details.append("Order Time: ").append(formattedOrderTime()).append("\n");
        return details.toString();
    }

    public String getCompletedOrderDetails() {
        return getOrderDetails() + "Completion Time: " + formattedCompletionTime() + "\n";
    }
}
