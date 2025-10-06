package DSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PointsProblems {

    public static void main(String[] args) {


        int[] A = {1, 1, 2, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1, 2};

        ArrayList<Integer> A1=new ArrayList<>(); ArrayList<Integer> B1= new ArrayList<>();
        for (Integer a :A){
            A1.add(a);
        }
        for (Integer a :B){
            B1.add(a);
        }

        System.out.println(countRectangles(A1,B1));
    }

    public static int countRectangles(ArrayList<Integer> A, ArrayList<Integer> B) {

        HashMap<String,Integer> map= new HashMap<>();
        for(int i =0;i<A.size();i++ ){
            map.put(A.get(i)+"&"+ B.get(i) ,1);
        }
        int count =0;

        for(int i =0;i<A.size();i++ ){
            for(int j =i+1;j<A.size();j++ ){
                  String x1 = A.get(i)+"&"+ B.get(j);
                  String x2= A.get(j)+"&"+ B.get(i);
                  if(A.get(i)==A.get(j) || B.get(i)==B.get(j) ){
                      continue;
                  }
                  if(map.containsKey(x1) && map.containsKey(x2)){
                      count++;
                  }
            }
        }
        return count>>1;

    }
}
