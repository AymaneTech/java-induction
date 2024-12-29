package com.wora.queue;

import com.wora.queue.exception.QueueEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {
    private Queue<String> underTest;

    @BeforeEach
    void setup() {
        underTest = new LinkedListQueue<>();
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
    void givenEmptyQueue_whenPeek_thenShouldThrowQueueEmptyException() {
        assertThrows(QueueEmptyException.class, () -> underTest.peek());
    }

    @Test
    void givenOneEnqueueAndOneDequeue_whenExecuted_thenQueueShouldBeEmpty() {
        underTest.enqueue("test");
        String result = underTest.dequeue();
        assertEquals("test", result);
        assertTrue(underTest.isEmpty());
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

    @Test
    void givenNonEmptyQueue_whenPeek_thenShouldReturnFirstElementWithoutRemoving() {
        underTest.enqueue("first");
        underTest.enqueue("second");

        assertEquals("first", underTest.peek());
        assertEquals(2, underTest.size());
    }

    @Test
    void givenEnqueueAfterDequeue_whenExecuted_thenShouldMaintainCorrectOrder() {
        underTest.enqueue("first");
        underTest.enqueue("second");
        assertEquals("first", underTest.dequeue());

        underTest.enqueue("third");
        assertEquals("second", underTest.peek());
        assertEquals(2, underTest.size());
    }

    @Test
    void givenDequeueToEmpty_whenEnqueue_thenShouldWorkCorrectly() {
        underTest.enqueue("first");
        underTest.dequeue();
        underTest.enqueue("second");

        assertEquals("second", underTest.peek());
        assertEquals(1, underTest.size());
    }
}