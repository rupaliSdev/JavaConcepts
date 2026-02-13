package DSA.dp.linearDP;

import java.util.Arrays;

public class CoinChangeII {

/*    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

    You may assume that you have an infinite number of each kind of coin.*/


    public static int findChange(int[][] dp, int[] coins, int ind, int amount) {
        if(amount==0){
            return 1;
        }
        if(ind==0){
            if(amount%coins[ind]==0){
                return 1;
            }
            return 0;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];
        int take =amount>=coins[ind]?findChange(dp, coins,ind,amount-coins[ind]):0;
        int NoTake = findChange(dp, coins,ind-1,amount);

        return dp[ind][amount]=take+NoTake;
    }

    public static int findChangeII(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int i =0;i<coins.length;i++){
            for (int a = coins[i]; a<=amount;a++){
                dp[a]+= dp[a-coins[i]];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int amount = 5; int[] coins = {1,2,5};
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(findChange(dp,coins,coins.length-1,amount));
        System.out.println(findChangeII(coins,amount));
    }
}
