package java8features.StreamHandsOn.streamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemoex3 {

	public static void main(String[] args) {
		List<Integer> num =new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		
		List<Integer> squares = num.stream().map(n->n*n).collect(Collectors.toList());
		
		System.out.println(squares);
		squares.forEach(System.out::println);
	}
}

