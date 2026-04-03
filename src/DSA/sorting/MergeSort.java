package DSA.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {2, 5, 7, 9, 13};
        int[] B = {1, 6, 8, 11, 14};
        int[] C = Merge(A, B);

        System.out.println(Arrays.toString(C));
        int[] k = {5, 2, 8, 7, 13, 23, 12, 9};

        int[] sorted = mergeSort(k, 0, k.length - 1);
        System.out.println(Arrays.toString(sorted));

    }

    private static int[] mergeSort(int[] k, int s, int e) {
        if (s == e) {
            return k;
        }
        int mid = (s + e) / 2;
        k = mergeSort(k, s, mid);
        k = mergeSort(k, mid + 1, e);
        MergetheArray(k, s, mid, e);
        return k;
    }

    private static int[] Merge(int[] a, int[] b) {
        // TODO Auto-generated method stub
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            c[k++] = a[i] >= b[j] ? b[j++] : a[i++];
        }
        while (i < a.length) {
            c[k++] = a[i++];

        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }

    private static int[] MergetheArray(int[] a, int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = 0;
        int[] c = new int[e - s + 1];
        while (i <= mid && j <= e) {

            if (a[i] > a[j]) {
                c[k] = a[j];
                j++;
            } else {
                c[k] = a[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            c[k++] = a[i++];

        }
        while (j <= e) {
            c[k++] = a[j++];
        }
        for (int t = 0; t < c.length; t++) {
            a[s + t] = c[t];
        }
        return a;
    }


}



