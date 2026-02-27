package LLD_Design.P_structural.proxy;

import LLD_Design.problems.HMS.Order;

interface OrderService {
    Order getOrder(String id);
}