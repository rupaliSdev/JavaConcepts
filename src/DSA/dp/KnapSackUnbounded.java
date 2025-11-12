package DSA.dp;

import java.util.Arrays;

public class KnapSackUnbounded {
    public static void main(String[] args) {

        int[] wt = {2, 3, 4, 5};
        int[] val = {5, 6, 7, 8};
        int cap = 8;
        System.out.println(maxKnapSackMemoization(wt,val,val.length,cap));
    }



    public static int maxKnapSackMemoization(int[] wt,int[] val,int n ,int cap ){
        int[][] dp = new int[n][cap+1];
        if(n==0){
            return 0;
        }
        return dfsk(n-1,cap,wt,val,dp);

    }

    private static int dfsk(int i, int cap, int[] wt, int[] val, int[][] dp) {

        if(i == 0) {

                return cap/wt[0] * val[0];


        }
        if(dp[i][cap]!=0){
            return dp[i][cap];
        }

        int nonTake = dfsk(i-1,cap,wt,val,dp);
        int take =0;
        if(wt[i] <= cap) take= val[i] +dfsk(i-1,cap-wt[i],wt,val,dp);

       return dp[i][cap]=Math.max(take,nonTake);
    }


    private static int tabulation(int[] wt,int[] val,int n ,int cap){
        int[][] dp = new int[n][cap+1];
        for (int[] d:dp) Arrays.fill(d,-1);

        for (int i =wt[0] ;i<=cap;i++) dp[0][i]= cap/wt[0] * val[0];

        for (int i=1;i<n;i++){
            for (int w=0;w<=cap;w++){
                 int nonTake = dp[i-1][w];
                 int take=0;
                 if(wt[i]<=w){
                     take = val[i] +  dp[i][w-wt[i]];
                 }
                 dp[i][w]=Math.max(take,nonTake);
            }
        }
     return dp[n-1][cap];
    }



}
