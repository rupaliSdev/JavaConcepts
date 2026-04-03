package DSA.intervals;

import java.util.TreeMap;

public class MyCalenderIII {
    TreeMap<Integer,Integer> map;

    public MyCalenderIII(TreeMap<Integer, Integer> map) {
        this.map = new TreeMap<>();
    }

    public int book(int start, int end) {

        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);

        int max = 0;
        int active = 0;

        for(int v : map.values()){
            active += v;
            max = Math.max(max,active);
        }

        return max;
    }

    //book()
    //
    //Time  O(N)
    //Space O(N)
    public static void main(String[] args) {

    }
}
