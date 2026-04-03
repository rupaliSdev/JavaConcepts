package DSA.Array.Kadane;

public class MaxSubArraySum {
    public static void main(String[] args) {

        System.out.println(maxSubarraySum(new int[]{-3, -2, -5}));

    }

    static int maxSubarraySum(int[] arr) {
        int max_sum = Integer.MIN_VALUE, curr_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            max_sum = Math.max(curr_sum, max_sum);
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}
