package DSA.LinkedList;

public class SortLL {
    public static void main(String[] args) {

    }

    public static Node mergeLL(Node h1,Node h2){
        Node h3 = new Node(-1);
        Node curr = h3;
        Node curr1 =h1,curr2=h2;

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
