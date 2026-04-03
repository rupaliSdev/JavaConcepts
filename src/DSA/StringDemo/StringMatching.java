package DSA.StringDemo;

public class StringMatching {
    public static void main(String[] args){
        System.out.println(isPatternMatch("abcdeffgh","abcd"));
    }
    public static boolean isPatternMatch(String s,String p){

        int i =0,j;

        int k =0;
        while(i<s.length()-p.length()){
            j=0;
            while(j < p.length() && s.charAt(i+j)==p.charAt(j)){
                j++;
            }
            if(j==p.length()){
                return true;
            }
            i++;
        }
        return false;
    }

    //tc:O(n*m))



}
