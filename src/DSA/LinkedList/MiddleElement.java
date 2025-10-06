package DSA.LinkedList;

public class MiddleElement {

    static Node middleElement(Node head){
        Node slow = head,fast= head;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;

    }





}
