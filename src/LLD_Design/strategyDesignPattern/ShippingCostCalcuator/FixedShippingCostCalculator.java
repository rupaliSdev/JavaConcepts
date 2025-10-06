package LLD_Design.strategyDesignPattern.ShippingCostCalcuator;

public class FixedShippingCostCalculator implements  ShippingCostCalculator{

    double shippingCost;
    public FixedShippingCostCalculator(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public double calculateShippingCost(double totalPrice) {
        return shippingCost;
    }
}
