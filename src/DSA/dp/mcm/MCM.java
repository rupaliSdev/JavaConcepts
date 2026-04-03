package DSA.dp.mcm;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        System.out.println(calcualateMCMRec(arr, 0, arr.length - 1));
        System.out.println(calculateMCMMemo(arr));
        System.out.println(calcualateMCMTab(arr));
    }

    //O(2 pow n)
    private static int calcualateMCMRec(int[] arr, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int curr_cost = calcualateMCMRec(arr, i, k) + calcualateMCMRec(arr, k, j) + arr[i] * arr[j] * arr[k];
            cost = Math.min(cost, curr_cost);

        }
        return cost == Integer.MAX_VALUE ? 0 : cost;
    }

    private static int calculateMCMMemo(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] d : dp) Arrays.fill(d, -1);
        return calcualateMCM(arr, dp, 0, arr.length - 1);
    }

    //range of i is 0 to n and j is 0 to n so total states = o(n*n) and for each state we are traversing n so tc(n*n*n)

    private static int calcualateMCM(int[] arr, int[][] dp, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int cost = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int curr_cost = calcualateMCM(arr, dp, i, k) + calcualateMCM(arr, dp, k, j) + arr[i] * arr[j] * arr[k];
            cost = Math.min(cost, curr_cost);

        }
        return dp[i][j] = cost == Integer.MAX_VALUE ? 0 : cost;

    }

    private static int calcualateMCMTab(int[] arr) {

        int[][] dp = new int[arr.length][arr.length];

        for (int gap = 2; gap < arr.length; gap++) {
            for (int i = 0; i+gap < arr.length; i++) {
                int j = i + gap;
                int cost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    cost = Math.min(cost, dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
                dp[i][j] = cost == Integer.MAX_VALUE ? 0 : cost;
            }
        }
        return dp[0][arr.length - 1];

    }


}
