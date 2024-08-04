package DSA.ArrayProblems.Array;

public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(secondLargest(arr));
    }

    private static int secondLargest(int[] arr) {

        int max1=arr[0];
        int max2=Integer.MIN_VALUE;

        for (int i=1;i<arr.length;i++){
            if(max1<arr[i]){
                max2=max1;
                max1=arr[i];
            }
            else if(arr[i]>max2 && arr[i]!=max1){
                max2=arr[i];
            }
        }
        return max2;
    }
}
