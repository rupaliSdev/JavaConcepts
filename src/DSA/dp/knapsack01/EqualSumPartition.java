package DSA.dp.knapsack01;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5};
//                {1,2,3,5};

        System.out.print(canPartitionOpt(nums));

    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) return false;
        int target = total / 2;

        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                //here i index is i-1 index of nums[i];
                dp[i][sum] = ((sum >= nums[i - 1]) ? dp[i - 1][sum - nums[i - 1]] : 0)
                        | dp[i - 1][sum];

            }


        }
        return dp[nums.length][target] == 1;
    }

    public static boolean canPartitionOpt(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) return false;
        int target = total / 2;

        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int sum = target; sum >= nums[i]; sum--) {
                //here i index is i-1 index of nums[i];
                dp[sum] = dp[sum - nums[i]] || dp[sum];

            }


        }
        return dp[target];
    }
}