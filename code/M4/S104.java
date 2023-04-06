package code.M4;

import code.TreeNode;

public class S104 {
    static public int dfs(TreeNode node,int d){
        if(node==null)return d-1;
        return Math.max(dfs(node.left,d+1),dfs(node.right,d+1));
//        return dfs
    }
    static public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(dfs(root.left,2),dfs(root.right,2));
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7,1};
//        Integer[] nums = {1};
        TreeNode root = TreeNode.initTreeByArray(nums);
        System.out.println(maxDepth(root));
    }
}
