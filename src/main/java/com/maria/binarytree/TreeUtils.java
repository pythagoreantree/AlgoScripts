package com.maria.binarytree;

import java.util.*;

public class TreeUtils {

    public static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.println(root.val);

        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> pre = new LinkedList<Integer>();
        if (root == null)
            return pre;
        pre.add(root.val);
        pre.addAll(preorderTraversal2(root.left));
        pre.addAll(preorderTraversal2(root.right));
        return pre;
    }

    private static List<Integer> res = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        else {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }

    public static List<List<Integer>> l = new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return l;
        }

        List<Integer> lst1 = new ArrayList<>();
        lst1.add(root.val);
        l.add(lst1);

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addFirst(root);
        while(!dq.isEmpty()){
            int length = dq.size();
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i < length; i++){
                TreeNode node = dq.pollFirst();
                if (node.left != null) {
                    lst.add(node.left.val);
                    dq.addLast(node.left);
                }
                if (node.right != null) {
                    lst.add(node.right.val);
                    dq.addLast(node.right);
                }
            }

            if (!lst.isEmpty()) l.add(lst);
        }
        return l;
    }

    public static TreeNode constructTreeFromArrayRaw(){
        //[1,2,3,4,null,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = null;
        root.right.right.left = new TreeNode(7);
        return root;
    }

    public static TreeNode constructTree2(){
        //[1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }

    public static TreeNode constructTree3(){
        //root = [1,2,2,null,3,null,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(3);
        return root;
    }

    public static TreeNode constructTree4(){
        //root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        return root;
    }

    public static TreeNode constructTree5(){
        //root = [1,2,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    public static boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = true;

        if (root == null) return true;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.addFirst(root);
        while(!dq.isEmpty()){
            int length = dq.size();
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i < length; i++){
                TreeNode node = dq.pollFirst();
                 if (node != null)
                     lst.add(node.val);
                 else
                     lst.add(null);
                if (node != null) dq.addLast(node.left);
                if (node != null) dq.addLast(node.right);
            }
            int fp = 0, lp = lst.size() - 1;
            while (fp < lp) {
                if (lst.get(fp++) != lst.get(lp--))
                    isSymmetric = false;
            }
        }

        return isSymmetric;
    }

    private static boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        return helper(root, root);
    }

    public static boolean hasPathSum(TreeNode root, int summ) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return (summ - root.val) == 0;
        }
        return hasPathSum(root.left, summ - root.val) || hasPathSum(root.right, summ - root.val);

    }

    /*public static List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> pre = new LinkedList<Integer>();
        if (root == null)
            return pre;
        pre.add(root.val);
        pre.addAll(preorderTraversal2(root.left));
        pre.addAll(preorderTraversal2(root.right));
        return pre;
    }

    private static List<Integer> res = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        else {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }

    private static List<List<Integer>> l = new ArrayList<>();
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        if (root != null) {
            List<Integer> lroot = new ArrayList<>();
            lroot.add(root.val);
            l.add(lroot);
        }

        process(root);

        return l;
    }

    public static void process(TreeNode node) {
        if (node == null)
            return;
        List<Integer> list = getChildrenVals(node);
        if (!list.isEmpty()) l.add(list);
        process(node.left);
        process(node.right);
    }

    public static List<Integer> getChildrenVals(TreeNode node) {
        List<Integer> levelList = new ArrayList();
        if (node.left != null)
            levelList.add(node.left.val);
        if (node.right != null)
            levelList.add(node.right.val);
        return levelList;
    }*/
}