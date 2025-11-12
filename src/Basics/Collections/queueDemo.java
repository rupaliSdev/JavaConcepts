package Basics.Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //min priority queue,used to solve problems of min heap
		Queue<String> queue = new PriorityQueue<>();

        Queue<Integer> queue1= new PriorityQueue<>((a,b)->b-a);
		Queue<String> q = new LinkedList<>();
		Queue<Integer> pbq = new LinkedList<>();
		pbq.add(10);
        pbq.add(20);
        pbq.add(15);
        
		queue.add("India");
		queue.add("Germany");
		queue.add("America");
		/////////
		q.offer("hello");
		q.offer("bye");
		q.offer("hi");
        System.out.println(q);
       
        //Collections.sort(q);
        Iterator it = q.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        //queue.remove();
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        String x = queue.poll();
        System.out.println(x);
      //Removing the first item from the queue.
        //If the queue is empty a java.util.NoSuchElementException will be thrown.
        
        System.out.println("remove: " + queue.remove());

        //Checking what item is first in line without removing it
        //If the queue is empty a java.util.NoSuchElementException will be thrown.
        System.out.println("element: " + queue.element());
        
        //Removing the first item from the queue.
        //If the queue is empty the method just returns false.
        System.out.println("poll: " + queue.poll());

        //Checking what item is first in line without removing it
        //If the queue is empty a null value will be returned.
        System.out.println("peek: " + queue.peek());
        
        
	}

}
