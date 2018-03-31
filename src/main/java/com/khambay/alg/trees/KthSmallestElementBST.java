package com.khambay.alg.trees;

/**
 * Time - O(n) and Space - O(n) worst if tree is linear (height of tree)
 */
public class KthSmallestElementBST {

    private static class Result {
        int number = 0;
        int count = 0;
    }

    public static int kthSmallest(TreeNode root, int k) {
        Result result = new Result();
        result.count = k;
        findKthSmallestDFS(root, result);
        return result.number;
    }

    public static void findKthSmallestDFS(TreeNode root, Result result) {
        //base case
        if(root == null || result.count < 0) {
            return;
        }

        //go left
        findKthSmallestDFS(root.left, result);

        result.count--;
        if(result.count == 0) { //found match
            result.number = root.data;
            return;
        }

        //go right
        findKthSmallestDFS(root.right, result);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode treeMinBST = TreeNode.createMinimalBST(arr);
        System.out.println("2nd smallest = " + kthSmallest(treeMinBST, 4));
        System.out.println("2nd smallest = " + kthSmallest(treeMinBST, 7));
    }
}
