package DSA.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int lcsMemo(String a,String b,int i,int j ,int[][] dp){
        if(i<0 || j<0 ){
            return 0;

        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(a.charAt(i)==b.charAt(j)) dp[i][j]= 1+ lcsMemo(a,b,i-1,j-1,dp);
        else{
            dp[i][j]= Math.max(lcsMemo(a,b,i-1,j,dp),lcsMemo(a,b,i,j-1,dp));
        }
      return dp[i][j];
    }

    static int lcsTabulation(String a,String b){


        int[][] dp= new int[a.length()+1][b.length()+1];

        for(int[] d :dp) Arrays.fill(d,-1);
        for(int i=0;i<=a.length();i++){
           dp[0][i]=0;
        }
        for(int i=0;i<=a.length();i++){
            dp[i][0]=0;
        }

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[a.length()][b.length()];
    }
}
