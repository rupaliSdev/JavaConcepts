package DSA.Array;

import java.util.Arrays;

public class SearchIn2D {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		int[][] arr = {{4,5,6},{7,8,9},{10,11,12}};
		int[] ans =LinearSearch(arr,5);
		System.out.println(Arrays.toString(ans));
		System.out.println(max(arr));

	}
	static int[] LinearSearch(int[][] arr ,int x) {
		for(int i=0 ; i<arr.length;i++ ) {
			for(int j=0;j<arr[i].length;j++) {
				
				if(arr[i][j] == x) {
					return   new int[]{i,j};
				}
			}
		}
		return new int[] {-1,-1};
	}
	static int max(int[][] arr) {
		int max_value  = Integer.MIN_VALUE;
		
		for(int i=0 ; i<arr.length;i++ ) {
			for(int j=0;j<arr[i].length;j++) {
				
				if(arr[i][j] >=max_value) {
					max_value = arr[i][j];
				}
			}
		}
		return max_value;}

}
