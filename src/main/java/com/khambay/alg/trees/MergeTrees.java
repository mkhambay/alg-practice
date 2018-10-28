package com.khambay.alg.trees;

/**
 * Time - O(n)
 * Space - O(n)
 */
public class MergeTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }

        if(t1 == null) {
            return t2;
        }

        if(t2 == null) {
            return t1;
        }

        t1.data += t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        TreeNode t1 = TreeNode.createMinimalBST(arr);

        int[] arr1 = {1,2};
        TreeNode t2 = TreeNode.createMinimalBST(arr);

        TreeNode merged = mergeTrees(t1, t2);
        System.out.println("Tree merged");
    }
}
