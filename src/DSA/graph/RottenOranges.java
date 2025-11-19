package DSA.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {

        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println(rotting);
    }
    public static int orangesRotting(int[][] grid) {
        int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
        int totalTime = 0;
        int countFresh=0;
        Queue<int[]> queue= new LinkedList<>();
        for (int i =0;i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    int[] point = {i,j};
                    queue.offer(point);
                }
                else if(grid[i][j]==1) countFresh++;

            }
        }
        if(countFresh==0)return 0;
        while (!queue.isEmpty()){
            int size= queue.size();
            boolean rottenNew = false;
            for(int i =0;i<size;i++) {
                int[] point1= queue.poll();
                for (int point = 0; point < dir.length; point++) {
                    int[] point2 = {point1[0] + dir[point][0], point1[1] + dir[point][1]};
                    if (point2[0] < 0 || point2[1] < 0 || point2[0] > grid.length - 1 || point2[1] > grid[0].length - 1) {
                        continue;
                    }
                    if (grid[point2[0]][point2[1]] == 1) {
                        grid[point2[0]][point2[1]]=2;
                        queue.offer(point2);
                        countFresh--;
                        rottenNew=true;
                    }
                }
            }
            if (rottenNew) {
                totalTime++;
            }
        }
        return countFresh!=0?-1: totalTime;
    }

//    Time Complexity: O ( n x n ) x 4
//
//    Reason: Worst-case - We will be making each fresh orange rotten in the grid and for each rotten orange will check in 4 directions
//
//    Space Complexity: O ( n x n )
//
//    Reason: worst-case -  If all oranges are Rotten, we will end up pushing all rotten oranges into the Queue data structure
//

}
