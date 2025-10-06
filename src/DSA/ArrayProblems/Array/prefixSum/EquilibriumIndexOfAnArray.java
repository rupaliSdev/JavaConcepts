package DSA.ArrayProblems.Array.prefixSum;


//You are given an array A of integers of size N.
//
//Your task is to find the equilibrium index of the given array
//
//The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
//
//If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
public class EquilibriumIndexOfAnArray {
    public static void main(String[] args) {
        
    }

    public int solve1(int[] A) {

        int s_sum=0;
        for(int i=0;i<A.length;i++){
            s_sum+=A[i];
        }
        int p_sum=0;
        for(int i=0;i<A.length;i++){
            s_sum-=A[i];
            if(p_sum==s_sum){
                return i;
            }
            p_sum+=A[i];

            // System.out.print(s_sum +" = "+ p_sum +" ");
        }
        return -1;
    }

    public int solve2(int[] A) {

        int s_sum=0;
        for(int i=0;i<A.length;i++){
            s_sum+=A[i];
        }
        int p_sum=0;
        for(int i=0;i<A.length;i++){
            s_sum-=A[i];
            if(p_sum==s_sum){
                return i;
            }
            p_sum+=A[i];

            // System.out.print(s_sum +" = "+ p_sum +" ");
        }
        return -1;
    }

}
