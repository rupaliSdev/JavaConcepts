package DSA.LinkedList;

public class RemoveNthNode {
    public static void main(String[] args) {

    }


    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {


             ListNode dummy = new ListNode(0);
             dummy.next=head;
             int i = 0;
             ListNode fast=dummy,slow=dummy;
            //maintain gap of n nodes
             while (i<=n){
                 fast=fast.next;
             }

             while (fast!=null){
                 fast=fast.next;
                 slow=slow.next;
             }


             //gap will be always be n
             slow.next=slow.next.next;
             return dummy.next;


        }
    }
}
