package DSA.dp.unboundedknapsack;

import java.util.Arrays;

public class RodCuttingProblem {


/*
    Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i.
    Your task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.

    Note: n = size of price, and price[] is 1-indexed array.

    Example:

    Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
    Output: 22
    Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
    */

    public static void main(String[] args) {

        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int cap = price.length;

        System.out.println(knapsackRecursive(price,cap,cap));
        System.out.println(knapsackMemo(price,cap,cap));
        System.out.println(knapsackTab(price,cap,cap));
    }

    private static int knapsackRecursive(int[] price, int cap,int index) {
        if(cap==0 || index==0) return 0;

        int take=0;
        if (cap>=index){
           take= price[index-1] +  knapsackRecursive(price,cap-index,index);
        }
        int noTake =  knapsackRecursive(price,cap,index-1);

        return Math.max(take,noTake);

    }

    private static int knapsackMemo(int[] price, int cap,int n) {

        int[][] dp = new int[n+1][cap+1];
        for(int [] d:dp) Arrays.fill(d,-1);
        return knapsack(price, cap, n-1,dp);

    }
    private static int knapsack(int[] price, int cap,int index,int[][] dp) {
        if(cap==0 || index==0) return 0;

        if(dp[index][cap]!=-1)return dp[index][cap];
        int take=0;
        if (cap>=index){
            take= price[index-1] +  knapsackRecursive(price,cap-index,index);
        }
        int noTake =  knapsackRecursive(price,cap,index-1);

        return dp[index][cap]=Math.max(take,noTake);

    }

    private static int knapsackTab(int[] price, int cap,int n) {

        int[][] dp = new int[n+1][cap+1];

        for(int i =1;i<=n;i++){
            for(int l =1;l<=cap;l++){

                int take = l>=i ?price[i-1]  +  dp[i][l-i]:0;
                int noTake = dp[i-1][l];
                dp[i][l]= Math.max(take,noTake);
            }
        }
        return dp[n][cap];

    }


}
