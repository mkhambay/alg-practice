package com.khambay.alg.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /**
     * Time and Space - O(n)
     */
    public static List<List<Integer>> levelOrderBFSQueue(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()){
            int nodes = queue.size();
            List<Integer> levelNodes = new LinkedList<>();

            //go through all the nodes on the level
            for(int i = 0; i < nodes; i++) {
                TreeNode current = queue.poll();
                levelNodes.add(current.data);

                //enqueue the next level for eval
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

    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelHelper(root, result, 0);
        return result;
    }

    public static void levelHelper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        result.get(level).add(root.data);
        levelHelper(root.left, result, level + 1);
        levelHelper(root.right, result, level + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode treeMinBST = TreeNode.createMinimalBST(arr);
        System.out.println("Tree=" + treeMinBST);

        List<List<Integer>> result1 = levelOrderBFSQueue(treeMinBST);
        System.out.println("Result Queue based = " + result1);

        List<List<Integer>> result2 = levelOrderDFS(treeMinBST);
        System.out.println("Result DFS based = " + result2);
    }
}
