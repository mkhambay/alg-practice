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

    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
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
    }
}

