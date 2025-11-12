package LLD_Design.Decorator;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee decorateCoffee) {
        super(decorateCoffee);
    }

    @Override
    public double getCost() {
        double cost = super.getCost();
        return super.getCost()+.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +", milk";
    }
}
