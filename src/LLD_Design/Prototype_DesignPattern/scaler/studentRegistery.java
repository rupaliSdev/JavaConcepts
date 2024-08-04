package LLD_Design.Prototype_DesignPattern.scaler;

import java.util.HashMap;

public class studentRegistery {
    private HashMap<String, Student> map = new HashMap<String,Student>();

    void register(String key, Student student){
         map.put(key,student);
     }

     Student get(String key){
         return map.get(key);
     }

}
