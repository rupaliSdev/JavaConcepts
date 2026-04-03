package DSA.graph.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindifPathExistsinGraph {
    public static void main(String[] args){
        System.out.print("hello");
    }
    public boolean findValidPath(int n ,int[][] edges,int s,int d){

        List<List<Integer>> adjList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        queue.offer(s);
        vis[s]=1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node==d){
                return true;
            }
            for(int adj: adjList.get(node)){
                if(vis[adj]==0){
                    vis[adj]=1;
                    queue.offer(adj);
                }

            }
        }

        return false;
    }
}

