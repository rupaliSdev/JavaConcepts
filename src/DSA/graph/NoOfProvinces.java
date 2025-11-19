package DSA.graph;

import java.util.ArrayList;
import java.util.List;

//https://takeuforward.org/data-structure/number-of-provinces/
public class NoOfProvinces {
    public static void main(String[] args) {

        int[][] adj = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        // Number of vertices
        int V = 3;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        System.out.println(numProvinces(adjList,V));



    }
    public static int numProvinces(List<List<Integer>> adj, int V){
        boolean[] vis = new boolean[V];
        int count =0;

        for(int i =0;i<V;i++){
            if(!vis[i]){
                count++;
                dfsP(i,adj,vis);
            }
        }
     return count;
    }

    private static void dfsP(int i, List<List<Integer>> adj, boolean[] vis) {
        vis[i]=true;
        for(Integer adjs:adj.get(i)){
            if(!vis[adjs]){
                dfsP(adjs,adj,vis);
            }
        }
    }
}
