package DSA.graph;
import java.util.*;

public class basic_1 {

	public static void main(String[] args) {
		
		int v=5;
		
		ArrayList<ArrayList<Integer>>  adj = new ArrayList<>(v);
		
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<>());
		}
		addEdge(adj,0,1);
		System.out.println("hello");
		addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        print(adj);
		
		
		// TODO Auto-generated method stub

	}

	private static void print(ArrayList<ArrayList<Integer>> adj) {

		for(int i=0;i<adj.size();i++) {
			 System.out.println("\nAdjacency list of vertex   " +adj.get(i).size() +"->" );
			for(int j=0;j<adj.get(i).size();j++) {
				
				System.out.print(adj.get(i).get(j)+ ",");
			}
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
	
		
		adj.get(i).add(j);
		adj.get(j).add(i);
		
		
	}
	
	

}
