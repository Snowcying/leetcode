package code.M4;

import code.TreeNode;

import java.util.Stack;

public class S114 {
    static public void flatten(TreeNode root) {
        if(root ==null) return;
        Stack<TreeNode> t = new Stack<>();
        TreeNode preNode = root;
        while (!(t.isEmpty() && root.left == null && root.right == null)) {
            if (root.right != null) {
                t.push(root.right);
                root.right = null;
            } else {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = t.pop();
                }
            }
        }
        while (preNode != null) {
            preNode.right = preNode.left;
            preNode.left = null;
            preNode = preNode.right;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = TreeNode.initTreeByArray(nums);
        flatten(root);
        TreeNode.printTree(root);
    }
}
