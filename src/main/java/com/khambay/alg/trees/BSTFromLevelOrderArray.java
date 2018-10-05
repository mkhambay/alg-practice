package com.khambay.alg.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BSTFromLevelOrderArray {

    public static TreeNode constructTree(int[] nums) {
        if(nums == null || nums.length < 1) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(nums[0]);
        queue.add(node);

        int i = 0;
        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;

            if(leftIndex < nums.length && rightIndex < nums.length) {
                TreeNode left = new TreeNode(nums[leftIndex]);
                TreeNode right = new TreeNode(nums[rightIndex]);
                n.left = left;
                n.right = right;
                queue.add(left);
                queue.add(right);
            }
            i++;
        }

        return node;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 9, 2, 4, 8, 10};
        TreeNode tree = constructTree(nums);
    }
}
