package DSA.StringDemo;

public class LongestPalindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String S= "aaabaaa";
         System.out.println(longestPalindrome(S));
         ;
         
		
	}


    public static String longestPalindrome(String A) {
        int n = A.length();
        int start =0;
        int end = 0;
        int len = 0;
        int max_length =1;
        for(int i=0;i<n-1;i++){
          for(int j=i+1;j<n;j++){
            if(A.charAt(i) ==A.charAt(j)){
                if(longestCS(A,i,j)==true){
                	  len = j-i+1;
                	  System.out.println(len);
                	  if(max_length<len) {
                		  max_length = len;
                          start =i;
                          end = j;
                	  }
                      
                     
                      System.out.println(i +" "+j);
                      System.out.println(max_length);
                }
                
            } 
            }
        }
        String str ="";
        
        for(int k =start;k<=end;k++){
            str += A.charAt(k);

        }
        return str;
    }
    public static boolean longestCS(String S, int i,int j){
        while(i<j){
            if(S.charAt(i) != S.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static String longestPalindromeOP(String s) {

        if(s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for(int i=0;i<s.length();i++){

            int len1 = expand(s,i,i);     // odd length
            int len2 = expand(s,i,i+1);   // even length

            int len = Math.max(len1,len2);

            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start,end+1);
    }

    public static int expand(String s,int left,int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }

    //Manacher Algorithm
}
