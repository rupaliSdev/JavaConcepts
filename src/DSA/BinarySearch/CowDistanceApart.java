package DSA.BinarySearch;

import java.util.Arrays;

public class CowDistanceApart {
    public static void main(String[] args) {


        int[] arr = {1, 3, 5, 6, 7, 10, 11, 15, 16, 17, 20, 22};
        int[] arr1 = {6, 4 ,3 ,16, 20 ,7 ,18 ,10};
        int c = 6;
        System.out.println(aggressiveCows(arr1, 5));


    }


    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = (stalls[stalls.length - 1] - stalls[0]);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValidDistance(stalls, k, mid)) {

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    public static boolean isValidDistance(int[] stalls, int k, int mid) {
        int prev = stalls[0];
        k--;
        int i = 1;
        while (i < stalls.length && k > 0) {
            if (prev + mid <= stalls[i]) {
                k--;
                prev = stalls[i];
            }
            i++;
        }
        if (i == stalls.length && k > 0) {
            return false;
        }
        return true;
    }
}
