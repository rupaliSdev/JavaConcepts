package DSA.maths;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementNTwo {
    public static void main(String[] args) {

    }


    public static List<Integer> CMEThree(int[] arr){
        int CME1=-1,CME2=-1;
        int i =0;
        int f1=0,f2=0;
        while(i< arr.length){

            if(f1==0){
                CME1=arr[i];
            }
            else if(f2==0){
                CME2=arr[i];
            }
            else if(arr[i]==CME1){
                f1++;
            }
            else if(arr[i]==CME2){
                f2++;
            }
            else{
                f1--;f2--;
            }
            i++;
        }
        f1=0;f2=0;
        for (int j =0;j<arr.length;j++){
            if(arr[i]==CME1){
                f1++;
            }
            else if(arr[i]==CME2){
                f1++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(f1 >arr.length/3){
            res.add(CME1);
        }
        if(f2 >arr.length/3){
            res.add(CME2);
        }
        return res;
    }

}
