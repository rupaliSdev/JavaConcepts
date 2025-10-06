package LLD_Design.strategyDesignPattern.ShippingCostCalcuator;
public class Main {  public static void main(String[] args) { 
    // Create some products      
    Product product1 = new Product("Product 1", 10.0);    
    Product product2 = new Product("Product 2", 20.0);      
    Product product3 = new Product("Product 3", 30.0);
    // Add products to the cart
    ShoppingCart cart = new ShoppingCart();
    cart.addProduct(product1);
    cart.addProduct(product2);
    cart.addProduct(product3);
    // Calculate the total price and shipping cost
    double totalPrice = cart.getTotalPrice();
    double shippingCost = cart.getShippingCost(new PercentageShippingCostCalculator(0.1));
    // 10% of the total price
    double totalCost = totalPrice + shippingCost;
    // Display the results
    System.out.println("Total Price: $" + totalPrice);
    System.out.println("Shipping Cost: $" + shippingCost);
    System.out.println("Total Cost: $" + totalCost);
}
}
