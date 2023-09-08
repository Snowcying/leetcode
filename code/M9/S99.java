package code.M9;

import code.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S99 {
    public void recoverTree(TreeNode root) {
//        System.out.println("123");
        List<TreeNode> res = new ArrayList<>();
        inSearch(root, res);
        int flag = 0;
        int[] exchange = new int[2];
        for (int i = 0; i < res.size() - 1; i++) {
            TreeNode cur = res.get(i);
            TreeNode next = res.get(i + 1);
            if (cur.val > next.val) {
                exchange[flag] = i;
                flag++;
            }
        }
        int i = 0, j = 0;
        if (flag == 1) {
            i = exchange[0];
            j = i + 1;
        } else if (flag == 2) {
            i = exchange[0];
            j = exchange[1] + 1;
        }
        TreeNode cur = res.get(i);
        TreeNode next = res.get(j);
        int temp = cur.val;
        cur.val = next.val;
        next.val = temp;

        for (TreeNode re : res) {
            System.out.println(re.val);
        }
//        System.out.println(res);
    }

    public void inSearch(TreeNode root, List<TreeNode> res) {
        if (root != null) {
            inSearch(root.left, res);
            res.add(root);
            inSearch(root.right, res);
        }
    }

    public static void main(String[] args) {
//        TreeNode head = TreeNode.initTreeByArray(new Integer[]{1, 3, null, null, 2});
        TreeNode head = TreeNode.initTreeByArray(new Integer[]{3, 1, 4, null, null, 2});
//        TreeNode.printTree(head);
        new S99().recoverTree(head);
    }
}
