package DSA.dp;

import java.util.Arrays;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        int n = prices.length;

        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns(prices, n, 0, 0, 2, dp);

    }

    private static int getAns(int[] prices, int n,int index, int buy, int cap, int[][][] dp) {
        if(index==n || cap==0) return 0;

        if(dp[index][buy][cap]!=0) return dp[index][buy][cap];

        int profit;
        if(buy ==0){
            profit =Math.max(getAns(prices,n,index+1,0,cap,dp),
                   -prices[index]+ getAns(prices,n,index+1,1,cap,dp));
        }
        else{
            profit =Math.max(getAns(prices,n,index+1,1,cap,dp),
                    prices[index]+ getAns(prices,n,index+1,0,cap-1,dp));
        }
        return dp[index][buy][cap]=profit;
    }


    private static int getAnsTab(int[] prices, int cap) {
        int n= prices.length;
        int[][][] dp = new int[prices.length+1][2][cap+1];

        for (int index = n-1; index >=0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k <=cap; k++) {
                    if(buy ==0){
                        dp[index][buy][k]= Math.max(dp[index+1][buy][k],-prices[index]+dp[index+1][1][k]);
                    }
                    else{
                        dp[index][buy][k]= Math.max(dp[index+1][buy][k],prices[index]+dp[index+1][0][k-1]);
                    }

                }
            }
        }


    return dp[0][0][2];


    }
}
