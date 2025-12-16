package LLD_Design.problems.OMS;

import java.util.*;

class ShoppingCart {
    int userId;
    HashMap<Integer, Integer> cart; // (itemId, quantity)
    
    private static final Map<Integer, Double> prices = new HashMap<>();
    static {
        prices.put(101, 120.40);
        prices.put(102, 60.50);
        prices.put(103, 140.20);
        prices.put(104, 20.60);
    }

    ShoppingCart(int userId) {
        this.userId = userId;
        cart = new HashMap<>();
    }

    public void addItemToCart(int itemId, int quantity) {
        if (!prices.containsKey(itemId))
            throw new IllegalArgumentException("Invalid Item Id!");
        if (quantity <= 0)
            throw new IllegalArgumentException("Invalid Quantity!");
        cart.put(itemId, cart.getOrDefault(itemId, 0) + quantity);
        System.out.println("User " + userId + " added " + quantity + " of item " + itemId);
    }

    public void removeItemFromCart(int itemId) {
        if (!cart.containsKey(itemId))
            throw new IllegalArgumentException("Item Id Not in Cart!");
        int qty = cart.get(itemId);
        if (qty > 1) {
            cart.put(itemId, qty - 1);
            System.out.println("User " + userId + " removed " + itemId + ", final qty=" + (qty - 1));
        } else {
            cart.remove(itemId);
            System.out.println("User " + userId + " removed " + itemId);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            int itemId = entry.getKey();
            int qty = entry.getValue();
            double price = prices.get(itemId);
            total += price * qty;
        }
        if (total > 100) total *= 0.95; // Apply 5% discount if total > $100
        return total;
    }

    public void checkout() {
        if (cart.isEmpty())
            throw new IllegalStateException("Cart is Empty!");
        double total = calculateTotal();
        double tax = 0.10 * total; // Apply 10% tax
        double finalAmount = total + tax;
        System.out.println("User " + userId + " - Total amount = $" + String.format("%.2f", finalAmount));

        try {
            Thread.sleep(200); // Simulate payment processing
        } catch (InterruptedException e) {
            System.out.println("Error: Payment interrupted!");
        }

        cart.clear();
        System.out.println("User " + userId + " - Order placed successfully!");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("User " + userId + " - Cart is Empty!");
            return;
        }
        System.out.println("User " + userId + "'s Cart:");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            System.out.println("Item " + entry.getKey() + " | Quantity: " + entry.getValue() + " | Price: $" + prices.get(entry.getKey()));
        }
    }
}

class OrderManagementSystem {
    private static final Map<Integer, ShoppingCart> userCarts = new HashMap<>();

    public static ShoppingCart getUserCart(int userId) {
        if (!userCarts.containsKey(userId)) {
            userCarts.put(userId, new ShoppingCart(userId));
        }
        return userCarts.get(userId);
    }

    public static void main(String[] args) {
        ShoppingCart user1cart = getUserCart(1);
        user1cart.addItemToCart(101, 4);
        user1cart.addItemToCart(102, 3);
        user1cart.addItemToCart(104, 2);
        user1cart.removeItemFromCart(101);
        user1cart.viewCart();
        user1cart.checkout();

        System.out.println("\n--- New User Session ---\n");

        ShoppingCart user2cart = getUserCart(2);
        user2cart.addItemToCart(103, 1);
        user2cart.addItemToCart(104, 5);
        user2cart.viewCart();
        user2cart.checkout();
    }
}