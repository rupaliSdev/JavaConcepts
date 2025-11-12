package DSA.Design;

import java.util.*;

public class LeaderBoardIUSingHeap {
    private final Integer k;
    private final Map<Integer,Integer> userScores;


    public LeaderBoardIUSingHeap(Integer k) {
        this.k = k;
        this.userScores = new HashMap<>();
    }

    //O(1)
    public void updateScores(Integer userId,Integer scores){
        userScores.put(userId,scores);
    }


    //0(NlogK)
    public List<Map.Entry<Integer, Integer>> getTopK() {
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : userScores.entrySet()){
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }
            else if(minHeap.peek().getValue()<entry.getValue()){
                 minHeap.remove();
                 minHeap.offer(entry);
            }
        }

        List<Map.Entry<Integer,Integer>> result = new ArrayList<>(minHeap);
        result.sort((a,b)-> b.getValue()-a.getValue());
        return result;
    }

    public static void main(String[] args) {
        LeaderBoardIUSingHeap lbHeap = new LeaderBoardIUSingHeap(3);

        lbHeap.updateScores(1, 50);
        lbHeap.updateScores(2, 30);
        lbHeap.updateScores(3, 70);
        lbHeap.updateScores(4, 30);
        lbHeap.updateScores(5, 90);

// Top 3 after first updates
        System.out.println(lbHeap.getTopK()); // users: 5, 3, 1

        lbHeap.updateScores(1, 20); // user 1 drops
        lbHeap.updateScores(6, 80);
        lbHeap.updateScores(2, 77); // user 2 climbs

        System.out.println(lbHeap.getTopK()); // users: 5, 6, 2

    }

}
