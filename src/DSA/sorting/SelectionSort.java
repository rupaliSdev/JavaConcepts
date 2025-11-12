package DSA.sorting;

import static DSA.backtracking.Permutations.swap;

public class SelectionSort {
    public static void main(String[] args) {

    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            boolean swaped = false;
            for(int j=0;i<i-1;j++){

                if(arr[j]<arr[j+1]){
                    swap(i,j+1,arr);
                    swaped=true;
                }
            }
            if(!swaped){
                return;
            }

        }

    }

    //shift min elements to left
    public static void selectionSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int i_min = i;
            for(int j=i+1;i<arr.length;i++){

                if(arr[j]<arr[i_min]){
                    i_min= j;
                }
            }
            swap(arr[i],arr[i_min],arr);
        }

    }

    private static void swap(int i, int j,int[] arr) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
