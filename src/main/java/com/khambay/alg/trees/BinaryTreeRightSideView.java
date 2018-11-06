package com.khambay.alg.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Time and Space - O(n)
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode curr, List<Integer> result, int level){
        if(curr == null) {
            return;
        }

        if(level == result.size()) { //this will prevent left and also right of 2 -> 5 to get added to the list
            result.add(curr.data);
        }

        rightView(curr.right, result, level + 1); //right first all the way down to null will fill out result and levels
        rightView(curr.left, result, level + 1);

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(root);
        System.out.println("Result = " + result);

        TreeNode root1 = new TreeNode(1);
        root.left = new TreeNode(2);
        List<Integer> result1 = rightSideView(root1);
        System.out.println("Result 1 = " + result1);
    }
}
