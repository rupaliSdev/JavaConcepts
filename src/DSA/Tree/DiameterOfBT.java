package DSA.Tree;

public class DiameterOfBT {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);


        int maxDiameter =0;
        // Calculate the diameter of the binary tree
        int diameter = diameterOfBinaryTree(root,maxDiameter);
        System.out.println(diameter);
    }

    private static int diameterOfBinaryTree(TreeNode root, int maxDiameter) {

        if(root==null){
            return 0;
        }
        int lheight = diameterOfBinaryTree(root.left,maxDiameter);
        int rheight = diameterOfBinaryTree(root.right,maxDiameter);

        maxDiameter  = Math.max(lheight +rheight,maxDiameter);

        return 1+Math.max(lheight,rheight);


    }


}
