package Basics.InterviewQues.map;

public class MyHashMap<K,V> {

    // Default settings
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // For treeification (just thresholds, no full tree code)
    private static final int TREEIFY_THRESHOLD = 8;
    private static final int MIN_TREEIFY_CAPACITY = 64;

    // Table – array of buckets
    private Node<K,V>[] table;

    private int size = 0;
    private int threshold;

    // Node structure for LinkedList bucket

    static class Node<K,V>{

        final int key;
        final int hash;
        V value;
        Node<K,V> next;

        public Node(int key, int hash, V value, Node<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }

    }

    public MyHashMap() {
        this.table =new Node[DEFAULT_CAPACITY];
        this.threshold = (int) (DEFAULT_CAPACITY* DEFAULT_LOAD_FACTOR);
    }

    private int hash(Object key){
        int h =key.hashCode();
        return (h ^ h>>>16);
    }

    private int findIndex(int hash,int length){
        return hash & length-1;
    }

   public void put(K key,V value){
        int hash = hash(key);
        //resize if needed
        if(size+1>threshold){
            resize();
        }
        int index= findIndex(hash,table.length);
   }

    private void resize() {

    }


}
