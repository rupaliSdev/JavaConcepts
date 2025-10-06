package DSA.maths;

import java.util.*;

public class RecoverArrayFromGCDArray {


//    Given an array of integers A of size N containing GCD of every possible
//    pair of elements of another array. Find and return the original numbers
//    used to calculate the GCD array in any order. For example,
//    if original numbers are {2, 8, 10} then the given
//    array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.


    public static void main(String[] args) {

        System.out.println(recoverArray(new ArrayList<>(Arrays.asList(2,2,2,2,8,2,2,2,10))));
    }

    public static List<Integer> recoverArray(List<Integer> arr){
        int n= arr.size();
        Map<Integer, Integer> freq = new HashMap<>();

        List<Integer> res = new ArrayList<>();
        for(Integer i:arr){
           freq.put(i, freq.getOrDefault(i,0)+1);

        }
        Collections.sort(arr,Collections.reverseOrder());
        for(Integer i :arr){

//            For each number x, if its remaining frequency > 0:
//             We add it to result once. subtract out all gcds it forms with previously found numbers.
//            We subtract its self-gcd once.If freq[x] is still >0 after one pass, it means there’s another original element equal to x still to take.
           while (freq.getOrDefault(i,0)>0){
               for(Integer j :res){
                   int g = gcd(j,i);
                   freq.put(g,freq.get(g)-2);
               }
               res.add(i);
               freq.put(i,freq.get(i)-1);
           }
        }

        return res;
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}
