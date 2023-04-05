package code.M4;

import code.TreeNode;

import java.util.Stack;

public class S98 {

    static boolean flag=true;
    static int pre=Integer.MIN_VALUE;
    static public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        if(root.val<pre){
            flag=false;
            return;
        }else{
            pre= root.val;
        }
        dfs(root.right);

    }
    static public boolean isValidBST(TreeNode root) {
//        TreeNode.printTree(root);
        Stack<TreeNode> s1=new Stack<>();
        long pre= Long.MIN_VALUE;
        while(!s1.isEmpty()||root!=null){
            if(root!=null){
                s1.push(root);
                root=root.left;
            }else{
                root=s1.pop();
                if(root.val<=pre){
                    return false;
                }else {
                    pre=root.val;
                }
                root=root.right;
            }
        }
        return true;
    }
    static public boolean isValidBST2(TreeNode root){
        dfs(root);
        return flag;
    }

    public static void main(String[] args) {
//        Integer[] root={5,6};
        Integer[] root={-2147483648};
        TreeNode rNode=TreeNode.initTreeByArray(root);
        System.out.println(isValidBST(rNode));
    }
}
