package DSA.dp;

import java.util.Arrays;

public class KnapsackBounded {

    public static void main(String[] args) {

    }

    public int maxKnapSackTabulation(int[] wt,int[] val,int n ,int cap ){
        int[][] dp = new int[n][cap+1];

        for(int i =wt[0] ;i<cap;i++) dp[0][i]=val[0];
        for(int i =1 ;i<val.length;i++) {
            for (int j = 0; j <= cap; j++) {
                   int nonTake= dp[i-1][j];
                   int take =wt[i]<=cap? wt[i]+ dp[i-1][cap-wt[i]]:0;

                   dp[i][j]= Math.max(take,nonTake);
            }
        }
        return dp[n-1][cap];
    }
    //Tc-O(N*W) SC-O(N*W)

    public int maxKnapSackMemoization(int[] wt,int[] val,int n ,int cap ){
        int[][] dp = new int[n][cap+1];
        Arrays.fill(dp,-1);

        return knapSackUtil(dp,wt,val,n-1,cap);
    }

    private int knapSackUtil(int[][] dp, int[] wt, int[] val, int n, int cap) {
        if(n==0) {
            if (wt[n] <= cap) {
                return val[0];
            }
            return 0;
        }
        if(dp[n][cap]!=-1){
            return dp[n][cap];
        }
        int nonTake = knapSackUtil(dp,wt,val,n-1,cap);
        int take =wt[n]<=cap?knapSackUtil(dp,wt,val,n-1,cap):0;

        return dp[n][cap]=Math.max(nonTake,take);
    }

    static int knapsack(int[] wt, int[] val, int n, int W) {
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[W + 1];

        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < n; ind++) {
            for (int cap = W; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[W];
    }

}
