package DSA.Tree;

import java.util.*;

public class levelOrderTraversal {
//               20
//	30                      10
//50 	    70              15       60

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(30);
        root.right= new TreeNode(10);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(70);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(60);
        
//        levelOrderTraversal(root);
//        TraversalMethod(root);
        leftView(root);
        System.out.println("next");
        rightView(root);

		System.out.println("zigzag");
		System.out.println(zigzagLevelOrder(root));



		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right= new TreeNode(5);
		root1.left.left = new TreeNode(3);
		root1.right.right= new TreeNode(6);
		root1.left.left.left= new TreeNode(4);

		System.out.println(cousinsOfGivenTreeI(root1,3,6));


	}

	private static void rightView(TreeNode root) {
		// TODO Auto-generated method stub
        Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(root);
        q.offer(null);
        System.out.print(q.peek().val);
		while(!q.isEmpty()) {
			TreeNode x= q.poll();
			if(x==null) {
				if(q.isEmpty()) {
					break;
				}
				System.out.println();
				System.out.print(q.peek().val);
				q.offer(null);
				
			}
			else {
				
	            if(x.right!=null) {
	            	q.offer(x.right);
				}
	            if(x.left!=null) {
					q.offer(x.left);
				}
//	            System.out.print(x.val+ " ");
				
			}
			
		}
		
	}

	private static void leftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(root);
        q.offer(null);
        System.out.print(q.peek().val);
		while(!q.isEmpty()) {
			TreeNode x= q.poll();
			if(x==null) {
				if(q.isEmpty()) {
					break;
				}
				System.out.println();
				System.out.print(q.peek().val);
				q.offer(null);
				
			}
			else {
				if(x.left!=null) {
					q.offer(x.left);
				}
	            if(x.right!=null) {
	            	q.offer(x.right);
				}
//	            System.out.print(x.val+ " ");
				
			}
			
		}
		
		System.out.println();
		
		
	}

	private static void TraversalMethod(TreeNode A) {
		// TODO Auto-generated method stub
		
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(A);
       while(!q.isEmpty()){
           
          
               TreeNode x= q.poll();
               if(x.left!=null){
                   q.offer(x.left);
               }
               if(x.right!=null){
                   q.offer(x.right);
               }
               
           
           System.out.println(x.val);}
       
	}

	private static void levelOrderTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		
		Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(root);
        q.offer(null);
		
		while(!q.isEmpty()) {
			TreeNode x= q.poll();
			if(x==null) {
				if(q.isEmpty()) {
					break;
				}
				System.out.println();
				q.offer(null);
				
			}
			else {
				if(x.left!=null) {
					q.offer(x.left);
				}
	            if(x.right!=null) {
	            	q.offer(x.right);
				}
	            System.out.print(x.val+ " ");
				
			}
			
		}
		
		
		
	}

	//zigzagtraversal

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 Queue<TreeNode> queue= new LinkedList<>();
		 boolean leftToRight= true;
		 queue.offer(root);
		 while (!queue.isEmpty()){
			 int n = queue.size();
			 ArrayList<Integer> res =new ArrayList<>();
			 for(int i =0;i<n;i++){
				 TreeNode q = queue.poll();
				 res.add(q.val);
				 if(q.left!=null) queue.add(q.left);
				 if(q.right!=null) queue.add(q.right);
			 }

			 if (!leftToRight) Collections.reverse(res);
			 result.add(res);

			 leftToRight= !leftToRight;

		 }
		 return result;
	}

	static boolean cousinsOfGivenTreeI(TreeNode root ,int x,int y){

		boolean foundX=false,foundY=false;

		Queue<TreeNode> queue= new LinkedList<>();

		queue.offer(root);
		while (!queue.isEmpty()){
			int n = queue.size();
			foundX=false;foundY=false;
			for(int i =0;i<n;i++){

				TreeNode q = queue.poll();


				if(q.left != null && q.right != null){
					if((q.left.val == x && q.right.val == y) ||
							(q.left.val == y && q.right.val == x)){
						return false;
					}
				}



				if(q.val==x) foundX= true;
				if(q.val==y) foundY =true;


				if(q.left!=null) queue.add(q.left);
				if(q.right!=null) queue.add(q.right);
			}
			if(foundX && foundY){
				return true;
			}

		}
		return foundX && foundY ;
	}


	static TreeNode cousinsOfGivenTreeII(TreeNode root){
       Queue<TreeNode> queue= new LinkedList<>();

		queue.offer(root);
		List<Integer> levelSums = new ArrayList<>();
		while (!queue.isEmpty()){
			int n = queue.size();
			int levelSum = 0;


			for(int i =0;i<n;i++){
				TreeNode q = queue.poll();
				levelSum +=q.val;
				if(q.left!=null) {queue.add(q.left);}
				if(q.right!=null){queue.add(q.right);}
			}
			levelSums.add(levelSum);
		}

		queue.offer(root);
		root.val=0;
		int levelIndex=1;
		while (!queue.isEmpty()){
			int n = queue.size();
			for(int i =0;i<n;i++){
				TreeNode q = queue.poll();
                int siblingSum =( q.left!=null ? q.left.val:0) +(q.right!=null ? q.right.val:0);

				if(q.left!=null) {
					q.left.val= levelSums.get(levelIndex)-siblingSum;
					queue.add(q.left);}
				if(q.right!=null)
				{q.right.val= levelSums.get(levelIndex)-siblingSum;
					queue.add(q.right);}
			}
			levelIndex++;
		}

        return root;
	}




}
