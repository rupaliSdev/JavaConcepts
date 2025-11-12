package DSA.BST;

public class LargestBST {


    public int largestBSTSubtree(TreeNode root) {
        int best = 0;
        Info info=findLargestBST(root);
        return info.size;
    }
    public static Info findLargestBST(TreeNode node) {

        if (node == null) return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        int best = 0;
        Info L = findLargestBST(node.left);
        Info R = findLargestBST(node.right);

        if (L.isBST && R.isBST && node.val > L.max && node.val < R.min) {
            int size = 1 + L.size + R.size;
            best=Math.max(best,size);
            return new Info(true, Math.min(L.min,node.val), Math.max(R.max,node.val), size);
        }
        return new Info(false, 0, 0, Math.max(L.size,R.size));
    }


}

class Info {
    boolean isBST;
    int min;
    int max;
    int size;

    public Info(boolean isBST, int min, int max, int size) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.size = size;
    }
}