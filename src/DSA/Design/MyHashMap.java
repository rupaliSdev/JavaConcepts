package DSA.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    class Node{
        int key;
        int value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    int size = 1000;
    List<Node>[] buckets;
    public MyHashMap() {
        buckets= new LinkedList[size];
        for (int i =0;i<size;i++)
            buckets[i]= new LinkedList<>();
    }

    int hash(int key){
        return key%size;
    }
    //o(1)
    public void put(int key, int value) {
        int index = hash(key);
        for(Node node: buckets[index]){
            if(node.key==key){
                node.value=value;
                return;
            }
        }
        buckets[index].add(new Node(key,value));

    }
    //o(1)
    public int get(int key) {
        int index= hash(key);
        for(Node node: buckets[index]){
            if(node.key==key){
                return node.value;
            }
        }
        return -1;
    }
    //o(1)
    public void remove(int key) {
        int index = hash(key);

        buckets[index].removeIf(n -> n.key == key);
    }
}