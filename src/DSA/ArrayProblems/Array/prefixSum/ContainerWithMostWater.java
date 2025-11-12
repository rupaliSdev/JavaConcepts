package DSA.ArrayProblems.Array.prefixSum;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] arr={3,1,2,4,5};
        System.out.println(mostWaterContainerOptimal(arr));
        System.out.println(mostWaterContainerBF(arr));

    }
    public static  int mostWaterContainerOptimal(int[] arr){
        int maxWater=0;
        int l=0,r=arr.length-1;
        while(l<=r){
            maxWater=Math.max(maxWater,(r-l)*Math.min(arr[l],arr[r]));
            if(arr[l]<arr[r]){l++;}else{r--;}
        }
        return maxWater;
    }

    public static int mostWaterContainerBF(int[] arr){
        int maxWater=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                maxWater=Math.max(maxWater,(j-i)*Math.min(arr[i],arr[j]));
            }
        }
        return maxWater;
    }
}
