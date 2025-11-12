package DSA.LinkedList;

import java.util.*;

public class LRU_CACHE {
	
	Node head= new Node(0,0);
	Node tail = new Node(0,0);
	
	int capacity;
	Map<Integer,Node> map= new HashMap<>();
	public LRU_CACHE(int capacity) {
		
		
		this.capacity = capacity;
		head.next=tail;
		tail.prev=head;
	}
	public void put(int key, int val) {
		// TODO Auto-generated method stub
		if(map.containsKey(key)) {
			remove(map.get(key));
		}
		if(map.size()==capacity) {
			remove(tail.prev);
		}
		insert(new Node(key,val));
	}
	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		node.next.prev= node;
		node.prev=head;
		head.next=node;
		
	}
	private void remove(Node node) {
		// TODO Auto-generated method stub
		map.remove(node.key);
		node.next.prev= node.prev;
		node.prev.next = node.next;
	}
	public int get(int key) {
		
		if(map.containsKey(key)) {
			remove(map.get(key));
			
			
			insert(map.get(key));
		}
		
		
		return key;
		
	}
	static
	class Node{

		Node next;
		Node prev;
		int key,value;
		Node(int key,int value){
			this.key=key;
			this.value=value;
		}
	}
	

}

