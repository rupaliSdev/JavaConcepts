package DSA.Array;

import java.util.ArrayList;
import java.util.HashMap;

public class RotateNonNegative {
    public static void main(String[] args) {

        int nums[] = {1, -2, 3, -4}, k = 3;
        rotateElements(nums, k);
        printElements(nums);

        int nums1[] = {5, 4, -9, 6};
        rotateElements(nums1, 2);
        printElements(nums1);


        //left rotation (i+k) % n // move forward
        //right rotation (i-k + n ) %n //backward

    }

    private static void printElements(int[] nums) {
        for (int n : nums) System.out.println(n);
    }

    public static int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> posiNegative = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                posiNegative.put(i, nums[i]);
            } else {
                res.add(nums[i]);
            }
        }

        if (res.size() == 0) {
            return nums;
        }
        k = k % res.size();
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (posiNegative.containsKey(i)) {
                nums[i] = posiNegative.get(i);
            } else {
                nums[i] = res.get((j + k) % res.size());
                j++;
            }

        }
        return nums;
    }


}
