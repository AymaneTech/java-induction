package com.wora.stack;

import com.wora.stack.exception.StackOverflow;
import com.wora.stack.exception.StackUnderflow;
import com.wora.utils.Utils;

public class DefaultStack<T> implements Stack<T> {
    private static final int RESIZING_FACTOR = 2;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private final boolean isDynamic;
    private T[] items;
    private int capacity;
    private int top;


    public DefaultStack(int capacity) {
        this(capacity, false);
    }

    public DefaultStack() {
        this(DEFAULT_INITIAL_CAPACITY, true);
    }

    @SuppressWarnings("unchecked")
    private DefaultStack(int capacity, boolean isDynamic) {
        Utils.positive(capacity, "Capacity must be positive");

        this.isDynamic = isDynamic;
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T item) {
        Utils.notNull(item, "Null elements are not allowed here!");
        if (isFull()) {
            if (isDynamic)
                resize();
            else
                throw new StackOverflow("stack overflow");
        }

        items[++top] = item;
    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackUnderflow("stack underflow");
        }
        T item = items[top];
        items[top--] = null;
        return item;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new StackUnderflow("stack underflow");
        }
        return items[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isFull() {
        return top == items.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newSize = capacity * RESIZING_FACTOR;
        T[] newArr = (T[]) new Object[newSize];

        for (int i = 0; i < capacity; i++) {
            newArr[i] = items[i];
        }
        capacity = newSize;
        items = newArr;
    }
}
