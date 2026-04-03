package DSA.LinkedList;

public class DetectACycle {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // create cycle
        n5.next = n3;

        System.out.println(isCyclePresent(n1));
    }

    private static boolean isCyclePresent(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while ( fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true;

        }
        return false;
    }

    public static ListNode findTheLoopNode(ListNode head){
        ListNode slow=head,fast = head;
        ListNode intersect= head;

        while (fast.next!=null && fast.next.next!=null)
        {
            if(slow==fast){
                intersect= slow;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode h = head,s= intersect;
        while (s!=h){
            s=s.next;
            h=h.next;
        }

        return s;
    }
}
