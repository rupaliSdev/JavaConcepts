package DSA.heapdemo;

import java.util.PriorityQueue;

public class AthLargestElement {

    public static void main(String[] args) {

    }

    public int[] findAthLargest(int[] arr,int A){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] res = new int[arr.length];
        for(int i=0;i<A;i++){
            if(i!=A-1){
                res[i]=-1;
            }
            priorityQueue.offer(arr[i]);
        }
        res[A-1] =priorityQueue.peek();

        for(int i=A;i<arr.length;i++){
            priorityQueue.offer(arr[i]);
            priorityQueue.poll();
            res[i] =priorityQueue.peek();
        }

        return res;
    }
}
