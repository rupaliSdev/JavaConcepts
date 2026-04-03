package DSA.slidingwindowTP;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {


    /*    Given a binary array nums and an integer k, return the maximum number of consecutive 1's
        in the array if you can flip at most k 0's.*/


        int nums[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, k = 2;
        System.out.println(longestOnes(nums, k));

        int nums1[] = {1, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(longestOnesAfterSwap(nums1));

    }


    public static int longestOnes(int[] nums, int k) {
        int l = 0, zeros = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            while (zeros > k && l <= i) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            ans = Math.max(i - l + 1, ans);

        }
        return ans;
    }

    //Given a binary array of zeros and ones,
    // find the max number of consecutive ones that can be obtained by swapping at most one zero to one.

    public static int longestOnesAfterSwap(int[] nums) {
        int totalOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }
        int zeros = 0, ans = 0, l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }

            while (zeros > 1 && l <= i) {
                if (nums[i] == 0) zeros--;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        ans= Math.min(ans,totalOnes);

        return ans;
    }
}
