package DSA.ArrayAdvanced;

public class MaxAbsoluteDiff {
/*
	You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j)
	is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxArr(new int[]{1, 3, -1}));
	}



	public static int maxArr(int[] A) {


/*
|A[i] - A[j]| + |i - j|
A[i] -A[j] + i-j. i>j

A[i]+ i -(A[j]+j) , i>j
A[i]-A[j] + j-i

(A[i] - i) - (A[j]-j)

*/
		    int val1max = Integer.MIN_VALUE;
			int val1min = Integer.MAX_VALUE;
			int val2max = Integer.MIN_VALUE;
			int val2min = Integer.MAX_VALUE;

			for(int i=0;i<A.length;i++){
				int val1=  A[i]+i;
				int val2 = A[i]-i;

				val1max= Math.max(val1,val1max);
				val1min = Math.min(val1,val1min);
				val2max= Math.max(val2,val2max);
				val2min = Math.min(val2,val2min);
			}
			return Math.max((val1max-val1min),(val2max-val2min));
	}



}
