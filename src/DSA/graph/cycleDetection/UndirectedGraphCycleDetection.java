package DSA.graph.cycleDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//
//https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
public class UndirectedGraphCycleDetection {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1);
        adj.get(1).add(3);


        boolean ans = isCycleII(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean isCycleI(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsApproach(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }

    private static boolean dfsApproach(int node, int parent, List<List<Integer>> adj, int[] vis) {

        vis[node] = 1;
        for (Integer i : adj.get(node)) {
            if (vis[i] == 0) {
                if (dfsApproach(i, node, adj, vis)) return true;
            }
            //if u see the node again but thats not parent
            else if (i != parent) {
                return true;
            }

        }
        return false;
    }

    public static boolean isCycleII(int V, List<List<Integer>> adjList) {
        boolean[] vis = new boolean[V];
        //for diconnected componenets
        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                Queue<Pair> queue = new LinkedList<>();
                queue.offer(new Pair(i, -1));
                vis[i] = true;
                while (!queue.isEmpty()) {
                    Pair curr = queue.poll();
                    for (int adj : adjList.get(curr.node)) {
                        if (!vis[adj]) {
                            vis[adj] = true;
                            queue.offer(new Pair(adj, curr.node));
                        } else {
                            if (adj != curr.parent) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }


}
