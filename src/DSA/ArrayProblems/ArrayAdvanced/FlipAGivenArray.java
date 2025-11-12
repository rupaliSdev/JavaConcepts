package DSA.ArrayProblems.ArrayAdvanced;

public class FlipAGivenArray {
    public static void main(String[] args) {

    }

    public int[] flip(String A) {

        char[] charArray = A.toCharArray();
        int curr_sum = 0,max_sum =0;
        int l=0,r=0;
        for(int i =0;i<charArray.length;i++){
            char c= charArray[i];
            curr_sum += c=='1'?-1:1;
            if(curr_sum<0){curr_sum=0;l=i+1;continue;}
            if(curr_sum>max_sum){
                max_sum=curr_sum;
                r= i;
            }

        }
        return new int[]{l+1,r+1};
    }
}
