package DSA.LinkedList;

public class basics {
	
	public static void main(String[] args) {
		
		
		ListNode root= new ListNode(20);
		root.next=new ListNode(30);
				
		root.next.next=new ListNode(40);
		root.next.next.next=new ListNode(50);
		root.next.next.next.next=new ListNode(60);
		root.next.next.next.next.next=new ListNode(70);
		//print(root);
		/////////////////////
		ListNode r1= new ListNode(40);
		ListNode temp =r1;
		for(int i=1;i<=5;i++) {
			temp.next= new ListNode(temp.value+10);
			temp=temp.next;

		}
		temp.next=null;
		print(r1);
		System.out.println(kthposition(r1,3) +"hey");
		r1=insertKthPosition(r1,0,20);
		r1=deleteKthPosition(r1,0);
		print(r1);
		r1=reverse(r1);
		print(r1);
		
	}

	private static ListNode reverse(ListNode r1) {
		// TODO Auto-generated method stub
		
		ListNode prev=null;
		ListNode next=null;
		ListNode curr= r1;
		while(curr!=null) {
			 next=curr.next;
			 curr.next=prev;
			 prev=curr;
			 curr=next;
		}
		return prev;
	}

	
	private static ListNode deleteKthPosition(ListNode r1, int k) {
		// TODO Auto-generated method stub
		ListNode curr=r1;
		if(k<0) {
			return r1;
		}
		if(k==0) {
			
			return r1.next;
		}
		for(int i=0;i<k-1 && curr!=null ;i++) {
			
			curr=curr.next;
		}
		
		if(curr!=null && curr.next!=null)
		{
			
			
			curr.next=curr.next.next;
			
		}
		return r1;
		
	}

	private static ListNode deleteKthPositionfromTheLast(ListNode r1, int k) {
		// TODO Auto-generated method stub
		ListNode slow=r1,fast = r1;
		if(k<0) {
			return r1;
		}

		for(int i=1;i<k && fast!=null ;i++) {
             fast=fast.next;
		}

		if(fast==null)
		{
            return r1.next;
		}
		while (fast!=null){
			fast=fast.next;
			slow= slow.next;
		}

		slow.next = slow.next.next;

		return  r1;

	}



	private static ListNode insertKthPosition(ListNode r1, int k, int x) {
		// TODO Auto-generated method stub
		ListNode curr=r1;
		if(k<0) {
			return r1;
		}
		if(k==0) {
			ListNode temp= new ListNode(x);
			temp.next= curr;
			curr=temp;
			return curr;
		}
		for(int i=0;i<k-1 && curr!=null ;i++) {
			
			curr=curr.next;
		}
		
		if(curr!=null)
		{
			
			ListNode temp= new ListNode(x);
			temp.next= curr.next;
			curr.next=temp;
			
		}
		
		
		return r1;
		
	}

	private static int kthposition(ListNode r1,int k) {
		// TODO Auto-generated method stub
		ListNode curr=r1;
		if(k<0) {
			return -1;
		}
		for(int i=0;i<k ;i++) {
			if(curr==null)
			{
				return -1;
			}
			curr=curr.next;
		}
		
		return curr.value;
	}

	public static boolean isPalindrome(ListNode head){
//		Find middle
//
//		Reverse second half
//
//				Compare
		return false;

	}



		public ListNode getIntersectionNode(ListNode a, ListNode b) {

			ListNode p1 = a;
			ListNode p2 = b;

			while(p1 != p2){

				p1 = (p1 == null) ? b : p1.next;
				p2 = (p2 == null) ? a : p2.next;
			}

			return p1;
		}

	private static void print(ListNode root) {
		// TODO Auto-generated method stub
		ListNode curr=root;
		while(curr!=null) {
			System.out.println(curr.value);
			curr=curr.next;
		}
	}



}
