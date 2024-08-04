package Basics.Collections;

import java.util.HashMap;
import java.util.Map.Entry;
public class map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //hashmap
		HashMap< String, Integer> map = new HashMap<>();
		map.put("a",10);
		map.put("b", 20);
		map.put("c", 30);
		System.out.println(map.getOrDefault("a", 0));
//		Set<Entry<String, Integer>> it1 = map.entrySet();
//		System.out.println(it1);
//		Set<String> it = map.keySet();
//		System.out.println(it);
		
		if(map.containsValue(30)) {
			System.out.println("yes");
		}
		for(Entry<String,Integer>entry :map.entrySet()) {
			System.out.println(entry.getValue() +" "+ entry.getKey());
		}

		for(Entry<String,Integer> entry:map.entrySet()){

		}
		
		System.out.println(map.toString());

	} 
}
