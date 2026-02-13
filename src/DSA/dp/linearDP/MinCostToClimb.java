package DSA.dp.linearDP;

public class MinCostToClimb {

    /*You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

    Return the minimum cost to reach the top of the floor.*/


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        if(cost.length==1)return cost[0];
        dp[0]= cost[0];dp[1]= cost[1];
        for(int i =2;i<cost.length;i++){

            dp[i]= Math.min(dp[i-1],dp[i-2]) + cost[i];



        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);

    }

    public int minCostClimbingStairsOptimized(int[] cost) {


        if(cost.length==1)return cost[0];
        int stepOne= cost[0],stepTwo= cost[1];
        for(int i =2;i<cost.length;i++){
            int temp = Math.min(stepOne,stepTwo) + cost[i];
            stepOne=stepTwo;
            stepTwo=temp;

        }

        return Math.min(stepOne,stepTwo);

    }
}
