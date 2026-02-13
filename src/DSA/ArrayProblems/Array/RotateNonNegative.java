package DSA.ArrayProblems.Array;

import java.util.ArrayList;

public class RotateNonNegative {
    public static void main(String[] args) {

    }


    public int[] rotateElements(int[] nums, int k) {


        int n = nums.length;

        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0;i<nums.length;i++){
            if(nums[i]>=0){
                res.add(nums[i]);
            }
        }
        if(res.size()==0){
            return nums;
        }
        k= k%res.size();
        int j =0;
        for(int i =0;i<nums.length;i++ ){

            if(nums[i]>=0){
                nums[i]= res.get((j+k)% res.size());
                j++;
            }

        }
        return nums;

    }


}
