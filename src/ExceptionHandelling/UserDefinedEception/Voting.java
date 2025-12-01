package ExceptionHandelling.UserDefinedEception;

import java.util.Scanner;

public class Voting {

	public static void main(String[] args) throws invalidAgeException {
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age to check if you are eligible or not?");
         int age= sc.nextInt();

			 if (age < 18) {
				 throw new invalidAgeException(age);
			 }

         
	}

	static class invalidAgeException extends Exception{
		private int age;

		invalidAgeException( int age) {
			this.age=age;
		}
		public String toString() {

			return "Your age id less than 18 ,you are not eligible";
		}
	}
}
