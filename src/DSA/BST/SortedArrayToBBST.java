package DSA.BST;

import OOPS.genericsDemo.EXample1.Data;

import java.util.LinkedList;
import java.util.Queue;

//
//Given a sorted array arr[]. Convert it into a Balanced Binary Search Tree (BST). Return the root of the BST.
//
//A Balanced Binary Search Tree (BST) is a type of binary tree in which the difference between the heights of the left and right subtrees of every node is at most one.
public class SortedArrayToBBST {
    public static void main(String[] args) {

     int[] arr = {1, 5, 9, 14, 23, 27};
     Node root = sortedArrayToBBST(arr,0,arr.length-1);
     Node root2 = sortedArrayToBBSTII(arr);

     print(root);
     print(root2);
    }

    private static Node sortedArrayToBBSTII(int[] arr) {

        Queue<Datas> queue = new LinkedList<>();
        int mid = (arr.length-1)/2;
        Node root = new Node(arr[mid]);
        queue.offer(new Datas(root,0,arr.length-1));

        while (!queue.isEmpty()){
            Datas current = queue.poll();
            int midIndex = current.start+ current.end;
            midIndex = midIndex/2;
            //leftNode
            if(current.start<midIndex){
                int leftMid = (current.start+midIndex-1)/2;
                Node leftNode = new Node(arr[leftMid]);
                current.node.left=leftNode;
                queue.offer(new Datas(leftNode,current.start,midIndex-1));
            }
            //rightNode
            if(current.end>midIndex){
                int rightMid = current.end+ midIndex+1;
                rightMid=rightMid/2;
                Node rightNode = new Node(arr[rightMid]);
                current.node.right=rightNode;
                queue.offer(new Datas(rightNode,midIndex+1,current.end));

            }


        }

        return root;

    }

    private static void print(Node root){
        if(root!=null){
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }

    }


    private static Node sortedArrayToBBST(int[] arr, int l, int r) {
        if(l>r){
            return null;
        }
        if(l==r){
            return new Node(arr[l]);
        }

        int mid = (l+r)/2;
        Node root = new Node(arr[mid]);
        root.left= sortedArrayToBBST(arr,l,mid-1);
        root.right=sortedArrayToBBST(arr,mid+1,r);
        return root;

    }


    static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }
    public static class Datas {
        Node node;
        int start,end;

        public Datas(Node node, int start, int end) {
            this.node = node;
            this.start = start;
            this.end = end;
        }
    }
}
