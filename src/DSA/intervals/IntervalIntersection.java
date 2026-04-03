package DSA.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10}};
        int[][] B = {{1,5},{8,12}};



    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i =0,j=0;
        List<int[]> res = new ArrayList<>();

        while (i< A.length && j<B.length){
            int start = Math.max(A[i][0],B[i][0]);
            int end = Math.max(A[i][0],B[i][0]);

            if(start<=end){
                res.add(new int[]{start,end});
            }
            if(A[i][1]<B[i][1]) i++;
            else j++;
        }
        return res.toArray(new int[res.size()][]);

    }
}
