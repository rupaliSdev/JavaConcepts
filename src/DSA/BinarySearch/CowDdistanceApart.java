package DSA.BinarySearch;

public class CowDdistanceApart {
    public static void main(String[] args) {


        int[] arr = {1,3,5,6,7,10,11,15,16,17,20,22};
        int c= 6;



    }

    public static int aggressiveCows(int[] A,int c){
        int n = A.length;
        int low =1,high = (A[n-1]-A[0])/c-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(isValid(A,mid,c)){
                low= mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return low-1;
    }

    public static boolean isValid(int[] A,int d,int c){

        int prev= A[0];
        c--;
        int i =1;
        while (c>0 )
        {
            if(i== A.length) return false;
           while(i<A.length){

            if(A[i]-prev >d){
                c--;
                prev=A[i];
            }

            i++;
        }
    }
        return true;
    }


}
