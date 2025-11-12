package DSA.ArrayProblems.Array;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr= {5,3,6,3,4,7,2,4,5};
     System.out.println( First_Approach(arr));
     System.out.println(ThirdApproach(arr));
	 System.out.println(Fourth_Approach(arr));
	}
	static //time complexity O(n**2)
	int First_Approach(int[] arr) {
	     int n = arr.length;
	     int ans =0;
		for(int i =1;i<n-1;++i) {
			 int height = arr[i];
			 int left_max = arr[0];
			 
			 int right_max = arr[n-1];
			 
			for(int j =1; j<=i;++j) {
				if(left_max <= arr[j])
				
				{
					left_max = arr[j];
				}
				
			}
			
            for(int j =n-2; j>=i;--j) {
            	if(right_max <= arr[j])
    				
				{
					right_max = arr[j];
				}
            	
			}

            int support = Math.min(left_max, right_max);
			ans +=  Math.abs(support - arr[i]);
			

			
		}
     return ans;
	}
	//timecomplexity O(n) and space complexity o(n)
	static int Second_Approach(int[] arr) {
		int n = arr.length;
	     int ans =0;
	     
	     int[] left_max= new int[n];
	     left_max[0]= arr[0];
	     
	     
		 int[] right_max = new int[n];
		 right_max[n-1]= arr[n-1];
		
		for(int j =1; j<n;++j) {
			left_max[j]= Math.max(arr[j], left_max[j-1]);
			
		}
		for(int j =n-2; j>=0;--j) {
			right_max[j]= Math.max(arr[j], right_max[j+1]);
			
		}
		
;
	  for(int i =0;i<n;++i) {
			 
           
             int support =Math.min(left_max[i], right_max[i]);

			ans +=  Math.abs(support - arr[i]);
			

			
		}
    return ans;
		
		
		
		
		
	     
		}

		public static int ThirdApproach(int[] arr){

		    int leftMax= arr[0];
			int rightMax= arr[ arr.length-1];
			int l=1,r= arr.length-2;
			int water =0;
			while(l<=r){
				if(arr[l]<arr[r]){
					if(arr[l]>leftMax){
						leftMax= arr[l];

					}
					else{
						water+=(leftMax-arr[l]);
					}
					l++;
				}
				else {
					if(arr[r]>rightMax){
						rightMax= arr[r];
					}
					else{
						water+=(rightMax-arr[r]);
					}
					r--;
				}
			}

          return water;
		}


	static //time complexity O(n)
	int Fourth_Approach(int[] arr) {
		int n = arr.length;
		int ans =0;

		Stack<Integer> stack = new Stack<>();
		for(int i =0;i<=n-1;++i) {
			while (!stack.isEmpty() && arr[stack.peek()]< arr[i]){
				int curr = stack.pop();

				if(stack.isEmpty()) break;
				int distance = i-stack.peek()-1;
				ans += distance *(Math.min(arr[stack.peek()] ,arr[i]) - arr[curr]);
			}
           stack.push(i);
		}
		return ans;
	}
		
	
}
