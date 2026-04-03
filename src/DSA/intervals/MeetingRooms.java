package DSA.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static void main(String[] args) {

    }


    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }

        return true;
    }


    //Find minimum number of meeting rooms required.
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals){

            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }

            pq.offer(interval[1]);
        }

        return pq.size();
    }
}
