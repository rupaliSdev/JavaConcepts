package LLD_Design.Behavioural.strategyDesignPattern;

/*
This pattern defines family of algorithm ,encapsulates each one
allows to select an algo at run time.
*/

import java.util.ArrayList;
import java.util.List;

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

    public static class ShoppingCart {
        private List< Product > products = new ArrayList< >();
        public void addProduct(Product product) {
            products.add(product);
        }
        public void removeProduct(Product product) {
            products.remove(product);
        }
        public double getTotalPrice() {
            double totalPrice = 0.0;
            for (Product product: products) {
                totalPrice += product.getPrice();
            }
            return totalPrice;
        }
        public double getShippingCost(ShippingCostCalculator calculator) {
            double totalPrice = getTotalPrice();
            ShippingCostContext context = new ShippingCostContext(calculator);
            return context.calculateShippingCost(totalPrice);
        }
    }

    public static class ShippingCostContext {
        private ShippingCostCalculator calculator;

        public ShippingCostContext(ShippingCostCalculator calculator) {
            this.calculator = calculator;
        }

        public double calculateShippingCost(double totalPrice) {
            return calculator.calculateShippingCost(totalPrice);
        }
    }

    public static class Product {
        double price ;
        String name;
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
    }
}
