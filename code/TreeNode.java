package code;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    int max;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.max=val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    static public TreeNode initTreeByArray(Integer[] list) {
        // 层序遍历
        TreeNode root = new TreeNode(list[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        int len = list.length;
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (index < len && list[index] != null) {
                TreeNode left = new TreeNode(list[index]);
                node.left = left;
                q.add(left);
            } else {
                node.left = null;
            }
            index++;
            if (index < len && list[index] != null) {
                TreeNode right = new TreeNode(list[index]);
                node.right = right;
                q.add(right);
            } else {
                node.right = null;
            }
            index++;
        }
        return root;
    }
    static public void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        System.out.println(root.val);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                System.out.println(node.left.val);
                q.add(node.left);
            } else {
                System.out.println("null");
            }
            if (node.right != null) {
                System.out.println(node.right.val);
                q.add(node.right);
            } else {
                System.out.println("null");
            }

        }
    }
}
