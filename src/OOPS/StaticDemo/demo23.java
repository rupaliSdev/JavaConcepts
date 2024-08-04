package OOPS.StaticDemo;


/*Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
         
Example 1:Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:
Input: head = []
Output: []
Example 3:
Input: head = [1]
Output: [1]*/
public class demo23 {
    public static void main(String[] args) {

/*
        int[] nums={1,1,2,2,3,3,4,4,5,5};
        int x=removeduplicates(nums);
        for (int i=0;i<nums.length;i++ ){
            System.out.println(nums[i]);
        }
//        System.out.println(x);

*/
        Node x= new Node(1,null);

        Node y= new Node(2,null);

        x.next=y;

        Node z= new Node(3,null);

        y.next=z;

        Node t= new Node(4,null);

        z.next=t;



        Node head =swapNodes(x);
        while (head!=null){
            System.out.println(head.data);
            head=head.next;
        }

    }

    private static Node swapNodes(Node x) {
        Node curr=x; //1
        Node prev=new Node(0,null);
        Node head=prev;

        while (curr.next != null) {

            Node temp=curr.next;//2
            curr.next=temp.next;//3
            temp.next=curr;
            prev.next=temp;
            prev=curr;
            if(curr.next!=null){
                curr=curr.next;
            }

        }
        return head.next;
    }

    public static int removeduplicates(int[] nums){


        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
              j++;
              nums[j]=nums[i];
            }
        }
        return j+1;

    }
}

class  Node{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
