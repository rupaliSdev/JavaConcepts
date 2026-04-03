package DSA.LinkedList;

public class ReverseLL {
    public static void main(String[] args) {



    }
    //TC: O(n)  and SC:O(1)
    public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null,next=null;
        ListNode curr = head;

        while (curr!=null){
            next = curr.next;
            curr.next=prev;
            prev= curr;
            curr=next;
        }
        return prev;
    }


}
