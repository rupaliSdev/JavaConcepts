package DSA.maths;

public class CircleAndLatticePoints {
    public static void main(String[] args) {
        int latticePoints= findLatticePoints(5);
        System.out.println(latticePoints);
    }

    private static int findLatticePoints(int r) {

        if(r<=0)return 0;
        int result=4;
        for(int i =1;i<r;i++){
            int ySquare=r*r-i*i;


            int y= (int) Math.sqrt(ySquare);
            if(y*y==ySquare){
                System.out.println(i +","+y);
                result+=4;
            }
        }
        return result;
    }
}
