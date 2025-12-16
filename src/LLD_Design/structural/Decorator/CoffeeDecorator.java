package LLD_Design.structural.Decorator;

public class CoffeeDecorator implements Coffee{

    Coffee decorateCoffee;

    public CoffeeDecorator(Coffee decorateCoffee) {
        this.decorateCoffee = decorateCoffee;
    }

    @Override
    public double getCost() {
        return decorateCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decorateCoffee.getDescription();
    }
}
