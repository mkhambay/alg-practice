package com.khambay.alg.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time and Space - O(n)
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for(int i = 0; i < nodes; i++) {
                TreeNode current = queue.poll();

                if(result.size() % 2 == 0) {
                    levelNodes.add(current.data);
                }
                else {
                    levelNodes.add(0, current.data); //adds always at beginning of ArrayList, creating a reverse list
                }

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(levelNodes);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode treeMinBST = TreeNode.createMinimalBST(arr);
        System.out.println("Tree=" + treeMinBST);

        List<List<Integer>> result1 = zigzagLevelOrder(treeMinBST);
        System.out.println("Result = " + result1);
    }
}
