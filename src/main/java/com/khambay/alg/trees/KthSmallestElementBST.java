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
        findKthSmallestDFSInOrder(root, result);
        return result.number;
    }

    public static void findKthSmallestDFSInOrder(TreeNode root, Result result) {
        //base case
        if(root == null || result.count < 0) { //As soon as a match is found, it will exit with the check
                                                // for result.count < 0 and not go over rest of the Tree
            return;
        }

        //go left
        findKthSmallestDFSInOrder(root.left, result);

        //visit root
        result.count--;
        if(result.count == 0) { //found match
            result.number = root.data;
            return;
        }

        //go right
        findKthSmallestDFSInOrder(root.right, result);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode treeMinBST = TreeNode.createMinimalBST(arr);
        System.out.println("2nd smallest = " + kthSmallest(treeMinBST, 4));
        System.out.println("2nd smallest = " + kthSmallest(treeMinBST, 7));
    }
}
