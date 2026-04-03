package LLD_Design.problems.InventoryManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static Inventory instance;
    List<Product> products=new ArrayList<>();
    List<Observers> observers=new ArrayList<>();

    private Inventory() {}

    public static synchronized Inventory getInstance(){
        if(instance==null) synchronized(Inventory.class){if(instance==null)return new Inventory();}
        return instance;
    }

    public void addProduct(Product product){
        products.add(product);
        notifyObserver(product.getId());

    }

    private void notifyObserver(int productId) {
        for(Observers observer:observers){
            observer.update(productId);
        }
    }

    public void removeProduct(Product product){

    }

    public void updateProduct(Product product,int quantity){


    }
    public void checkStock(int productId){

    }
    public void addObserver(Observers observer){
        observers.add(observer);
    }
}
