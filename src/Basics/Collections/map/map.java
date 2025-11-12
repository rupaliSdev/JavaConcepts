package Basics.Collections.map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //hashmap
		HashMap< String, Integer> map = new HashMap<>();
		map.put("a",10);
		map.put("b", 20);
		map.put("c", 30);
		map.put(null,40);
		map.putIfAbsent("a",40);
		map.computeIfAbsent("d",k->40);
		System.out.println(map.getOrDefault("a", 0));

		System.out.println(map.size() +","+ map.isEmpty() +","+ map.containsKey("a"));

		Set<Entry<String, Integer>> it1 = map.entrySet();
		System.out.println(it1);
		Set<String> it = map.keySet();
		System.out.println(it);
		
		if(map.containsValue(30)) {
			System.out.println("yes");
		}
		for(Entry<String,Integer>entry :map.entrySet()) {
			System.out.println(entry.getValue() +" "+ entry.getKey());
		}
		
		System.out.println(map.toString());

	} 
}
