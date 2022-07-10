package com.maria.trees.avltree;

public class AVLNode {

    public int val;
    public int height = 1;
    public AVLNode left;
    public AVLNode right;

    public AVLNode() {}

    public AVLNode(int val) {
        this.val = val;
    }

    public AVLNode(int val, int height) {
        this.val = val;
        this.height = height;
    }

    public AVLNode(int val, AVLNode left, AVLNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
