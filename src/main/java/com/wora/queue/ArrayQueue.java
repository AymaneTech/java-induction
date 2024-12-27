package com.wora.queue;

import com.wora.queue.exception.QueueEmptyException;
import com.wora.queue.exception.QueueFullException;

public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final int RESIZING_FACTOR = 2;

    private final boolean isDynamic;
    private T[] items;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY, true);
    }

    public ArrayQueue(int capacity) {
        this(capacity, false);
    }

    @SuppressWarnings("unchecked")
    private ArrayQueue(int capacity, boolean isDynamic) {
        this.items = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.isDynamic = isDynamic;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == capacity) {
            if (isDynamic)
                resize();
            else
                throw new QueueFullException("Queue is full");

        }

        rear++;
        items[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new QueueEmptyException("Queue is empty");

        T item = items[front];
        items[front] = null;
        front++;
        size--;
        return item;
    }

    @Override
    public T peek() {
        return items[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newSize = capacity + DEFAULT_INITIAL_CAPACITY;
        T[] newArr = (T[]) new Object[newSize];

        for (int i = 0; i < capacity; i++) {
            newArr[i] = items[i];
        }
        capacity = newSize;
        items = newArr;
    }
}