package DSA.ArrayProblems.Array.subArrays;

import java.util.*;

public class CountSubArrayDivisibleByK {
    public static void main(String[] args) {
        int[] arr=new int[]{4,5,0,-2,-3,1};
        int k=5;
        System.out.println(findSubArray(arr,k));
    }

    private static int findSubArray(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;

        for(int a : A) {
            sum = (sum + a);
            int rem=sum%K;

            if(rem< 0) {rem += K; }
            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem ,map.getOrDefault(rem, 0) + 1);
        }
        return count;

    }
}
