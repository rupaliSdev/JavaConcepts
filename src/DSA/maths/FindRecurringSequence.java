package DSA.maths;

import java.util.HashMap;

public class FindRecurringSequence {

//    1/3
    public static void main(String[] args) {


        System.out.println(findRecurringSequence(1,3));

    }

    private static String findRecurringSequence(int num, int deno) {
        int rem= num%deno;
        HashMap<Integer,Integer> map= new HashMap<>();
        String ans="";
        while (rem!=0 && !map.containsKey(rem)){
            map.put(rem,ans.length());
            rem=rem*10;
            ans += String.valueOf(rem/deno);
            rem= rem%deno;
        }

        if(rem==0){
            return "";
        }
        else if (map.containsKey(rem)){
            return ans.substring(map.get(rem));
        }
        return "";
    }
}
