package LLD_Design.Builder_design;

public class Client {
    public static void main(String[] args) {

        Order order=new Order.OrderBuilder().build();
    }
}
