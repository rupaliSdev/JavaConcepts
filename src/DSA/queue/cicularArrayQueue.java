package DSA.queue;

public class cicularArrayQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue x= new queue(5);
		x.offer(20);
		x.offer(30);
		x.offer(40);
		x.offer(50);
		x.offer(60);
//		x.offer(70);
		x.remove();
		System.out.println(x.size);
		x.offer(46);
		x.print();

	}

}



class queue{
	int size;
	int capacity;
	int[] arr;
	int front =-1;
	int rear = -1;
	
	queue(int x){
		 capacity = x;
         arr= new int[x];
         
	}
	public void offer(int x) {
		rear++;
		if(size==capacity) {
			System.out.println("index out of bound");
			return;
		}
		
		arr[rear%capacity]= x;
		size++;
	}
	public int remove() {
		front++;
		
		size--;
		return size;
	}
	public void print() {
		for(int i=front+1 ;i<=size;i++) {
			System.out.println(arr[i%capacity]);
		}
	}

	
}
