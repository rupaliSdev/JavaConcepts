package LLD_Design.creational.Builder_design;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;
    private Address billingAddress;
    private Address shippingAddress;
    private double discount;
    private double tax;

    public Order(List<Product> products, Address billingAddress, Address shippingAddress, double discount, double tax) {
        this.products = products;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.discount = discount;
        this.tax = tax;
    }

    public static class  OrderBuilder{
        private List<Product> products;
        private Address billingAddress;
        private Address shippingAddress;
        private double discount;
        private double tax;


        public OrderBuilder() {
            this.products = new ArrayList<>();
            this.discount = 0.0;
            this.tax = 0.0;
        }

        public OrderBuilder AddProducts(Product product) {

            this.products.add(product);
            return this;
        }

        public OrderBuilder setBillingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
            return  this;
        }

        public OrderBuilder setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public OrderBuilder setTax(double tax) {
            this.tax = tax;
            return this;
        }

        public Order build(){
            return new Order(products,billingAddress,shippingAddress,discount,tax);
        }

    }


    public static void main(String[] args) {

        Order order=new OrderBuilder().setDiscount(100.0).setBillingAddress(new Address()).setShippingAddress(new Address())
                .AddProducts(new Product()).AddProducts(new Product()).setTax(1.2).build();
    }
}
