package DSA.StringDemo;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {

    static final int MAX_CHAR=26;
    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};

        ArrayList<ArrayList<String>> res= anagrams(arr);

        System.out.println(res.toString());


    }

    private static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        HashMap<String,Integer> map= new HashMap<>();
        ArrayList<ArrayList<String>> res= new ArrayList<>();
        for(String string :arr){
            String key = findHash(string);
            if(!map.containsKey(key)){
                map.put(key,res.size());
                res.add(new ArrayList<>());

            }
            res.get(map.get(key)).add(string);
        }
        return res;
    }

    private static String findHash(String string) {
        StringBuilder sb = new StringBuilder();
        int[] freq= new int[MAX_CHAR];
        for (char c:string.toCharArray()){
            freq[c-'a']++;
        }

        for(int  i=0;i<MAX_CHAR;i++){
            sb.append(freq[i]);
            sb.append("$");
        }
        return sb.toString();
    }
}
