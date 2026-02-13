package DSA.dp.linearDP;

public class PaintHouse {

   /* There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
    Return the minimum cost to paint all houses.*/



//    Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
//    Output: 10
//    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
//    Minimum cost: 2 + 5 + 3 = 10.




    public static void main(String[] args) {
        int[][] costs= {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};

       int minCost= findMinCost(-1,0,costs);
       int[][] dp = new int[costs.length][costs[0].length];
       dp[0][0]=17;
        dp[0][1]=16;
        dp[0][2]=14;
    }

    private static int findMinCost(int r, int prev, int[][] costs) {


        if(r==costs.length){
            return 0;
        }
        int minCost=Integer.MAX_VALUE;
        for(int i =0;i<costs[0].length;i++){
            if(i!=prev){
                minCost= Math.min(minCost,costs[r][i]+findMinCost(r+1,i,costs));
            }
        }

        return minCost;
    }

//    Time: O(3ⁿ) ❌
//
//    Space: O(n) (recursion stack)


    //bottom up
    private static int findMinCostMemo(int r, int prev, int[][] costs,int[][] dp) {


        if(dp[r][prev+1]!=-1){
            return dp[r][prev+1];
        }
        int minCost=Integer.MAX_VALUE;
        for(int i =0;i<costs[0].length;i++){
            if(i!=prev){
                minCost= Math.min(minCost,costs[r][i]+findMinCost(r+1,i,costs));
            }
        }

        return dp[r][prev+1]=minCost;
    }

    //bottom up
    private static int findMinCostTable(int[][] costs) {

        int[][] dp = new int[costs.length+1][costs[0].length+1];
        int n =costs.length;

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i =0;i<costs.length;i++){
             dp[i][0]= costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
             dp[i][1]= costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
             dp[i][2]= costs[i][2] + Math.min(dp[i-1][1],dp[i-1][0]);
        }

        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }


    //bottom up//space optimized
    private static int findMinCostOpt(int[][] costs) {


        int n =costs.length;

        int r = costs[0][0];
        int g = costs[0][1];
        int b= costs[0][2];

        for(int i =1;i<costs.length;i++){
            int nr= costs[i][0] + Math.min(g,b);
            int ng= costs[i][1] + Math.min(r,b);
            int nb = costs[i][2] + Math.min(r,g);
            r=nr;g=ng;b=nb;
        }

        return Math.min(r,Math.min(g,b));
    }



}
