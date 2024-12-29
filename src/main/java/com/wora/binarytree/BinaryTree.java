package com.wora.binarytree;

public interface BinaryTree {

    boolean accept(int value);

    int depth(int value);
    
    int treeDepth();
}
