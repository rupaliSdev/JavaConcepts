package DSA.dp.knapsack01;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int target = 9;

        if (findTheSubsetRecursive(arr, 0, 0, target)) {
            System.out.print("yes ");
        }

        int[][] dp = new int[target + 1][arr.length];
        for (int[] d : dp) Arrays.fill(d, -1);
        if (findTheSubsetMemo(arr, 0, target, dp)) {
            System.out.print("yes ");
        }

    }

    private static boolean findTheSubsetRecursive(int[] arr, int curr_sum, int index, int target) {

        if (curr_sum > target || index == arr.length) {
            return false;
        }
        if (curr_sum == target) {
            return true;
        }

        //take
        boolean take = findTheSubsetRecursive(arr, curr_sum + arr[index], index + 1, target);
        boolean noTake = findTheSubsetRecursive(arr, curr_sum, index + 1, target);

        return take || noTake;
    }

    private static boolean findTheSubsetMemo(int[] arr, int index, int target, int[][] dp) {

        if (index == arr.length) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (dp[target][index] != -1) {
            return dp[target][index] == 1;
        }

        //take
        boolean take = false;
        if (arr[index] <= target) {
            take = findTheSubsetMemo(arr, index + 1, target - arr[index], dp);
        }

        boolean notake = findTheSubsetMemo(arr, index + 1, target, dp);
        dp[target][index] = take || notake ? 1 : 0;

        return take || notake;
    }

    private static boolean findTheSubsettab(int[] arr, int target) {

        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }


        for (int i = 1; i <= arr.length; i++) {
            for (int sum = 1; sum <= target; sum++) {
                boolean take = false;
                if (arr[i - 1] <= sum) {
                    take = dp[i - 1][sum - arr[i - 1]];
                }
                boolean notake = dp[i - 1][sum];
                dp[i][sum] = take || notake;
            }
        }
        return dp[arr.length][target];
    }

    //tc:o(n*target)


    private static boolean findTheSubsetOpt(int[] arr, int target) {

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < arr.length; i++) {
            for (int sum = target; sum >= arr[i]; sum--) {
                boolean take = false;
                if (arr[i] <= sum) {
                    take = dp[sum - arr[i]];
                }
                boolean notake = dp[sum];
                dp[sum] = take || notake;
            }
        }

        return dp[target];
    }

}
