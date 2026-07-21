package DSA.maths;

public class IntegerOverFlowCases {
    public static void main(String[] args) {

        int x= Integer.MAX_VALUE;
        x=x+1;
        System.out.println(x);

        int y= Integer.MAX_VALUE;
        int mid = (y + 20)/2;
        System.out.println(mid);

        mid = x + (y - x) / 2;
        System.out.println(mid);



    }
}
