package DSA.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(n, ans, 0, 0, "");

        return ans;

    }


    private void solve(int n, List<String> ans, int open, int close, String curr) {
        if (curr.length() == 2 * n) {
            ans.add(curr);
        }

        if (open < n) {
            solve(n, ans, open + 1, close, curr + "(");
        }
        if (close < open) {
            solve(n, ans, open, close + 1, curr + ")");
        }
    }
}
