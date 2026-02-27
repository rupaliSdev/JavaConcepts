package LLD_Design.SOLIDPrniciples.DI;

public class DependecyInversion {


    public static void main(String[] args) {


        OrderRepository orderRepository= new DatabaseOrderRepository();
        OrderService orderService= new OrderService(orderRepository);

    }


    static class DatabaseOrderRepository implements  OrderRepository{

    }

    static class InMemoryOrderRepository implements OrderRepository{

    }

    static interface OrderRepository {
    }

     static class OrderService {
         //a class should depend upon interface rather than concrete class as we can do modification
         // or any changes in the
         //impl
        OrderRepository orderRepository;

        OrderService(OrderRepository orderRepository){
            this.orderRepository=orderRepository;
        }
    }
}
