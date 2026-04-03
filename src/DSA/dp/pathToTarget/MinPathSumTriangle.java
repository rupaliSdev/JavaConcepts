package DSA.dp.pathToTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle {


    /* Given a triangle array, return the minimum path sum from top to bottom.

     For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.



     Example 1:

     Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     Output: 11
     Explanation: The triangle looks like:
             2
             3 4
             6 5 7
             4 1 8 3
     The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
     Example 2:

     Input: triangle = [[-10]]
     Output: -10*/
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));

        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));


        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal2(triangle));
    }


    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return minimumTotal1(dp, triangle, 0, 0);
    }

    public static int minimumTotal1(int[][] dp, List<List<Integer>> triangle, int row, int index) {

        // base case
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(index);
        }

        if (dp[row][index] != Integer.MIN_VALUE) {
            return dp[row][index];
        }

        int down = minimumTotal1(dp, triangle, row + 1, index);
        int diag = minimumTotal1(dp, triangle, row + 1, index + 1);

        dp[row][index] =
                triangle.get(row).get(index) + Math.min(down, diag);

        return dp[row][index];
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }


}
