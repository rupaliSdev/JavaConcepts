package DSA.StringDemo;

import java.util.Arrays;

public class LinearSearchStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="Rupali Sahu";
		System.out.println(Arrays.toString(str.toCharArray()));
        
	}
   int linearSearch(String str, char p) {
	   if(str ==null) {
		   return -1;
	   }
	   for(int i=0;i<str.length();i++) {
		   if(str.charAt(i)==p) {
			   return i;
		   }
	   }
	return -1;}
   
}
