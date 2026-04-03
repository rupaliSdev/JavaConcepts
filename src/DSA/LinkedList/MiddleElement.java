package DSA.LinkedList;

public class MiddleElement {

    //O(n)
    public static ListNode middleElement(ListNode head){
        ListNode slow = head,fast= head;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;

    }





}
