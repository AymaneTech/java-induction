package com.wora;

import com.wora.binarytree.BinaryTree;
import com.wora.binarytree.DefaultBinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new DefaultBinaryTree();

        tree.accept(8);

        System.out.println(tree.accept(3));
    }

}