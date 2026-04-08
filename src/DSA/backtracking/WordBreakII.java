package DSA.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {

    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()];

        dp[0] = true;
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i < l; i++) {
                if (dp[i] && dict.contains(s.substring(i, l))) {
                    dp[l] = true;
                }
            }
        }
        List<String> res = new ArrayList<>();
        backTrack(s, dict,0,new ArrayList<>(),new StringBuilder(),dp);
        return res;
    }

    private void backTrack(String s, HashSet<String> dict, int start, List<String> res, StringBuilder curr, boolean[] dp) {
        if(start==s.length()){
            res.add(curr.toString());
            return;
        }

        for(int end =start+1;end<=s.length();end++){
            if(!dp[end]) continue;

            if(dict.contains(s.substring(start,end))){
                int len = curr.length();
                curr.append(s.substring(start,end)).append(" ");
                backTrack(s,dict,start,res,curr,dp);
                curr.setLength(len);
            }

        }
    }
}
