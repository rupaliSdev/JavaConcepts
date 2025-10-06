package DSA.ArrayProblems.Matrix;

public class NinetyDegreeRotation {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };

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


            }
        }
    }

}
