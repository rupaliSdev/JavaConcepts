package DSA.dp.unboundedknapsack;

public class CoinChangeII {

    /*    You are given an integer array coins representing coins of different denominations
    and an integer amount representing a total amount of money.

     Return the number of combinations that make up that amount. If that amount of money cannot
     be made up by any combination of the coins, return 0.

    You may assume that you have an infinite number of each kind of coin.
    */


    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(changeTab(amount, coins));
        System.out.println(changeOpt(amount, coins));
    }

    public static int changeOpt(int amount, int[] coins) {

        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int a = coins[i - 1]; a <= amount; a++) {
                dp[a] = dp[a] + dp[a - coins[i - 1]];
            }
        }
        return dp[amount];
    }

    public static int changeTab(int amount, int[] coins) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int a = 0; a <= amount; a++) {
                //notake
                int notake = dp[i - 1][a];
                int take = 0;
                //take
                if (a >= coins[i - 1]) {
                    take = dp[i][a - coins[i - 1]];
                }
                dp[i][a] = take + notake;
            }
        }
        return dp[coins.length][amount];
    }
}