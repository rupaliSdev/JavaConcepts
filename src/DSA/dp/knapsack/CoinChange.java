package DSA.dp.knapsack;

import java.util.Arrays;

public class CoinChange {

/*    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.*/


//    https://leetcode.com/problems/coin-change/description/


//    Input: coins = [1,2,5], amount = 11
//    Output: 3
//    Explanation: 11 = 5 + 5 + 1

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int dp[][] = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(coinChange(coins,dp,amount,coins.length-1));

        int[] coins2 = {2};
        int amount2 = -1;
        int dp2[][] = new int[coins2.length][amount2+1];
        for (int i = 0; i < coins2.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        int res2=coinChange(coins2,dp2,amount2,coins2.length-1);
        System.out.println(res2==1e9?-1:res2);
    }

    private static int coinChange(int[] coins, int[][] dp, int amount,int index) {
        if(amount==0){
            return 0;
        }
        if(index==0){
            if(amount % coins[0]==0){
                return amount/coins[0];
            }
            return (int) 1e9;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        //take=0
        int take=(int) 1e9,notTake=(int) 1e9;
        if(coins[index]<=amount) take =1+ coinChange(coins ,dp,amount-coins[index],index);
        // dp not take
        notTake=coinChange(coins ,dp,amount,index-1);

        int ans =dp[index][amount]= Math.min(take,notTake);


        return ans;
    }


}
