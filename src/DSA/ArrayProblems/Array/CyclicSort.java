package DSA.ArrayProblems.Array;
import java.util.List;
import java.util.ArrayList;

public class CyclicSort {

    public static void main(String[] args) {
        int[] nums= {4,3,2,7,8,2,3,1};
        List<Integer> list=findDuplicates(nums);
        System.out.println(list);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        var n = nums.length;
        var duplicates = new ArrayList<Integer>();

        // cyclic sort
        for (var i = 0; i < n; i++)
            while (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);

        // find index value mismatches
        for (var i = 0; i < n; i++)
            if (i != nums[i] - 1)
                duplicates.add(nums[i]);

        return duplicates;
    }

    private static void swap(int[] nums, int i, int j) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
