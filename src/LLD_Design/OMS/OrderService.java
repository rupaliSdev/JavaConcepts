package LLD_Design.OMS;


import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {


    static interface IOrder {
        void setName(String name);
        String getName();
        void setPrice(int price);
        int getPrice();
    }
    static interface IOrderSystem {
        void addToCart(IOrder order);
        void removeFromCart(IOrder order);
        double calculateTotalDiscountedPrice();
        Map<DiscountCategory, Double> getCategoryDiscounts();
        Map<String, Integer> getCartItems();
        Map<String, Integer> showCart();
        Map<String,Order> orderListMap = new HashMap<>();

    }

    static enum DiscountCategory{
        CHEAP(10),MODERATE(20),EXPENSIVE(30);
        private final int discount;

        DiscountCategory(int discount) {
            this.discount = discount;
        }

        public int getDiscount() {
            return discount;
        }

        public static DiscountCategory getCategory(double price){
            if(price<10) return CHEAP;
            if(price<=20) return MODERATE;
            return EXPENSIVE;
        }
    }

    static class Order implements IOrder{

        String name;
        int price;

        public Order(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public void setName(String name) {
            if(name==null && name.isEmpty()){
                System.out.println("Name can't be empty");
                return;
            }
            this.name=name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setPrice(int price) {
            if (price < 0) {
                System.out.println("Price cannot be negative");
                return;
            }
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj)return true;
            if(obj instanceof Order)return false;
            Order order = (Order) obj;
            return this.name.equals(order.name) && this.price== order.price;
        }
    }
    static class OrderSystem implements IOrderSystem{

        private final Map<String, List<IOrder>> cart = new HashMap<>();

        @Override
        public void addToCart(IOrder order) {
            cart.computeIfAbsent(order.getName(), k -> new java.util.ArrayList<>()).add(order);
        }

        @Override
        public void removeFromCart(IOrder order) {
            if (cart.containsKey(order.getName())) {
                List<IOrder> orders = cart.get(order.getName());
                orders.remove(order);
                if (orders.isEmpty()) {
                    cart.remove(order.getName());
                }
            }
        }

        @Override
        public double calculateTotalDiscountedPrice() {
            double price =0.0;
            for(List<IOrder> orders: cart.values()){
                for(IOrder order: orders){
                    double curr_price=order.getPrice() * (1- DiscountCategory.getCategory(order.getPrice()).getDiscount()/100.0);
                  price +=curr_price;
                }
            }
            return price;
        }

        @Override
        public Map<DiscountCategory, Double> getCategoryDiscounts() {
            Map<DiscountCategory, Double> discountCategoryMap=
                    new EnumMap<>(DiscountCategory.class);
            for(List<IOrder> orders : cart.values())
            {
                for(IOrder order:orders){
                    DiscountCategory category=DiscountCategory.getCategory(order.getPrice());
                    discountCategoryMap.put(category,
                            discountCategoryMap.getOrDefault(category,0.0)+ order.getPrice() * (1- DiscountCategory.getCategory(order.getPrice()).getDiscount()/100.0));

                }
            }
            return discountCategoryMap;
        }

        @Override
        public Map<String, Integer> getCartItems() {
            Map<String,Integer> result = new HashMap<>();
            for (String name:cart.keySet()){
                result.put(name, cart.get(name).size());
            }
            return result;
        }


        @Override
        public Map<String, Integer> showCart() {
            return Map.of();
        }

    }

    public static void main(String[] args) {
        IOrderSystem system= new OrderSystem();
        system.addToCart(new Order("Pizza", 40));
        system.addToCart(new Order("Pizza", 50));
        system.addToCart(new Order("Sandwich", 30));
        system.addToCart(new Order("Sandwich", 30));
        system.addToCart(new Order("Sandwich", 30));
        system.addToCart(new Order("Roll", 20));
        system.addToCart(new Order("Roll", 20));
        system.addToCart(new Order("Roll", 20));
        double total = system.calculateTotalDiscountedPrice();
        System.out.println("Total Amount: " + total);
        Map<DiscountCategory, Double> discounts = system.getCategoryDiscounts();
        System.out.println("Expensive Category Discount: " + discounts.get(DiscountCategory.EXPENSIVE));
        System.out.println("Moderate Category Discount: " + discounts.get(DiscountCategory.MODERATE));

        Map<String, Integer> cartItems = system.getCartItems();
        cartItems.forEach((k, v) -> System.out.println(k + " (" + v + " items)"));

    }
}

//https://chatgpt.com/c/692d380c-f464-8323-a277-e96b3ff1964c
