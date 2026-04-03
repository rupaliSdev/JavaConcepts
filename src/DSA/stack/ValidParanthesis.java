package DSA.stack;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {


        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char x = st.pop();
                if (!((x == '(' && c == ')') || (x == '[' && c == ']') ||
                        (x == '{' && c == '}'))) {
                    return false;
                }

            }
        }

        return st.isEmpty();
    }
}
//https://chatgpt.com/c/69c62c59-ca64-8323-b022-a0b0e1d8e570