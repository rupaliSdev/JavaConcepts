package DSA.Tree;

import java.util.ArrayList;

public class BasicProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode t = new TreeNode(20);
		t.left=new TreeNode(35);
		t.right = new TreeNode(40);

	}
	//size of a tree
	static int size(TreeNode root) {
		if(root==null) {
			return 0;
		}
		return size(root.left)+size(root.right)+1;
	}
	//height of a tree
	static int height(TreeNode root) {
		if(root==null) {
			return -1;
		}
		return Math.max(height(root.left), height(root.right))+1;
	}
	//depth of a tree
	static void filldepth(TreeNode root,int d) {
		if(root==null) {
			return;
		}
		filldepth(root.left ,d+1);
		filldepth(root.right,d+1);
	}
	static boolean findElement(TreeNode root , int k) {
		if(root==null) {
			return false;
		}
		if(root.val == k) {
			return true;
		}
		return findElement(root.left,k) || findElement(root.right,k);
	}
	static ArrayList<Integer> arr =new ArrayList<>();
	static boolean findPath(TreeNode root,int k) {
		if(root==null) {
			return false;
		}
		if(root.val == k) {
			arr.add(root.val);
			return true;
		}
		if(findPath(root.left,k) || findPath(root.right,k)) {
			arr.add(root.val);
			return true;
		}
		return false;
	}

	static boolean areMirror(TreeNode t1 ,TreeNode t2){
		if(t1==null && t2==null) return  true;
		if(t1==null || t2==null) return false;

		return t1.val==t2.val && areMirror(t1.left,t1.right) && areMirror(t1.right, t2.left);
	}

}
