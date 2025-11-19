package DSA.graph;

public class NoOFIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(countNoOfIslands(grid));

    }

    private static int countNoOfIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsIs(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void dfsIs(int r, int c, char[][] grid) {
        grid[r][c] = '0';
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int curr_row = r + i, curr_col = c + j;
                if (curr_row < grid.length && curr_row >= 0 && curr_col < grid[0].length && curr_col >= 0 && grid[curr_row][curr_col] == '1') {
                    dfsIs(curr_row, curr_col, grid);
                }
            }
        }
    }
}
