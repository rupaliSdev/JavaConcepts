package DSA.dp.unboundedknapsack;

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
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChangeMemo(coins, amount));

        int[] coins2 = {2};
        int amount2 = -1;

        int res2 = coinChangeMemo(coins2, amount2);
        System.out.println(res2);
    }

    private static int coinChangeMemo(int[] coins, int amount) {
        if (amount < 0) return -1;
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }

        int ans = coinChange(coins, dp, amount, coins.length - 1);
        return ans >= (int) 1e9 ? -1 : ans;
    }

    private static int coinChange(int[] coins, int[][] dp, int amount, int index) {

        if (amount == 0) return 0;
        if (index < 0) {
            return (int) 1e9;
        }

        if (dp[index][amount] != 1e9) return dp[index][amount];

        int take = amount >= coins[index] ? 1 + coinChange(coins, dp, amount - coins[index], index) : (int) 1e9;
        int nonTake = coinChange(coins, dp, amount, index - 1);
        return dp[index][amount] = Math.min(take, nonTake);

    }

    private static int coinChangeTab(int[] coins, int amount) {
        if (amount < 0) return -1;
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int a = 0; a <= amount; a++) {
                int take = (int) 1e9;
                if (a >= coins[i]) {
                    take = dp[i][a - coins[i]];
                }
                int nonTake = dp[i - 1][a];

            }
        }

        int ans = coinChange(coins, dp, amount, coins.length - 1);
        return ans >= (int) 1e9 ? -1 : ans;
    }


}
