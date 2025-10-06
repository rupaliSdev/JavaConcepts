package LLD_Design.SOLIDPrniciples.DI;

public class DependecyInversion {


    public static void main(String[] args) {

        //a class should depend upon interface rather than concrete class as we can do modification or any changes in the
        //implementation
        OrderRepository orderRepository= new DatabaseOrderRepository();
        OrderService orderService= new OrderService(orderRepository);

    }


}
