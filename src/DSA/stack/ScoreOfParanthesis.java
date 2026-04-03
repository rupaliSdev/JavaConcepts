package DSA.stack;

import java.util.Stack;

//https://leetcode.com/problems/score-of-parentheses/description/
public class ScoreOfParanthesis {

    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                int x = st.pop();
                int score = Math.max(2 * x, 1);
                st.push(score + st.pop());
            }
        }

        return st.pop();
    }
}
