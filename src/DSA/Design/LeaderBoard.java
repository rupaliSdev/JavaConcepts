package DSA.Design;

import java.util.*;

public class LeaderBoard {

    TreeMap<Integer, Set<Integer>> scoreToUsers ;
    HashMap<Integer, Integer> userToScore ;


    public LeaderBoard(TreeMap<Integer, HashSet<Integer>> scoreToUsers, HashMap<Integer, Integer> userToScore) {
        this.scoreToUsers =  new TreeMap<>(Comparator.reverseOrder());
        this.userToScore =  new HashMap<>();
    }

    public void updateScores(Integer userId, Integer score) {
        if (userToScore.containsKey(userId)) {
            Set<Integer> users = scoreToUsers.get(userToScore.get(score));
            users.remove(userId);

            if (users.isEmpty()) scoreToUsers.remove(score);
        }
        scoreToUsers.computeIfAbsent(score, k -> new HashSet<>()).add(userId);
        userToScore.put(userId, score);
    }

    public List<Map.Entry<Integer, Integer>> topK(int k){
        List<Map.Entry<Integer, Integer> >result = new ArrayList<>();

        for (Map.Entry<Integer,Set<Integer>> keyValue :scoreToUsers.entrySet()){
            for (Integer val :keyValue.getValue()){
                if (result.size()>k) break;
                result.add(Map.entry(val,keyValue.getKey()));
            }

        }
        result.sort((a,b)->b.getValue()-a.getValue());
        return result;
    }


}
