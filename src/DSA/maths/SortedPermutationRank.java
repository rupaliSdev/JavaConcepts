package DSA.maths;

public class SortedPermutationRank {
    static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(calculateRank("VIEW"));
        System.out.println(calculateRankRepeatedCharacters("aba"));
    }

    public static int calculateRank(String A){
        int rank=0;
        for(int i =0;i<A.length();i++){
            char c= A.charAt(i);
            int count =0;

            for(int j =i+1;j<A.length();j++){
                char x= A.charAt(j);
                if(c>x){
                    count++;
                }


            }
            rank+= (count * fact(A.length()-1-i,mod)) %mod;

        }
      return rank+1;
    }

    public static int calculateRankRepeatedCharacters(String A){
        int rank=0;
        int[] freq = new int[256];
        for (char c:A.toCharArray()){
            freq[c]++;
        }
        for(int i =0;i<A.length();i++){
            char c= A.charAt(i);
            int count =0;

            for(int j =i+1;j<A.length();j++){
                char x= A.charAt(j);
                if(c>x){
                    count++;
                }
            }

            long r =1;
            for(Integer rep :freq){
                r= (r* fact(rep,mod)) % mod;
            }

            //a pow -1 = a pow p-2 where p is modulo
            long inverse=power((int)r,mod-2,mod) %mod;
            long perm = (fact(A.length()-1-i,mod) * inverse) % mod;

            rank+= (count * perm)%mod;
            freq[A.charAt(i)]--;

        }
        return rank+1;
    }

    private static int fact(int i,int mod) {
        if(i==0){
            return 1;
        }
        return (int) i* fact(i-1,mod) % mod ;
    }
    public static int power(int a,int b,int c){
        if(a==0){
            return 0;
        }
        if(b==0){
            return 1;
        }
        long y = power(a,b/2,c);
        long x=  (y%c  * y%c)%c ;
        if(b%2==0){
            return (int)x;
        }
        return  (int)((x* a)%c +c)%c;
    }
}
