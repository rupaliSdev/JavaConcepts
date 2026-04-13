package DSA.StringDemo;

import java.util.Arrays;

public class longestCommonprefix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer" };
        System.out.println(findLongestCommonPrefix(arr));
        System.out.println(findLongestCommonPrefixII(arr));
    }

    private static String findLongestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        String x1 = arr[0], x2 = arr[arr.length - 1];
        int i = 0, n = Math.min(x2.length(), x1.length());
        String lcp = "";
        while (x2.charAt(i) == x1.charAt(i) && i < n) {
            lcp += x2.charAt(i);
            i++;
        }
        return lcp;
    }

    public static String findLongestCommonPrefixII(String[] arr) {
        if (arr == null || arr.length == 0) return "";

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}
