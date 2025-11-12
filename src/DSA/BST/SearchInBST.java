package DSA.BST;



public class SearchInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(60);
		//-----------------------------
		root.left = new TreeNode(40);
		root.left.left=new TreeNode(30);
		root.left.right = new TreeNode(50);
		//-------------------------------------
		root.right = new TreeNode(80);
		root.right.left=new TreeNode(70);
		root.right.right = new TreeNode(90);
		//------------------------------------------
		root.left.left.left = new TreeNode(25);
		root.left.left.right=new TreeNode(35);
		root.left.right.left = new TreeNode(45);
		root.left.right.right=new TreeNode(55);
		//--------------------------------------------------
		root.right.left.left = new TreeNode(65);
		root.right.left.right=new TreeNode(75);
		root.right.right.right = new TreeNode(95);
	    root.right.right.left = new TreeNode(85);
		Inorder(root);
		boolean x=search(root,45);
		System.out.println(x);
		System.out.println(IsValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

	}

	private static boolean IsValidBST(TreeNode root, int l, int r) {
		if(root==null) {
			return true;
			
		}
		if(root.val>l && root.val<r) {
			return IsValidBST(root.left,l,root.val) && IsValidBST(root.right,root.val,r);
		}
		
		return false;
		// TODO Auto-generated method stub
		
	}

	private static boolean search(TreeNode root, int i) {
		if(root!=null) {
		// TODO Auto-generated method stub
		if(root.val ==i) {
			return true;
		}
		if(root.val>i) {
			return search(root.left,i);
		}
		if(root.val<i) {
			return search(root.right,i);
		}
		
		}
		return false;
	}

	private static void Inorder(TreeNode root) {
		// TODO Auto-generated method stub
		if(root ==null) {
			return;
			
		}
		Inorder(root.left);
		System.out.print(root.val+" ");
		Inorder(root.right);
		
	}



}