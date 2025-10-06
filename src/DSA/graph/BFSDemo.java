package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;

public class BFSDemo {

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> adj= new ArrayList<>(10);

        for(int i=0 ;i<10;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj,1,2);
        addEdge(adj,1,6);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,3,2);
        addEdge(adj,4,2);
        addEdge(adj,4,5);
        addEdge(adj,5,4);
        addEdge(adj,5,8);
        addEdge(adj,6,1);
        addEdge(adj,6,7);
        addEdge(adj,6,9);
        addEdge(adj,7,6);
        addEdge(adj,7,8);
        addEdge(adj,8,5);
        addEdge(adj,8,7);
        addEdge(adj,9,6);

        printBFS(adj,1);

    }



    private static void printBFS(ArrayList<ArrayList<Integer>> adj,int start) {

        int[] visited= new int[adj.size()];

        for(int i=0 ;i< adj.size();i++){
            visited[i]=0;
        }

        Queue<Integer> q= new LinkedList<>();
        q.offer(start);
        visited[start]=1;
        while(!q.isEmpty()){
            int x= q.peek();


            for(Integer i:adj.get(x)){
                if(visited[i]==0){
                q.add(i);
                visited[i]=1;
                }
            }
            q.remove();
            System.out.print(x + " ");
        }




    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {


        adj.get(i).add(j);


    }

}
