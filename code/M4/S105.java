package code.M4;

import code.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S105 {
    static Map<Integer, Integer> m = new HashMap<>();

    static public TreeNode getNode(int[] pre, int[] in, int preL, int preR, int inL, int inR) {

        if (preL > preR) return null;
        int root = pre[preL];
        int inRootIndex = m.get(root);
        TreeNode node = new TreeNode(root);
        int lLen = inRootIndex - inL;

        node.left = getNode(pre, in, preL + 1, preL + lLen, inL, inRootIndex - 1);
        node.right = getNode(pre, in, preL + lLen + 1, preR, inRootIndex + 1, inR);
        return node;

    }

    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        int n = preorder.length;
        return getNode(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] t1 = {1}, t2 = {1};
//        int[] t1 = {3, 9, 20, 15, 7}, t2 = {9, 3, 15, 20, 7};
        TreeNode.printTree(buildTree(t1, t2));
    }
}
