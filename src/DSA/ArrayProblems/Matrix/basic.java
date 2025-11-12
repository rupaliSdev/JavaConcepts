package DSA.matrix;

public class basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{-2,3,4,5},{-5,6,7,8},{-8,9,10,11}};
        rowWisesum(mat);
        columnWisesum(mat);
        
        submatrixSum(mat);
	}

	private static void submatrixSum(int[][] A) {
		// TODO Auto-generated method stub
		
		int n= A.length;
	    int m= A[0].length;
	    for(int j=m-1;j>=0;j--){
	        for(int i=n-2;i>=0;i--){
	            A[i][j]+=A[i+1][j];
	        
	    }

	    }
	    for(int i=0;i<A.length;i++) {
			
			
			for(int i1=0;i1<A[0].length;i1++) {
				System.out.print(A[i][i1]+" ");
				
				
			}
			System.out.println();
			
		}
	    
	    for(int j=n-1;j>=0;j--){
	        for(int i=m-2;i>=0;i--){
	            A[j][i]+=A[j][i+1];
	        
	    }

	    }
for(int i=0;i<A.length;i++) {
			
			
			for(int i1=0;i1<A[0].length;i1++) {
				System.out.print(A[i][i1]+" ");
				
				
			}
			System.out.println();
			
		}
	    
	}

	private static void columnWisesum(int[][] mat) {
		// TODO Auto-generated method stub
		int sum;
		for(int i=0;i<mat.length;i++) {
			sum=0;
			
			for(int i1=0;i1<mat[i].length;i1++) {
				sum =sum+ mat[i][i1];
				
			}
			System.out.println("hey");
			System.out.println(sum);
		}
	}

	private static void rowWisesum(int[][] mat) {
		// TODO Auto-generated method stub
		int sum;
		for(int i=0;i<mat.length;i++) {
			sum=0;
			
			for(int i1=0;i1<mat[i].length;i1++) {
				sum =sum+ mat[i][i1];
				
			}
			System.out.println("hey");
			System.out.println(sum);
		}
	}

}
