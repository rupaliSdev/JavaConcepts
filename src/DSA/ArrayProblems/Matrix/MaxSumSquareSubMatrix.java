package DSA.ArrayProblems.Matrix;

public class MaxSumSquareSubMatrix {

    public static void main(String[] args) {

//        int[][] prefixSum = new int[n+1][m+1];

        int[][] A = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};

        System.out.println(maxSum(A,3));

        System.out.println(solve(A,3));


    }


    public static int maxSum(int[][] matrix, int B){

        int[][] prefixSum = findPrefixSum(matrix);
        int n= matrix.length ,m=matrix[0].length;
        int max_Sum=0;
        for(int i =0;i<=n-B;i++){
            for(int j =0;j<=m-B;j++){
                int x1 = i+1,y1= j+1;
                int x2= B+i, y2= B+j;

                int sum= prefixSum[x2][y2]- prefixSum[x1-1][y2]-prefixSum[x2][y1-1]+prefixSum[i][j];
                //System.out.println(max_Sum);
                   max_Sum= Math.max( max_Sum,sum );

            }
        }
        return max_Sum;

    }

    public static int solve(int[][] A, int B) {
        int n = A.length,m=A[0].length;

        int[][] stripe = new int[n][m];

        for(int j =0;j<A[0].length;j++){
            int sum = 0;
            for (int i = 0; i < B; i++) {
                sum += A[i][j];
            }
            stripe[0][j] = sum;

            // Calculate sum of remaining Bx1 rectangles in the same column
            for (int i = 1; i < n - B + 1; i++) {
                sum += (A[i + B - 1][j] - A[i - 1][j]);
                stripe[i][j] = sum;
            }
        }
        return 0;

    }



    private static int[][] findPrefixSum(int[][] matrix) {
        int n= matrix.length ,m=matrix[0].length;
        int[][] prefixSum = new int[n+1][m+1];

        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                prefixSum[i][j]= matrix[i-1][j-1] + prefixSum[i][j-1]+ prefixSum[i-1][j]-prefixSum[i-1][j-1];

            }
        }
        return prefixSum;

    }

}
