package DSA.graph;

import java.util.ArrayList;
import java.util.List;

//https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
public class AlienDictionary {
    public static void main(String[] args) {

        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String res = findOrder(N,K,dict);
        System.out.println(res);

    }

    private static String findOrder(int n, int k, String[] dict) {
        List<List<Integer>> adjList= new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i =0;i<n-1;i++){
            String dic1= dict[i],dict2=dict[i+1];
            int j =0,len= Math.min(dic1.length(),dict2.length());
            while (j<len){
                if(dic1.charAt(j)!=dict2.charAt(j)){
                    adjList.get(dic1.charAt(j)-'a').add(dict2.charAt(j)-'a');
                    break;
                }
                j++;
            }
        }
        List<Integer> orderedList= TopoSort.topoWithKahnsApproach(k,adjList);
        String ans="";
        for(Integer i :orderedList){
            ans=ans+(char)(i+(int)'a');
        }
        return ans;
    }

//    Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary, ‘len’ is the length up to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.
//
//    Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure used in BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.
//
}
