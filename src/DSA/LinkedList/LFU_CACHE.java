package DSA.LinkedList;


import java.util.HashMap;

public class LFU_CACHE {


    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;
    int capacity = 0;
    int minFreq;

    public LFU_CACHE(int capacity) {
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            updateFrequency(key);
            return node.val;
        }
        return -1;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        freqMap.computeIfAbsent(node.freq, k-> new DLL()).addFirst(node);
    }

    private void updateFrequency(int key) {
        Node node = map.get(key);
        int oldFreq = node.freq;
        DLL dll = freqMap.get(oldFreq);
        dll.remove(node);
        if (dll.head.next == dll.tail && oldFreq == minFreq) {
            minFreq += 1;
        }
        node.freq += 1;
        freqMap.computeIfAbsent(node.freq, k-> new DLL()).addFirst(node);

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateFrequency(key);
            return;
        }
        if (map.size() == capacity) {
            DLL minFreqDLL = freqMap.get(minFreq);
            Node node= minFreqDLL.tail.prev;
            minFreqDLL.remove(node);
            map.remove(node.key);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        minFreq=1;

    }

    class DLL {
        Node head= new Node(0,0);
        Node tail= new Node(0,0);

        public DLL() {
            head.next = tail;
            tail.prev = head;
        }
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addFirst(Node node) {
            node.next= head.next;
            node.next.prev= node;
            node.prev= head;
            head.next= node;
        }
    }
}