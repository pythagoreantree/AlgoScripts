package com.maria.trees.binarysearchtree;

import com.maria.trees.TreeNode;

import java.util.ArrayList;

public class BinarySearchTree {


    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        validate(root);
        return valid;
    }

    private static boolean valid = true;
    private static Integer current = null;
    private static void validate(TreeNode node) {
        if (node == null)
            return;
        validate(node.left);
        if (valid && current != null && node.val <= current)
            valid = false;
        current = node.val;
        validate(node.right);
    }

    public static TreeNode constructTree2() {
        //[4,2,7,1,3, null, null]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.print(root.val + " ");

        inOrderTraversal(root.right);
    }

    public static TreeNode constructTree3() {
        //[5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode constructTree4() {
        //[6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        return root;
    }

    public static TreeNode constructTree5() {
        //[2, 1, 3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }


    public boolean isValidBSTv2(TreeNode root) {
        long min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        return bstHelper(root, min - 1, max + 1);
    }

    public boolean bstHelper(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if ((long) root.val <= min || (long) root.val >= max)
            return false;
        return bstHelper(root.left, min, root.val) && bstHelper(root.right, root.val, max);
    }


    public static TreeNode constructTree1() {
        //[2,2,2]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        return root;
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static TreeNode searchBSTv2(TreeNode root, int val) {
        while (root != null && root.val != val){
            if (val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null)
//            return new TreeNode(val);
//        bstInsertV3(root, val);
//        return root;
        return bstInsertV4(root, val);
    }

    public static void bstInsert(TreeNode node, int val) {

        if (val < node.val) {
            if (node.left == null){
                node.left = new TreeNode(val);
                return;
            } else {
                bstInsert(node.left, val);
            }
        }

        if (val > node.val) {
            if (node.right == null){
                node.right = new TreeNode(val);
                return;
            } else {
                bstInsert(node.right, val);
            }
        }
    }

    public static void bstInsertV2(TreeNode node, int val) {

        while (true){
            if (val < node.val && node.left != null) {
                node = node.left;
            } else if (val > node.val && node.right != null){
                node = node.right;
            }

            if (node.left == null && val < node.val){
                node.left = new TreeNode(val);
                break;
            }
            if (node.right == null && val > node.val){
                node.right = new TreeNode(val);
                break;
            }
        }
    }

    public static void bstInsertV3(TreeNode node, int val) {

        TreeNode parent = null;
        while (node != null){
            parent = node;
            if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (val < parent.val)
            parent.left = new TreeNode(val);
        else
            parent.right = new TreeNode(val);
    }

    public static TreeNode bstInsertV4(TreeNode node, int val) {

        if(node == null) {
            TreeNode n = new TreeNode(val);
            return n;
        }

        if(val < node.val) {
            node.left = insertIntoBST(node.left, val);
        } else {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        TreeNode node = root;
        //1. find the node
        TreeNode parent = null;
        while (node != null && node.val != key){
            parent = node;
            if (key < node.val){
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node == null) {
            return root;
        }

        if (node != null) {
            //2. delete node
            if (node.left == null){
                TreeNode t = redirectParent(parent, node, node.right);
                if (parent == null){
                    root = t;
                }
            } else if (node.right == null) {
                TreeNode t = redirectParent(parent, node, node.left);
                if (parent == null){
                    root = t;
                }
            } else {
                TreeNode parent2 = node;
                TreeNode right = node.right;
                while (right.left != null){
                    parent2 = right;
                    right = right.left;
                }

                if (parent2 != node){
                    redirectParent(parent2, right, right.right);
                    right.right = node.right;
                }
                TreeNode t = redirectParent(parent, node, right);
                if (parent == null){
                    root = t;
                }
                right.left = node.left;
            }
        }
        return root;
    }

    private static TreeNode redirectParent(TreeNode parent, TreeNode node, TreeNode nodeToReplace) {
        if (parent != null){
            if (parent.left == node)
                parent.left = nodeToReplace;
            else
                parent.right = nodeToReplace;
        }
        return nodeToReplace;
    }

    public static TreeNode delNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {

            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;

            TreeNode inOrderSuccessor = root.right;
            while (inOrderSuccessor.left !=null)
                inOrderSuccessor = inOrderSuccessor.left;

            root.val = inOrderSuccessor.val;
            root.right = delNode(root.right, inOrderSuccessor.val);
        } else if (key > root.val){
            root.right = delNode(root.right, key);
        } else {
            root.left = delNode(root.left, key);
        }
        return root;
    }

    //Inorder Successor in Binary Search Tree

    //LCA in BST. O(h)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val > q.val){
            return searchLCA(root, q, p);
        }
        return searchLCA(root, p, q);
    }

    private static TreeNode searchLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        } else if (p.val < root.val && q.val < root.val){
            return searchLCA(root.left, p, q);
        } else {
            return searchLCA(root.right, p, q);
        }
    }

    public static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return root;
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestorV2(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestorV2(root.left, p, q);
        else
            return root;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        populateHeight(root);
        return isBalanced;
    }

    private static boolean isBalanced = true;
    private static int populateHeight(TreeNode node){
        if (node == null)
            return 0;

        int leftHeight = populateHeight(node.left);
        int rightHeight = populateHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            isBalanced = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }

    public static TreeNode convertBSTtoBalancedBST(TreeNode root){
        if (root == null)
            return null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        bstToArray(root, nodes);

        return buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    private static void bstToArray(TreeNode root, ArrayList<TreeNode> nodes) {
        if (root == null)
            return;

        bstToArray(root.left, nodes);
        nodes.add(root);
        bstToArray(root.right, nodes);
    }

    private static TreeNode buildBalancedTree(ArrayList<TreeNode> nodes, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);

        node.left = buildBalancedTree(nodes, start, mid - 1);
        node.right = buildBalancedTree(nodes, mid + 1, end);

        return node;
    }

    //BST from sorted Linked List
    /*public static TreeNode sortedListToBSTRecur(int n) {
        *//* Base Case *//*
        if (n <= 0)
            return null;

        *//* Recursively construct the left subtree *//*
        TreeNode left = sortedListToBSTRecur(n / 2);

        *//* head_ref now refers to middle node,
           make middle node as root of BST*//*
        TreeNode root = new TreeNode(head.data);

        // Set pointer to left subtree
        root.left = left;

        *//* Change head pointer of Linked List for parent
           recursive calls *//*
        head = head.next;

        *//* Recursively construct the right subtree and link it
           with root. The number of nodes in right subtree  is
           total nodes - nodes in left subtree - 1 (for root) *//*
        root.right = sortedListToBSTRecur(n - n / 2 - 1);

        return root;
    }*/
}


