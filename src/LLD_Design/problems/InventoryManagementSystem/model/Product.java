package LLD_Design.problems.InventoryManagementSystem.model;

public abstract class Product {

     protected int id;
     protected String name;
     protected float price;
     protected int quantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

