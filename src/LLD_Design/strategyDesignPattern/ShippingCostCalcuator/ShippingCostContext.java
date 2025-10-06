package LLD_Design.strategyDesignPattern.ShippingCostCalcuator;

public class ShippingCostContext {
    private ShippingCostCalculator calculator;

    public ShippingCostContext(ShippingCostCalculator calculator) {
        this.calculator = calculator;
    }

    public double calculateShippingCost(double totalPrice) {
        return calculator.calculateShippingCost(totalPrice);
    }
}
