package com.acouchis.middle;

/**
 * 先序构造二叉树
 * <p>
 * Created by gaopeng09 on 2020-01-20
 */
public class BuildBinTree {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode treeNode = null;
        for (int v : preorder) {
            TreeNode treeNode1 = add(treeNode, v);
            if (null == treeNode) {
                treeNode = treeNode1;
            }
        }
        return treeNode;
    }

    private TreeNode add(TreeNode treeNode, int v) {
        if (null == treeNode) {
            return new TreeNode(v);
        }

        while (true) {
            if (v > treeNode.val) {
                if (treeNode.right != null) {
                    treeNode = treeNode.right;
                } else {
                    treeNode.right = new TreeNode(v);
                    break;
                }
            } else {
                if (null != treeNode.left) {
                    treeNode = treeNode.left;
                } else {
                    treeNode.left = new TreeNode(v);
                    break;
                }
            }
        }

        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
