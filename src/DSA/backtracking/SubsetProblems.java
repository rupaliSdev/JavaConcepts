package DSA.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetProblems {


    public static void main(String[] args) {

        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> subsetArrays=subSetGenerateFirstApproach(arr);

        subsetArrays.forEach(System.out::println);

    }

    public static ArrayList<ArrayList<Integer>> subSetGenerateFirstApproach(int[] arr){

        Arrays.sort(arr);
        int n= arr.length;

        ArrayList<ArrayList<Integer>> subList = new ArrayList<>();

        for (int  i=0;i<(1<<n);i++){
            ArrayList<Integer> temp =new ArrayList<>();
            for (int j=0;j<n ;j++){
                if((i & (1<<j))!=0){
                    temp.add(arr[j]);
                }
            }
            subList.add(temp);

        }


        Collections.sort(subList,(first, second)->{
            for(int i =0;i<first.size() && i<second.size() ;i++){
                if(first.get(i)<second.get(i)){
                    return  -1 ;
                }
                else{
                    return 1;
                }

            }
            if(first.size()>second.size()){
                return 1;
            }
           return -1;
        });

      return subList;
    }

    public void subSetSumI2ndApproach(int[] arr){

    }
}
