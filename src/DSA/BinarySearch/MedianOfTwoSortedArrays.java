package DSA.BinarySearch;


//https://leetcode.com/problems/median-of-two-sorted-arrays/description/?envType=problem-list-v2&envId=binary-search
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] A= {7,12,14,15};
        int[] B = {1,2,3,4,9,11};
        double median = findMedianSortedArraysBinarySearch(A,B);
        double median1 = findMedianSortedArraysInplace(A,B);
        System.out.println(median+" " +median1);
    }

    private static double findMedianSortedArraysInplace(int[] a, int[] b) {

        int n1=a.length,n2=b.length;
        int count =0;
        int m1= (n1+n2)/2;
        int m2 = m1-1;
        int idle1=-1,idle2=-1;
        int i=0,j=0;
        //here count <=m1 bcoz for 8/4 = 4 and 4,5 both will be median but 0 based indexing 3,4
        // 7/2 = 3  and median will be 4th element but in zero based its 3rd index
        while (count<=m1 ){
            idle2= idle1;

            if(i<n1  && j<n2) {
               idle1= (a[i]>b[j])? b[j++]:a[i++];
            }
            else if(i<n1){
                idle1=a[i++];

            }
            else if(j<n2){
                idle1=b[j++];

            }

            count++;
        }
        if((n1+n2)%2 ==0){
            return (double)((idle1+idle2)/2);
        }
        else{
            return (double) idle1;

        }

    }

    public static double findMedianSortedArraysBinarySearch(int[] A, int[] B ){
        int m = A.length;
        int n = B.length;
        if(m > n){
            return findMedianSortedArraysBinarySearch(B, A);
        }
        int start =0 ,end = m;
        int half_len= (m+n+1)/2;

        while(start <= end){
            int i = (start+end)/2;
            int j = half_len-i;

            if(i< m && A[i]<B[j-1]){
                start = i+1;
            }
            else if (i>0 && A[i-1]>B[j]){
                end = i-1;
            }
            else{
                int max_left=0;
                if(i==0){
                    max_left = B[j-1];
                }
                else if(j==0){
                    max_left = A[i-1];
                }
                else{
                    max_left = Math.max(A[i-1],B[j-1]);
                }
                int max_right=0;
                if(i==m){
                    max_right = B[j];
                }
                else if(j==n){
                    max_right = A[i];
                }
                else{
                    max_right = Math.min(A[i],B[j]);
                }
                if((m+n)%2 !=0 ){
                    return max_left;
                }
             
                return (double)(max_left+max_right)/2;

            }
        }
        return 0.0;
    }
}
