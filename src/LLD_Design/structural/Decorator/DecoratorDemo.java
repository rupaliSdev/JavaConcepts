package LLD_Design.structural.Decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        //order a simple coffee
        Coffee coffee= new SimpleCoffee();
        double cost = coffee.getCost();
        System.out.println(coffee.getDescription()+" cost:"+coffee.getCost());

        coffee= new Milk(coffee);
        cost = coffee.getCost();
        System.out.println(coffee.getDescription()+" cost:"+coffee.getCost());
        coffee= new Sugar(coffee);
        System.out.println(coffee.getDescription()+" cost:"+coffee.getCost());
    }
}
