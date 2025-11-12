package DSA.ArrayProblems.ArrayAdvanced;

public class FirstMissingInteger {

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{8, 10, 1, -3, 2, -5}));

	}

	public static int firstMissingPositive(int[] A) {
		int n = A.length;
		for(int i=0;i<n;i++){

			if((A[i]>n)|| (A[i]<=0) || (A[i]==i+1 ) || (A[i]==A[A[i]-1])){
				continue;
			}

			int temp = A[A[i]-1];
			A[A[i]-1] =A[i];
			A[i]=temp;
			i--;


		}
		for(int i=0;i<n;i++){
			if(A[i]!=i+1){
				return i+1;
			}

		}


		return n+1;
	}
}

