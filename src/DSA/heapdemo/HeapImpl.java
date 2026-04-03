package DSA.heapdemo;

import java.util.ArrayList;

public class HeapImpl {

	public static void main(String[] args) {
		
		ArrayList<Integer> heap = new ArrayList<Integer>();
		insert(heap,5);
		insert(heap,3);
		insert(heap,4);
		insert(heap,7);
		insert(heap,8);
		
		
		System.out.println(heap.toString());
		
		
		
		

	}
    public static ArrayList<Integer> swap(ArrayList<Integer> arr,int i,int j) {
		
		int temp= arr.get(i);
		arr.set(i,arr.get(j));
		
		arr.set(j, temp);
		

		return arr;
		
	}
    public int leftChild(int i) {
    	return 2*i+1;
    	
    }
    public int rightChild(int i) {
    	return 2*i+2;
    	
    }
	
	public ArrayList<Integer> deleteroot(ArrayList<Integer> arr) {
		
		int temp= arr.get(0);
		arr.set(0,arr.get(arr.size()-1));
		
		arr.set(arr.size()-1, temp);
		
//		arr=rise(arr);
		arr.remove(arr.size()-1);
		return arr;
		
	}
	
     public static ArrayList<Integer> insert(ArrayList<Integer> heap,int x) {
		
		heap.add(x);
		rise(heap,heap.size()-1);
		return heap;
		
	}

	public ArrayList<Integer> sink(ArrayList<Integer> arr,int parent) {
		
		int n= arr.size();
		while(true) {
			int child=leftChild(parent);
			if(child>=arr.size()) {
				break;
			}
			if(rightChild(parent)<n && arr.get(rightChild(parent))<arr.get(child) ) {
				child =rightChild(parent);
			}
			if(arr.get(child)<arr.get(parent)) {
				swap(arr,child, parent);
				parent=child;
			}
			else {
				break;
			}
		}
		return arr;
	}
	
	public static ArrayList<Integer> rise(ArrayList<Integer> heap,int node){
		while(true) {
			
			if(parent(node)>=0 && heap.get(node)<heap.get(parent(node))) {
				
				swap(heap,node,parent(node));
				node =parent(node);
			}
			else {
				break;
			}
			
		}
		
		return heap;
		
		
	}
	private static int parent(int node) {
		// TODO Auto-generated method stub
		return (node-1)/2;
	}
	
	

}
