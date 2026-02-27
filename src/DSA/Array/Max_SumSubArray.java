package DSA.Array;

import java.util.List;

public class Max_SumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}
	public int maxSubArray(final List<Integer> A) {
        //if()
        int max_sum =Integer.MIN_VALUE;
        int curr_sum =0;
        for(int i =0;i<A.size();i++){
            curr_sum = curr_sum + A.get(i);

            if(curr_sum>max_sum){
                max_sum = curr_sum;
            }
            if(curr_sum<0){
                curr_sum =0;
            }
        }

 return max_sum;
 }
}
