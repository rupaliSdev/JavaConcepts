package LLD_Design.SOLIDPrniciples.DI;

public class OrderService {
    OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
}
