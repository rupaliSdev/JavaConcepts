package DSA.Design;


import java.util.*;

//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
public class RandomizedSetII {

/*    Use ArrayList for O(1) random access and HashMap to store value → index,
    enabling O(1) deletion by swapping with the last element.*/

    List<Integer> list ;
    HashMap<Integer, HashSet<Integer>> map;

    public RandomizedSetII() {
        list  = new ArrayList<>();
        map = new HashMap<>();

    }

    public boolean insert(int val) {
        boolean isPresent = map.containsKey(val);
        map.putIfAbsent(val,new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return !isPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size()==0) return false;

        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);

        int lastOne = list.get(list.size()-1);

        if(removeIndex < list.size()-1){
            list.set(removeIndex,lastOne);
            map.get(lastOne).add(removeIndex);
            map.get(lastOne).remove(list.size()-1);

        }

        list.remove(list.size()-1);
        if(map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;

    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}