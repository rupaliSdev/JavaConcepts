package LLD_Design.problems.InventoryManagementSystem.model;

public class ClothingProduct extends Product {
    private String size;
    private String material;

    public ClothingProduct(int id, String name, float price,String size, String material) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }
}
