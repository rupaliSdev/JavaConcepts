package DSA.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopoSort {

//    u->v u should always come before v

    public static void main(String[] args) {

       List<List<Integer>> adj=new ArrayList<>();
        int n=6;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> res=topoSort(n,adj);
       // Collections.reverse(res);
        for (Integer i:res){
            System.out.println(i);
        }




    }

    public static List<Integer> topoSort(int V, List<List<Integer>> adjList){
        int[] vis = new int[V];
        List<Integer> res= new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        for(int i =0;i<V;i++){
            if(vis[i]==0){
                dfs(i,stack,vis,adjList);
            }
        }

      while (!stack.isEmpty()){
          res.add(stack.pop());
      }
      return res;
    }

    public static void dfs(int i ,Stack<Integer> stack , int[] vis , List<List<Integer>> adjList){

      vis[i]=1;
      for(Integer j: adjList.get(i)){
          if (vis[j]==0){
              dfs(j,stack,vis,adjList);
          }

      }
      stack.push(i);

    }
}
