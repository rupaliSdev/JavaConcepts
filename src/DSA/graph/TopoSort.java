package DSA.graph;

import java.util.*;

public class TopoSort {

    //    u->v u should always come before v
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            adj.add(arr);
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        List<Integer> res = topoSortDFS(n, adj);
        System.out.println(res);

        List<Integer> result = topoWithKahnsApproach(n, adj);
        System.out.println(result);

    }

    public static List<Integer> topoWithKahnsApproach(int n, List<List<Integer>> adjLists) {

        int[] inDegree = new int[n];
        for (List<Integer> adjList : adjLists) {
            for (Integer adj : adjList) {
                inDegree[adj]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (Integer i : adjLists.get(x)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            res.add(x);
        }
        return res;
    }

    public static List<Integer> topoSortDFS(int V, List<List<Integer>> adjList) {
        int[] vis = new int[V];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsTopo(vis, i, adjList, stack);
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;

    }

    private static void dfsTopo(int[] vis, int i, List<List<Integer>> adjList, Stack<Integer> stack) {
        vis[i] = 1;
        for (Integer adjs : adjList.get(i)) {
            if (vis[adjs] == 0) {
                dfsTopo(vis, adjs, adjList, stack);
            }
        }
        stack.push(i);
    }

}
