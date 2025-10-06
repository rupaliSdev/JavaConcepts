package DSA.bitManipulation;

public class DevideInteger {

    public static void main(String[] args) {
        System.out.println(divide(480,10));

    }

    public static int divide(int dividend, int divisor){

       if(dividend ==Integer.MIN_VALUE && divisor==-1){
           return Integer.MAX_VALUE;
       }

       boolean negative = dividend<0 ^ divisor<0 ;
        long ldividend= Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long result =0;

        while(ldividend >=ldivisor){
            long temp = ldivisor,multiple = 1;

            while (ldividend >= (temp <<1)){
                temp <<=1;
                multiple<<=1;
            }
            ldividend-=temp;
            result+=multiple;
        }

        if(negative) result=-result;
        if (result> Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result< Integer.MIN_VALUE) return  Integer.MIN_VALUE;

        return (int)result;
    }
}
