package DSA.ArrayProblems.Array.prefixSum;

import java.util.ArrayList;


//You are given an integer array A of size N.
//
//You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
//
//Find and return the maximum possible sum of the B elements that were removed after the B operations.
//
//        NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
//
//Remove 3 elements from front and 0 elements from the back, OR
//Remove 2 elements from front and 1 element from the back, OR
//Remove 1 element from front and 2 elements from the back, OR
//Remove 0 elements from front and 3 elements from the back.
public class pickFromBothSide {

    public int solve(ArrayList<Integer> A, int B) {

        int max_sum=Integer.MIN_VALUE;
        int n= A.size();
        int curr=0;

        for(int i=0;i<B;i++){
            curr+=A.get(i);
        }
        max_sum= Math.max(curr,max_sum);
        int i =0;
        while(i<B){
            curr+= A.get(n-1-i);
            curr-= A.get(B-1-i);
            i++;
            max_sum= Math.max(curr,max_sum);
        }
        return max_sum;
    }
}
