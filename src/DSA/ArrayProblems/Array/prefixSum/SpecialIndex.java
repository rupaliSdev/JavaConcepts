package DSA.ArrayProblems.Array.prefixSum;


//Given an array, arr[] of size N, the task is to find the count of array indices such
//that removing an element from these indices makes the sum of even-indexed and odd-indexed
//array elements equal.
public class SpecialIndex {
    public static void main(String[] args) {

   int[] arr = {2, 1, 6, 4};
        System.out.println(solve(arr));

    }

    public static int solve(int[] arr){

        int[] pre_even= new int[arr.length];
        int[] pre_odd = new int[arr.length];
        pre_odd[0]=arr[0]; pre_even[0]=0;
        for(int i= 1;i< arr.length;i++){
            if(i%2==0){
                pre_odd[i]=pre_odd[i-1]+ arr[i];
                pre_even[i]= pre_even[i-1];
            }
            else{
                pre_even[i]=pre_even[i-1]+arr[i];
                pre_odd[i]= pre_odd[i-1];
            }
        }
        int count=0;
        for(int i= 1;i< arr.length;i++){
            int ES=0,OS=0;
            if(i==0){
               ES = pre_odd[arr.length-1]-pre_odd[i];
               OS= pre_even[arr.length-1]-pre_even[i];
            }
            else{
                ES = pre_even[i-1]+ pre_odd[arr.length-1]-pre_odd[i];
                OS = pre_odd[i-1]+pre_even[arr.length-1]-pre_even[i];
            }
            if(ES==OS){
                System.out.println(arr[i]);
                count++;
            }
        }

        return count;
    }
}
