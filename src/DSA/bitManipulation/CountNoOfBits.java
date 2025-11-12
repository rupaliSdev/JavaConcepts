
package DSA.bitManipulation;

public class CountNoOfBits {

    public static void main(String[] args) {
        System.out.println(11);
    }


    public static int numSetBits(int A) {
        int count=0;
        while(A>0){
            A = A & (A-1);
            count++;
        }
        return count;
    }
}
