package LLD_Design.OMS.op2;

import LLD_Design.OMS.OrderService;

import java.io.*;
import java.util.*;
interface IOrder {
    void setName(String name);
    String getName();
    void setPrice(int price);
    int getPrice();
}
interface IOrderSystem {
    void addToCart(IOrder order);
    void removeFromCart(IOrder order);
    int calculateTotalAmount();
    Map<String, Integer> categoryDiscounts();
    Map<String, Integer> cartItems();
}
class Order implements IOrder {

    private String name;
    private int price;

    public Order(String pizza, int price) {
        this.name=pizza;
        this.price=price;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        if(name.isEmpty()){
            System.out.println("Name can't be empty'");
            return;
        }
        this.name = name;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }
    @Override
    public void setPrice(int price) {
        // TODO Auto-generated method stub
        if(price<0){
            System.out.println("Price can't be negative'");
            return;
        }
        this.price = price;
    }
    @Override
    public int getPrice() {
        // TODO Auto-generated method stub
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getPrice() == order.getPrice() && Objects.equals(getName(), order.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

}
class OrderSystem implements IOrderSystem {

    Map<IOrder, Integer> cart;
    Map<String, Integer> categoryDiscounts;
    Map<String, Integer> cartItems;

    public OrderSystem(){
        categoryDiscounts = new HashMap<>();
        categoryDiscounts.put("Cheap", 10);
        categoryDiscounts.put("Moderate", 20);
        categoryDiscounts.put("Expensive", 30);
        cart = new HashMap<>();
        cartItems = new TreeMap<>();
    }

    @Override
    public void addToCart(IOrder order) {
        // TODO Auto-generated method stub
        if(order == null){
            System.out.println("Invalid order item");
            return;
        }
        cart.put(order, cart.getOrDefault(order, 0)+1);
        cartItems.put(order.getName(), cartItems.getOrDefault(order.getName(), 0)+1);
    }
    @Override
    public void removeFromCart(IOrder order) {
        // TODO Auto-generated method stub
        if(order == null){
            System.out.println("Invalid order item");
            return;
        }
        if(!cart.containsKey(order)){
            System.out.println("Given order item doesn't exist in the cart'");
            return;
        }
        int quantity = cart.get(order);
        if(quantity == 1){
            cart.remove(order);
            cartItems.remove(order.getName());
        }else{
            cart.put(order, quantity-1);
            cartItems.put(order.getName(), quantity-1);
        }
    }
    @Override
    public int calculateTotalAmount() {
        // TODO Auto-generated method stub
        int total = 0;
        for(Map.Entry<IOrder,Integer> item : cart.entrySet()){
            int quantity = item.getValue();
            if(item.getKey().getPrice()<=10){
                total += quantity * (item.getKey().getPrice() - ((item.getKey().getPrice() * categoryDiscounts.get("Cheap")/100)));
            }else if(item.getKey().getPrice()>10 && item.getKey().getPrice()<=20){
                total += quantity * (item.getKey().getPrice() - ((item.getKey().getPrice() * categoryDiscounts.get("Moderate")/100)));
            }else{
                total += quantity * (item.getKey().getPrice() - ((item.getKey().getPrice() * categoryDiscounts.get("Expensive")/100)));
            }
        }
        return total;
    }
    @Override
    public Map<String, Integer> categoryDiscounts() {
        // TODO Auto-generated method stub

        Map<String, Integer> catDiscounts = new HashMap<>();

        for(Map.Entry<IOrder,Integer> item : cart.entrySet()){
            int discount = 0;
            int quantity = item.getValue();
            if(item.getKey().getPrice()<=10){
                discount = quantity * (item.getKey().getPrice() * categoryDiscounts.get("Cheap")/100);
                catDiscounts.put("Cheap", catDiscounts.getOrDefault("Cheap", 0)+discount);
            }else if(item.getKey().getPrice()>10 && item.getKey().getPrice()<=20){
                discount = quantity * (item.getKey().getPrice() * categoryDiscounts.get("Moderate")/100);
                catDiscounts.put("Moderate", catDiscounts.getOrDefault("Moderate", 0)+discount);
            }else{
                discount = quantity * (item.getKey().getPrice() * categoryDiscounts.get("Expensive")/100);
                catDiscounts.put("Expensive", catDiscounts.getOrDefault("Expensive", 0)+discount);
            }
        }
        return catDiscounts;
    }
    @Override
    public Map<String, Integer> cartItems() {
        // TODO Auto-generated method stub
        return cartItems;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter textWriter = new PrintWriter(System.out);
        IOrderSystem system= new OrderSystem();
        system.addToCart(new Order("Pizza", 40));
        system.addToCart(new Order("Pizza", 50));
        system.addToCart(new Order("Sandwich", 30));
        system.addToCart(new Order("Sandwich", 30));
        system.addToCart(new Order("Sandwich", 30));
        system.addToCart(new Order("Roll", 20));
        system.addToCart(new Order("Roll", 20));
        system.addToCart(new Order("Roll", 20));
        int totalAmount = system.calculateTotalAmount();
        textWriter.println("Total Amount: " + totalAmount);
        Map<String, Integer> categoryDiscounts = system.categoryDiscounts();
        for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
            if(entry.getValue() > 0) {
                textWriter.println(entry.getKey() + " Category Discount: " + entry.getValue());
            }
        }
        Map<String, Integer> cartItems = system.cartItems();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            textWriter.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }
        textWriter.flush();
        textWriter.close();


    }
}