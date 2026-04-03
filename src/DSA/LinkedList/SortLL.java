package DSA.LinkedList;

public class SortLL {
    public static void main(String[] args) {

    }

    public static ListNode mergeLL(ListNode h1, ListNode h2){
        ListNode h3 = new ListNode(-1);
        ListNode curr = h3;
        ListNode curr1 =h1,curr2=h2;

        while (curr1!=null && curr2!=null){
            if(curr1.value<=curr2.value){
                curr.next= curr1;
                curr1= curr1.next;
                curr= curr.next;
            }
            else{
                curr.next= curr2;
                curr2= curr2.next;
                curr= curr.next;
            }
        }
        while (curr1!=null){

                curr.next= curr1;
                curr1= curr1.next;
                curr= curr.next;

        }
        while (curr2!=null){

            curr.next= curr1;
            curr2= curr2.next;
            curr= curr.next;

        }
        return h3.next;
    }
}
