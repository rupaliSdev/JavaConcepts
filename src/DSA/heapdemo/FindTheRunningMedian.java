package DSA.heapdemo;

import java.util.Collections;
import java.util.PriorityQueue;


//Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed, each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end of C. Your task is to find and return the array C.
//
//        NOTE:
//
//If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
//If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
public class FindTheRunningMedian {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 3,6};
        double[] c = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            addNum(arr[i]);
            c[i] = findMedian();
        }
        for (Double i : c) {
            System.out.println(i);
        }

    }


    private static double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        if (minHeap.size() > maxHeap.size()) return minHeap.peek();
        return (double) (maxHeap.peek()+minHeap.peek())/2;
    }

    public static void addNum(int i) {

        if (maxHeap.isEmpty() || maxHeap.peek() >= i) {
            maxHeap.offer(i);
        } else {
            minHeap.offer(i);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }


}
