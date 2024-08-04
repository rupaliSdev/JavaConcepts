package java8features.StreamHandsOn.streamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamFilter1_Salary {

	public static void main(String[] args) {
		int max_salary = 0;
		List<Integer> salaries = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter 5 Salaries");
		
		for(int i = 0; i< 5; i++) {
			salaries.add(s.nextInt());
		}

		max_salary = salaries.stream().max(Integer :: compareTo).get();
				//max(Integer :: compareTo).get();
		System.out.println("Maximum Salary : "+max_salary);

	}

}
