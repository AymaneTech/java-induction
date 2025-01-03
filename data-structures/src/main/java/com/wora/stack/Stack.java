package com.wora.stack;

public interface Stack<T> {
    void push(T item);

    T pop();

    int size();

    T peek();

    boolean isFull();

    boolean isEmpty();
}
