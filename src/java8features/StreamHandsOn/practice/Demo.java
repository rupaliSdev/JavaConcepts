package java8features.StreamHandsOn.practice;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://priyank-agarwal.medium.com/mastering-java-streams-with-complex-data-structures-45a0f4031b46
class Demo {
    public static void main(String[] args) {

//        Filter Customers with No Orders

        List<Customer> customers = new ArrayList<>();

        List<Customer>customersWithNoOrders= customers.stream().filter((c) -> c.getOrders().isEmpty())
                .collect(Collectors.toList());

//        Extract and Flatten Products from All Orders


//        flatMap()

//        Used when each input produces multiple values, and you want to flatten them into single stream.
        List<Product> products = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream()).toList();

//
//        map()
//
//        Takes each item and converts it → 1 input → 1 output


//        3. Calculate Total Spent by Each Customer
//        Problem: Compute the total amount each customer has spent on their orders.

        Map<Customer, Double> totalSpentByCustomer = customers.stream()
                .collect(Collectors.toMap(c -> c, customer -> customer.getOrders()
                        .stream().flatMap(order -> order.getProducts().stream())
                        .mapToDouble(Product::getPrice).sum())
                );


//2nd approach
        customers.stream()
                .collect(Collectors.toMap
                        (Function.identity(),
                                customer -> customer.getOrders().stream()
                                        .flatMap(order -> order.getProducts().stream())
                                        .mapToDouble(Product::getPrice).sum()));


// Group Orders By Date

        Map<Date, List<Order>> orderByDate = customers.stream().flatMap(customer -> customer.getOrders()
                .stream()).collect(Collectors.groupingBy(Order::getOrderDate));




     /*   5. Find Most Expensive Product Ordered
        Problem: Identify the most expensive product ordered by any customer.*/

        Product mostExpensiveProduct = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .max(Comparator.comparing(Product::getPrice)).orElseThrow(NoSuchElementException::new);






/*        6. Count Orders for Each Product
        Problem: Count how many times each product has been ordered across all customers.*/


        Map<String, Long> productOrderCount = customers.stream()
                .flatMap((c) -> c.getOrders().stream())
                .flatMap((o) -> o.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));



   /*     7. Filter Orders with Products Above a Price
        Problem: Find all orders that contain products priced above a certain threshold.*/

        double priceThreshold = 100.0;
        List<Order> highValueOrders = customers.stream().flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getPrice() >= priceThreshold)).toList();


//        8. Find Customers Who Ordered Specific Product Category
//        Problem: Identify customers who have ordered products in a specific category.
        String category = "Electronics";
        List<Customer> customersOrderSpecificCategory = customers.stream()
                .filter(customer -> customer.getOrders().stream()
                        .flatMap(order -> order.getProducts().stream())
                        .anyMatch(product -> product.getCategory().equals(category))).toList();




        /*9. Calculate Average Price of Products per Order
        Problem: Compute the average price of products for each order.*/


        Map<Integer, Double> avgPriceProductPerOrder = customers.stream().
                flatMap(customer -> customer.getOrders().stream())
                .collect(
                        Collectors.toMap(o -> o.getOrderId(),
                                o -> o.getProducts().stream()
                                        .mapToDouble(Product::getPrice).average().orElse(0.0)));







/*        10. Find Customers with Orders in Last Month
        Problem: Find customers who have placed an order in the last month.*/

        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        List<Customer> customersOrderedLastMonth = customers.stream()
                .filter(customer -> customer.getOrders().stream()
                        .anyMatch(order -> order.getOrderDate().toInstant()
                                .atZone(ZoneId.systemDefault()).toLocalDate().isAfter(oneMonthAgo)))
                .toList();

       /* 11. Sort Customers by Total Spending
        Problem: Sort customers by the total amount they have spent, in descending order.
        */

        List<Customer> customersSortedBasedOnspend = customers.stream()
                .sorted(Comparator.comparingDouble(c -> c.getOrders().stream()
                        .flatMap(order -> order.getProducts().stream())
                        .mapToDouble(Product::getPrice).sum())).toList();


/*
        12. Partition Orders by Product Category
      Problem: Partition orders into those containing products of a specified category and those that do not.*/
        String categoryOfProduct = "Electronics";
        Map<Boolean, List<Order>> ordersByCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.partitioningBy((o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals(categoryOfProduct)))));


  /*     13. Summarize Statistics for Product Prices
        Problem: Get summary statistics (count, sum, average, min, max) for product prices.*/
        DoubleSummaryStatistics doubleSummaryStatistics = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .summaryStatistics();


 /*       14. Find Any High-Value Order
        Problem: Find any order with a total value greater than a specified amount.*/

        double minValue = 200.0;
        Optional<Order> highValueOrder = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(o -> o.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                        .sum() > minValue)
                .findFirst();



  /*      15. Transform Orders to Descriptive Strings
        Problem: Convert each order to a string describing its details (e.g., order ID, total price).*/

        List<String> orderList = customers.stream().flatMap(c -> c.getOrders().stream())
                .map(order -> order.toString()).toList();
    }
}

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Order {

    List<Product> products;
    int orderId;
    Date orderDate;

    public Order(List<Product> products, int orderId, Date orderDate) {
        this.products = products;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", orderId=" + orderId +
                ", orderDate=" + orderDate +
                '}';
    }
}

class Customer {
    int customerId;
    String name;
    List<Order> orders;

    public Customer(int customerId, String name, List<Order> orders) {
        this.customerId = customerId;
        this.name = name;
        this.orders = orders;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}