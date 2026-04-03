package LLD_Design.problems.InventoryManagementSystem.model;

import java.util.Date;

public class GroceryProduct extends Product{
    private Date expiryDate;
    public GroceryProduct(int id, String name, float price, Date expiryDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
