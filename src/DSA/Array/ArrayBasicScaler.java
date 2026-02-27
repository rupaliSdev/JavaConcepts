package DSA.Array;

import java.util.HashMap;
import java.util.Scanner;

public class ArrayBasicScaler {

	
	public static void main(String[] args) {
       //RotationGame

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        int B = sc.nextInt();
        B=B%n;
        arr =reverse(arr,0,n-1);
        arr =reverse(arr,0,B-1);
        arr =reverse(arr,B,n-1);
        for(int i =0 ;i<n ;i++){
            System.out.print(arr[i] + " ");
        }
        
    }
    public static int[] reverse(int[] arr,int s,int e){

        while(s<=e){
            int temp = arr[s];
            arr[s]= arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
        return arr;
    }
    //Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). 
    //Check if any good pair exist or not.
    public int GoodPair(int[] A, int B) {


        HashMap<Integer,Integer> map= new HashMap<>();


      for(int i =0 ;i<A.length ;i++){
          int comp = B-A[i];
           if(map.containsKey(comp)){
               return 1;
           }
           map.put(A[i],i);
        }
        return 0;
    }
    
    //Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

//Find the rotated array for each value 
//and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.
    
    public int[][] solveleftRotation(int[] A, int[] B) {
        int n =A.length;
        int k=B.length;

        int[][] arr = new int[k][n];

        for(int i=0;i<k;i++){
            B[i]=B[i]%n;
            for(int j=0;j<n;j++){
               arr[i][j]= A[(j+B[i])%n];

            
        }

        }
        return arr;
        }

}
