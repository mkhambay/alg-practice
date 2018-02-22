package com.khambay.alg.trees;


import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public void insertInOrder(int d) {
        if(d <= data) {
            if(left == null) {
                setLeftChild(new TreeNode(d));
            }
            else {
                left.insertInOrder(d);
            }
        }
        else {
            if(right == null) {
                setRightChild(new TreeNode(d));
            }
            else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public TreeNode find(int d) {
        if(d == data) {
            return this;
        }
        else if(d <= data) {
            return left != null ? left.find(d): null;
        }
        else if(d > data) {
            return right != null ? right.find(d): null;
        }
        return null;
    }

    public void setLeftChild(TreeNode left) {
        this.left = left;
        if(left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
        if(right != null) {
            right.parent = this;
        }
    }

    //Traversal
    public void inOrderTraversal(TreeNode node) {
        if(node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if(node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if(node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    public boolean isBST() {
        if (left != null) {
            if (data < left.data || !left.isBST()) {
                return false;
            }
        }

        if (right != null) {
            if (data >= right.data || !right.isBST()) {
                return false;
            }
        }

        return true;
    }

    public void visit(TreeNode node) {
        System.out.print(node.data + " ");
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //4.2 Create minimal BST
    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    public static TreeNode createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeftChild(createMinimalBST(arr, start, mid - 1));
        n.setRightChild(createMinimalBST(arr, mid + 1, end));
        return n;
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedListDFSPreOrder(root, lists, 0);
        return lists;
    }

    //4.3 List of depths
    public static void createLevelLinkedListDFSPreOrder(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if(root == null) {
            return;
        }

        LinkedList<TreeNode> list = null;
        if(lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        }
        else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedListDFSPreOrder(root.left, lists, level + 1);
        createLevelLinkedListDFSPreOrder(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null) {
            current.add(root);
        }

        while(current.size() != 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for(TreeNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }


    //4.4 Is Balanced
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //4.5 Check BST
    public static Integer lastVisitedNode = null;

    //Solution 1:
    //If left is true, the left child value can be equal to parent
    public static boolean checkBST(TreeNode node) {
        return checkBSTInOrderTraversal(node, true);
    }

    public static boolean checkBSTInOrderTraversal(TreeNode n, boolean isLeft) {
        if (n == null) {
            return true;
        }

        //Check left node recursively
        if (!checkBSTInOrderTraversal(n.left, true)) {
            return false;
        }

        //Visit current node and compare value to the last visited node
        if (lastVisitedNode != null) {
            if (isLeft) {
                if (n.data < lastVisitedNode) {
                    return false;
                }
            } else {
                if (n.data <= lastVisitedNode) {
                    return false;
                }
            }
        }
        lastVisitedNode = n.data;

        //Check right node recursively
        if (!checkBSTInOrderTraversal(n.right, false)) {
            return false;
        }
        return true;
    }

    //Solution 2
    public static boolean checkBSTSolution2(TreeNode n) {
        return checkBST(n, null, null);
    }

    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) ||
                !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    //4.6 Successor
    public static TreeNode inorderSucc(TreeNode n) {
        if (n == null) {
            return null;
        }

        // Found right children -> return left most node of right subtree
        if (n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        }
        else {
            TreeNode q = n;
            TreeNode x = q.parent;
            // Go up until we�re on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public static TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    //4.8 First Common Ancestor
    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q); // get difference in depths
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta)); // move shallower node to depth of deeper
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    public static TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    public static int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    //4.10 Check Subtree
    //Solution 1
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    public static void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");             // Add null indicator
            return;
        }
        sb.append(node.data);           // Add root
        getOrderString(node.left, sb);  // Add left
        getOrderString(node.right, sb); // Add right
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println("Preorder traversal");
        tree.preOrderTraversal(tree);

        System.out.println("\nInorder traversal");
        tree.inOrderTraversal(tree);

        System.out.println("\nPostorder traversal");
        tree.postOrderTraversal(tree);

        //Insert
        System.out.println("\nInsert 6");
        tree.insertInOrder(6);
        tree.preOrderTraversal(tree);

        System.out.println("\nInsert 8");
        tree.insertInOrder(8);
        tree.preOrderTraversal(tree);

        System.out.println("\n Find 6");
        TreeNode t = tree.find(6);
        System.out.println("TreeNode Data=" + t.data);

        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode treeMinBST = createMinimalBST(arr);
        System.out.println("Tree=" + treeMinBST);

        System.out.println("createLevelLinkedListDFS");
        ArrayList<LinkedList<TreeNode>> levelLinkedListsDFS = createLevelLinkedListDFS(treeMinBST);

        System.out.println("createLevelLinkedListBFS");
        ArrayList<LinkedList<TreeNode>> levelLinkedListsBFS = createLevelLinkedListBFS(treeMinBST);


        TreeNode root = TreeNode.createMinimalBST(arr);
        System.out.println("Is balanced? " + isBalanced(root));

        root.insertInOrder(11); // Add 4 to make it unbalanced
        System.out.println("Is balanced? " + isBalanced(root));

        TreeNode node;
        boolean condition;
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        lastVisitedNode = null;
        condition = checkBST(node);
        System.out.println("should be true: " + condition);
        condition = checkBSTSolution2(node);
        System.out.println("should be true: " + condition);

        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        lastVisitedNode = null;
        condition = checkBST(node);
        System.out.println("should be false: " + condition);
        condition = checkBSTSolution2(node);
        System.out.println("should be false: " + condition);

        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root1 = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node1 = root1.find(array[i]);
            TreeNode next = inorderSucc(node1);
            if (next != null) {
                System.out.println(node1.data + "->" + next.data);
            } else {
                System.out.println(node1.data + "->" + null);
            }
        }

        TreeNode root2 = TreeNode.createMinimalBST(array);
        TreeNode n3 = root2.find(3);
        TreeNode n7 = root2.find(7);
        TreeNode ancestor = commonAncestor(n3, n7);
        System.out.println(ancestor.data);

        // t2 is a subtree of t1
        int[] array10 = {1,2,3,4,5,6,7,8,9};
        int[] array20 = {6,7,8,9};

        TreeNode t1 = TreeNode.createMinimalBST(array10);
        TreeNode t2 = TreeNode.createMinimalBST(array20);

        if (containsTree(t1, t2)) {
            System.out.println("t2 is a subtree of t1");
        } else {
            System.out.println("t2 is not a subtree of t1");
        }
    }
}

