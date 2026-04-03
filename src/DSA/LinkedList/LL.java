package DSA.LinkedList;

public class LL {
    //object variable of LL
    private Node head;
    private Node tail;
    private int size = 0;

    LL() {
        this.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int x) {
            val = x;
            next = null;
        }

        public Node(int x, Node node) {
            next = node;
            val = x;

        }
    }

    public void insertFst(int x) {
        Node node = new Node(x);

        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;

        }
        size += 1;
    }

    public void inserlast(int x) {
        if (tail == null) {
            insertFst(x);
            return;
        }
        Node node = new Node(x);
        tail.next = node;
        tail = node;

        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFst(val);
        }
        if (index == size) {
            inserlast(val);
        }
        Node temp = head;
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        Node x = new Node(val, temp.next);
        temp.next = x;
        size++;
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public int deleteFirst(Node head) {
        if (head == null) {
            return -1;

        }
        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public int deleteLast(Node head) {
        if (tail == null) {
            return -1;

        }
        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public Node reverse(Node head) {
        Node prev = null, next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        LL first = new LL();
        first.insertFst(20);
        first.inserlast(30);
        first.inserlast(40);
        first.inserlast(50);
        first.inserlast(60);
        first.inserlast(70);
        System.out.println(first.size);
        first.insert(90, 3);
        first.display(first.head);
        first.head = first.reverse(first.head);
        first.display(first.head);
    }

}
