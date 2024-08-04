package DSA.ArrayProblems.Array.subArrays;

import java.util.HashMap;


/*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



        Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2*/
public class CountsubArrayequalK {


    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6,7};
        int k=7;
        System.out.println(countSubarrays(arr,k));
    }

    public static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int count = 0,sum=0;
        for(int i=0;i<arr.length;i++) {

            sum+=arr[i];
            int diff = sum-k;
            if(map.containsKey(diff)) {
                count+=map.get(diff);
            }
            map.put(sum, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
}
