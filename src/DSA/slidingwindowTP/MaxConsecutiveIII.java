package DSA.slidingwindowTP;

public class MaxConsecutiveIII {
    public static void main(String[] args) {

    }
/*
    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
            if you can flip at most k 0's
            .*/

    public int longestOnes(int[] nums, int k) {

        int left =0,right =0;
        int zeros=0;
        int maxLen=0;
        while(right<nums.length){
            if(nums[right]==0){
               zeros++;
            }

            while (zeros>k && left<=right){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;

        }
        return maxLen;

    }
}
