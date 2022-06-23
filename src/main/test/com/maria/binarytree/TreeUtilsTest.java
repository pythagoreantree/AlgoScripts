package com.maria.binarytree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeUtilsTest {

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
        TreeNode root = TreeUtils.constructTreeFromArrayRaw();
        List<List<Integer>> llist = TreeUtils.levelOrder(root);
        for (List<Integer> linteger: llist){
            System.out.println(linteger.toString());
        }
    }

    @Test
    void isSymmetric() {
        TreeNode root = TreeUtils.constructTreeFromArrayRaw();
        boolean isSym = TreeUtils.isSymmetric2(root);
        System.out.println(isSym);
    }

    @Test
    void hasPathSum() {
        TreeNode root = TreeUtils.constructTree5();
        boolean hasSum = TreeUtils.hasPathSum(root, 5);
        System.out.println(hasSum);
    }
}