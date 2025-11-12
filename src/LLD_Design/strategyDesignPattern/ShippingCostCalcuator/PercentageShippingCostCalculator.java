package LLD_Design.strategyDesignPattern.ShippingCostCalcuator;

public class PercentageShippingCostCalculator implements ShippingCostCalculator {

    private double percentage;
    public PercentageShippingCostCalculator(double percentage) {
        this.percentage = percentage;
    }

@Override
public double calculateShippingCost(double totalPrice) {
    return totalPrice * percentage; // Percentage of the total price 
}

}
