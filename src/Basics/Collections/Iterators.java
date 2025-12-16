package Basics.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {

	public static void main(String[] args) {

    /*    The java.util.Iterator interface in Java is used to iterate over elements of
                a collection sequentially.
• It provides methods for checking if there are more elements (hasNext()),
                retrieving the next element (next()), and removing the current element
        (remove()).
• Iterator objects are obtained from collection classes using the iterator()
        method.*/

		//Iterator<String>str = Iterator();
        List<Integer> in = new ArrayList<Integer>();
        in.add(10);
        in.add(20);
        in.add(30);
        in.add(40);
        Iterator<Integer> it = in.iterator();
        while(it.hasNext()) {
            int val =it.next();
        	System.out.println(val);
            if(val==30){
                it.remove();
            }
        }

        System.out.println(in.contains(3));
        in.remove(1);//indexwise

        in.remove(Integer.valueOf(10));
        System.out.println(in.size());

        in.stream().forEach((i)-> System.out.println(i));
	}

}
