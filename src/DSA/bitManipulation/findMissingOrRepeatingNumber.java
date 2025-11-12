package DSA.bitManipulation;

public class findMissingOrRepeatingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingRepeatingNo(new int[]{3,1,2,2,5}));
    }

    public static int[]  findMissingRepeatingNo(int[] arr){


        int n= arr.length;
        int xor=0;


        for(int i =0;i<arr.length;i++){
            xor^=arr[i];
            xor^=(i+1);
        }


        int number = xor & ~(xor-1) ;

        int zeros =0,ones=0;

        for(int i =0;i<n;i++){
            if((arr[i] & number) != 0 ) ones^=arr[i];
            else zeros^=arr[i];
        }

        for(int i =1;i<=n;i++){

            if((i & number) != 0 ) ones^=i;
            else zeros^=i;
        }

        int count =0;
        for(int i =0;i<n;i++){
            if(arr[i] ==ones ) count++;

        }
        if(count==2) return new int[]{zeros,ones};
        return new int[]{ones,zeros};

    }
}
