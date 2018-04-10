package com.khambay.alg.trees;

/**
 * Time - O(n^2) with the for loop
 */
public class BinaryTreeFromPreorderInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        //b ase case
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        //create root from preorder list
        TreeNode root = new TreeNode(preorder[preStart]);

        //find Index of current root in inorder list
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.data) {
                inIndex = i;
            }
        }

        //get offset to right side
        int offset = inIndex - inStart;
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + 1 + offset, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = buildTree(preorder, inorder);
        System.out.println("Tree =" + tree);
    }
}
