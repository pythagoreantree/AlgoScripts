package com.maria.trees.binarysearchtree;

import com.maria.trees.TreeNode;

import java.util.ArrayList;

public class BSTIterator {

    public ArrayList<Integer> m;
    public int pointer = -1;

    public BSTIterator(TreeNode root) {
        m = new ArrayList();
        inOrderTraversal(root);
    }

    public int next() {
        return m.get(++pointer);
    }

    public boolean hasNext() {
        return 0 <= (pointer + 1) && (pointer + 1) < m.size();
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        m.add(root.val);
        inOrderTraversal(root.right);
    }
}
