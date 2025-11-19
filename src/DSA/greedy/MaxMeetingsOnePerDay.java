package DSA.greedy;

import java.util.*;

public class MaxMeetingsOnePerDay {


        public static int maxMeetings(int[] firstDay, int[] lastDay) {
            int n = firstDay.length;
            // Create list of intervals (start, end)
            List<int[]> meetings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                meetings.add(new int[]{firstDay[i], lastDay[i]});
            }
            // Sort by end time
            meetings.sort(Comparator.comparingInt(a -> a[1]));
            Set<Integer> bookedDays = new HashSet<>();
            int maxCount = 0;
            for (int[] meeting : meetings) {
                for (int day = meeting[0]; day <= meeting[1]; day++) {
                    if (!bookedDays.contains(day)) {
                        bookedDays.add(day);
                        maxCount++;
                        break;
                    }
                }
            }
            return maxCount;
        }


    public static int maxMeetingsII(int[] firstDay, int[] lastDay) {
            int n= firstDay.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = firstDay[i];
            meetings[i][1] = lastDay[i];
        }
        Arrays.sort(meetings,(a,b)->a[1]-b[1]);
        int maxCount = 0,prev_EndDay=0;
        for (int i=0;i<firstDay.length;i++) {
            if(meetings[i][1]>prev_EndDay) {
                maxCount++;
                prev_EndDay=meetings[i][0]>prev_EndDay?meetings[i][0]:prev_EndDay+1;
            }
        }
        return maxCount;
    }


    public static void main(String[] args) {
            // Example input
            int[] firstDay = {1, 1, 3, 3, 2};
            int[] lastDay  = {2, 2, 3, 4, 4};

            int result = maxMeetings(firstDay, lastDay);

            System.out.println("Maximum number of meetings: " + result+","+maxMeetingsII(firstDay,lastDay));
        }
    }


