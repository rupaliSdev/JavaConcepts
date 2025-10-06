package DSA.LinkedList;

public class DetectACycle {
    public static void main(String[] args) {

    }

    public static Node findTheLoopNode(Node head){
        Node slow=head,fast = head;
        Node intersect= head;

        while (fast.next!=null && fast.next.next!=null)
        {
            if(slow==fast){
                intersect= slow;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        Node h = head,s= intersect;
        while (s!=h){
            s=s.next;
            h=h.next;
        }

        return s;
    }
}
