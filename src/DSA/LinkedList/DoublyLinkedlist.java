package DSA.LinkedList;

public class DoublyLinkedlist {

	public static void main(String[] args) {
		
		
		Nodes x = new Nodes(20);
		
		Nodes y = new Nodes(20);
		y.prev =x;
		x.next =y;

	}
	public Nodes insert(int x, Nodes head) {
		Nodes y= new Nodes(x);
		head.next =y;
		y.prev=head;
		head = head.next;
		return head;
	}
	public void display(Nodes head) {
		if(head!=null) {
			System.out.println(head.data);
			head =head.next;
		}
//		if(head!=null) {
//			System.out.println(head.data);
//			head =head.prev;
//		}
	}
	
	//check if it is palindrome or not
	public void palindrome(Nodes head) {
		Nodes tail=head,curr = head;
		if(tail!=null) {
			
			tail =tail.next;
		}
		while(curr!=tail && tail.next!=curr){
			System.out.println(head.data);
			head =head.prev;
		}
	}

	static class Nodes{
		int data;
		Nodes next;
		Nodes prev;
		Nodes(int d){
			data = d;
			next = null;
			prev= null;
		}
	}
}
