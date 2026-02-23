package DSA.heapdemo;

import java.util.Comparator;
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

    public int findKthLargestElement(int[] arr,int K){

        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
        for(int i:arr){
            priorityQueue.offer(i);
            if(priorityQueue.size()>K){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
    //o(logk) per insertion as height of tree is k

    //n insertion

    public int findKthSmallestElement(int[] arr,int K){

        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:arr){
            priorityQueue.offer(i);
            if(priorityQueue.size()>K){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
