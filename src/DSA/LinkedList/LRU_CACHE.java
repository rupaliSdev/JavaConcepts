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


	public static class demo {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			LRU_CACHE cache = new LRU_CACHE(2);

			cache.put(1, 1);   // cache = {1=1}
			cache.put(2, 2);   // cache = {2=2, 1=1}

			System.out.println(cache.get(1)); // returns 1  → cache = {1=1, 2=2}

			cache.put(3, 3);   // evicts key 2 → cache = {3=3, 1=1}

			System.out.println(cache.get(2)); // returns -1 (not found)

			cache.put(4, 4);   // evicts key 3 → cache = {4=4, 1=1}

			System.out.println(cache.get(1)); // returns 1
			System.out.println(cache.get(3)); // returns -1 (not found)
			System.out.println(cache.get(4)); // returns 4
		}

	}
}
