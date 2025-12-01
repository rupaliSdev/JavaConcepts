package Basics.Collections.collections1;


import java.util.ArrayList;

public class ex1 {
    public static void main(String[] args){
        ArrayList<gerbil> arr= new ArrayList<>();
        for(int i=0;i<3;i++){
            arr.add(new gerbil(i));
        }
        for(int i=0;i<3;i++){
            arr.get(i).hop();
        }
    }

    static class gerbil{
        int gerbilNumber;

        public gerbil( int gerbilNumber) {
            this.gerbilNumber=gerbilNumber;
        }
        public void hop(){
            System.out.println(gerbilNumber);
        }
    }
}
