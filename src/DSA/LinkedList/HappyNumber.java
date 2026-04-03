package DSA.LinkedList;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 89;
        System.out.println(isHappy(n));
	}
   static boolean isHappy(int n) {
	    int slow = n;
	    int fast = n;
	    do {
	    	slow= square(slow);
	    	fast= square(square(fast));
	    }while(slow!=fast);
	    
	   if(slow==1) {
		   return true;
	   }
	return false;
	   
   }
   static int square(int n) {
	   if(n==0) {
		   	return 0;
	   }
	   int r = n%10;
	   return (int) (Math.pow(r, 2)+square((int)n/10))  ;
	   }


	   //https://leetcode.com/problems/add-two-numbers/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int digit1 = (l1 != null) ? l1.value : 0;
			int digit2 = (l2 != null) ? l2.value : 0;

			int sum = digit1 + digit2 + carry;
			int digit = sum % 10;
			carry = sum / 10;

			ListNode newNode = new ListNode(digit);
			tail.next = newNode;
			tail = tail.next;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		ListNode result = dummyHead.next;
		dummyHead.next = null;
		return result;
	}
}
