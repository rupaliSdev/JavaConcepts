package DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        String[] strings={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));

        int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));

    }

    public static String longestCommonPrefix(String[] strings){
        Arrays.sort(strings);

        String firstString = strings[0];
        String lastString = strings[strings.length-1];
        String lcp="";
        for(int i=0;i<firstString.length();i++){
            if(firstString.charAt(i)!=lastString.charAt(i))
            {
                break;
            }
            lcp+=firstString.charAt(i);

        }

        return lcp;

    }



    public static int orangesRotting(int[][] grid) {

        int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

        int totalTime = 0;

        Queue<int[]> queue= new LinkedList<>();
        int countFresh = 0;
        for (int i =0;i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                  if(grid[i][j]==2){
                      int[] point = {i,j};
                      queue.offer(point);
                  }


            }
        }


        while (!queue.isEmpty()){


            for(int i =0;i<queue.size();i++) {
                int[] point1= queue.poll();
                for (int point = 0; point < dir.length; point++) {
                    int[] point2 = {point1[0] + dir[point][0], point1[1] + dir[point][1]};

                    if (point2[0] < 0 || point2[1] < 0 || point2[0] > grid.length - 1 || point2[1] > grid[0].length - 1) {
                        continue;
                    }

                    if (grid[point2[0]][point2[1]] == 1) {
                        grid[point2[0]][point2[1]]++;
                        queue.offer(point2);
                    }

                }


            }
            if (!queue.isEmpty()) {
                totalTime++;
            }
        }

        return  totalTime;

    }

}
