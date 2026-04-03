package DSA.LinkedList;

import static DSA.LinkedList.MiddleElement.middleElement;

public class ReorderLinkedlist {

    public static void main(String[] args) {


        ListNode root= new ListNode(20);
        root.next=new ListNode(30);

        root.next.next=new ListNode(40);
        root.next.next.next=new ListNode(50);
        root.next.next.next.next=new ListNode(60);
        root.next.next.next.next.next=new ListNode(70);

        System.out.println(middleElement(root).value);


    }

    public void reorderLL(ListNode head) {

        ListNode middle = middleElement(head);

        ListNode head2 = middle.next;
        middle.next = null;

        ListNode prev = null, next = null;
        while (head2 != null) {
            next = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = next;
        }

        ListNode curr2 = prev, curr1 = head;


        while (curr1 != null && curr2 != null) {

            ListNode temp1 = curr1.next;
            ListNode temp2 = curr2.next;

            curr1.next = curr2;
            curr2.next = temp1;

            curr1 = temp1;
            curr2 = temp2;
        }


    }


}
