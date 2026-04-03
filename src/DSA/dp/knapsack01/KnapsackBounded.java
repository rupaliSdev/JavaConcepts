package DSA.dp.knapsack01;

import java.util.Arrays;

public class KnapsackBounded {


    /*    Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively,
        also given an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
        Put the items into the knapsack such that the sum of values
        associated with them is the maximum possible, without exceeding the capacity W.*/
    public static void main(String[] args) {

        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int n = val.length;
        int cap = 4;
        int[][] dp = new int[n][cap + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        System.out.print(tabulationII(wt, val, n, cap));


    }

    private static int findTheMaxPossible(int[] wt, int[] val, int n, int cap) {
        if (cap == 0 || n == 0) {
            return 0;
        }
        int take = -1;
        if (wt[n - 1] <= cap) {
            take = val[n - 1] + findTheMaxPossible(wt, val, n - 1, cap - wt[n - 1]);
        }
        int noTake = findTheMaxPossible(wt, val, n - 1, cap);
        return Math.max(take, noTake);

    }
//    tc: o(2 pow n)

    private static int memoization(int[] wt, int[] val, int n, int cap, int[][] dp) {
        if (cap == 0 || n == 0) {
            return 0;
        }

        if (dp[n - 1][cap] != -1) {
            return dp[n - 1][cap];
        }
        int take = -1;
        if (wt[n - 1] <= cap) {
            take = val[n - 1] + findTheMaxPossible(wt, val, n - 1, cap - wt[n - 1]);
        }
        int noTake = findTheMaxPossible(wt, val, n - 1, cap);
        return dp[n - 1][cap] = Math.max(take, noTake);

    }
    //tc:o(n* cap)
    //    cap
    // n   0  1 2 3 4
    // 0   0  0 0 0 4
    // 1   0
    // 2   0


    private static int tabulation(int[] wt, int[] val, int n, int cap) {
        int[][] dp = new int[n][cap + 1];
        for (int c = 0; c <= cap; c++) {
            if (wt[0] <= c) dp[0][c] = val[0];
            else dp[0][c] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= cap; c++) {
                // here curr max capacity is c
                // not taking the current item
                int notake = dp[i - 1][c];
                //taking the current one
                int take = 0;
                if (wt[i] <= c) {
                    take = val[i] + dp[i - 1][c - wt[i]];
                }
                dp[i][c] = Math.max(take, notake);
            }
        }
        return dp[n - 1][cap];
    }

    private static int tabulationII(int[] wt, int[] val, int n, int cap) {
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 0; i <= n; i++) {
            for (int c = 0; c <= cap; c++) {
                if (i == 0 || c == 0) dp[i][c] = 0;
                else {
                    int notake = dp[i - 1][c];
                    //taking the current one
                    int take = 0;
                    if (wt[i - 1] <= c) {
                        take = val[i - 1] + dp[i - 1][c - wt[i - 1]];
                    }
                    dp[i][c] = Math.max(take, notake);
                }
            }
        }
        return dp[n][cap];

    }

    //Tc-O(N*W) SC-O(N*W)


    static int knapsack(int[] wt, int[] val, int n, int W) {
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[W + 1];

        // Base Condition: Initialize the first row of the array
        for (int cap = wt[0]; cap <= W; cap++) {
            prev[cap] = val[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind <n; ind++) {
            for (int cap = W; cap >= wt[ind]; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];
                // Calculate the maximum value when the current item is taken
                int taken = val[ind] + prev[cap - wt[ind]];
                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[W];
    }

//    | Problem Type       | Loop Direction |
//            | ------------------ | -------------- |
//            | 0/1 Knapsack       | Backward ✅     |
//            | Unbounded Knapsack | Forward ✅      |
//            | Coin Change        | Forward ✅      |
//            | Subset Sum         | Backward ✅     |


}
