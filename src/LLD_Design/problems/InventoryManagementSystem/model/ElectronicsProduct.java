package LLD_Design.problems.InventoryManagementSystem.model;

public class ElectronicsProduct extends Product{
    private int warrantyPeriod;

    public ElectronicsProduct(int id, String name, float price,int warrantyPeriod) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
