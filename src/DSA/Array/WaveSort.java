package DSA.Array;

public class WaveSort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        waveSort(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }

    private static void waveSort(int[] arr) {
        for(int i =0;i< arr.length-1;i=i+2){
            int temp= arr[i];
            arr[i]=arr[i+1];
            arr[i+1]= temp;
        }
    }
}
