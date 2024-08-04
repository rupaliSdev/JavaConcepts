package java8features.StreamHandsOn.streamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream3_DistinctJob {

	public static void main(String[] args) {
		
		List<String> jobs = new ArrayList<String>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter 5 Jobs");
		
		for(int i = 0; i< 5; i++) {
			jobs.add(s.nextLine());
		}

		List<String> distinct_jobs = jobs.stream().distinct().collect(Collectors.toList());

		System.out.println("------Distinct Jobs------");
		distinct_jobs.forEach(System.out::println);
	}
}
