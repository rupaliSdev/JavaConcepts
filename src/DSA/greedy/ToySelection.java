package DSA.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ToySelection {

    static class Toy{
        int deadLine;
        int beauty;

        public Toy(int deadLine, int beauty) {
            this.deadLine = deadLine;
            this.beauty = beauty;
        }
    }

    public static void main(String[] args) {
        Toy[] toys = {
                new Toy(1, 9), new Toy(2, 6), new Toy(3, 5), new Toy(3, 3)
        };

        System.out.println("Max Beauty = " + maxBeauty(toys));
    }
    public static int maxBeauty(Toy[] toys){
        Arrays.sort(toys,(a,b)->a.deadLine-b.deadLine);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Toy t :toys){
            if(queue.size()<t.deadLine){
                queue.add(t.beauty);
            }
            else if(!queue.isEmpty() && queue.peek() <t.beauty){
                queue.poll();
                queue.offer(t.beauty);
            }
        }
        int totalBeauites= 0;
        for(int b:queue){
            totalBeauites+=b;
        }
        return totalBeauites;
    }
}
