package DSA.graph.cycleDetection;

public class EventualSafeStates {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[] ans = findSafeNodes(edges);
        for (int i = 0; i < edges.length; i++) {
            if (ans[i] == 1) {
                System.out.print(i);
            }
        }


        // optimized
        int[] state = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (state[i] == 0 && dfs2nd(edges, i, state)) {
                state[i] = 3;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (state[i] == 2) {
                System.out.print(i);
            }
        }


    }

    private static boolean dfs2nd(int[][] edges, int curr, int[] state) {

        if (state[curr] == 3) return false;
        state[curr] = 1;
        for (int i : edges[curr]) {
            if (state[i] == 0 && dfs2nd(edges, i, state)) {
                state[curr] = 3;
                return true;
            } else if (state[i] == 1) {
                state[curr] = 3;
                return true;
            }

        }
        state[curr] = 2;
        return false;

    }

    public static int[] findSafeNodes(int[][] edges) {
        int[] safeNodes = new int[edges.length];
        int[] vis = new int[edges.length];
        int[] pathVis = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            safeNodes[i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            if (vis[i] == 0 && dfsSafeNodes(safeNodes, i, vis, edges, pathVis)) {
                safeNodes[i] = 0;
            }
        }

        return safeNodes;
    }

    private static boolean dfsSafeNodes(int[] safeNodes, int curr, int[] vis, int[][] edges, int[] pathVis) {
        vis[curr] = 1;
        pathVis[curr] = 1;
        int[] adjList = edges[curr];
        for (int adj : adjList) {
            if (vis[adj] == 0 && dfsSafeNodes(safeNodes, adj, vis, edges, pathVis)) {
                safeNodes[curr] = 0;
                return true;
            } else if (pathVis[adj] == 1) {
                safeNodes[curr] = 0;
                return true;
            }
        }
        pathVis[curr] = 0;
        return false;
    }


}
