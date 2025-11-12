package DSA.BST;

public class checkbst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t =new TreeNode(20);
		t.left=new TreeNode(16);
		
		t.left.left=new TreeNode(15);
		t.left.right=new TreeNode(17);

		t.right=new TreeNode(22);
		t.right.left=new TreeNode(21);
		t.right.right=new TreeNode(23);
		System.out.println(t.val);
		System.out.println(max(t,Integer.MIN_VALUE));
		System.out.println(min(t,Integer.MAX_VALUE));
		System.out.println(checkBST1(t));
		System.out.println(checkBST(t,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
	}

	private static boolean checkBST(TreeNode root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if(root==null) {
			return true;
		}
		if(root.val>=minValue && root.val<=maxValue) {
			return (checkBST(root.left,Integer.MIN_VALUE,root.val-1)&&checkBST(root.right,root.val+1,Integer.MAX_VALUE));
		}
		return false;
	}

	private static int max(TreeNode t, int max) {
		// TODO Auto-generated method stub
		if(t==null) {
			return max;
		}
		if(t.val>max) {
			max=t.val;
		}
		//System.out.println(max);
		return Math.max(max(t.left,max), max(t.right,max));
	}
	private static int min(TreeNode t, int min) {
		// TODO Auto-generated method stub
		if(t==null) {
			return min;
		}
		if(t.val<min) {
			min=t.val;
		}
		//System.out.println(max);
		return Math.min(min(t.left,min), min(t.right,min));
	}
	
	
	public static boolean checkBST1(TreeNode root) {
		if(root==null) {
			return true;
		}
		
		int maxLeft = max(root.left,Integer.MIN_VALUE);
		int minRight = min(root.right,Integer.MAX_VALUE);
		
		if(root.val> maxLeft && root.val<minRight) {
			return (checkBST1(root.left) && checkBST1(root.right));
		}
		
		return false;
	}

	public int countInRange(TreeNode root, int L, int R){

		if(root ==null) return 0;
		if(root.val<L) return countInRange(root.right,L,R);
		if(root.val>R) return countInRange(root.left,L,R);

		return 1 + countInRange(root.left,L,R) + countInRange(root.right,L,R);
	}





}
