package com.maria.trees.avltree;

import com.maria.trees.TreeNode;

public class AVLTree {

    public AVLNode root;

    // A utility function to get the height of a node
    private int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    private AVLNode rightRotate(AVLNode z) {
        AVLNode y = z.left;
        AVLNode T2 = y.right;

        // Perform rotation
        y.right = z;
        z.left = T2;

        // Update heights
        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    private AVLNode leftRotate(AVLNode z) {
        AVLNode y = z.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = z;
        z.right = T2;

        //  Update heights
        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of a node
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    public AVLNode insert(AVLNode node, int key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode(key));

        if (key < node.val)
            node.left = insert(node.left, key);
        else if (key > node.val)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(height(node.left), height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        //here it may fail if node.left == null
        if (balance > 1 && key < node.left.val)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.val)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void inOrderTraversal(AVLNode root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.print(root.val + " ");

        inOrderTraversal(root.right);
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    public AVLNode deleteNode(AVLNode root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.val)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.val)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp;
                if (root.left == null)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                AVLNode temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.val = temp.val;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.val);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

}
