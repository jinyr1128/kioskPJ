package Kiosk;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }
    public void addItem(Product product) {
        items.put(product, items.getOrDefault(product, 0) + 1);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
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
