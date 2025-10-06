package DSA.graph;

import java.util.*;

public class ClonedGraphQues {

    HashMap<Integer,Node> visited = new HashMap<>();

    public static void main(String[] args) {


    }



    public Node clonedGraphDFS(Node node){

        if(node!=null)
        {
        if(!visited.containsKey(node)){
            Node node1 = new Node(node.val,new ArrayList<>());
            visited.put(node.val,node1);
            for(Node n :node.neighbours){
                node1.neighbours.add(clonedGraphDFS(n));
            }
        }
       return visited.get(node.val);}
        return null;

    }

    public Node clonedGraphBFS(Node node){


        Queue<Node> nodes= new PriorityQueue<>();
        if(node!=null)
        {

            Node node1 = new Node(node.val,new ArrayList<>());
            nodes.offer(node);
            visited.put(node.val,node1);

            while(!nodes.isEmpty()){
                Node p =nodes.peek();
                for(Node node2: p.neighbours){

                    if(!visited.containsKey(node2.val)){
                        Node node3 = new Node(node2.val,new ArrayList<>());
                        visited.put(node3.val,node3);
                        nodes.offer(node2);

                    }
                    p.neighbours.add(visited.get(node2.val));
                }


            }

            return visited.get(node.val);}
        return null;

    }



    class Node{
        int val;

        List<Node> neighbours;

        public Node(int val, List<Node> neighbours) {
            this.val = val;
            this.neighbours = neighbours;
        }
    }

}
