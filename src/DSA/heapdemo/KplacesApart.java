package DSA.heapdemo;

//
//N people having different priorities are standing in a queue.
//The queue follows the property that each person is standing at most B places away
// from its position in the sorted queue.
//
//Your task is to sort the queue in the increasing order of priorities.
//
//        NOTE:
//
//No two persons can have the same priority.
//Use the property of the queue to sort the queue with complexity O(NlogB).

// N insertion + N deletion  -> O(N logB) TC
//SC

import java.util.Arrays;
import java.util.PriorityQueue;

public class KplacesApart {
    public static int[] solve(int[] A, int B) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i ;
        for(i =0;i<=Math.min(B,A.length-1);i++){
            minHeap.offer(A[i]);
        }

        int j =0;
        while(j<A.length && i<A.length){
            A[j] =minHeap.poll();
            minHeap.offer(A[i]);
            i++;j++;
        }
        while(j<A.length){
            A[j] =minHeap.poll();
            j++;
        }
        return A;
    }

    public static void main(String[] args){

        int[] arr = {4,9,27,3,39,44,7,14,30,21};
        System.out.print(Arrays.toString(solve(arr,4)));
    }
}
