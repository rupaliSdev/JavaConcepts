package DSA.dp.mcm;

import static DSA.dp.mcm.PalindromicPartition.isItPalindrome;

public class PalindromicPartitionII {
    public static void main(String[] args) {

        System.out.println(findminCuts("efe"));
        System.out.println(findminCutsTab("efe"));
    }

    public static int findminCuts(String s) {

        int ans = findminCutsRec(s, 0, s.length() - 1);
        return ans;
    }

    private static int findminCutsRec(String s, int i, int j) {
        if (i >= j || isItPalindrome(s, i, j)) return 0;
        int ans = Integer.MAX_VALUE, cuts = 0;
        for (int k = i; k < j; k++) {
            if (isItPalindrome(s, i, k)) {
                cuts = 1 + findminCutsRec(s, k + 1, j);
                ans = Math.min(cuts, ans);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static int findminCutsTab(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false;
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        //minCuts
        int[] minCut = new int[s.length()];
        for (int i = 0; i < minCut.length; i++) minCut[i] = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) minCut[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                    }
                }
            }
        }
        return minCut[s.length() - 1];
    }


}
