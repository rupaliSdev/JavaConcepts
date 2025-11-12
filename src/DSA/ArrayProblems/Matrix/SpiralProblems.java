package DSA.ArrayProblems.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralProblems {

    public static void main(String[] args) {
        int[][] x= new int[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.println(x[i][j]);
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] m) {
        List<Integer> res = new ArrayList<>();
        int dir =0;
        int l=0,r= m[0].length-1;
        int t=0,d=m.length-1;

        while(t<=d && l<=r){
            if(dir ==0){
                for(int i=l;i<=r;i++){
                    res.add(m[t][i]);
                }
                t++;
            }
            else if(dir ==1){
                for(int i=t;i<=d;i++){
                    res.add(m[i][r]);
                }
                r--;
            }
            else if(dir ==2){
                for(int i=r;i>=l;i--){
                    res.add(m[d][i]);
                }
                d--;
            }
            else if(dir ==3){
                for(int i=d;i>=t;i--){
                    res.add(m[i][l]);
                }
                l++;
            }

            dir=(dir+1)%4;
        }
        return res;
    }


}
