package DSA.greedy;

import java.util.Arrays;

public class MinPlatformsRequired {


    /*
    * Given arrival arr[] and departure dep[] times of trains on the same day, find the minimum number of platforms needed so that no train waits. A platform cannot serve two trains at the same time; if a train arrives before another departs, an extra platform is needed.

Note: Time intervals are in the 24-hour format (HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this will be <= 59 and >= 0). Leading zeros for hours less than 10 are optional (e.g., 0900 is the same as 900).


    * */


    public static void main(String[] args) {
      int arr[] ={900, 940, 950 ,1100 ,1500, 1800},dep[] ={910, 1200 ,1120, 1130, 1900, 2000};
        System.out.println(minPlatform(arr,dep));
    }

    public static int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxPlatforms=1;
        int platforms =1;
        int i=1,j=0;
        while(i<arr.length && j<arr.length ){
            if(dep[j]>=arr[i]){
                platforms++;maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            }
            else if (arr[i]> arr[j]){
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
    }
}
