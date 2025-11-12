package DSA.ArrayProblems.Matrix;

public class NinetyDegreeRotation {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        // {7,4,1}
        // {8,5,2}
        // {9,6,3}

       // arr[i][j]= arr[n-1-i][j]
        //arr[n-1-i][j]=arr[n-1-i][n-1-j]
        //arr[n-1-i][n-1-j]=arr[i][n-1-j]
        //arr[i][n-1-j]=arr[i][j]

        rotateByCircularWay(matrix);

        for (int i =0;i<matrix.length;i++){
            System.out.print("{");
            for (int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.print("},");
        }

    }


    public static void rotateByCircularWay(int[][] matrix){
        int n = matrix.length;
        for(int i =0;i<n/2;i++){
            for(int j =i;j<n-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]= matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]= matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;



                // arr[i][j]= arr[n-1-j][i]
                //arr[n-1-j][i]=arr[n-1-i][n-1-j]
                //arr[n-1-i][n-1-j]=arr[j][n-1-i]
                //arr[j][n-1-i]=arr[i][j]


            }
        }
    }

    void rotateEfficient(int[][] mat) {
        int n = mat.length;
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // reverse each row
        for (int[] row : mat) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = row[l];
                row[l++] = row[r];
                row[r--] = temp;
            }
        }
    }


}
