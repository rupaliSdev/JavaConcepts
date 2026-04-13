package DSA.StringDemo;

public class ReverseString {

	public static void main(String[] args) {
		String str = "hello";
		String str1= new String();
		for(int i=0;i<str.length();i++) {
			str1 =str.charAt(i) +str1;
		}
		// TODO Auto-generated method stub

		
		System.out.println(str1);
	}

}
