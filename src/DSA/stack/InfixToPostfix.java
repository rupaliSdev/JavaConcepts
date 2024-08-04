package DSA.stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(infixPostfix("(a+b)*d-(a*b)/f"));
        String x2 ="a";
        
        System.out.println(false);
	}
	
	public static String infixPostfix(String str) {
		StringBuilder ans = new StringBuilder();
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char x=str.charAt(i);
//			System.out.println(st);
			if((x>='a' && x<='z')){

				ans.append(x);
			}
			else if(x=='(') {
				st.push(x);
			}
            else if(x==')') {
				while(st.peek()!='(') {
					ans.append(st.pop());
				}
				st.pop();
			}
            else{
            	
            	 while( !st.isEmpty() && st.peek()!='(' && checkPriority(x)<=checkPriority(st.peek())) {
            			ans.append(st.pop());
            		}
            		st.push(x);
            	}

				
			
		}
		System.out.println(st);
		while(!st.isEmpty()) {
		ans.append(st.pop());
	}
		return ans.toString();
		
	}

	private static int checkPriority(Character k) {
		// TODO Auto-generated method stub
        return switch (k) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default ->
//		if(k == '^')
//            return 3;
//        else if(k == '/' || k == '*')
//            return 2;
//        return 1;
                    0;
        };

    }

}
