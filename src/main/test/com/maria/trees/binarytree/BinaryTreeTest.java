package com.maria.trees.binarytree;

import com.maria.trees.NodeExt;
import com.maria.trees.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

class BinaryTreeTest {

    @Test
    void inOrderTraversal() {
    }

    @Test
    void preOrderTraversal() {
    }

    @Test
    void postOrderTraversal() {
    }

    @Test
    void levelOrder() {
        //[1,2,3,4,null,null,5]
        TreeNode root = BinaryTree.constructTreeFromArrayRaw();
        List<List<Integer>> llist = BinaryTree.levelOrder(root);
        for (List<Integer> linteger: llist){
            System.out.println(linteger.toString());
        }
    }

    @Test
    void isSymmetric() {
        TreeNode root = BinaryTree.constructTreeFromArrayRaw();
        boolean isSym = BinaryTree.isSymmetric2(root);
        System.out.println(isSym);
    }

    @Test
    void hasPathSum() {
        TreeNode root = BinaryTree.constructTree5();
        boolean hasSum = BinaryTree.hasPathSum(root, 5);
        System.out.println(hasSum);
    }

    @Test
    void buildTreePreOrder() {
        int[] in = new int[]{9,3,15,20,7};
        int[] pre = new int[]{3,9,20,15,7};
        TreeNode root = BinaryTree.buildTreePre(in, pre);
        List<Integer> list = BinaryTree.levelOrderWithNulls(root);
        System.out.println(list.toString());
    }

    @Test
    void buildTreePostOrder() {
        int[] in = new int[]{9,3,15,20,7};
        int[] post = new int[]{9,15,7,20,3};
        TreeNode root = BinaryTree.buildTreePost(in, post);
        List<Integer> list = BinaryTree.levelOrderWithNulls(root);
        System.out.println(list.toString());
    }

    @Test
    void connect() {
        NodeExt root = BinaryTree.constructTree6();
        BinaryTree.connect2(root);
        BinaryTree.inOrderTraversal(root);
    }

    @Test
    void lowestCommonAncestor() {
        TreeNode root = BinaryTree.constructTree7();
        TreeNode ans = BinaryTree.lowestCommonAncestor2(root, new TreeNode(2), new TreeNode(3));
        System.out.println(ans.val);
    }

    @Test
    void printInOrderWithoutRecursion() {
        TreeNode root = BinaryTree.constructTree7();
        BinaryTree.inOrderWithoutRecursion(root);
    }

    @Test
    void findLCA() {
        TreeNode root = BinaryTree.constructTree7();
        TreeNode ans = BinaryTree.findLCA(root, new TreeNode(4), new TreeNode(7));
        System.out.println(ans.val);
    }
}