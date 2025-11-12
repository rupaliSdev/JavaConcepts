package DSA.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {


    public static void main(String[] args) {


        System.out.println(findPermutations("ABC"));
        System.out.println(findUniquePermutations("121"));

    }

    private static List<String>  findUniquePermutations(String number) {

        int[] vis = new int[number.length()];
        List<String> res = new ArrayList<>();

        char[] ch = number.toCharArray();
        Arrays.sort(ch);
        permut(ch,vis,res,new ArrayList<>());
        return res;
    }

    private static void permut(char[] number, int[] vis, List<String> res, ArrayList<Character> temp) {

        if(temp.size()==number.length){
            StringBuilder sb = new StringBuilder();
            for(char c : temp) sb.append(c);
            res.add(sb.toString());
            return;
        }

        for (int i=0;i<number.length;i++){
            if(vis[i]==1){
                continue;
            }
            if (i>0 && (number[i]==number[i-1]) && vis[i-1]==0){
                continue;
            }
            temp.add(number[i]);
            vis[i]=1;
            permut(number,vis,res,temp);
            temp.remove(temp.size()-1);
            vis[i]=0;
        }



    }

    public static List<String> findPermutations(String str){

        char[] arr= str.toCharArray();
        List<String> res = new ArrayList<>();
        findAllPermut(arr,0,res);
         return res;

    }

    private static void findAllPermut(char[] arr, int index, List<String> res) {


        if(index==arr.length){
            res.add(new String(arr));
        }


        for (int i =index;i<arr.length;i++) {
            swap(arr, index, i);
            findAllPermut(arr,index+1,res);
            swap(arr, i, index);
        }

    }



    public static void swap(char[] arr, int i, int j){
          char c= arr[i];
          arr[i]=arr[j];
          arr[j]=c;

    }
}
