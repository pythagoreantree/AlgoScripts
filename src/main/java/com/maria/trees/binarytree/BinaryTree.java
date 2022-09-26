package com.maria.trees.binarytree;

import com.maria.trees.NodeExt;
import com.maria.trees.TreeNode;

import java.util.*;

public class BinaryTree {

    public static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.print(root.val + " ");

        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val + " ");

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val + " ");

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);
    }

    public static void inOrderTraversal(NodeExt root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.print(root.val + " ");

        inOrderTraversal(root.right);
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

    public static List<Integer> levelOrderWithNulls(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> lst = new ArrayList<>();
        lst.add(root.val);

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addFirst(root);
        while(!dq.isEmpty()){
            int length = dq.size();
            for (int i = 0; i < length; i++){
                TreeNode node = dq.pollFirst();
                if (node.left != null) {
                    lst.add(node.left.val);
                    dq.addLast(node.left);
                } else {
                    lst.add(null);
                }
                if (node.right != null) {
                    lst.add(node.right.val);
                    dq.addLast(node.right);
                } else {
                    lst.add(null);
                }
            }

        }
        return lst;
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

    public static NodeExt constructTree6(){
        //root = [1,2,3,4,5,6,7]
        //3,5,1,6,2,0,8,null,null,7,4
        NodeExt root = new NodeExt(3);
        root.left = new NodeExt(5);
        root.right = new NodeExt(1);
        root.left.left = new NodeExt(6);
        root.left.right = new NodeExt(2);
        root.right.left = new NodeExt(0);
        root.right.right = new NodeExt(8);
        return root;
    }

    public static TreeNode constructTree7(){
        //root = [1,2,3,4,5,null,7, null, null, 8, 9, null, null ...]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.left = new TreeNode(10);
        root.left.right.right.left.right = new TreeNode(12);
        return root;
    }

    public static TreeNode constructTree8(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
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

    private static HashMap<Integer,Integer> map = new HashMap<>();
    private static int preIndex = 0;

    public static TreeNode buildTreePre(int in[], int pre[]){
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildTreePreOrder(pre, 0, in.length-1);
    }

    private static TreeNode buildTreePreOrder(int pre[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        Integer currentNum = pre[preIndex++];
        TreeNode tNode = new TreeNode(currentNum);

        /* If this node has no children then return */
        if (inStart == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = map.get(currentNum);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTreePreOrder(pre, inStart, inIndex - 1);
        tNode.right = buildTreePreOrder(pre, inIndex + 1, inEnd);

        return tNode;
    }

    private static HashMap<Integer,Integer> inOrderMap = new HashMap<>();
    private static int postIndex = 0;

    public static TreeNode buildTreePost(int in[], int post[]){
        postIndex = post.length-1;
        for(int i = 0; i < in.length; i++) {
            inOrderMap.put(in[i], i);
        }
        return buildTreePostOrder(post, 0, in.length-1);
    }

    private static TreeNode buildTreePostOrder(int post[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        Integer currentNum = post[postIndex--];
        TreeNode tNode = new TreeNode(currentNum);

        /* If this node has no children then return */
        if (inStart == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = inOrderMap.get(currentNum);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.right = buildTreePostOrder(post, inIndex + 1, inEnd);
        tNode.left = buildTreePostOrder(post, inStart, inIndex - 1);

        return tNode;
    }

    public static NodeExt connect(NodeExt root) {
        if (root == null)
            return root;

        Queue<NodeExt> queue = new LinkedList<>();
        Deque<NodeExt> stackHelper = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int  i=0; i<size; i++){
                NodeExt node = queue.poll();
                stackHelper.push(node);

                if (node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            NodeExt next = null;
            for (int  i=0; i<size; i++){
                NodeExt node = stackHelper.pop();
                node.next = next;
                next = node;
            }
        }

        return root;
    }

    public static NodeExt connect2(NodeExt root) {
        if (root == null)
            return root;

        Queue<NodeExt> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            NodeExt next = null;
            for (int  i=0; i<size; i++){
                NodeExt node = queue.poll();
                node.next = next;
                next = node;

                if(node.right != null){
                    queue.offer(node.right);
                }

                if (node.left != null){
                    queue.offer(node.left);
                }
            }
        }

        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        search(root, p.val, q.val);
        return result;
    }

    private static TreeNode result = null;
    private static boolean nodeFound = false;
    private static ArrayList<Integer> search(TreeNode node, int pval, int qval){
        if (node == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> list = new ArrayList();
        list.addAll(search(node.left, pval, qval));
        list.addAll(search(node.right, pval, qval));
        list.add(node.val);

        if (!nodeFound){
            boolean hasP = false;
            boolean hasQ = false;
            for (Integer integer: list){
                if (integer == pval)
                    hasP = true;
                if (integer == qval)
                    hasQ = true;
                if (hasP && hasQ){
                    result = node;
                    nodeFound = true;
                    break;
                }
            }
        }
        return list;
    }

    private static HashMap<Integer, TreeNode> mapParentChild = new HashMap<>();
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (p == q)
            return p;

        fillParent(root, null);

        TreeNode parent1 = mapParentChild.get(p.val);
        TreeNode parent2 = mapParentChild.get(q.val);
        if(parent1 != null && parent2 != null
                && parent1.val == parent2.val){
            return parent1;
        }
        if (parent2 != null && p.val == parent2.val)
            return p;
        if (parent1 != null && q.val == parent1.val)
            return q;
        List<Integer> list = new ArrayList<>();
        list.add(p.val);
        list.add(q.val);
        if (parent1 != null) list.add(parent1.val);
        if (parent2 != null) list.add(parent2.val);

        TreeNode result = null;
        while(parent1 != null || parent2 != null){
            if (parent1 != null){
                parent1 = mapParentChild.get(parent1.val);
                if (parent1 != null){
                    if (list.contains(parent1.val)){
                        result = parent1;
                        break;
                    }
                    list.add(parent1.val);
                }
            }
            if (parent2 != null){
                parent2 = mapParentChild.get(parent2.val);
                if (parent2 != null){
                    if (list.contains(parent2.val)){
                        result = parent2;
                        break;
                    }
                    list.add(parent2.val);
                }
            }

        }

        return result;
    }

    public static void fillParent(TreeNode node, TreeNode parent){
        if (node == null){
            return;
        }

        mapParentChild.put(node.val, parent);
        fillParent(node.left, node);
        fillParent(node.right, node);
    }

    //Inorder Tree Traversal without Recursion (Stack)
    /*
    1) Create an empty stack S.
    2) Initialize current node as root
    3) Push the current node to S and set current = current->left until current is NULL
    4) If current is NULL and stack is not empty then
        a) Pop the top item from stack.
        b) Print the popped item, set current = popped_item->right
        c) Go to step 3.
    5) If current is NULL and stack is empty then we are done.

    Time Complexity: O(n)
    Space Complexity: O(n)
    */
    public static void inOrderWithoutRecursion(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || stack.size() > 0) {

            /* Reach the left most Node of the curr Node */
            while (curr != null) {
                /* place pointer to a tree node on the stack before traversing the node's left subtree */
                stack.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = stack.pop();

            System.out.print(curr.val + " ");

            /* we have visited the node and its left subtree. Now, it's right subtree's turn. */
            curr = curr.right;
        }
    }

    //Lowest Common Ancestor in a Binary Tree 1
    /*
        1. Find a path from the root to n1 and store it in a vector or array.
        2. Find a path from the root to n2 and store it in another vector or array.
        3. Traverse both paths till the values in arrays are the same. Return the common element just before the mismatch.

        Time Complexity: O(n)
    */
    private static List<TreeNode> path1 = new ArrayList<>();
    private static List<TreeNode> path2 = new ArrayList<>();
    public static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {

        path1.clear();
        path2.clear();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return null;
        }

        int i;
        for (i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    private static boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null)
            return false;

        // Store this node. The node will be removed if not in path from root to n.
        path.add(root);

        if (root.val == node.val)
            return true;

        if (root.left != null && findPath(root.left, node, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, node, path)) {
            return true;
        }

        // If not present in subtree rooted with root, remove root from path[] and return false
        path.remove(path.size() - 1);

        return false;
    }

    //Lowest Common Ancestor in a Binary Tree 2
    //Time Complexity: O(n)

    public static TreeNode findLCAv2(TreeNode node, int n1, int n2) {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.val == n1 || node.val == n2)
            return node;

        // Look for keys in left and right subtrees
        TreeNode leftLCA = findLCAv2(node.left, n1, n2);
        TreeNode rightLCA = findLCAv2(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (leftLCA != null && rightLCA != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static String preOrderTraversalString(TreeNode node) {
        res.clear();
        List<Integer> list = preorderTraversal(node);
        return list != null ? list.toString() : "";
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