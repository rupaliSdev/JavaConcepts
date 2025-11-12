package DSA.graph;

import DSA.BST.TreeNode;

import java.util.*;

public class CheapestFlightWithKStops {
//   [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]

    public static void main(String[] args) {
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        System.out.println(findCheaperPrice(4,flights,0,3,1));
        System.out.println(findCheapestPrice(4,flights,0,3,1));
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Map.Entry<Integer,Integer>>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            List<Map.Entry<Integer,Integer>> res= new ArrayList<>();
            adjList.add(res);
        }

        for(int[] flight:flights){
            adjList.get(flight[0]).add(Map.entry(flight[1],flight[2]));
        }

        int[] dist = new int[adjList.size()];
        for(int i=0;i<adjList.size();i++){
            dist[i]= Integer.MAX_VALUE;
        }
        dist[src]=0;


        Queue<Triplet> q= new LinkedList<>();
        q.offer(new Triplet(src,0,0));

        while (!q.isEmpty()){
            Triplet t1 = q.poll();
            int node = t1.node;
            int cost = t1.cost;
            int stops= t1.stops;
            if(stops>k){
                continue;
            }
            for(Map.Entry<Integer,Integer> adj:adjList.get(node)){
                int nextCost= cost+ adj.getValue();

                if(nextCost< dist[adj.getKey()]){
                    dist[adj.getKey()]=nextCost;
                    q.offer(new Triplet(adj.getKey(),nextCost, stops+1));
                }
            }


        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
    static class Triplet {
        int node;
        int cost;
        int stops;

        public Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        private Triplet(int node,int stops){
            this.node = node;
            this.stops = stops;
        }
    }

    public static int findCheaperPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build adjacency list
        List<List<Map.Entry<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adjList.get(flight[0]).add(Map.entry(flight[1], flight[2]));
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Queue for BFS (node, cost, stops)
        Queue<Triplet> q = new LinkedList<>();
        q.offer(new Triplet(src, 0, 0));

        while (!q.isEmpty()) {
            Triplet curr = q.poll();
            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            // If we exceed allowed stops, skip
            if (stops > k) continue;

            for (Map.Entry<Integer, Integer> adj : adjList.get(node)) {
                int next = adj.getKey();
                int edgeCost = adj.getValue();
                int newCost = cost + edgeCost;

                // Only consider if cheaper or same stop count allows a new path
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    q.offer(new Triplet(next, newCost, stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

}
