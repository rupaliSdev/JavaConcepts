package java8features.StreamHandsOn.streamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream4_First5 {

	public static void main(String[] args) {
		List<Integer> val = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter 10 Values");
		
		for(int i = 0; i< 10; i++) {
			val.add(s.nextInt());
		}

		List<Integer> first = val.stream().limit(5).collect(Collectors.toList());
		System.out.println("First five values from array : "+first);

	}

}
