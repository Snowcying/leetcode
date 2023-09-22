package code.M9;

import code.TreeNode;

public class S226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode head = TreeNode.initTreeByArray(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        new S226().invertTree(head);
        TreeNode.printTree(head);
    }
}
