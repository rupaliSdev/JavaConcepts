package DSA.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindTheClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 2, 3, 3};
        System.out.println(findClosestElementsBS(arr, 3, 3));
    }

    public static List<Integer> findClosestElementsBS(int[] arr, int k, int x) {
        int l = 0, h = arr.length - k;
        while (l < h) {
            int mid = (l + h) / 2;
            if ((x - arr[mid]) <= (arr[mid + k] - x)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static List<Integer> findClosestElementsTwoP(int[] arr, int k, int x) {
        int l = 0, h = arr.length - 1;
        while (h - l + 1 > k) {
            if (Math.abs(x - arr[l]) <= Math.abs(arr[h] - x)) {
                h--;
            } else {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= h; i++) {
            res.add(arr[i]);
        }
        return res;
    }


}
