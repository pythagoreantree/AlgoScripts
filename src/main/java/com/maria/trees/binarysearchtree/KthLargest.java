package com.maria.trees.binarysearchtree;

import com.maria.trees.TreeNode;

public class KthLargest {

    public int k;
    TreeNodeCounter root = null;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i: nums){
            if (root == null) {
                root = new TreeNodeCounter(i);
                continue;
            }
            add(root, i);
        }
    }

    public int add(int val) {
        if (root == null) {
            root = new TreeNodeCounter(val);
            return val;
        }
        //1. add node to tree
        add(root, val);
        //2. find K largest
        return findKlargest(root, k);
    }

    private TreeNodeCounter add(TreeNodeCounter node, int val){
        if (node == null){
            return new TreeNodeCounter(val);
        }

        if (val <= node.val){
            node.cnt++;
            node.left = add(node.left, val);
        } else {
            node.cnt++;
            node.right = add(node.right, val);
        }
        return node;
    }

    private int findKlargest(TreeNodeCounter node, int k){
        int b = node.right != null? node.right.cnt: 0;
        int nodesLeft = k - b - 1;
        if (nodesLeft == 0){
            return node.val;
        } else if (nodesLeft < 0){
            return findKlargest(node.right, k);
        } else {
            k = nodesLeft;
            return findKlargest(node.left, k);
        }
    }

    private class TreeNodeCounter {
        public int val;
        public int cnt = 1;
        public TreeNodeCounter left;
        public TreeNodeCounter right;

        public TreeNodeCounter() {}

        public TreeNodeCounter(int val) {
            this.val = val;
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void inOrderTraversal(TreeNodeCounter root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.print("[" + root.val + ", " + root.cnt + "] ");

        inOrderTraversal(root.right);
    }
}
