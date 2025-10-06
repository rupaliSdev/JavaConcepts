package DSA.graph;

import java.util.ArrayList;
//
//https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);


        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       int[] vis = new int[V];
       for(int i=0;i<V;i++){
           if(vis[i]==0){
              if(dfsApproach(i,-1,adj,vis)) return true;
           }
       }
       return false;
    }

    private static boolean dfsApproach(int node, int parent, ArrayList<ArrayList<Integer>> adj,int[] vis) {

        vis[node]=1;
        for (Integer i :adj.get(node)){

            if(vis[i]==0){
                if(dfsApproach(i,node,adj,vis)) return true;
            }
            else if(node!=parent){
                return true;
            }

        }
        return false;
    }
}
