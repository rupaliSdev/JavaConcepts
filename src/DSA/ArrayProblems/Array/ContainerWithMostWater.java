package DSA.ArrayProblems.Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {


    }

    public static int amountOfWaterStored(int[] heights) {
        int low = 0, high = heights.length - 1;
        int waterStored = 0;
        while (low <= high) {

            waterStored = Math.max(waterStored, Math.min(heights[high], heights[low]) * (high - low));

            if (heights[low] < heights[high]) {
                low++;
            } else {
                high--;
            }

        }
        return waterStored;
    }

    public static int amountOfWater(int[] arr) {

        int l = 0, r = arr.length - 1;
        int water = 0;
        while (l <= r) {

            water = Math.max((r - l) * (Math.min(arr[l], arr[r])), water);

            if (arr[l] > arr[r]) {
                r--;
            } else {
                l++;
            }

        }


        return water;
    }


}
