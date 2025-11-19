package DSA.dp;


//Consider a n*n matrix. Suppose each cell in the matrix has a value assigned. We can go from each cell in row i to a diagonally higher
//cell in row i+1 only [i.e from cell(i, j) to cell(i+1, j-1) and cell(i+1, j+1) only].
//Find the path from the top row to the bottom row following the aforementioned condition such that the maximum sum is obtained.
public class MaximumPathSumInMatrix {
    public static void main(String[] args) {

        int mat[][] = { {5, 6, 1, 7},
            {-2, 10, 8, -1},
            {3, -7, -9, 11},
            {12, -4, 2, 6} };
        System.out.println(findMaxPathSumI(mat));
        System.out.println(findMaxPathSumII(mat));
        System.out.println(findMaxPathSumIII(mat));

    }

    private static int findMaxPathSumIII(int[][] mat) {
        int m= mat.length,n=mat[0].length;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){

                int left = (j > 0) ? mat[i+1][j - 1] : Integer.MIN_VALUE;
                int right = (j < n - 1) ? mat[i+1][j + 1] : Integer.MIN_VALUE;
                mat[i][j]=mat[i][j]+Math.max(left,right);
            }
        }
        int max= Integer.MIN_VALUE;
        for(int i =0;i<n;i++)max=Math.max(max,mat[0][i]);

        return max;

    }

    private static int findMaxPathSumII(int[][] mat) {
        int m= mat.length,n=mat[0].length;
        int[] prevRow = new int[n];

        for(int i=0;i<n;i++){
            prevRow[i]=mat[0][i];
        }

        for (int i=1;i<m;i++) {
            int[] currRow = new int[n];
            for (int j = 0; j < n; j++) {

                int left = (j > 0) ? prevRow[j - 1] : Integer.MIN_VALUE;
                int right = (j < n - 1) ? prevRow[j + 1] : Integer.MIN_VALUE;

                currRow[j] = mat[i][j] + Math.max(left, right);


            }
            prevRow = currRow;

        }

        int max = Integer.MIN_VALUE;
        for (int val : prevRow) {
            max = Math.max(max, val);
        }

        return max;


    }

    private static Integer findMaxPathSumI(int[][] mat) {
        int m= mat.length,n=mat[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<n;i++){
           dp[m-1][i]=mat[n-1][i];
        }

        int maxSum = Integer.MIN_VALUE, max;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                max= Integer.MIN_VALUE;

                if(j-1>=0 && max < dp[i+1][j-1]){
                    max=dp[i+1][j-1];
                }
                if(j+1<n && max < dp[i+1][j+1]){
                    max=dp[i+1][j+1];
                }

                dp[i][j]= mat[i][j]+ max;

            }
        }
        for (int j = 0; j < n; j++)
            if (maxSum < dp[0][j])
                maxSum = dp[0][j];


        return maxSum;
    }



}
