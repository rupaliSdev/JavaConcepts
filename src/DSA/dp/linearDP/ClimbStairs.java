package DSA.dp.linearDP;

public class ClimbStairs {

/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
      climb[1] = 1
      climb[2] =1
     climb[i]= climb[i-1]+ climb[i-2]

*/


    public static void main(String[] args) {
          int n =4;
        System.out.println(findTheWays(n));


    }

    private static int findTheWays(int n) {
        int x=1,y=1;
        for(int i =2;i<=n ;i++){
            int temp = x+y;
            x= y;
            y =temp;
        }
      return y;
    }


}
