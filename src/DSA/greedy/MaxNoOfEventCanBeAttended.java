package DSA.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxNoOfEventCanBeAttended {
    public static void main(String[] args) {
        int[][] events = {{1,5},{1,5},{1,5},{2,3},{2,3}};

        System.out.println(maxNoOfEvents(events));
    }

    private static int maxNoOfEvents(int[][] events) {

        int maxDay = 0,n= events.length;
        int ans=0;
        for(int[] event:events){
            maxDay=Math.max(maxDay,event[1]);
        }
        Arrays.sort(events, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
        for(int i =1,j=0;i<=maxDay;i++){

            while(j<n && events[j][0]<=i){
                priorityQueue.offer(events[j][1]);
                j++;
            }
            while(!priorityQueue.isEmpty() && priorityQueue.peek()<i){
                priorityQueue.poll();
            }

            if(!priorityQueue.isEmpty()){
                priorityQueue.poll();
                ans++;
            }


        }
        return ans;
    }


}
