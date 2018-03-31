package com.khambay.alg.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time and Space - O(n) - n is number nodes
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.data == t2.data)
                && isMirror(t1.right, t2.left)  //compare right of t1 to left of t2 first, otherwise it will go over entire tree 2 times
                && isMirror(t1.left, t2.right);
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.data != t2.data) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 4, 3};
        TreeNode tree = TreeNode.createMinimalBST(arr);
        System.out.println("Tree {3, 4, 2, 1, 2, 4, 3} is Symmetric Recursive = " + isSymmetric(tree));
        System.out.println("Tree {3, 4, 2, 1, 2, 4, 3} is Symmetric Iterative = " + isSymmetricIterative(tree));

        int[] arr1 = {3, 4, 2, 1, 2, 4, 4};
        TreeNode tree1 = TreeNode.createMinimalBST(arr1);
        System.out.println("Tree {3, 4, 2, 1, 2, 4, 4} is Symmetric Recursive = " + isSymmetric(tree1));
        System.out.println("Tree {3, 4, 2, 1, 2, 4, 4} is Symmetric Iterative = " + isSymmetricIterative(tree1));
    }
}
