package Basics.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>lst = new ArrayList<>();
		lst.add(20);
		lst.add(10);
		lst.add(50);
		Collections.sort(lst);
		Collections.sort(lst,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		System.out.println(lst);
	}

}
