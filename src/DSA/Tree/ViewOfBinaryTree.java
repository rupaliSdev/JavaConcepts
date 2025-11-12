package DSA.Tree;

import java.util.*;

public class ViewOfBinaryTree {


//                   1
//                 /   \
//                 2    3
//               / \   / \
//              4   5 6  7
//                 /
//                 8

//    ans 1,3,7,8 right
    // 1 2 4 8 6 7 3
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(8);


        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(solveIstRightView(root).toString());


        System.out.println(solveIIRightView(root).toString());
        System.out.println(solveIILeftView(root).toString());
        System.out.println(bounndaryOrderTraversal(root).toString());

    }

    private static List<Integer> solveIIRightView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root!=null) queue.offer(root);

        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode r= queue.poll();
                if(i==0) res.add(r.val);
                if(r.right!=null) queue.add(r.right);
                if(r.left!=null) queue.add(r.left);

            }
        }
      return res;
    }

    public static List<Integer> solveIstRightView(TreeNode A) {


        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode  curr = A;
        queue.offer(curr);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode temp = queue.peek();
            if(temp!=null){
                res.add(temp.val);
                while (queue.peek()!=null){
                    if(temp.right!=null){
                        queue.offer(temp.right);
                    }
                    if(temp.left!=null){
                        queue.offer(temp.left);
                    }
                    queue.remove();
                    temp=queue.peek();
                }
                queue.offer(null);

            }
            queue.remove();
        }


    return res;
    }

    private static List<Integer> solveIILeftView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root!=null) queue.offer(root);

        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode r= queue.poll();
                if(i==0) res.add(r.val);
                if(r.left!=null) queue.add(r.left);
                if(r.right!=null) queue.add(r.right);


            }
        }
        return res;
    }


    private static List<Integer> bounndaryOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root!=null){
            res.add(root.val);
        }
        addLeftView(root.left,res);

        addLeafNode(root,res);
        addRightView(root.right,res);
        return res;

    }

    private static void addRightView(TreeNode root, List<Integer> res) {
        Stack<Integer> stack= new Stack<>();

        while (root!=null){
            if(!leafNode(root)) stack.push(root.val);
            if(root.left!=null){
                root=root.left;
            }
            else{
                root=root.right;
            }

        }
        while (!stack.isEmpty()) res.add(stack.pop());



    }

    private static boolean leafNode(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        return false;
    }

    private static void addLeafNode(TreeNode root, List<Integer> res) {
        if(root!=null){
        if(leafNode(root)){
            res.add(root.val);
            return;
        }
        addLeafNode(root.left ,res);
        addLeafNode(root.right,res);}
    }

    private static void addLeftView(TreeNode root, List<Integer> res) {
        while (root!=null){
            if(!leafNode(root)) res.add(root.val);
            if(root.left!=null){
                root=root.left;
            }
            else{
                root=root.right;
            }

        }
    }


}
