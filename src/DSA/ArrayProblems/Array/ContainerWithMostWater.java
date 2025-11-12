package DSA.ArrayProblems.Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {


    }
public static int amountOfWater(int[] arr){

        int l=0,r=arr.length-1;
        int water =0;
        while (l<=r){

            water=Math.max((r-l) *(Math.min(arr[l],arr[r])),water);

            if(arr[l]>arr[r]){
                r--;
            }
            else{
                l++;
            }

        }


        return water;
}


}
