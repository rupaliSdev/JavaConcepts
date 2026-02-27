package DSA.slidingwindowTP;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

//    https://leetcode.com/problems/minimum-window-substring/description/
    public static void main(String[] args) {

    }


    public String minWindow(String s, String t) {

        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        for(char c:t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        int formed =0,required = tMap.size();

        int[] ans = {-1,0,0};
        int left =0,right = 0;
        while (right<s.length()){
            char c= s.charAt(right);
            sMap.put(c,sMap.getOrDefault(c,0)+1);

            if(tMap.containsKey(c) &&
            tMap.get(c).intValue() ==sMap.get(c).intValue()){
                formed++;
            }

            while (left<=right && formed==required){

                if(ans[0]==-1 || right-left+1< ans[0]){
                    ans[0]= right-left+1;
                    ans[1]= left;ans[2]= right;
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.getOrDefault(leftChar,0)-1);
                if(tMap.containsKey(leftChar) &&  sMap.get(leftChar)<
                tMap.get(leftChar)){
                    formed--;
                }
               left++;
            }
           right++;
        }
        return ans[0]!=-1 ? s.substring(ans[1],ans[2]+1):"";
    }
}
