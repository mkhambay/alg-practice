package com.khambay.alg.trees;


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

    public void visit(TreeNode node) {
        System.out.print(node.data + " ");
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
    }
}

