package DSA.dp;

import java.util.Arrays;

public class PredictTheWinner {

    /*You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

    Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with
    a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e.,
     nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the
     chosen number to their score. The game ends when there are no more elements in the array.

    Return true if Player 1 can win the game. If the scores of both players are equal, then player
     1 is still the winner, and you should also return true. You may assume that both players are playing optimally.
    public static void main(String[] args) {
  */
    int[][] memo;
    public static void main(String[] args) {
        System.out.println(new PredictTheWinner().predictTheWinner(new int[]{1,5,233,7}));
    }


    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        return maxDiff(nums,0,n-1)>=0;
    }

    private int maxDiff(int[] nums, int l, int r) {

        if(l==r){
            return nums[l];
        }
        int scoreByLeft= nums[l]-maxDiff(nums,l+1,r);
        int scoreByRight= nums[r]-maxDiff(nums,l,r-1);
        return Math.max(scoreByLeft,scoreByRight);
    }

    public boolean predictTheWinnerDP(int[] nums) {
        int n= nums.length;
        memo= new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(memo[i], -1);
        }
        return maxDiff(nums,0,n-1)>=0;

    }
    private int maxDiffDP(int[] nums,int left,int right){
        if(memo[left][right]!=-1){
            return memo[left][right];
        }
        if(left==right){
            return nums[left];
        }

        int scoreByLeft = nums[left]-maxDiff(nums,left+1,right);
        int scoreByRight = nums[right]-maxDiff(nums,left,right-1);
        memo[left][right]= Math.max(scoreByLeft,scoreByRight);
        return memo[left][right];
    }


    public boolean predictTheWinnerIII(int[] nums) {


        int n= nums.length;

        int [][] memo= new int[n][n];
        for (int i = 0; i < n; ++i) {
            memo[i][i]= nums[i];
        }

        for(int diff =1;diff<n;diff++){
            for(int left =0;left<nums.length-diff ;left++){
                int right = left+ diff;
                memo[left][right]= Math.max(nums[left]-memo[left+1][right],
                        nums[right]-memo[left][right-1]);
            }
        }

        return memo[0][n-1]>=0;



    }

    public boolean predictTheWinnerIV(int[] nums) {
        int n = nums.length;
        int[] dp = Arrays.copyOf(nums, n);

        for (int diff = 1; diff < n; ++diff) {
            for (int left = 0; left < n - diff; ++left) {
                int right = left + diff;
                dp[left] = Math.max(nums[left] - dp[left + 1], nums[right] - dp[left]);
            }
        }

        return dp[0] >= 0;
    }


}
