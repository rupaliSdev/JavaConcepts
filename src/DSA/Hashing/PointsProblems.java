package DSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static DSA.maths.RecoverArrayFromGCDArray.gcd;

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

    public static int samePointsOnTheLine(ArrayList<Integer> A, ArrayList<Integer> B) {

        HashMap<List<Integer>,Integer> map= new HashMap<>();


        int max_count =0;


        for(int i =0;i<A.size();i++ ){
            int overlapping=0,count=0;

            for(int j =i+1;j<A.size();j++ ){
                List<Integer> tmp= new ArrayList<>();
                int x1 = A.get(i);int y1= B.get(i);
                int x2=  A.get(j);int y2= B.get(j);

                if(A.get(i)==A.get(j) || B.get(i)==B.get(j) ){
                    overlapping++;
                }
                else {
                    int xdiff = x2 - x1;
                    int ydiff = y2 - y1;
                    int z = gcd(xdiff,ydiff);
                    xdiff/=z;ydiff/=z;

                    tmp.add(xdiff);tmp.add(ydiff);
                    map.put(tmp,map.getOrDefault(tmp,0)+1);
                }

                count=Math.max(count,map.get(tmp));

            }
            max_count= Math.max(max_count,count+overlapping+1);
        }
        return max_count;

    }


}
