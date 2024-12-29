package com.wora.binarytree;

public class DefaultBinaryTree implements BinaryTree {
    private Node root;

    @Override
    public boolean accept(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        return root.accept(value);
    }

    @Override
    public int depth(int value) {
        return findDepth(root, value, 0);
    }

    private int findDepth(Node node, int value, int currentDepth) {
        if (root == null)
            return -1;

        if (root.data == value)
            return currentDepth;

        if (node.data > value)
            return findDepth(node.right, value, currentDepth + 1);

        return findDepth(node.left, value, currentDepth + 1);
    }

    @Override
    public int treeDepth() {
        return (root != null) ? calculateDepth(root) : 0;
    }

    private int calculateDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    private class Node {
        final int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }

        /*
         * refactored version
         */
        public boolean accept(int value) {
            if (this.data == value) {
                return false;
            }
            Node child = value > this.data ? right : left;
            if (child == null) {
                if (value > this.data)
                    right = new Node(value);

                if (value < this.data)
                    left = new Node(value);

                return true;
            }
            return child.accept(value);
        }

        /*
         * first version
         */
        public boolean _accept(int value) {
            if (this.data == value) {
                return false;
            } else if (value > this.data) {
                if (right == null) {
                    right = new Node(value);
                    return true;
                } else {
                    return right.accept(value);
                }
            } else {
                if (left == null) {
                    left = new Node(value);
                    return true;
                } else {
                    return left.accept(value);
                }
            }
        }
    }
}