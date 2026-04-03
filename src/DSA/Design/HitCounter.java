package DSA.Design;

import java.util.LinkedList;
import java.util.Queue;

public interface HitCounter {
    void hit(int timestamp);
    int getHits(int timestamp);
}

class HitCounterI implements HitCounter{

    Queue<Integer> queue;
    public HitCounterI() {
        queue= new LinkedList<>();
    }

    @Override
    public void hit(int timestamp) {

        queue.offer(timestamp);
    }

    @Override
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp-300>=queue.peek()){
            queue.poll();
        }
        return queue.size();
    }
}

class HitCounterII implements HitCounter{

    int[] times;
    int[] hits;
    public HitCounterII() {
        times= new int[300];
        hits= new int[300];
    }

    @Override
    public void hit(int timestamp) {

        int index = timestamp%300;
        if(times[index]!= timestamp){
            times[index]=timestamp;
            hits[index]=1;
        }
        else{
            hits[index]++;
        }
    }

    @Override
    public int getHits(int timestamp) {
        int total =0;
        for(int i=0;i<300;i++){

            if(timestamp-times[i]<300){
                total+=hits[i];
            }
        }
        return total;
    }
}
