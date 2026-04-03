package DSA.graph.shortestPath;

import java.util.*;


public class SnackesAndLadders {
    public static void main(String[] args) {
        int[][] board = {{-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        System.out.print(snakesAndLaddersII(board));

    }

    public static int snakesAndLadders(int[][] board) {

        int n = board.length;

        //create a graph
        int node = 1;

        int ans = 0;
        int[] connections = new int[n * n + 1];
        Arrays.fill(connections, -1);
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) connections[node] = board[i][j];
                    node++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    connections[node] = board[i][j];
                    node++;
                }
            }
            flag = !flag;
        }

        //create graph
        List<List<Integer>> adjList = new ArrayList<>();


        for (int i = 0; i <= n * n; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < n * n + 1; i++) {
            for (int j = 1; j <= 6; j++) {
                int nbr = i + j;
                if (nbr <= n * n) {
                    if (connections[nbr] != -1) {
                        adjList.get(i).add(connections[nbr]);
                    } else {
                        adjList.get(i).add(nbr);
                    }
                }
            }

        }

        //finding the shortest path


        int[] vis = new int[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n * n) {
                    return level;
                }
                for (int adj : adjList.get(curr)) {
                    if (vis[adj] == 0) {
                        q.offer(adj);
                        vis[adj] = 1;
                    }
                }

            }
            level++;
        }

        return -1;

    }

    public static int snakesAndLaddersII(int[][] board) {
        int n = board.length;
        int[] vis = new int[n * n + 1];

        int node = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int nbr = q.poll();
                if (nbr == n * n) {
                    return level;
                }
                for (int i = 1; i <= 6; i++) {
                    int adj = nbr + i;
                    if (adj <= n * n) {
                        int[] next = findCoordinates(adj, n);
                        if (board[next[0]][next[1]] != -1) {
                            adj = board[next[0]][next[1]];
                        }
                        if (vis[adj] != 1) {
                            vis[adj] = 1;
                            q.offer(adj);
                        }

                    }

                }
            }
            level++;

        }
        return -1;

    }

    private static int[] findCoordinates(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;

        if (r % 2 != 0) {
            c = n - 1 - c;
        }
        r = n - 1 - r;
        return new int[]{r, c};

    }


}


//TC:o(n*n)
//sc:o(n*n)