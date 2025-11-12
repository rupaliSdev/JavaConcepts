package DSA.ArrayProblems.prefixSum;

public class specialIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pf_even = new int[20];
		int[] pf_odd= new int[20];
		
		int n=20;
		for(int i=0;i<n;i++) {
			int e= pf_even[i-1]+ pf_odd[n-1]-pf_odd[i];
			int o =pf_odd[i-1]+ pf_even[n-1]-pf_even[i];
			if(e==o) {
				System.out.println("the special index is :"+i);
			}
		}
	}
	
	///An array can be said a special index if after deleting it sum of all even indexes = 
	///sum of all odd indexes
	
	
	

}
