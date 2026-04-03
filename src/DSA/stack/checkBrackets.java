package DSA.stack;

import java.util.Stack;

public class checkBrackets {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        int[] ans = find("-(a+b)+c");
//		System.out.println(Arrays.toString(ans));
    }

    public static int[] find(String A) {
        int i = 0;
        int x = 1;
        int[] ans = new int[26];
        for (int j = 0; j < 26; j++) {
            ans[j] = -1;
        }

        Stack<Integer> st = new Stack<>();
        st.push(x);
//        System.out.println("hrllo");
        while (i < A.length()) {
            char c = A.charAt(i);
//        System.out.println(c);

            if (c >= 'a' && c <= 'z') {
                ans[(c - 'a')] = st.peek();
                System.out.print(st.peek() + " ");

            } else if (c == '+' || c == '-') {
                if (c == '+') {
                    st.push(st.peek());
                } else {
                    int z = st.peek() * (-1);
                    st.push(z);
                }
            } else if (c == ')' && !st.isEmpty()) {
                st.pop();
            }

            i++;

        }


        //   System.out.print(Arrays.toString(ans));
        return ans;

    }


}
