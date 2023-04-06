package code.M4;

import code.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S102 {
    static public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeNode[] nodes = new TreeNode[2001];
        nodes[0] = root;
        int l = 0, r = 1;
        while (l < r) {
            List<Integer> temp = new ArrayList<>();
            int preR = r;
            for (; l < preR; l++) {
                root = nodes[l];
                temp.add(root.val);
                if (root.left != null) {
                    nodes[r++] = root.left;
                }
                if (root.right != null) {
                    nodes[r++] = root.right;
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
//        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        Integer[] nums = {1};
        TreeNode root = TreeNode.initTreeByArray(nums);
        System.out.println(levelOrder(null));
    }
}
