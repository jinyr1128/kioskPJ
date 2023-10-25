package Kiosk;

import java.util.*;

public class KioskManager {

    private List<Order> pendingOrders = new ArrayList<>();
    private List<Order> completedOrders = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public KioskManager() {
        initializeProducts();
    }

    private void initializeProducts() {
        // 커피 카테고리
        products.add(new Product("아메리카노", "국민음료? 당신의 하루는 언제나 아메리카노로 시작하는거 다알아요!!!", 3.5, "Coffee"));
        products.add(new Product("라떼", "우유와 함께한 에스프레소의 궁합!! 고소한 커피를 경험해보세요.", 4.0, "Coffee"));

        // 차 카테고리
        products.add(new Product("아이스 티", "뜨숩은 차가 심심할 땐 아이스로 즐겨보는건 어떤가요? 아샷추 가능!!", 3.0, "Tea"));
        products.add(new Product("페퍼민트 티", "초코민트는 안좋아할수있지!!하지만 이건 좀 다를껄??", 4.8, "Tea"));

        // 토스트 카테고리
        products.add(new Product("평범한 토스트?", "버터와 잼의 가장 기본의 충실한 맛!!!!!", 2.2, "Toast"));
        products.add(new Product("치즈 토스트", "치즈가 숨어있어! 누가 나를 찾나?(치즈양이 적다는건 아녀유...)", 3.0, "Toast"));

        // 디저트 카테고리
        products.add(new Product("치즈케이크", "치즈가 웃다! 행복의 원조!", 4.0, "Dessert"));
        products.add(new Product("티라미수 ", "커피와 치즈의 이탈리아 방식 폭신폭신이!!", 4.5, "Dessert"));
    }
    public void addPendingOrder(Order order) {
        this.pendingOrders.add(order);
    }

    public boolean completeOrder(int orderId) {
        for (Order order : pendingOrders) {
            if (order.getOrderId() == orderId) {
                order.setCompletionTime(new Date());
                completedOrders.add(order);
                pendingOrders.remove(order);
                return true;
            }
        }
        return false;
    }

    public void addProduct(String name, String description, double price, String category) {
        products.add(new Product(name, description, price, category));
    }

    public boolean removeProduct(String productName) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Order> getPendingOrders() {
        return this.pendingOrders;
    }

    public List<Order> getCompletedOrders() {
        return this.completedOrders;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void viewPendingOrders() {
        System.out.println("\n[ 대기 주문 목록 ]");
        for (Order order : pendingOrders) {
            System.out.println(order.getOrderDetails());
        }
    }
    public boolean approvePendingOrder(int orderId) {
        Iterator<Order> iterator = pendingOrders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId() == orderId) {
                order.setCompletionTime(new Date());
                completedOrders.add(order);
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public void viewRecentCompletedOrders(int count) {
        System.out.println("\n[ 최근 완료된 주문 ]");
        int displayedCount = 0;
        ListIterator<Order> iterator = completedOrders.listIterator(completedOrders.size());
        while (iterator.hasPrevious() && displayedCount < count) {
            Order order = iterator.previous();
            System.out.println("대기번호: " + order.getOrderId());
            System.out.print("상품목록: ");
            for (Product product : order.getProducts()) {
                System.out.print(product.getName() + ", ");
            }
            System.out.println("\n---------------------");
            displayedCount++;
        }
    }
}