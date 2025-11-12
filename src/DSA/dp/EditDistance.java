package DSA.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n= word1.length(),m = word2.length();

        int[] prev= new int[m+1];
        int[] curr= new int[m+1];

        for(int i =0;i<n;i++) prev[i]=i; //s1 is empty so s2 we need to insert

        for(int i =1;i<n;i++){
            curr[0]= i;////s2 is empty so s2 we need to delete
            for(int j =1;j<m;i++){
               if(word1.charAt(i-1)==word2.charAt(j-1)){
                   curr[j]=prev[j-1];
               }
               else{
                   curr[j]= Math.min(Math.min(prev[j] //delete
                           ,curr[j-1]) //insert
                           ,prev[j-1]); //replace

               }
            }
            prev=curr.clone();
        }
      return prev[m];
    }

    public int minDistanceTab(String word1, String word2) {
        int n= word1.length(),m = word2.length();

        int[][] dp= new int[n+1][m+1];


        for(int i =0;i<n;i++) dp[0][i]=i; //s1 is empty so s2 we need to insert
        for(int i =0;i<n;i++) dp[i][0]=i; //s2 is empty so s1 we need to delete

        for(int i =1;i<n;i++){
            for(int j =1;j<m;i++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]= Math.min(Math.min(dp[i-1][j] //delete
                                    ,dp[i][j-1]) //insert
                            ,dp[i-1][j-1]); //replace

                }
            }
        }
        return dp[m][n];
    }
}
