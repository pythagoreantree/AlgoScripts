package com.maria.trees;

public class InvertTreeTask {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;
        return root;
    }

}
