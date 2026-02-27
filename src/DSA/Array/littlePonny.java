package DSA.Array;

import java.util.ArrayList;

public class littlePonny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int B= 3;
		int count =0;
		int max= Integer.MIN_VALUE;
		int[] A = new int[20];
		for(int i=0;i<A.length;i++) {
			if(A[i]>B) {
				A[i]=-1;
				count++;
			}
			max= Math.max(A[i],max);
		}
		if(max==B) {
			System.out.println("hey");
		}
	}
	
	
	static int littleponny(ArrayList<Integer>A,int B) {
		 boolean c =false;
	        int count =0;
	        for(int i =0;i<A.size();i++){
	            if(A.get(i)>B){
	                A.set(i,-1) ;
	                count++;
	            }
	            if(A.get(i)==B){
	                 c= true;
	            }

	        }
	        if(c){
	            return count;
	        }
	        else{
	            return -1;
	        }
	}

}
