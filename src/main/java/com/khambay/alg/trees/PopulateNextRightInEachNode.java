package com.khambay.alg.trees;

/**
 * Time - O(n)
 * Space - O(n) worst if tree is linear (height of tree)
 */
public class PopulateNextRightInEachNode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

    public static void main(String[] args) {
        TreeLinkNode tree = new TreeLinkNode(1);
        tree.left = new TreeLinkNode(2);
        tree.right = new TreeLinkNode(3);
        tree.left.left = new TreeLinkNode(4);
        tree.left.right = new TreeLinkNode(5);
        tree.right.left = new TreeLinkNode(6);
        tree.right.right = new TreeLinkNode(7);

        connect(tree);
        System.out.println("Next of 2 = " + tree.left.next.val);
    }
}
