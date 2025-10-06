package DSA.LinkedList;

public class basics {
	
	public static void main(String[] args) {
		
		
		lnode root= new lnode(20);
		root.next=new lnode(30);
				
		root.next.next=new lnode(40);
		root.next.next.next=new lnode(50);
		root.next.next.next.next=new lnode(60);
		root.next.next.next.next.next=new lnode(70);
		//print(root);
		/////////////////////
		lnode r1= new lnode(40);
		lnode temp =r1;
		for(int i=1;i<=5;i++) {
			temp.next= new lnode(temp.val+10);
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

	private static lnode reverse(lnode r1) {
		// TODO Auto-generated method stub
		
		lnode prev=null;
		lnode next=null;
		lnode curr= r1;
		while(curr!=null) {
			 next=curr.next;
			 curr.next=prev;
			 prev=curr;
			 curr=next;
		}
		return prev;
	}

	
	private static lnode deleteKthPosition(lnode r1, int k) {
		// TODO Auto-generated method stub
		lnode curr=r1;
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

	private static lnode deleteKthPositionfromTheLast(lnode r1, int k) {
		// TODO Auto-generated method stub
		lnode slow=r1,fast = r1;
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



	private static lnode insertKthPosition(lnode r1, int k, int x) {
		// TODO Auto-generated method stub
		lnode curr=r1;
		if(k<0) {
			return r1;
		}
		if(k==0) {
			lnode temp= new lnode(x);
			temp.next= curr;
			curr=temp;
			return curr;
		}
		for(int i=0;i<k-1 && curr!=null ;i++) {
			
			curr=curr.next;
		}
		
		if(curr!=null)
		{
			
			lnode temp= new lnode(x);
			temp.next= curr.next;
			curr.next=temp;
			
		}
		
		
		return r1;
		
	}

	private static int kthposition(lnode r1,int k) {
		// TODO Auto-generated method stub
		lnode curr=r1;
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
		
		return curr.val;
	}

	private static void print(lnode root) {
		// TODO Auto-generated method stub
		lnode curr=root;
		while(curr!=null) {
			System.out.println(curr.val);
			curr=curr.next;
		}
	}
	
	
	
	 

}
class lnode{
	lnode next;
	int val;
	lnode(int x){
		val=x;
		next =null;
	}
}
