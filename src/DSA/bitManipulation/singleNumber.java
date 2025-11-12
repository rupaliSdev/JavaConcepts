package DSA.bitManipulation;

public class singleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1= {1, 2, 2, 3, 1};
		System.out.println(singleNumber(arr1));

		int[] arr2={1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
		System.out.println(singleNumberII(arr2));

	}

	// every element appears twice except for one. Find that integer that occurs once.
	public static int singleNumber(int[] A) {

			int x =A[0];
			for(int i=1;i<A.length;i++){
				x= x^A[i];
			}
			return x;


	}

	//every element appears thrice except for one, which occurs once.

	public static int singleNumberII(int[] nums) {
		int ones = 0, twos = 0, threes = 0;

		for (int i = 0; i < nums.length; i++) {
			// twos holds the num that appears twice
			twos |= ones & nums[i];

			// ones holds the num that appears once
			ones ^= nums[i];

			// threes holds the num that appears three times
			threes = ones & twos;

			// if num[i] appears three times
			// doing this will clear ones and twos
			ones &= ~threes;
			twos &= ~threes;
		}

		return ones;
	}



}
