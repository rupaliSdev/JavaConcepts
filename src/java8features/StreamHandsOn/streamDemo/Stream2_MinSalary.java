package java8features.StreamHandsOn.streamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stream2_MinSalary {

	public static void main(String[] args) {
		int min_salary = 0;
		List<Integer> salaries = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter 5 Salaries");
		
		for(int i = 0; i< 5; i++) {
			salaries.add(s.nextInt());
		}

		min_salary = salaries.stream().min(Integer :: compareTo).get();
				//max(Integer :: compareTo).get();
		System.out.println("Minimum Salary : "+min_salary);
	}

}
