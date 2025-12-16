package LLD_Design.Behavioural.strategyDesignPattern;

public interface ShippingCostCalculator {
    double calculateShippingCost(double totalPrice);


}
class PercentageShippingCostCalculator implements ShippingCostCalculator {

    private double percentage;
    public PercentageShippingCostCalculator(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateShippingCost(double totalPrice) {
        return totalPrice * percentage; // Percentage of the total price 
    }

}
class FixedShippingCostCalculator implements ShippingCostCalculator {

    double shippingCost;

    public FixedShippingCostCalculator(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public double calculateShippingCost(double totalPrice) {
        return shippingCost;
    }
}

class FreeShippingCostCalculator implements ShippingCostCalculator{

    @Override
    public double calculateShippingCost(double totalPrice) {
        return 0;
    }


}
