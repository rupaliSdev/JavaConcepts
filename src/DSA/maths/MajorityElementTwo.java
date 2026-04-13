package DSA.maths;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 1, 3, 3, 2}));
        //System.out.println(CMEThree(new int[]{2, 2, 3, 1, 3, 2, 1, 1}));
        System.out.println(CMEThree(new int[]{2, 1 ,1 ,3, 1, 4, 5 ,6}));
    }


    public static List<Integer> CMEThree(int[] arr) {
        int CME1 = -1, CME2 = -1;
        int i = 0;
        int f1 = 0, f2 = 0;
        while (i < arr.length) {

            if (f1 == 0 && arr[i]!= CME2) {
                CME1 = arr[i];
                f1 = 1;
            } else if (arr[i] == CME1) {
                f1++;
            } else if (f2 == 0) {
                CME2 = arr[i];
                f2 = 1;
            } else if (arr[i] == CME2) {
                f2++;
            } else {
                f1--;
                f2--;
            }
            i++;
        }
        f1 = 0;
        f2 = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == CME1) {
                f1++;
            } else if (arr[j] == CME2) {
                f2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (f1 > arr.length / 3) {
            res.add(CME1);
        }
        if (f2 > arr.length / 3) {
            res.add(CME2);
        }
        return res;
    }

    static int majorityElement(int A[]) {
        int maj = 0;
        int f = 0;
        int N = A.length;
        for (int i = 0; i < A.length; i++) {
            if (f == 0) {
                maj = A[i];
                f = 1;
            } else {
                if (maj == A[i]) {
                    f++;
                } else {
                    f--;
                }
            }
        }
        int freq = 0;
        for (int i = 0; i < A.length; i++) {
            if (maj == A[i]) freq++;
        }
        return (freq > N / 2) ? maj : -1;
    }

}
