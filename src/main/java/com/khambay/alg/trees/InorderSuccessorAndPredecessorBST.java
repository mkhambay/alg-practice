package com.khambay.alg.trees;

/**
 * Time and Space - O(n)??
 */
public class InorderSuccessorAndPredecessorBST {

    public static TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.data <= p.data) { //if node matches root, based on in order we go for right as the successor
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
            //in order successor - left null, return the next -> root
            //left is not null when we searching on the right side of the tree
            //ex 5 -> 6 (left is 6)
        }
    }

    public static TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.data >= p.data) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2};
        int[] arr1 = {1};
        TreeNode tree = TreeNode.createMinimalBST(arr);
        TreeNode tree1 = TreeNode.createMinimalBST(arr1);
        TreeNode successor = successor(tree, tree1);
        System.out.println("Successor = " + successor);
        if(successor != null) {
            System.out.println("successor val = " + successor.data);
        }

        System.out.println("In Order successor");
        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root1 = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node1 = root1.find(array[i]);
            TreeNode next = successor(root1, node1);
            if (next != null) {
                System.out.println(node1.data + "->" + next.data);
            } else {
                System.out.println(node1.data + "->" + null);
            }
        }

        System.out.println("In Order predecessor");
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        TreeNode root2 = TreeNode.createMinimalBST(array1);
        for (int i = 0; i < array1.length; i++) {
            TreeNode node2 = root2.find(array1[i]);
            TreeNode next = predecessor(root2, node2);
            if (next != null) {
                System.out.println(node2.data + "->" + next.data);
            } else {
                System.out.println(node2.data + "->" + null);
            }
        }
    }
}
