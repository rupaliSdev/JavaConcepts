package LLD_Design.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private  final Map<Product,Integer>  inventoryList;

    public Inventory(){
        inventoryList= new HashMap<>();
    }
    public void addProduct(Product product,int qty){
        if(inventoryList.containsKey(product)){
            qty+= inventoryList.get(product);
        }
        inventoryList.put(product,qty);
    }

    public void updateQuantity(Product product,int qty){

        inventoryList.put(product,qty);
    }
    public int getQuantity(Product product) {
        return inventoryList.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product) {
        return inventoryList.containsKey(product) && inventoryList.get(product) > 0;
    }

}
