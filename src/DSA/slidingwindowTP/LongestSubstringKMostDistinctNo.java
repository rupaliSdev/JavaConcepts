package DSA.slidingwindowTP;

import java.util.HashMap;

public class LongestSubstringKMostDistinctNo {

//    https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
    public static void main(String[] args) {

        LongestSubstringKMostDistinctNo solutions = new LongestSubstringKMostDistinctNo();
        String s= "eceba";
        int k =2;
        System.out.println(solutions.lengthOfLongestSubstringKDistinct(s,k));

//        Count Subarrays with Exactly K Distinct

        int ans = solutions.lengthOfLongestSubstringKDistinct(s,k)- solutions.lengthOfLongestSubstringKDistinct(s,k-1);
        System.out.println(ans);
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int left =0,right=0;
        HashMap<Character,Integer> map= new HashMap<>();
        int count =0;
        int max_len=0;
        while (right<s.length()){
             char c= s.charAt(right);
             map.put(c,map.getOrDefault(c,0)+1);

             while ( map.size()>k && left<right ){

                 char ch = s.charAt(left);
                 map.put(ch,map.getOrDefault(ch,0)-1);
                 if(map.get(ch)==0){
                     map.remove(ch);
                 }
                 left++;
             }

                 max_len= Math.max(max_len,right-left+1);

             right++;
        }
        return max_len;
    }
}
//TC:o(n)
//sc: o(n)