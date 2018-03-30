package com.khambay.alg.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    /**
     * Time complexity : O(n). The time complexity is O(n)
     * because the recursive function is T(n) = 2*T(n/2)+1
     *
     * Space complexity : The worst case space required is O(n),
     * and in the average case it's O(log(n)) where n is number of nodes
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root != null) {
            inorderTraversal(root.left, result);
            result.add(root.data);
            inorderTraversal(root.right, result);
        }
    }

    /**
     * Time and Space - O(n)
     */
    public static List <Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) { //curr can be null when bottom is reached and right is empty

            //Keep going left
            while (curr != null) { //this will be skipped when right is null
                stack.push(curr); //root gets added here first
                curr = curr.left;
            }
            curr = stack.pop(); //with stack last one comes out first. Incase of right null, the root is visited
            res.add(curr.data); //at the very bottom, its the last left node
            curr = curr.right; //at the very bottom, this will be null
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        TreeNode tree = TreeNode.createMinimalBST(arr);
        List<Integer> result = inorderTraversal(tree);
        System.out.println("Result=" + result);
        System.out.println("Result Iterative = " + inorderTraversalIterative(tree));
    }
}
