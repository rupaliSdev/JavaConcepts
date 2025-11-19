package DSA.dp;

public class CountNoOfTeams {
    public static void main(String[] args) {
        int[] rating = {2,5,3,4,1};
        int n= numOfTeamsMemo(rating);
        numOfTeamsTab(rating);
        System.out.println(n);
    }

    private static int numOfTeamsTab(int[] rating) {

        int n = rating.length;
        int teams=0;
        Integer[][] increasingCache= new Integer[n][4];
        Integer[][] decreasingCache= new Integer[n][4];

        for (int i = 0; i < n; i++) {
            increasingCache[i][1] = 1;
            decreasingCache[i][1] = 1;
        }

        for(int count =2 ;count<=3;count++){
            for(int i =0 ;i<rating.length;i++){
                for(int j=0 ;j<i ;j++){

                }
            }
        }



        return 0;
    }


    private static int numOfTeamsMemo(int[] rating) {

        int n=rating.length;
        int teams=0;
        Integer[][] increasingCache= new Integer[n][4];
        Integer[][] decreasingCache= new Integer[n][4];

        for(int startIndex=0;startIndex<n;startIndex++){
            teams+=countIncreasingTeams(rating,startIndex,1,increasingCache)
                    +countDecreasingTeams(rating,startIndex,1,decreasingCache);
        }
        return teams;
    }

    private static int countDecreasingTeams(int[] rating, int currIndex, int teamSize, Integer[][] decreasingCache) {
        int n= rating.length;
        if(currIndex==n)return 0;
        if(teamSize==3) return 1;

        if(decreasingCache[currIndex][teamSize]!=null){
            return decreasingCache[currIndex][teamSize];
        }
        int teams =0;

        for(int nextIndex= currIndex+1;nextIndex<n;nextIndex++){
            if(rating[nextIndex]<rating[currIndex]){
                teams+=countDecreasingTeams(rating,nextIndex,teamSize+1,decreasingCache);
            }
        }
        return decreasingCache[currIndex][teamSize]=teams;
    }

    private static int countIncreasingTeams(int[] rating, int currIndex, int teamSize, Integer[][] increasingCache) {
        int n=rating.length;
        if(currIndex==n)return 0;
        if(teamSize==3) return 1;
        if(increasingCache[currIndex][teamSize]!=null)return increasingCache[currIndex][teamSize];

        int teams=0;

        for(int nextIndex= currIndex+1;nextIndex<n;nextIndex++){

            if(rating[nextIndex]>rating[currIndex]){
                teams+=countIncreasingTeams(rating,nextIndex,teamSize+1,increasingCache);
            }

        }
        return increasingCache[currIndex][teamSize]=teams;
    }
}
