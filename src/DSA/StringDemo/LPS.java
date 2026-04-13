package DSA.StringDemo;

import java.util.Arrays;

public class LPS {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] x = generateLPS("aabaaba");
        int[] y = generateLPSOpt("aabaaba");
        Arrays.stream(x).forEach(System.out::print);
        Arrays.stream(y).forEach(System.out::print);
        System.out.println();
        System.out.println(findTheString("ABABACD", "ACD"));


    }

    //kmp search
    public static int findTheString(String hayStack, String pattern) {
        int[] lps = generateLPSOpt(pattern);
        int i = 0, j = 0;
        while (i < hayStack.length()) {
            if (hayStack.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return i - j;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }


    //kmp
    private static int[] generateLPSOpt(String text) {
        int[] lps = new int[text.length()];
        int len = 0, i = 1;
        while (i < text.length()) {
            if (text.charAt(i) == text.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }

            }
        }
        return lps;
    }

    private static int[] generateLPS(String text) {
        int[] lps = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            for (int len = 1; len <= i; len++) {

                //length = end-start+1
                //start = end - length+1
                //prefix ->0 , len-1
                //suffix -> i-len+1  ,i
                int p1 = 0, p2 = i - len + 1;
                boolean ok = true;
                while (p1 < len) {
                    if (text.charAt(p1) != text.charAt(p2)) {
                        ok = false;
                        break;
                    }
                    p1++;
                    p2++;
                }
                if (ok) {
                    lps[i] = len;

                }

            }
        }
        return lps;
    }


}
