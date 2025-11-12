package DSA.ArrayProblems.subsequences;

import java.util.Arrays;

public class SubsequenceMaxSum {
    public static void main(String[] args) {
        int[] arr = {3,1,-4};
        int sum = findTheMaxSubsequenceSum(arr);
        System.out.println(sum);
    }

    private static int findTheMaxSubsequenceSum(int[] arr) {

        Arrays.sort(arr);
        long max_sum =0;
        long min_sum =0;
        for(int i =0;i<arr.length;i++){
           max_sum+=arr[i] * (1<<i) ;
           min_sum+=arr[i] *(1<< (arr.length-1-i));
        }
        return (int)(max_sum-min_sum);
    }


}
