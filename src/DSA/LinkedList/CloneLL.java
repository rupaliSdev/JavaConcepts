package DSA.LinkedList;

public class CloneLL {

   // Clone a linked list with next and random pointer

    public static void main(String[] args) {
       CloneNode head = new CloneNode(7);
        head.next = new CloneNode(14);
        head.next.next = new CloneNode(21);
        head.next.next.next = new CloneNode(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        CloneNode copy = cloneLinkedList(head);
        while (copy!=null){
            System.out.println(copy.val);
           // System.out.println(copy.random.val);
            copy=copy.next;
        }
        copy = cloneLinkedList(head);
        while (copy!=null){
           // System.out.println(copy.val);
            System.out.println(copy.random.val);
            copy=copy.next;
        }

    }
    public static CloneNode cloneLinkedList(CloneNode head){

        CloneNode curr= head;
        while (curr!=null){
            CloneNode copy= new CloneNode(curr.val);
            copy.next= curr.next;
            curr.next= copy;
            curr= copy.next;
        }
        curr= head;
        while (curr!=null){

           if(curr.random!=null){
               curr.next.random= curr.random.next;
           }
           curr=curr.next.next;
        }

        //extract
        curr= head;
        CloneNode res= new CloneNode(0),copyCur= res;

        while (curr!=null){
            copyCur.next= curr.next;

            copyCur= copyCur.next;

            curr= curr.next.next;

        }

     return res.next;
    }

    static class CloneNode{
        CloneNode random;
        CloneNode next;
        int val;

        public CloneNode(int val) {
            this.val = val;
            random=null;
            next=null;
        }
    }
}
