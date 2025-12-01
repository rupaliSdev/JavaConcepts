package LLD_Design.OMS;

import java.util.*;

interface IOrder {
    String getName();
    double getPrice();
    void setName(String name);
    void setPrice(double price);
}

class Order implements IOrder {
    private String name;
    private double price;

    public Order(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}

interface IOrderManagement {
    void addOrder(String itemName, Order order);
    void removeOrder(String itemName);
    int calculateTotalDiscountedPrice();
    Map<String, Integer> getCategoryDiscounts();
    void countDuplicateOrders();
    Map<String, Integer> showCart();  // ✅ Returns cart instead of printing
}

class OrderManagement implements IOrderManagement {
    private final HashMap<String, Order> orders = new HashMap<>(); // Stores itemName -> Order
    private final HashMap<String, Integer> cart = new HashMap<>(); // Stores itemName -> quantity
    private final HashMap<String, Integer> categoryDiscounts = new HashMap<>(); // Stores "Cheap" -> 10, "Moderate" -> 20, "Expensive" -> 30

    public void addOrder(String itemName, Order order) {
        orders.put(itemName, order);
    }

    public void removeOrder(String itemName) {
        if (!orders.containsKey(itemName)) {
            System.out.println("Order " + itemName + " not found in the cart.");
            return;
        }
        orders.remove(itemName);
        cart.remove(itemName);
        System.out.println("Order " + itemName + " removed.");
    }

    public Map<String, Integer> getCategoryDiscounts() {
        Map<String, Integer> categoryMap = new HashMap<>();
        categoryMap.put("Cheap", 10);
        categoryMap.put("Moderate", 20);
        categoryMap.put("Expensive", 30);
        return categoryMap;
    }

    private String getCategory(double price) {
        return price < 10 ? "Cheap" : (price <= 20 ? "Moderate" : "Expensive");
    }

    public void countDuplicateOrders() {
        for (String item : orders.keySet()) {
            cart.put(item, cart.getOrDefault(item, 0) + 1);
        }
    }

    public int calculateTotalDiscountedPrice() {
        int totalDiscountedPrice = 0;
        Map<String, Integer> categoryDiscounts = getCategoryDiscounts();

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            double price = orders.get(item).getPrice();
            String category = getCategory(price);
            int discountRate = categoryDiscounts.get(category);
            int discountedPrice = (int) Math.round(price * (1 - discountRate / 100.0));

            totalDiscountedPrice += discountedPrice * quantity;
        }

        return totalDiscountedPrice;
    }

    public Map<String, Integer> showCart() {  // ✅ Returns cart instead of printing
        return new HashMap<>(cart);
    }
}

class Solution {
    public static void main(String[] args) {
        OrderManagement system = new OrderManagement();

        // Sample Input
        system.addOrder("Order-1", new Order("Order-1", 49));
        system.addOrder("Order-2", new Order("Order-2", 30));
        system.addOrder("Order-3", new Order("Order-3", 15));
        system.addOrder("Order-4", new Order("Order-4", 7));

        // Count duplicate items (as done at the end in your interview)
        system.countDuplicateOrders();

        // Output
        System.out.println("Cart Contents: " + system.showCart());  // ✅ Returns map
        System.out.println("Discounted Price: $" + system.calculateTotalDiscountedPrice());

        // Get category discounts
        Map<String, Integer> categoryDiscounts = system.getCategoryDiscounts();
        System.out.println("Category Discounts: " + categoryDiscounts);

        // Removing an order
        system.removeOrder("Order-2");
        System.out.println("Cart Contents after removal: " + system.showCart());  // ✅ Returns map
        System.out.println("Discounted Price after removal: $" + system.calculateTotalDiscountedPrice());
    }
}