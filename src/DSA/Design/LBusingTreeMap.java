package DSA.Design;

import java.util.*;

public class LBusingTreeMap {

    private final TreeMap<Integer, Set<Integer>> scoreToUsers;
    private final HashMap<Integer,Integer> userScores;
    private final Integer k;


    public LBusingTreeMap(Integer k) {
        this.userScores = new HashMap<>();
        this.scoreToUsers=new TreeMap<>(Comparator.reverseOrder());
        this.k = k;
    }

    //O(1)
    public void updateScores(Integer userId,Integer scores){
        if(userScores.containsKey(userId)){
            Set<Integer> users= scoreToUsers.get(userScores.get(userId));
            users.remove(userId);
            if(users.isEmpty()) scoreToUsers.remove(userScores.get(userId));
        }
        userScores.put(userId,scores);

        scoreToUsers.computeIfAbsent(scores,k->new HashSet<>()).add(userId);
    }

    public List<Map.Entry<Integer, Integer>> getTopK() {
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,Set<Integer>> entry:scoreToUsers.entrySet()){
            for (Integer id : entry.getValue()){
                if(result.size()>k)break;
                result.add(Map.entry(id,entry.getKey()));
            }

        }
       result.sort((a,b)->b.getValue()-a.getValue());
     return result;

    }

    public static void main(String[] args) {
        LBusingTreeMap lbBST = new LBusingTreeMap(3);

        lbBST.updateScores(1, 50);
        lbBST.updateScores(2, 30);
        lbBST.updateScores(3, 70);
        lbBST.updateScores(4, 30);
        lbBST.updateScores(5, 90);

        System.out.println(lbBST.getTopK()); // users: 5, 3, 1

        lbBST.updateScores(1, 20);
        lbBST.updateScores(6, 80);
        lbBST.updateScores(2, 77);

        System.out.println(lbBST.getTopK()); // users: 5, 6, 2


    }
}
//
//Feature/Operation  |  HashMap + Min-Heap             |  TreeMap (BST)
//-------------------+---------------------------------+-----------------------
//updateScores       |  O(1)                           |  O(log n)
//getTopK()          |  O(n log K)                     |  O(K)
//Implementation     |  Simple                         |  More complex
//Stale Entry Issue  |  Requires heap rebuild          |  No stale entries
//Memory Usage       |  O(n) + O(K) during getTopK     |  O(n) (main map + BST)
//Real-time Top K    |  Not real-time (needs rebuild)  |  Always real-time
