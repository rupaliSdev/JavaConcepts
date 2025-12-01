package LLD_Design.OMS.op;

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

// ✅ Using Enum Instead of HashMap for Discounts
enum DiscountCategory {
    CHEAP(10), MODERATE(20), EXPENSIVE(30);
    private final int discount;

    DiscountCategory(int discount) { this.discount = discount; }
    public int getDiscount() { return discount; }

    public static DiscountCategory getCategory(double price) {
        if (price < 10) return CHEAP;
        if (price <= 20) return MODERATE;
        return EXPENSIVE;
    }
}

interface IOrderManagement {
    void addOrder(String itemName, Order order);
    void removeOrder(String itemName);
    int calculateTotalDiscountedPrice();
    List<String> getCategoryDiscounts();
    void countDuplicateOrders();
    Map<String, Integer> showCart();
}

class OrderManagement implements IOrderManagement {
    private final List<Order> orders = new ArrayList<>(); // ✅ Using `ArrayList<Order>` instead of `HashMap`
    private final Map<String, Integer> cart = new HashMap<>(); // Stores itemName -> quantity

    public void addOrder(String itemName, Order order) {
        orders.add(order); // ✅ Allows duplicates naturally
    }

    public void removeOrder(String itemName) {
        orders.removeIf(order -> order.getName().equals(itemName));
    }

    public List<String> getCategoryDiscounts() {  // ✅ Uses `List<String>` Instead of HashMap
        return Arrays.asList("Cheap: 10%", "Moderate: 20%", "Expensive: 30%");
    }

    public void countDuplicateOrders() {
        cart.clear();
        for (Order order : orders) {
            cart.put(order.getName(), cart.getOrDefault(order.getName(), 0) + 1);
        }
    }

    public int calculateTotalDiscountedPrice() {
        int totalDiscountedPrice = 0;
        for (Order order : orders) {
            DiscountCategory category = DiscountCategory.getCategory(order.getPrice());
            int discountedPrice = (int) Math.round(order.getPrice() * (1 - category.getDiscount() / 100.0));
            totalDiscountedPrice += discountedPrice;
        }
        return totalDiscountedPrice;
    }

    public Map<String, Integer> showCart() {  
        return new HashMap<>(cart);
    }
}

class Solution {
    public static void main(String[] args) {
        IOrderManagement system = new OrderManagement();

        // Sample Input
        system.addOrder("Order-1", new Order("Order-1", 49));
        system.addOrder("Order-2", new Order("Order-2", 30));
        system.addOrder("Order-3", new Order("Order-3", 15));
        system.addOrder("Order-4", new Order("Order-4", 7));
        system.addOrder("Order-1", new Order("Order-1", 49)); // ✅ Duplicate item

        // Count duplicate items
        system.countDuplicateOrders();

        // Output
        System.out.println("Cart Contents: " + system.showCart());  
        System.out.println("Discounted Price: $" + system.calculateTotalDiscountedPrice());

        // Get category discounts
        System.out.println("Category Discounts: " + system.getCategoryDiscounts());

        // Removing an order
        system.removeOrder("Order-2");
        system.countDuplicateOrders(); // Recalculate duplicates
        System.out.println("Cart Contents after removal: " + system.showCart());
        System.out.println("Discounted Price after removal: $" + system.calculateTotalDiscountedPrice());
    }
}