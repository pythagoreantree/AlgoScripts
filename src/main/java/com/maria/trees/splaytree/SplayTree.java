package com.maria.trees.splaytree;

import com.maria.trees.TreeNode;

public class SplayTree {


    private static TreeNode rightRotate(TreeNode z) {
        TreeNode y = z.left;
        z.left = y.right;
        y.right = z;
        return y;
    }

    // A utility function to left rotate subtree rooted with z
    private static TreeNode leftRotate(TreeNode z) {
        TreeNode y = z.right;
        z.right = y.left;
        y.left = z;
        return y;
    }

    private TreeNode search(TreeNode root, Integer key) {
        // Base cases: root is null or
        // key is present at root
        if (root == null || root.val == key)
            return root;

        // Key lies in left subtree
        if (root.val > key) {
            // Key is not in tree, we are done
            if (root.left == null) return root;

            // Zig-Zig (Left Left)
            if (root.left.val > key) {
                // First recursively bring the
                // key as root of left-left
                root.left.left = search(root.left.left, key);

                // Do first rotation for root,
                // second rotation is done after else
                root = rightRotate(root);

            } else if (root.left.val < key) /* Zig-Zag (Left Right)*/  {
                // First recursively bring
                // the key as root of left-right
                root.left.right = search(root.left.right, key);

                // Do first rotation for root.left
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }

            // Do second rotation for root
            return (root.left == null) ? root : rightRotate(root);

        } else /* Key lies in right subtree*/ {
            // Key is not in tree, we are done
            if (root.right == null) return root;

            // Zag-Zig (Right Left)
            if (root.right.val > key) {
                // Bring the key as root of right-left
                root.right.left = search(root.right.left, key);

                // Do first rotation for root.right
                if (root.right.left != null)
                    root.right = rightRotate(root.right);

            } else if (root.right.val < key)/* Zag-Zag (Right Right)*/ {
                // Bring the key as root of
                // right-right and do first rotation
                root.right.right = search(root.right.right, key);
                root = leftRotate(root);
            }

            // Do second rotation for root
            return (root.right == null) ?
                    root : leftRotate(root);
        }
    }

    // Function to insert a new key k
    // in splay tree with given root
    private TreeNode insert(TreeNode root, Integer k) {
        // Simple Case: If tree is empty
        if (root == null) return new TreeNode(k);

        // Bring the closest leaf node to root
        root = search(root, k);

        // If key is already present, then return
        if (root.val == k) return root;

        // Otherwise allocate memory for new node
        TreeNode newNode = new TreeNode(k);

        // If root's key is greater, make
        // root as right child of newnode
        // and copy the left child of root to newnode
        if (root.val > k) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            // If root's key is smaller, make
            // root as left child of newnode
            // and copy the right child of root to newnode
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }

        return newNode; // newnode becomes new root
    }

    public TreeNode remove(TreeNode root, Integer key) {

        if (root == null)
            return null;

        // Splay the given key
        root = search(root, key);

        // If key is not present, then
        // return root
        Comparable<Integer> rootKey = (Comparable) root.val;
        if (rootKey == null && key == null)
            return root;
        if (rootKey.compareTo(key) != 0)
            return root;

        // If key is present
        // If left child of root does not exist
        // make root.right as root
        if (root.left == null)
            return root.right;

        // Else if left child exits
        TreeNode temp = root;
        /*Note: Since key == root.key,
        so after Splay(key, root.lchild),
        the tree we get will have no right child tree
        and maximum node in left subtree will get splayed*/
        // New root
        root = search(root.left, key);

        // Make right child of previous root as
        // new root's right child
        root.right = temp.right;

        // return root of the new Splay Tree
        return root;
    }
}
