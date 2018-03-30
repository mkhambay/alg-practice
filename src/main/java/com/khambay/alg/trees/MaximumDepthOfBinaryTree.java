package com.khambay.alg.trees;

/**
 * Time and Space - O(n)
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //get the height of the tree
        return getTreeHeight(root);

    }

    public static int getTreeHeight(TreeNode root) {
        int leftHeight = root.left != null ? getTreeHeight(root.left): 0;
        int rightHeight = root.right != null ? getTreeHeight(root.right): 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        TreeNode tree = TreeNode.createMinimalBST(arr);
        System.out.println("Max Depth = " + maxDepth(tree));
    }
}
