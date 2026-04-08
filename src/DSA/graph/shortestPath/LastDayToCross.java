package DSA.graph.shortestPath;

import java.util.LinkedList;
import java.util.Queue;

public class LastDayToCross {

    // https://leetcode.com/problems/last-day-where-you-can-still-cross/description/
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {

        int row = 2, col = 2, cells[][] = {{1, 1}, {2, 1}, {1, 2}, {2, 2}};
        System.out.println(latestDayToCross(row, col, cells));
    }

    public static int latestDayToCross(int row, int col, int[][] cells) {

        int low = 0, high = row * col;

        while (low < high) {
            int mid = (low + high) / 2;
            if (canCross(row, col, mid, cells)) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    private static boolean canCross(int row, int col, int mid, int[][] cells) {

        int[][] grid = new int[row][col];
        for (int i = 0; i < mid; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            if (x[0] == row - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int newRow = x[0] + dir[0];
                int newCol = x[1] + dir[1];
                if (newRow >= 0 && newRow < row && newCol < col && newCol >= 0 && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = -1;
                }
            }
        }
        return false;
    }

}
