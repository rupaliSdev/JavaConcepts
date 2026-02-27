package DSA.heapdemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        SlidingWindowMedian solutions = new SlidingWindowMedian();
        int k = 3;
        System.out.println(Arrays.toString(solutions.medianSlidingWindow(nums, 3)));

        int[] arr={2147483647,2147483647};
        System.out.println(Arrays.toString(solutions.medianSlidingWindow(arr, 2)));

    }

    static PriorityQueue<ValidNo> minHeap = new PriorityQueue<>(Comparator.comparing(ValidNo::getValue));
    static PriorityQueue<ValidNo> maxHeap = new PriorityQueue<>(Comparator.comparing(ValidNo::getValue).reversed());
    static int left = 0, right = 0;

    public double[]  medianSlidingWindow(int[] nums, int k) {

        minHeap.clear();
        maxHeap.clear();
        left = 0;
        right = 0;
        double[] res = new double[nums.length - k + 1];
        HashMap<Integer, ValidNo> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ValidNo validNo = new ValidNo(nums[i]);
            addNo(validNo);
            map.put(i, validNo);
            if (i >= k - 1) {
                res[i - k + 1] = findMedian();
                ValidNo out = map.get(i - k + 1);
                remove(out);
            }
        }

        return res;
    }

    private  void remove(ValidNo validNo) {
        validNo.isValid = false;
        if (validNo.isMaxHeap) left--;
        else right--;
        rebalance();
    }

    private void rebalance() {
        prune(maxHeap);
        prune(minHeap);
        if (left > right + 1) {
            ValidNo v1 = maxHeap.poll();
            v1.isMaxHeap = false;
            prune(maxHeap);
            minHeap.offer(v1);
            left--;
            right++;

        } else if (left < right) {
            ValidNo v1 = minHeap.poll();
            v1.isMaxHeap = true;
            prune(minHeap);
            maxHeap.offer(v1);
            left++;
            right--;
        }
    }

    private void prune(PriorityQueue<ValidNo> heap) {
        while (!heap.isEmpty() && !heap.peek().isValid) heap.poll();
    }

    private double findMedian() {
        prune(maxHeap);
        prune(minHeap);
        if (left > right) {
            return maxHeap.peek().value;
        }
        if (right > left) return minHeap.peek().value;

        return (double) ((double)maxHeap.peek().value + (double)minHeap.peek().value) / 2;
    }

    private void addNo(ValidNo validNo) {
        if (maxHeap.isEmpty() || maxHeap.peek().value >= validNo.value) {
            validNo.isMaxHeap = true;
            maxHeap.offer(validNo);
            left++;
        } else {
            validNo.isMaxHeap = false;
            minHeap.offer(validNo);
            right++;
        }
        rebalance();
    }


    class ValidNo {
        int value;
        boolean isValid;
        boolean isMaxHeap;

        public ValidNo(int value) {
            this.value = value;
            this.isValid = true;
            this.isMaxHeap = false;
        }

        public int getValue() {
            return value;
        }

        public boolean isValid() {
            return isValid;
        }

        public boolean isMaxHeap() {
            return isMaxHeap;
        }
    }


}
