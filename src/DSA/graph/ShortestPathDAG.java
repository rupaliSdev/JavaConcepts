package DSA.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDAG {
    public static void main(String[] args) {

        int n = 6, m = 7;
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ArrayList <ArrayList< Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            ArrayList < Pair > temp = new ArrayList < Pair > ();
            adj.add(temp);
        }
        //We create a graph first in the form of an adjacency list.

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int res[] = dfsApproach(n ,adj);

        for (int i = 0;i<n;i++){
            System.out.println(res[i]);

        }

    }


    public static int[] dfsApproach(int n, ArrayList<ArrayList<Pair>> adj){
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++ ){
            if(vis[i]==0){
                dfs(adj,st,vis,i);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[0]=0;
        while (!st.isEmpty()){
            int node = st.peek();
            st.pop();

            for(Pair j :adj.get(node)){
                if(dist[node] + j.second <dist[j.first]){
                    dist[j.first]= dist[node] + j.second;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return  dist;

    }

    private static void dfs(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int[] vis,int node) {
        vis[node]=1;
        for(Pair i:adj.get(node)){
            if(vis[i.first]==0){
                dfs(adj,st,vis,i.first);
            }

        }
        st.push(node);
    }

    static class Pair {
        int first, second;
        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }



}
