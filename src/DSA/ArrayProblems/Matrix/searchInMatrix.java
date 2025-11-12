package DSA.ArrayProblems.Matrix;

public class searchInMatrix {

    public static void main(String[] args) {

    }


    //Search in Sorted Matrix I //globally sorted
    public static boolean searchMatrixI(int[][] arr,int x){

        int m= arr.length,n=arr[0].length;
        int l =0,r= m*n-1;

        while (l<=r){

            int mid =( l+r)/2;

            if(arr[mid/m][mid%m]==x){
                return true;
            }
            else if(arr[mid/m][mid%m]>x){
                r = mid-1;
            }
            else {
                l =mid+1;
            }

        }
        return false;
    }

    //Search in Sorted Matrix II (Row-wise column wise sorted like 1D)//globally sorted
    public static boolean searchMatrixII(int[][] arr,int x){

        int m= arr.length,n=arr[0].length;
        int r =0,c= n-1;

        while (r<m && c>=0){



            if(arr[r][c]==x){
                return true;
            }
            else if(arr[r][c]>x){
                c--;
            }
            else {
               r++;
            }

        }
        return false;
    }
}
