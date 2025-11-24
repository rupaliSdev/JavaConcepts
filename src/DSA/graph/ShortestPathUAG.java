package DSA.graph;

import java.util.*;

public class ShortestPathUAG {
    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] result = shortestPathBFS(9, adj);
        int[] res1 = shortestPathDFS(9, adj);

        for (int i = 0; i < n; i++) {
            System.out.println(i + " - " + result[i] + " - " + res1[i]);
        }


    }

    private static int[] shortestPathBFS(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {

            int x = queue.poll();
            for (Integer i : adj.get(x)) {
                if (dist[x] + 1 < dist[i]) {
                    dist[i] = dist[x] + 1;
                    queue.offer(i);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private static int[] shortestPathDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < V; i++) {
            dfs(i, adj, dist);
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] dist) {
        for (Integer j : adj.get(i)) {
            if (dist[j] > dist[i] + 1) {
                dist[j] = dist[i] + 1;
                dfs(i, adj, dist);
            }
        }
    }


}
