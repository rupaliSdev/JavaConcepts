package DSA.Tree;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(30);
        root.right= new TreeNode(10);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(70);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(60);
        root.right.left.left= new TreeNode(15);
        System.out.println(height(root));
        System.out.println(NoOfNodes(root));
        System.out.println(findNode(root,60));
	}
	
	public TreeNode invertTree(TreeNode A) {
        if(A==null){
            return A;
        }
        A.left =invertTree(A.left);
        A.right =invertTree(A.right);
        TreeNode node = A.left;
        A.left = A.right;
        A.right = node;
        return A;
    }

	public static int height(TreeNode A) {
		if(A==null) {
			return 0;
		}
		return 1+Math.max(height(A.left), height(A.right));
	}
	public static int NoOfNodes(TreeNode A) {
		if(A==null) {
			return 0;
		}
		return 1+(NoOfNodes(A.left)+NoOfNodes(A.right));
	}

	public static boolean findNode(TreeNode A,int x) {
		if (A==null){
			return false;
		}
		
		if (A.val==x){
			return true;
		}
//		if(findNode(A.left,x)==true) {
//			return true;
//		}
//		if(findNode(A.right,x)==true) {
//			return true;
//		}
		return findNode(A.left,x)||findNode(A.right,x);
		
	}
	public static boolean checkNode(TreeNode A,int x) {
		if (A==null){
			return true;
		}
		
		if (A.val==x){
			return false;
		}
		
		return findNode(A.left,x)||findNode(A.right,x);
		
	}
	
}

