package LLD_Design.P_structural.Decorator;

public class DecoratorDemo {

    //Decorator = Feature wrapping
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

    public static interface Coffee {

        double getCost();
        String getDescription();
    }

    public static class CoffeeDecorator implements Coffee {

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

    static class SimpleCoffee implements Coffee {
        @Override
        public double getCost() {
            return 1.0;
        }

        @Override
        public String getDescription() {
            return "Simple coffee";
        }
    }

    public static class Milk extends CoffeeDecorator {
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

    static class Sugar extends CoffeeDecorator {
        public Sugar(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double getCost() {
            return super.getCost() + 0.2;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", sugar";
        }

    }
}
