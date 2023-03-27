package code;

import java.util.LinkedList;
import java.util.Queue;

class Tree {
    static TreeNode initTreeByArray(Integer[] list) {
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

    static void printTree(TreeNode root) {
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

class TreeNode {
    int val;
    int max;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
        this.max=val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution124 {
    int max;
     int maxGain(TreeNode node){
         if(node==null){
             return 0;
         }
        int leftGain=Math.max(maxGain(node.left),0);
        int rightGain=Math.max(maxGain(node.right),0);
        int nodeGain=leftGain+rightGain+node.val;
        this.max=Math.max(nodeGain,this.max);
        return node.val+Math.max(leftGain,rightGain);
    }
     public int maxPathSum(TreeNode root) {
        this.max=root.val;
        int nodeMax=maxGain(root);
        return this.max;
    }
}

public class Hot124Tree {
    public static void main(String[] args) {
//        int[] nums={-10,9,20,null,null,15,7};
        Integer[] nums = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = Tree.initTreeByArray(nums);
//        System.out.println(root.right.left.val);
//        Tree.printTree(root);
        Solution124 s=new Solution124();
        System.out.println(s.maxPathSum(root));

    }
}
