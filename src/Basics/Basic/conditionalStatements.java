package Basics.Basic;

import java.util.Scanner;

public class conditionalStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int p = sc.nextInt();
		if(p %2==0) {
			System.out.println("even number");
		}
		else {
			System.out.println("odd number");
		}

        /////////////////////////////////
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a==b) {
			System.out.println("a and b are equal");
		}
		else if(a>b){
			System.out.println("a is grater than b");
		}
		
		else {
			System.out.println("a is less than b");
		}


		/////////////////////////////
		int button = sc.nextInt();
		if(button ==1) {
			System.out.println("hello");
		}
		else if ( button ==2){
			System.out.println("hi");
		}
		else if (button ==3){
			System.out.println("bi");
		}
		else {
			System.out.println("Invalid");
		}
		

		/////////////////////////////////

		switch(button) {
		case 1:
			System.out.println("hello");
			break;
		case 2:
			System.out.println("hi");
			break;
		case 3:
			System.out.println("bi");
			break;
		default:
			System.out.println("Invalid");
		
		}
	}
	

}
