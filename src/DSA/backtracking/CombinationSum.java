package DSA.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
       int[] arr= {10, 1, 2, 7, 6, 1, 5}; int target = 8;
        Arrays.sort(arr);
       System.out.println(combinationSum2(arr,8));

        int[] arr1= {2,3,6,7}; int target1 = 7;
        System.out.println(combinationSum1(arr1,target1));

    }


   /* Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        findSum(res,0,candidates,target,new ArrayList<>());


        List<List<Integer>> res1= new ArrayList<>();
        Arrays.sort(candidates);
        findSum2ndApproach(res1,0,candidates,target,new ArrayList<>());
        System.out.println("here " +res1);
        return res;
    }


/*    Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.*/
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        findSum2(res,0,candidates,target,new ArrayList<>());
        return res;
    }


    public static void findSum(List<List<Integer>> res, int index, int[] c, int target, List<Integer> temp) {


        if (index == c.length) {
            if (target == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (c[index] <= target) {
            temp.add(c[index]);
            findSum(res, index, c, target - c[index], temp);
            temp.remove(temp.size() - 1);

        }
        findSum(res, index + 1, c, target, temp);
    }


    public static void findSum2ndApproach(List<List<Integer>> res, int index, int[] c, int target, List<Integer> temp) {

        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        if (target < 0)
            return;

        for (int i =index;i<= target/c[index];i++) {
            temp.add(c[i]);
            findSum2ndApproach(res, i, c, target - c[i], temp);
            temp.remove(temp.size() - 1);
        }
    }


    public static void findSum2(List<List<Integer>> res, int index, int[] c, int target, List<Integer> temp) {


        if (index == c.length) {

            if (target == 0) {

                res.add(new ArrayList<>(temp));

            }
            return;
        }

        if (c[index] <= target) {


            temp.add(c[index]);
            findSum2(res, index+1, c, target - c[index], temp);
            temp.remove(temp.size() - 1);


       }
        int i = index + 1;
        while ( i < c.length && c[i] == c[i - 1] ) {
            i++;
        }
        findSum2(res, i, c, target, temp);
    }

}
