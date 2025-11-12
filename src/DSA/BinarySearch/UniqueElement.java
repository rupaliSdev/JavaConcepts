package DSA.BinarySearch;



public class UniqueElement {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,3 ,1,1,8,8,10,10,19,6,6,2,2,4,4};
		
		int x=findUniqueElement(arr);
		System.out.println(x);
	}

	private static int findUniqueElement(int[] A) {
		// TODO Auto-generated method stub
		
		
		 int l=0,r=A.length;
		 
		 while(l<=r) {
			 int m= (l+r)/2;
			 int fo=m;
			 if(A[m]!=A[m-1] && A[m]!=A[m+1]) {
				 return m;
			 }
			 if(A[m]==A[m-1]) {
				 fo=m-1;
			 }
			 else {
				 fo=m;
			 }
			 
			 if(fo%2==0) {
				 l=m+1;
			 }
			 else {
				 r=m-1;
			 }
		 }
		return 0;
	}
}
