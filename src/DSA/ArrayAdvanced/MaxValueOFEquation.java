package DSA.ArrayAdvanced;

public class MaxValueOFEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum ,start=0;
        int diff,end=0;
        int max_value =Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            sum =points[i][0] +points[i][1];
            diff =points[i][0]-points[i][1];
            if(sum>=max){
                start =i;
                max= sum;
            }
            if(sum<=min){
                end =i;
                min=diff;
            }
            if((start-end)<=k){
                max_value = Math.max(max_value,(max-min));
            }
        }
		return max_value;
        
    }
}
