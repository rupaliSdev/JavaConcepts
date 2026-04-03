package DSA.Google;

public class MinNoOfSwaps {
    public static void main(String[] args) {

        minNoOfSwaps("1010", "1001");
    }

    private static int minNoOfSwaps(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int countO1 = 0, count10 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else if (s1.charAt(i) == '1' && s2.charAt(i) == '0') {
                count10++;
            } else if (s1.charAt(i) == '0' && s2.charAt(i) == '1') {
                countO1++;
            }
        }
        if ((count10 + countO1) % 2 != 0) return -1;
        int ans = (count10 / 2) + (countO1 / 2);
        if (count10 % 2 != 0) ans += 2;
        return ans;
    }
    //110100
    //001011
}
