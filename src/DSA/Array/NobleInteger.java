package DSA.Array;

import java.util.Arrays;

public class NobleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A ={5,6,2};

	}
	public int solve(int[] A) {
        int count =0;
        
        Arrays.sort(A);
        System.out.print(Arrays.toString(A));
        int l =0;
        int r = A.length-1;
        while(l < r){
            int temp = A[l];
            A[l] =A[r];
            A[r] =temp;
            l++;
            r--;
        }
       //System.out.print(Arrays.toString(A));
      
        
        for(int i =r;i>=0;i--){
             if(i==r){
                 count =r;
             }

           else if(A[i] != A[i+1]){
              count =r- i;
               
            }
            else{
                continue;
            }

            if(A[i] == count){
                     return 1;
               }
            
        }


  return -1;
  }
}
