package Basics.Collections.map;

import java.util.LinkedList;

public class HashMapImpl {
    static class HashMap<K,V> {
        private class Node{
            K key ;
            V value;
            public Node(K key ,V value){
                this.key =key;
                this.value= value;
            }
        }
        private int n;//no of nodes
        private int N;//size of bucket
        private LinkedList<Node> buckets[];

        {
            buckets = new LinkedList[20];
        }

        @SuppressWarnings("Unchecked")

        public HashMap() {
            this.N =4;
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
    }
    public static void main(String[] args){

    }
}
