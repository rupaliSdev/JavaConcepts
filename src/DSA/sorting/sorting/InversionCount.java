package DSA.sorting.sorting;

import java.util.ArrayList;
import java.util.List;

public class InversionCount {

 /*   Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j)
    is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).*/


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Integer> arr = new ArrayList<>();
        arr.addAll(List.of(3, 4, 1, 2));
        int c = countInversions(arr, 0, arr.size() - 1, (int) 1e7);
        System.out.println(c);

    }

    private static int countInversions(List<Integer> arr, int s, int e, int m) {
        if (s == e) {
            return 0;
        }
        int mid = (s + e) / 2;
        int x = countInversions(arr, s, mid, m);
        int y = countInversions(arr, mid + 1, e, m);
        int z = merge(arr, s, mid, e, m);
        return (x + y + z) % m;
    }

    private static int merge(List<Integer> arr, int s, int mid, int e, int m) {
        if (s == e) {
            return 0;
        }
        int[] temp = new int[e - s + 1];
        int i = s, j = mid + 1;
        int count = 0;
        int k = 0;
        while (i <= mid && j <= e) {
            if (arr.get(i) > arr.get(j)) {
                count += mid - i + 1;
                temp[k++] = arr.get(j);
                j++;
            } else {
                temp[k++] = arr.get(i);
                i++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr.get(i);
            i++;
        }
        while (j <= e) {
            temp[k++] = arr.get(j);
            j++;

        }
        for (int p = s; p <= e; p++) {
            arr.set(p, temp[p - s]);
        }
        return count % m;
    }

}
