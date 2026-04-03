package DSA.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public List<int[]> employeeFreeTime(List<List<int[]>> schedule) {

        List<int[]> all = new ArrayList<>();

        for(List<int[]> emp : schedule){
            all.addAll(emp);
        }

        Collections.sort(all,(a, b)->a[0]-b[0]);

        List<int[]> res = new ArrayList<>();

        int end = all.get(0)[1];

        for(int i=1;i<all.size();i++){

            if(all.get(i)[0] > end){
                res.add(new int[]{end, all.get(i)[0]});
            }

            end = Math.max(end, all.get(i)[1]);
        }

        return res;
    }
}
