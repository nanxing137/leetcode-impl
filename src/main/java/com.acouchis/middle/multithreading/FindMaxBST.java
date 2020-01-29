package com.acouchis.middle.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaopeng09 on 2020-01-22
 */
public class FindMaxBST {
    private MyList<Integer> list = new MyList();

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        list.rootNum = root.val;
        return 0;
    }

    private void find(TreeNode treeNode, int deep) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            find(treeNode.left, deep + 1);
        }
        list.add(treeNode.val);
        if (deep == 0) {
            list.rootIdx = list.size() - 1;
        }
        if (treeNode.right != null) {
            find(treeNode.right, deep + 1);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class MyList<E> extends ArrayList<E> {
        Integer rootIdx;
        int rootNum;
        int max;
        int cur;
        @Override
        public boolean add(E e) {
            // 没找到root 证明还在左边树
            if (rootIdx==null){

            }
            return super.add(e);
        }
    }

}
