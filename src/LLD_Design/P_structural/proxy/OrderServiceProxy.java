package LLD_Design.P_structural.proxy;

import LLD_Design.problems.HMS.Order;

import java.util.HashMap;
import java.util.Map;

class OrderServiceProxy implements OrderService {

    private OrderService realService;
    private Map<String, Order> cache = new HashMap<>();

    public OrderServiceProxy(OrderService realService) {
        this.realService = realService;
    }

    public Order getOrder(String id) {

        if(cache.containsKey(id)) {
            return cache.get(id);
        }

        Order order = realService.getOrder(id);
        cache.put(id, order);
        return order;
    }
}