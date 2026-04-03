package DSA.ArrayAdvanced;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueOfEquation {

//    https://leetcode.com/problems/max-value-of-equation/description/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMaxValueOfEquation(int[][] points, int k) {


//        yi + yj + |xi - xj| j>i
//        yi + yj + xi -xj = xi + yi + yj-xj

        int max_value =Integer.MIN_VALUE;
        Deque<Integer> dq= new ArrayDeque<>();
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y =points[i][1];

            while (!dq.isEmpty() && x-points[dq.peekFirst()][0] > k){
                dq.pollFirst();
            }

            //store the result

            if(!dq.isEmpty()){
                int j = dq.peekFirst();
                max_value= Math.max(max_value, x+y + (points[j][1]-points[j][0]));
            }
            //maintain decreasing y-x
            while (!dq.isEmpty() && (points[dq.peekLast()][1]-points[dq.peekLast()][0])<=( y-x )){
                dq.pollLast();
            }

            dq.offerLast(i);

        }
		return max_value;
        
    }
}
