package DSA.graph;

import java.util.*;

public class KahnsAlgo {

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
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> res=topoSort(n,adj);
        for (Integer i:res){
            System.out.println(i);
        }




    }

    public static List<Integer> topoSort(int V,List<List<Integer>> adj){

        List<Integer> res = new ArrayList<>();
        int[] ind = new int[V];
        Arrays.fill(ind,0);

        Queue<Integer> q = new LinkedList<>();

        for( List<Integer> list : adj ){
            for (Integer i :list){
                ind[i]++;
            }
        }

        for (int i =0;i<V;i++){
            if(ind[i]==0){
               q.offer(i);
           }
        }
        while (!q.isEmpty()){
            int i = q.poll();
            for (Integer j :adj.get(i)){
                ind[j]--;
                if(ind[j]==0){
                    q.offer(j);
                }
            }
            res.add(i);
        }


    return res ;
    }

}
