package com.maria.trees.binarysearchtree;

import com.maria.trees.TreeNode;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    void isValidBST() {
        TreeNode root = BinarySearchTree.constructTree1();
        boolean isValid = BinarySearchTree.isValidBST(root);
        System.out.println(isValid);
    }

    @Test
    void searchBST() {
        TreeNode root = BinarySearchTree.constructTree2();
        TreeNode result = BinarySearchTree.searchBSTv2(root, 3);
        System.out.println(result.val);
    }

    @Test
    void insertIntoBST() {
        TreeNode root = BinarySearchTree.insertIntoBST(null, 5);
        root = BinarySearchTree.insertIntoBST(root, 2);
        root = BinarySearchTree.insertIntoBST(root, 6);
        root = BinarySearchTree.insertIntoBST(root, 1);
        root = BinarySearchTree.insertIntoBST(root, 7);
        root = BinarySearchTree.insertIntoBST(root, 4);
        root = BinarySearchTree.insertIntoBST(root, 3);
        BinarySearchTree.inOrderTraversal(root);
    }

    @Test
    void deleteNode() {
        TreeNode root = BinarySearchTree.constructTree3();
        root = BinarySearchTree.deleteNode(root, 5);
        BinarySearchTree.inOrderTraversal(root);

    }

    @Test
    void lowestCommonAncestor() {
        TreeNode root = BinarySearchTree.constructTree4();
//        BinarySearchTree.inOrderTraversal(root);
        TreeNode ans = BinarySearchTree.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(7));
        System.out.println(ans.val);
    }
}