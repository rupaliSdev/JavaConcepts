package DSA.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightsInChess {


    public static void main(String[] args) {
        int N = 6;
        int knightPos[] = {4, 5};
        int targetPos[] = {1, 1};
        System.out.print(minNoOfMoves(N, knightPos, targetPos));
    }

    public static int minNoOfMoves(int n, int[] knightPosition, int[] target) {
        int[][] dirs = {{-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(knightPosition);
        visited[knightPosition[0]][knightPosition[1]] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                if (pos[0] == target[0] && pos[1] == target[1]) {
                    return count;
                }
                for (int[] dir : dirs) {
                    int row = pos[0] + dir[0];
                    int col = pos[1] + dir[1];
                    if (row >= 0 && row < n && col >= 0 && col < n && visited[row][col] == false) {
                        visited[row][col] = true;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
            count++;
        }
        return -1;
    }

}

