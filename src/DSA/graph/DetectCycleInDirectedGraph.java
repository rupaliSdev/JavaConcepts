package DSA.graph;

import java.util.*;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(2);


        boolean ans = isCyclicDFS(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public boolean isCyclicBFS(int V,List<List<Integer>> adjList){


        int[] inDegree = new int[V];
        int[] vis = new int[V];

        for(List<Integer> adj : adjList){
            for(Integer j: adj){
                inDegree[j]++;

            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(Integer j: inDegree){
            if (inDegree[j]==0){
                priorityQueue.offer(j);
            }
        }

        int count =0;
        while(!priorityQueue.isEmpty()){
            int x= priorityQueue.poll();
            count++;
            for(Integer i : adjList.get(x)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    priorityQueue.offer(i);
                }
            }
        }
           if(count==V) {
               return false;
           }
            return true;
    }

    public static boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adjList){

        int[] pathVis = new int[V];
        int[] vis = new int[V];

        for (int i =0;i<V;i++){
            if (vis[i]==0){
                if(dfs(i,pathVis,vis,adjList)){
                    return true;
                }

            }
        }

    return false;
    }

    private static boolean dfs(int i, int[] pathVis, int[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[i]=1;
        pathVis[i]=1;
        for (Integer j:adjList.get(i)){
            if(vis[j]==0){
                if(dfs(j,pathVis,vis,adjList)){
                    return true;
                }
            } else if (pathVis[j]==1) {
                return true;
            }
        }
        pathVis[i]=0;
        return false;
    }
}
