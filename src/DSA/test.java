package DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        String[] strings={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));

        int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
//        System.out.println(orangesRotting(grid));

    }

    public static String longestCommonPrefix(String[] strings){
        Arrays.sort(strings);

        String firstString = strings[0];
        String lastString = strings[strings.length-1];
        String lcp="";
        for(int i=0;i<firstString.length();i++){
            if(firstString.charAt(i)!=lastString.charAt(i))
            {
                break;
            }
            lcp+=firstString.charAt(i);

        }

        return lcp;

    }





}
