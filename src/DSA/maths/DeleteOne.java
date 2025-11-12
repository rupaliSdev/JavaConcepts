package DSA.maths;

public class DeleteOne {


//    Given an integer array A of size N. You have to delete one element such that
//    the GCD(Greatest common divisor) of the remaining array is maximum.
//    Find the maximum value of GCD.
    public static void main(String[] args) {

    }


    public int solveGCD(int[] arr){
        int n = arr.length;
        int[] PGCD = new int[n];
        int[] SGCD = new int[n];

        PGCD[0]= arr[0];
        SGCD[n-1]=arr[n-1];
        int x= n-1;
        for(int i =1;i<n;i++){
            PGCD[i]= gcd(PGCD[i-1],arr[i]);
            SGCD[x-i]= gcd(SGCD[x-i+1],arr[i]);
        }
        int max_gcd =0;
        for(int i =1;i<n;i++){

            if(i==n-1){
                max_gcd = Math.max(max_gcd, PGCD[n-2]);
            }
             max_gcd = Math.max(max_gcd, gcd(PGCD[i-1],SGCD[i+1]));
        }

    return max_gcd;

    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}
