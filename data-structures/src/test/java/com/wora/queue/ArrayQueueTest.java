package com.wora.queue;

import com.wora.queue.exception.QueueEmptyException;
import com.wora.queue.exception.QueueFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    private Queue<String> underTest;

    @BeforeEach
    void setup() {
        underTest = new ArrayQueue<>();
    }

    @Test
    void givenNewQueue_whenCreated_thenShouldBeEmpty() {
        assertTrue(underTest.isEmpty());
        assertEquals(0, underTest.size());
    }

    @Test
    void givenEmptyQueue_whenEnqueue_thenShouldNotBeEmpty() {
        underTest.enqueue("test");
        assertFalse(underTest.isEmpty());
        assertEquals(1, underTest.size());
    }

    @Test
    void givenEmptyQueue_whenDequeue_thenShouldThrowQueueEmptyException() {
        assertThrows(QueueEmptyException.class, () -> underTest.dequeue());
    }

    @Test
    void givenOneEnqueueAndOneDequeue_whenExecuted_thenQueueShouldBeEmpty() {
        underTest.enqueue("test");
        assertEquals("test", underTest.dequeue());
        assertTrue(underTest.isEmpty());
    }

    @Test
    void givenDynamicQueue_whenEnqueuedBeyondInitialCapacity_thenShouldResize() {
        int queueSize = 11;
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < queueSize; i++) {
            queue.enqueue(i + 1);
        }
        assertFalse(queue.isEmpty());
        assertEquals(queueSize, queue.size());
    }

    @Test
    void givenStaticQueue_whenExceedsCapacity_thenShouldThrowQueueFullException() {
        int queueSize = 10;
        Queue<Integer> queue = new ArrayQueue<>(queueSize);
        for (int i = 0; i < queueSize; i++) {
            queue.enqueue(i + 1);
        }
        assertThrows(QueueFullException.class, () -> queue.enqueue(11));
    }

    @Test
    void givenNonEmptyQueue_whenPeek_thenShouldReturnFirstElementWithoutRemoving() {
        underTest.enqueue("first");
        underTest.enqueue("second");

        assertEquals("first", underTest.peek());
        assertEquals(2, underTest.size());
    }

    @Test
    void givenMultipleOperations_whenExecuted_thenShouldMaintainFIFOOrder() {
        underTest.enqueue("first");
        underTest.enqueue("second");
        underTest.enqueue("third");

        assertEquals("first", underTest.dequeue());
        assertEquals("second", underTest.dequeue());
        assertEquals("third", underTest.dequeue());
        assertTrue(underTest.isEmpty());
    }
}