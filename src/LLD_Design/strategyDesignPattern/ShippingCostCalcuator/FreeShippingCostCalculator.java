package LLD_Design.strategyDesignPattern.ShippingCostCalcuator;

public class FreeShippingCostCalculator implements ShippingCostCalculator{


    @Override
    public double calculateShippingCost(double totalPrice) {
        return 0;
    }
}
