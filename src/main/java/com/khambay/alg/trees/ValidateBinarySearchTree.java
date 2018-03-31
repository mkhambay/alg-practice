package com.khambay.alg.trees;

/**
 * Time - O(n) and Space - O(n) worst if tree is linear (height of tree)
 */
public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    private static boolean checkBST(TreeNode root, Integer min, Integer max) {
        //base case
        if(root == null) {
            return true;
        }

        if((min != null && root.data <= min) || //right side - cannot be equal to root
                (max != null && root.data >= max)) { //left side - cannot be equal to root
            return false;
        }

        if(!checkBST(root.left, min, root.data) ||
                !checkBST(root.right, root.data, max)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        TreeNode tree = TreeNode.createMinimalBST(arr);
        System.out.println("Is BST = " + isValidBST(tree));

        int[] arr1 = {1, 2, 3, 4};
        TreeNode tree1 = TreeNode.createMinimalBST(arr1);
        System.out.println("Is BST = " + isValidBST(tree1));
    }
}
