package DSA.stack;

import java.util.Stack;

public class removeConsecutivesdups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s= "AABAAC";
        System.out.println(doublecharTrouble(s));
        
	}

	private static String doublecharTrouble(String s) {
		Stack<Character> st = new Stack();
		for(int i=0;i<s.length();i++) {
			if(!st.isEmpty() && st.peek()==s.charAt(i)) {
				//System.out.println("hi " + s.charAt(i));
				st.pop();
			}
			else {
				//System.out.println("hey " + s.charAt(i));
				st.push(s.charAt(i));
			}
		}

		StringBuilder sb = new StringBuilder();
        if(st.isEmpty()) {
			return "";
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.reverse().toString();
		// TODO Auto-generated method stub
		
	}
	
	

}
