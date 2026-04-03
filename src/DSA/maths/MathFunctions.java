package DSA.maths;

import java.util.Random;

public class MathFunctions {
    public static void main(String[] args) {
        //largest integer <=x
        System.out.println(Math.floor(3.7));
        System.out.println(Math.floor(-3.7));

        //smallest integer >=x
        System.out.println(Math.ceil(3.2));
        System.out.println(Math.ceil(-3.2));

       //nearest integer
        System.out.println(Math.round(3.7));
        System.out.println(Math.round(3.3));

        System.out.println((int)3.7);
        //Math.floor(3.7) ~ (int)3.7 //only for positive int negative it will be diff

        System.out.println((int)-3.7);
        //Returns a double between 0.0 and 1.0
        System.out.println(Math.random());

        //Generates number between min and max (inclusive)
        int max=100,min= 10;
        int x= min + (int) (Math.random() * (max-min+1)) ;

        System.out.println(x);

        //Random class
        Random random = new Random();
        System.out.println(random.nextInt(10));

        System.out.println("abs value "+ Math.abs(-5+2) + " pow "+ Math.pow(2, 3) + " sqrt "+ Math.sqrt(9));
    }
}
