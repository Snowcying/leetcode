package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hot94 {
    static class Solution {

        static void dfs(TreeNode node, List<Integer> ans,String mode) {
            if(node==null){
                return;
            }

            if(mode.equals("preorder")){
                ans.add(node.val);
            }
            if (node.left != null) {
                dfs(node.left, ans,mode);
            }
            if(mode.equals("inorder")){
                ans.add(node.val);
            }
            if (node.right != null) {
                dfs(node.right, ans,mode);
            }
            if(mode.equals("postorder")){
                ans.add(node.val);
            }
        }

        static public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root,ans,"inorder");
            return ans;
        }
        static public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> s=new Stack<>();
            TreeNode node=root;
            while(!s.isEmpty()||node!=null){
                if(node!=null){
                    s.push(node);
                    node=node.left;
                }else{
                    node=s.pop();
                    ans.add(node.val);
                    node=node.right;
                }
            }
            return ans;
        }
        static public List<Integer> preorderTraversal(TreeNode root){
            List<Integer> ans = new ArrayList<>();
            dfs(root,ans,"preorder");
            return ans;
        }
        static public List<Integer> preorderTraversal2(TreeNode root){
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> s=new Stack<>();
            TreeNode node=root;
            while(!s.isEmpty()||node!=null){
                if(node!=null){
                    s.push(node);
                    ans.add(node.val);
                    node=node.left;
                }else {
                    node=s.pop().right;
                }
            }
            return ans;
        }
        static public List<Integer> postorderTraversal(TreeNode root){
            List<Integer> ans = new ArrayList<>();
            dfs(root,ans,"postorder");
            return ans;
        }
        static public List<Integer> postorderTraversal2(TreeNode root){
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> s=new Stack<>();
            TreeNode node=root;
            TreeNode r=new TreeNode();
//            while(!s.isEmpty()||node!=null){
//                if(node!=null){
//                    s.push(node);
//                    node=node.left;
//                }else {
//                    node=s.peek();
//                    node.left=null;
//                    if(node.right==null){
//                        s.pop();
//                        ans.add(node.val);
//                        node=null;
//                    }else {
//                        TreeNode pre=node;
//                        node=node.right;
//                        pre.right=null;
//                    }
//                }
//            }
            while(!s.isEmpty()||node!=null){
                if(node!=null){
                    s.push(node);
                    node=node.left;
                }else {
                    node=s.peek();
                    if(node.right!=null&&node.right!=r){
                        node=node.right;
                        s.push(node);
                        node=node.left;
                    }else {
                        node=s.pop();
                        ans.add(node.val);
                        r=node;
                        node=null;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        Integer[] input = {1};
        Integer[] input = {1, 9, 2,null,null, 3,4,5,6,7,8};
        TreeNode root = Tree.initTreeByArray(input);
        List<Integer> ans,ans2;
//        Tree.printTree(root);

        // preorder
        System.out.println("preorder");
        ans=Solution.preorderTraversal(root);
        System.out.println(ans);
        ans2=Solution.preorderTraversal2(root);
        System.out.println(ans2);

        // inorder
        System.out.println("inorder");
         ans=Solution.inorderTraversal(root);
        System.out.println(ans);
         ans2=Solution.inorderTraversal2(root);
        System.out.println(ans2);



        // postorder
        System.out.println("postorder");
        ans=Solution.postorderTraversal(root);
        System.out.println(ans);
        ans2=Solution.postorderTraversal2(root);
        System.out.println(ans2);
    }
}
