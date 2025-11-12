package Basics.Collections;

import java.util.HashSet;
import java.util.Iterator;




public class hashset {

	public static void main(String[] args) {
		//
//		Set<String> hset = new HashSet<String>();
//		hset.add("h");
//		hset.add("b");
//		hset.add("y");
//		for(String i :hset) {
//			System.out.println(i);
//		}
//		System.out.println(hset);
//        boolean r1 = hset.add("yu");
//        System.out.println(r1);
//        boolean r2 = hset.add("yu");
//        System.out.println(r2);
//        System.out.println(hset.contains("yu"));
//        System.out.println(hset);
//        Iterator it = hset.iterator();
//        while(it.hasNext()) {
//        	System.out.println((String)it.next());
//        }
//        Iterator it = hset.iterator();   //Displya elements is one direction
//		while(it.hasNext()) {
//			String value = (String)it.next();
//			System.out.println("Value : "+value);
//		}
		HashSet<String> hs;
        hs = new HashSet<String>();
        //Duplicate elements are not permitted
		hs.add("Mayuri");
		hs.add("Rajendra");
		hs.add("Sannap");
		hs.add("Lalita");
		hs.add("Vinayak");
		hs.add("Priyanka");

		Iterator it = hs.iterator();   //Displya elements is one direction
		while(it.hasNext()) {
			String value = (String)it.next();
			System.out.println("Value : "+value);
		}
		System.out.println("Size : "+hs.size());
		System.out.println(hs.contains("Vinayak"));
		//Remove element from hashset
		hs.remove("Mayuri");
		
		System.out.println(hs);
		
		//To remove all objects from hashset
		hs.clear();
		System.out.println("String is "+hs);

		//type eraser : any internal type will be erased at runtime

		System.out.println(hs.getClass().getName());
	}

}
