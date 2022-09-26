package com.maria.trees;

import com.maria.trees.binarytree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertTreeTaskTest {

    @Test
    void invertTree() {
        TreeNode root = BinaryTree.constructTree8();
        System.out.println(root);
        InvertTreeTask.invertTree(root);
        System.out.println(root);

    }
}