package DSA.Array;

public class MinSwaps {

    /*Given an array of integers A and an integer B, find and return the minimum number of swaps required
     to bring all the numbers less than or equal to B together.
     Note: It is possible to swap any two elements, not necessarily consecutive.*/
    public static void main(String[] args) {
        int A[] = {1, 12, 10, 3, 14, 10, 5}, B = 8;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int count = 0;
        for (int a : A) {
            if (a <= B) count++;
        }
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] > B) bad++;
        }
        int ans = bad;
        int l = 0, r = count;
        while (r < A.length) {
            if (A[l] > B) {
                bad--;
            }
            if (A[r] > B) {
                bad++;
            }
            l++;
            r++;
            ans = Math.min(ans, bad);
        }

        return ans;

    }

}
