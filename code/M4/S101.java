package code.M4;

import code.TreeNode;

public class S101 {

    static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }

    static public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, null, 3, null, 3};
        TreeNode root = TreeNode.initTreeByArray(nums);
        System.out.println(isSymmetric(root));

    }
}
