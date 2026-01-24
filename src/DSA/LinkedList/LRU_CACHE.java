package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU_CACHE {

	Map<Integer,Node> map = new HashMap<>();
	int capacity;
	Node head = new Node(0,0);
	Node tail = new Node(0,0);

	public LRU_CACHE(int capacity) {

		this.capacity = capacity;
		head.next = tail;
		tail.prev= head;
	}

	public int get(int key) {

		if(map.containsKey(key)){
			Node node=map.get(key);
			remove(node);
			insert(node);
			return node.val;
		}

		return -1;

	}

	public void put(int key, int value) {

		if(map.containsKey(key)){
			remove(map.get(key));
		}
		if(map.size()==capacity){
			remove(tail.prev);
		}
		insert(new Node(key,value));
	}


	public void insert(Node node){

		map.put(node.key,node);

		node.next = head.next;
		node.next.prev= node;
		head.next = node;
		node.prev = head;


	}



	public void remove(Node node){
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	class Node{
		int val,key;
		Node next;
		Node prev;

		Node(int key,int val){
			this.val = val;
			this.key = key;

		}
	}


}
