package DSA.Design;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class RandomizedSet {

/*    Use ArrayList for O(1) random access and HashMap to store value → index,
    enabling O(1) deletion by swapping with the last element.*/

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;


    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            list.set(index, lastOne);
            map.put(lastOne, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}