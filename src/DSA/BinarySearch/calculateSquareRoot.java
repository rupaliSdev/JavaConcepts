package DSA.BinarySearch;

public class calculateSquareRoot {
    public static void main(String[] args) {

    }


    public static int findSquareRoot(int N){

        if(N<2) return N;
        int low = 2 , high = N/2;

        while(low<=high){
            int mid = (low+high)/2;
            long num =mid * mid;
            if(num ==N ){
                return mid;
            }
            else if(num <N){
                low= mid+1;
            }
            else{
                high= mid-1;
            }
        }
    return 0;
    }
}
