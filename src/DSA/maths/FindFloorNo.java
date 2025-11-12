package DSA.maths;


/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */


import java.util.HashMap;
import java.util.Map;

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [["Bobby", "87"],
 **   ["Charles", "100"],
 **   ["Eric", "64"],
 **   ["Charles", "22"]].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */
public class FindFloorNo {


        /*
         **  Find the best average grade.
         */

        public static int bestAverageGrade(String[][] scores) {

            HashMap<String,Pair> scoreMap= new HashMap<>();

            for(String[] score :scores){
                String name= score[0];
                long sum =Integer.valueOf(score[1]);
                System.out.println(sum);
                int count =1;
                if(scoreMap.containsKey(name)){
                    sum+=scoreMap.get(name).scores;
                    count+=scoreMap.get(name).numOfScores;

                }
                Pair pair = new Pair(sum, count);
                scoreMap.put(name,pair);
            }

            int max_avg_scores=Integer.MIN_VALUE;

            for(Map.Entry<String,Pair> entry:scoreMap.entrySet()){
                double avg = (double)(entry.getValue().scores)/entry.getValue().numOfScores;

                int avg_score =(int)Math.floor(avg);

                max_avg_scores= Math.max(avg_score,max_avg_scores);
                System.out.println(max_avg_scores);

            }

            return max_avg_scores;
        }

        /*
         **  Returns true if the tests pass. Otherwise, returns false;
         */
        public static boolean doTestsPass() {
            // TODO: implement more test cases
            String[][] tc1 = {
                    {"Bobby", "87"},
                    {"Charles", "100"},
                    {"Eric", "64"},
                    {"Charles", "22"}};


            String[][] tc2 = {
                    {"Bobby", "57"},
                    {"Charles", "193"},
                    {"Eric", "64"},
                    {"Charles", "22"}};


            String[][] tc3 = {
                    {"Bobby", "-57"},
                    {"Bobby", "-2"},
                    {"Charles", "-193"},
                    {"Eric", "-64"},
                    {"Charles", "-22"}};



            return bestAverageGrade(tc1) == 87 && bestAverageGrade(tc2) == 107
                    && bestAverageGrade(tc3) == -30 ;
        }

        /*
         **  Execution entry point.
         */
        public static void main(String[] args) {
            // Run the tests
            if (doTestsPass()) {
                System.out.println("All tests pass");
            }
            else {
                System.out.println("Tests fail.");
            }
        }

}
class Pair{
    long scores;
    int numOfScores;
    Pair(long scores,int numOfScores){
        this.scores=scores;
        this.numOfScores=numOfScores;
    }
}


