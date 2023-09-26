package code.M9;

import code.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S236 {
    List<TreeNode> path;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pre = new ArrayList<>();
        dfs(pre, root, p);
        ArrayList<TreeNode> list1 = new ArrayList<>(path);
        pre = new ArrayList<>();
        dfs(pre, root, q);
        ArrayList<TreeNode> list2 = new ArrayList<>(path);
        int len = Math.min(list2.size(), list1.size());
        int i = 0;
        for (i = 0; i < len; i++) {
            if (list1.get(i) != list2.get(i)) {
                break;
            }
        }
        return list1.get(i - 1);
    }

    void dfs(List<TreeNode> pre, TreeNode cur, TreeNode end) {
        if (cur != null) {
            pre.add(cur);
            if (cur == end) {
                path = new ArrayList<>(pre);
                return;
            }
            dfs(pre, cur.left, end);
            dfs(pre, cur.right, end);
            pre.remove(cur);
        }
    }

    public static void main(String[] args) {
        TreeNode head = TreeNode.initTreeByArray(new Integer[]{3, 5});
//        TreeNode head = TreeNode.initTreeByArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(new S236().lowestCommonAncestor(head, head, head.left).val);
//        TreeNode.printTree(head);
    }
}
