package com.khambay.alg.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.khambay.alg.trees.TreeNode.createMinimalBST;

/**
 * PreOrder Traversal
 * Time and Space - O(n) - worst if tree is linear (height of tree)
 */
public class Codec {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
            return;
        }
        sb.append(node.data).append(spliter);
        buildString(node.left, sb);
        buildString(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(); //Queue to store the pre-order traversal
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();

        if (val.equals(NN)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode root = createMinimalBST(arr);
        Codec codec = new Codec();
        String treeString = codec.serialize(root);
        System.out.println("Tree String = " + treeString);
        codec.deserialize(treeString);
    }
}
