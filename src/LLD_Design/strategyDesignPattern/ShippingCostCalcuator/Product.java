package LLD_Design.strategyDesignPattern.ShippingCostCalcuator;

public class Product {
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
