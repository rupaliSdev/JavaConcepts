package Basics.InterviewQues.map;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {


        Set<Map.Entry<Integer,String>> map = new HashSet<>();
        map.add(Map.entry(1,"rupali"));
        map.add(Map.entry(1,"rupali sahu"));
        map.add(Map.entry(2,"munmun"));
        map.add(Map.entry(3,"anchal"));

        //cant have null values
        // map.add(Map.entry(null,"anchal"));

        TreeMap<Integer, String> hashMap= new TreeMap<>();
        hashMap.put(1,"rupali");
        hashMap.put(4,"rupali sahu");
        hashMap.put(2,"munmun");
        hashMap.put(3,"anchal");
        System.out.println(hashMap.size() + " "+ map.size());

        for (Map.Entry<Integer,String> entry:hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("next");
        for (Map.Entry<Integer,String> entry:map){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }


}
