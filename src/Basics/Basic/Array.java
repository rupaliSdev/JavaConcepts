package Basics.Basic;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int[] anArray = {2,3,4,5,6,7,8};
        int[] arr1=new int[]{2,3,4,5,6};
        int[] arry= Arrays.copyOf(arr1,6);
        int[] arr2=Arrays.copyOfRange(anArray,0,3);
        //using constructors
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        //Array  = new int[5];
        for (int j : anArray) {
            System.out.println(j);
        }
//        for(int i =0;i<arr.length;i++) {
//       	      arr[i]=sc.nextInt();
//       }
        for(int i:anArray) {
       	 System.out.println(i);	
       }

        for(int i:arr) {
        	System.out.println(i);
        }

       System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arry));
        System.out.println(Arrays.toString(arr2));
       System.out.println(Arrays.toString(anArray));
	}

}
