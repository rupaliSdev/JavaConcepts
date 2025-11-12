package DSA.graph;

import java.util.*;

class Edge {
    int to, weight;
    Edge(int t, int w) { to = t; weight = w; }
}
public class DijkstraNegativeDemo {
    public static void main(String[] args) {
        int V = 3;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        // Edges: A=0, B=1, C=2
        graph.get(0).add(new Edge(1, 5));   // A -> B
        graph.get(0).add(new Edge(2, 6));   // A -> C
        graph.get(2).add(new Edge(1, -3));  // C -> B

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, 0}); // [dist, node]

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            for (Edge e : graph.get(u)) {
                if (dist[e.to] > dist[u] + e.weight) {
                    dist[e.to] = dist[u] + e.weight;
                    pq.offer(new int[] {dist[e.to], e.to});
                }
            }
        }
        System.out.println("Dist to B = " + dist[1]); // Incorrectly prints 5
    }
}
