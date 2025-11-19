package DSA.ArrayProblems.Matrix;

//
//Given a binary 2D array, where each row is sorted. Find the row with the maximum number of 1s.
public class BinarySortedArray {
    public static void main(String[] args) {

        int[][] arr ={{ 0 ,1, 1, 1},
                {0, 0 ,1 ,1},
                {1 ,1 ,1 ,1},
                {0 ,0 ,0 ,0}};


        System.out.println(findTheMaxRow(arr));
    }

    private static int findTheMaxRow(int[][] arr) {
        int m= arr.length,n=arr[0].length;
        int r=0,c=n-1;
        int max_row=0;
        while (r<m && c>=0){
            if(arr[r][c]==0){
                r++;
            }
            else{
                c--;
                max_row=r;
            }
        }
        return max_row;
    }
}
