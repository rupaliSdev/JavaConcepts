package DSA.dp;

import java.util.Arrays;

public class UnboundedKnapsackMemo {

    public int maxKnapSackMemoization(int[] wt, int[] val, int n, int cap) {
        int[][] dp = new int[n][cap + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(n - 1, cap, wt, val, dp);
    }

    private int dfs(int i, int cap, int[] wt, int[] val, int[][] dp) {
        // Base case
        if (i == 0) {
            return (cap / wt[0]) * val[0]; // can take multiple times
        }

        if (dp[i][cap] != -1) return dp[i][cap];

        int notTake = dfs(i - 1, cap, wt, val, dp);
        int take = 0;
        if (wt[i] <= cap)
            take = val[i] + dfs(i, cap - wt[i], wt, val, dp); // reuse same item

        return dp[i][cap] = Math.max(notTake, take);
    }

    public static void main(String[] args) {
        UnboundedKnapsackMemo obj = new UnboundedKnapsackMemo();
        int[] wt = {2, 3, 4, 5};
        int[] val = {5, 6, 7, 8};
        int cap = 8;
        System.out.println("Max Value = " + obj.maxKnapSackMemoization(wt, val, wt.length, cap));
    }
}
