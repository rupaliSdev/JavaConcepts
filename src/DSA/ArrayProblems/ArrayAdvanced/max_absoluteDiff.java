package DSA.ArrayProblems.ArrayAdvanced;

public class max_absoluteDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	public static int maxArr(int[] A) {


			int xmax = Integer.MIN_VALUE;
			int xmin = Integer.MAX_VALUE;
			int ymax = Integer.MIN_VALUE;
			int ymin = Integer.MAX_VALUE;


			for(int i=0;i<A.length;i++){
				int x= A[i]+i;
				int y = A[i]-i;

				xmax= Math.max(x,xmax);
				xmin = Math.min(x,xmin);
				ymax= Math.max(y,ymax);
				ymin = Math.min(y,ymin);
			}
			return Math.max((xmax-xmin),(ymax-ymin));
	}



}
