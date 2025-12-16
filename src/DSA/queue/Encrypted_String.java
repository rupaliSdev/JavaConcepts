package DSA.queue;

import java.util.HashMap;
import java.util.Stack;

public class Encrypted_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findtheKthDecrypted("ab2cd2",11));

	}

	static char findtheKthDecrypted(String s,int k) {
		// TODO Auto-generated method stub
		Stack<Integer>st = new Stack();
		HashMap<Integer,Character> map = new HashMap<>();
		int x=0;
		for(int i=0;i<s.length();i++) {
			
			if('a'<=s.charAt(i) && s.charAt(i)<='z') {
				x++;
				st.push(x);
				map.put(x,s.charAt(i));
			}
			else {
				x+=(s.charAt(i)-'0');
			}
		}
		while(true) {
			
			while(!st.isEmpty() && st.peek()>k) {
				st.pop();
			}
			k=k%st.peek();
			if(k==0) {
				return map.get(st.peek());
			}
			if(map.containsKey(k)) {
				return map.get(k);
			}
			if(st.isEmpty()) {
				break;
			}
		}
		return '#';
	}
	

}
