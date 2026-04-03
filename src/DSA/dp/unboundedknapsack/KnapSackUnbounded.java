package DSA.dp.unboundedknapsack;

import java.util.Arrays;

public class KnapSackUnbounded {
    public static void main(String[] args) {

        int[] wt = {2, 3, 4, 5};
        int[] val = {5, 6, 7, 8};
        int cap = 8;
        System.out.println(knapSackII(val, wt, cap));
        System.out.println(knapSack(wt, val, cap));
        System.out.println(knapSackTab(val, wt, cap));

    }


    public static int knapSack(int wt[], int val[], int capacity) {
        return knapSackRecursive(val, wt, capacity, val.length - 1);
    }

    private static int knapSackRecursive(int[] val, int[] wt, int capacity, int index) {
        if (capacity == 0) {
            return 0;
        }
        if (index == 0) {
            if (wt[0] <= capacity) {
                return capacity / wt[0] * val[0];
            }
            return 0;
        }
        int take = (wt[index] <= capacity) ? val[index] + knapSackRecursive(val, wt, capacity - wt[index], index) : 0;
        int notake = knapSackRecursive(val, wt, capacity, index - 1);
        return Math.max(take, notake);
    }

    public static int knapSackII(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity + 1];
        for (int i = 0; i < val.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return knapSackMemo(val, wt, capacity, val.length - 1, dp);
    }

    static int knapSackMemo(int[] val, int[] wt, int capacity, int index, int[][] dp) {
        if (index == 0) {
            if (wt[0] <= capacity) {
                return capacity / wt[0] * val[0];
            }
            return 0;
        }
        if (dp[index][capacity] != -1) return dp[index][capacity];
        int take = (wt[index] <= capacity) ? val[index] + knapSackMemo(val, wt, capacity - wt[index], index, dp) : 0;
        int notake = knapSackMemo(val, wt, capacity, index - 1, dp);
        return dp[index][capacity] = Math.max(take, notake);
    }

    public static int knapSackTab(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity + 1];

        for (int i = wt[0]; i <= capacity; i++) {
            dp[0][i] = i / wt[0] * val[0];
        }

        for (int i = 1; i < val.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                int nonTake = dp[i - 1][c];
                int take = 0;
                if (c >= wt[i]) {
                    take = val[i] + dp[i][c - wt[i]];
                }

                dp[i][c] = Math.max(take, nonTake);

            }

        }
        return dp[val.length - 1][capacity];

    }

    private static int tabulation(int[] wt, int[] val, int n, int cap) {
        int[][] dp = new int[n][cap + 1];
        for (int[] d : dp) Arrays.fill(d, -1);

        for (int i = wt[0]; i <= cap; i++) dp[0][i] = cap / wt[0] * val[0];

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= cap; w++) {
                int nonTake = dp[i - 1][w];
                int take = 0;
                if (wt[i] <= w) {
                    take = val[i] + dp[i][w - wt[i]];
                }
                dp[i][w] = Math.max(take, nonTake);
            }
        }
        return dp[n - 1][cap];
    }


}
