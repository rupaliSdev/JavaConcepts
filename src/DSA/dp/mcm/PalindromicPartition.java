package DSA.dp.mcm;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {

    public static void main(String[] args) {

        String s = "geeks";
        List<List<String>> res = new ArrayList<>();
        listOfPalindromes(s, 0, new ArrayList<>(), res);
        System.out.println(res);

        List<List<String>> res1 = new ArrayList<>();
        listOfPalindromesDP(s,0,new ArrayList<>(),res);
//        Output: [[g, e, e, k, s], [g, ee, k, s]]
    }

    //TC:O(n* 2 pow n)
    public static void listOfPalindromes(String s, int i, List<String> curr, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i1 = i; i1 < s.length(); i1++) {
            if (isItPalindrome(s, i, i1)) {
                curr.add(s.substring(i, i1 + 1));
                listOfPalindromes(s, i1 + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }

    }


    //O(n)
    static boolean isItPalindrome(String temp, int i, int j) {
        int s = i, e = j;
        while (s < e) {
            if (temp.charAt(s) != temp.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    private static void palindromes(String s, boolean[][] dp) {

        for (int i = 0; i < s.length(); i++) {
            dp[i][1] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false;
        }
        for (int l = 3; l < s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
    }

    public static List<List<String>> listOfPalindromesDP(String s, int i, List<String> curr, List<List<String>> res) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        palindromes(s, dp);

        backTracking(s, curr, res, dp, 0);
        return res;
    }

    private static void backTracking(String s, List<String> curr, List<List<String>> res, boolean[][] dp, int index) {

        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                curr.add(s.substring(index, i + 1));
                backTracking(s, curr, res, dp, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }


}
