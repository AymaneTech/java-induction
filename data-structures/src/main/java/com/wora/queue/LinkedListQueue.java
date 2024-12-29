package com.wora.queue;

import com.wora.queue.exception.QueueEmptyException;

public class LinkedListQueue<T> implements Queue<T> {
    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new QueueEmptyException("Queue is empty");
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new QueueEmptyException("Queue is empty");

        return front.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
