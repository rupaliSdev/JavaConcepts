package DSA.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        return checkRec(s, words, 0);

    }

    public boolean checkRec(String s2, Set<String> words, int s) {
        if (s == s2.length()) {
            return true;
        }
        String s1 = "";
        for (int i = s; i < s2.length(); i++) {
            s1 += s2.charAt(i);
            if (words.contains(s1) && checkRec(s2, words, i + 1)) {
                return true;

            }
        }
        return false;
    }


    public boolean dpTab(String s2, Set<String> words) {
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;

        for (int l = 1; l <= s2.length(); l++) {
            for (int j = 0; j < l; j++) {
                if (dp[j] && words.contains(s2.substring(j, l))) {
                    dp[l] = true;
                    break;
                }
            }
        }
        return dp[s2.length()];
    }
}

