package DSA.ArrayProblems.Array.subArrays;

import java.util.HashMap;
import java.util.Map;

public class countNoOfSubarraysWithXORK {
    public static void main(String[] args) {

    }

    /*
    *
    * x ^ y = z
    * x^ z= y
    * subArray(l to r) = subArrayXor (o to r)  ^ subArrayXor(o to l-1)(cancels out 0 to l-1)
    *
    *
    *
    *
    * */
    public static int countSubarrayWithXorK(int[] arr,int k){

        Map<Integer,Integer> freq =new HashMap<>();

        int prefixXor =0;
        int count =0;

        freq.put(0,1);

        for(int num :arr){
            prefixXor^=num;
            int needed = prefixXor^k;
            count+=freq.getOrDefault(needed,0);

            freq.put(prefixXor , freq.getOrDefault(prefixXor,0)+1);


        }
        return count;
    }
}
