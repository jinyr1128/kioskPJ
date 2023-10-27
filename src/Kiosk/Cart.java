package Kiosk;

import java.util.HashMap;
import java.util.Map;

// 장바구니 기능을 구현한 클래스
public class Cart {
    // 장바구니에 담긴 상품들과 그 상품의 수량을 저장하는 맵
    private Map<Product, Integer> items;

    // 기본 생성자로 장바구니를 초기화한다.
    public Cart() {
        this.items = new HashMap<>();
    }

    // 장바구니에 상품을 추가하는 메서드
    // 이미 있는 상품이면 수량을 1 증가시키고, 없으면 새로운 항목으로 추가한다.
    public void addItem(Product product) {
        items.put(product, items.getOrDefault(product, 0) + 1);
    }

    // 현재 장바구니의 상품들을 반환하는 메서드
    public Map<Product, Integer> getItems() {
        return items;
    }

    // 장바구니의 모든 상품을 제거하는 메서드
    public void clear() {
        items.clear();
    }

    // 장바구니가 비어있는지 확인하는 메서드
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 장바구니에서 특정 상품의 수량을 1 줄이는 메서드
    // 수량이 1이면 해당 상품을 장바구니에서 제거한다.
    public void removeOneItem(Product product) {
        if (items.containsKey(product)) {
            int currentQuantity = items.get(product);
            if (currentQuantity > 1) {
                items.put(product, currentQuantity - 1);
            } else {
                items.remove(product);
            }
        }
    }

    // 장바구니의 총 금액을 계산하여 반환하는 메서드
    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
}
