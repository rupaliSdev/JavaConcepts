package DSA.BinarySearch;

//34. Find First and Last Position of Element in Sorted Array
public class FindFirstAndLastOccurence {
    public static void main(String[] args) {

//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//        Example 3:
//
//        Input: nums = [], target = 0
//        Output: [-1,-1]

        int[] result = searchRangeI(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] result1 = searchRangeII(new int[]{5, 7, 7, 8, 8, 10}, 8);

        System.out.println(result[0] + "-" + result[1]);
        System.out.println(result1[0] + "-" + result1[1]);


    }

    private static int[] searchRangeII(int[] nums, int target) {
        int f_index = -1, l_index = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                f_index = mid;
                l_index = mid;
                while (f_index > 0 && nums[f_index] == nums[f_index - 1]) {
                    f_index--;
                }
                while (l_index < nums.length - 1 && nums[l_index] == nums[l_index + 1]) {
                    l_index++;
                }
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{f_index, l_index};
    }

    public static int[] searchRangeI(int[] nums, int target) {
        int f_index = -1, l_index = -1;
        f_index = findFirstPosition(nums, target);
        l_index = findLastPosition(nums, target);
        return new int[]{f_index, l_index};
    }


    public static int findFirstPosition(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findLastPosition(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


}
