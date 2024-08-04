package java8features.StreamHandsOn.streamDemo;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo_ex1 {

	public static void main(String[] args) {
		long count = 0;
		List<String> names = new ArrayList<String>();
		names.add("Stella");
		names.add("John");
		names.add("Priya");
		names.add("Stephen");
//		for(String s : names) {
//			if(s.length()<=5)
//				count++;
//		}
		count = names.stream().filter(s->s.length()<=5).count(); //2
		System.out.println("There are "+count+ " Strings which is less than 5 charcaters");

	}

}