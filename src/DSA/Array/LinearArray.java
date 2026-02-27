package DSA.Array;

import java.util.Arrays;
import java.util.Scanner;

public class LinearArray {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			Scanner sc = new Scanner(System.in);
			int x= sc.nextInt();
			arr[i] = x;
		}
		System.out.println(Arrays.toString(arr));
       System.out.println(LinearSearch(7, arr));
	}
 static int LinearSearch(int x,int[] arr) {
	 
	 if(arr.length==0) {
		 return -1;
	 }
	 for(int i =0;i<arr.length;i++) {
		 if(arr[i]==x) {
			 return i;
		 }
	 }
	return -1;
	 
 }
}
