package com.khambay.alg.trees;

/**
 * Time - O(n)
 * Space - O(n) worst if tree is linear (height of tree)
 */
public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        return left == null ? right : right == null ? left : root;

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode treeMinBST = TreeNode.createMinimalBST(arr);
        TreeNode p = treeMinBST.find(6);
        TreeNode q = treeMinBST.find(2);
        TreeNode result = lowestCommonAncestor(treeMinBST, p, q);
        System.out.println("Result = " + result.data);
    }
}
