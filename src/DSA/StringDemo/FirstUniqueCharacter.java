package DSA.StringDemo;


//Given a sting , return the character that appears the minimum number of
// times in the string. The string will contain only ascii characters, from
// the ranges (“a”-”z”,”A”-”Z”,0-9), and case matters . If there is a tie
// in the minimum number of times a character appears in the string return
// the character that appears first in the string.
public class FirstUniqueCharacter {
    public static void main(String[] args) {


        String str ="cdadcda";
        System.out.println(findFirstUniqueCharacter(str));

    }

    private static char findFirstUniqueCharacter(String str) {
        int[] charArray = new int[256];
        for(char c:str.toCharArray()){
            charArray[c]++;
        }
        int min =Integer.MAX_VALUE;
       for(int i=255;i>=0;i--){
           if(charArray[i]==0)continue;
           min=Math.min(min,charArray[i]);
       }
       for(char c:str.toCharArray()){
            if(min==charArray[c]){
                return c;
            }
       }

     return '-';
    }

}
