package DSA.heapdemo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

        SlidingWindowMaximum solver = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solver.maxSlidingWindow(nums, k)));
        // Output: [3, 3, 5, 5, 6, 7]

    }

    public static int[] maxSlidingWindow(int[] arr,int k){
        if(arr.length<k|| k<0) return new int[0];

        if(k==1) return arr;

        int[] result = new int[arr.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        //k=3
        for(int i =0;i<arr.length;i++){
            while( !dq.isEmpty()&& arr[dq.peekFirst()]<=i-k){
                dq.removeFirst();
            }

            while( !dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i>=k-1){

                result[i-k+1]= arr[dq.peekFirst()];
            }

        }
        return result;
    }
}

//https://chatgpt.com/c/6996b0f3-b758-83a5-8ccf-1977180c842f
