package LLD_Design.P_creational.AbstarctFactory;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingFactory factory =
                new MallParkingFactory();

        ParkingSpot spot = factory.createSpot();
        Ticket ticket = factory.createTicket();
        PricingStrategy pricing = factory.createPricing();
    }
}

interface ParkingSpot {
    int getPrice();
}

interface Ticket {
    void generate();
}

interface PricingStrategy {
    int calculate(int hours);
}

//Mall implementation
class MallSpot implements ParkingSpot {
    public int getPrice() { return 20; }
}

class MallTicket implements Ticket {
    public void generate() {
        System.out.println("Mall Ticket Generated");
    }
}

class MallPricing implements PricingStrategy {
    public int calculate(int hours) {
        return hours * 20;
    }
}

//Step 3: Airport Implementations
class AirportSpot implements ParkingSpot {
    public int getPrice() { return 50; }
}

class AirportTicket implements Ticket {
    public void generate() {
        System.out.println("Airport Ticket Generated");
    }
}

 class AirportPricing implements PricingStrategy {
    public int calculate(int hours) {
        return hours * 50;
    }
}

//Abstract Factory
interface ParkingFactory {

    ParkingSpot createSpot();

    Ticket createTicket();

    PricingStrategy createPricing();
}

//concrete Factories
class MallParkingFactory
        implements ParkingFactory {

    public ParkingSpot createSpot() {
        return new MallSpot();
    }

    public Ticket createTicket() {
        return new MallTicket();
    }

    public PricingStrategy createPricing() {
        return new MallPricing();
    }
}

class AirportParkingFactory
        implements ParkingFactory {

    public ParkingSpot createSpot() {
        return new AirportSpot();
    }

    public Ticket createTicket() {
        return new AirportTicket();
    }

    public PricingStrategy createPricing() {
        return new AirportPricing();
    }
}