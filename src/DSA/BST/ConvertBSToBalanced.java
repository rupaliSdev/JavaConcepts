package DSA.BST;

import java.util.ArrayList;

public class ConvertBSToBalanced {

//    Given a BST (Binary Search Tree) that may be unbalanced, the task is to
//    convert it into a balanced BST that has the minimum possible height.
//
    public static void main(String[] args) {

    }

    static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();

        // Store the nodes in sorted order
        storeInorder(root, nodes);

        // Build the balanced tree from the sorted nodes
        return buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    private static TreeNode buildBalancedTree(ArrayList<Integer> nodes, int l, int r) {

        if(l>r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBalancedTree( nodes, l, mid - 1);
        node.right = buildBalancedTree( nodes, mid + 1, r);
        return node;
    }

    private static void storeInorder(TreeNode root, ArrayList<Integer> nodes) {

        if(root==null){
            return;
        }
        storeInorder(root.left,nodes);
        nodes.add(root.val);
        storeInorder(root.right,nodes);
    }


}
