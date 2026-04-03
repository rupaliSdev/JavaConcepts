package DSA.BinarySearch;

/*Given an array arr[] consisting of N positive integers and a positive integer K such that there
are N countries, each country has arr[i] players, the task is to find the maximum number of teams that can be
formed by forming teams of size K such that each player in the team is from a different country.*/


public class MaxTeamOfKPlayers {

    public static void main(String[] args) {

        int N = 4;
        int K = 3;
        int[] arr =new int[] {4, 3, 5, 3};
        System.out.println(countOfTeams(N,K,arr));


    }
    public static int countOfTeams(int N,int K,int[] arr){
        int totalCnt = 0;
        for(int a:arr)totalCnt+=a;

        int left =0,right= totalCnt/K;

        int ans = 0;

        while (left<=right){
            int mid = (left+right)/2;

            if(canFormed(arr,K,mid)){
                ans= left;
                left= mid+1;
            }
            else{
                right= mid-1;
            }
        }

        return ans;
    }

    private static boolean canFormed(int[] arr, int k, int maxPlayers) {
        int totalPlayers=0;
        for(int a:arr){
           totalPlayers+= Math.min(a,maxPlayers);
        }

        return totalPlayers>=maxPlayers *k;
    }
}
