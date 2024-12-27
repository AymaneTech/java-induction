package com.wora.stack;

import com.wora.stack.exception.StackOverflow;
import com.wora.stack.exception.StackUnderflow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultStackTest {
    private Stack<String> underTest;

    @BeforeEach
    void setup() {
        underTest = new DefaultStack<>();
    }

    @Test
    void givenNewStack_whenCreated_thenShouldBeEmpty() {
        assertTrue(underTest.isEmpty());
    }

    @Test
    void givenNonEmptyStack_whenPush_thenShouldNotBeEmpty() {
        underTest.push("hello world");
        assertFalse(underTest.isEmpty());
    }

    @Test
    void givenEmptyStack_whenPop_thenShouldThrowStackUnderflowException() {
        assertThrows(StackUnderflow.class, underTest::pop);
    }

    @Test
    void givenOnePushAndOnePop_whenExecuted_thenStackShouldBeEmpty() {
        underTest.push("hello world");
        underTest.pop();
        assertTrue(underTest.isEmpty());
    }

    @Test
    void givenDynamicStack_whenPushedBeyondInitialCapacity_thenShouldResize() {
        int stackSize = 11;
        Stack<Integer> stack = new DefaultStack<>();
        for (int i = 0; i < stackSize; i++) {
            stack.push(i + 1);
        }
        assertFalse(stack.isEmpty());
        assertEquals(stackSize, stack.size());
    }

    @Test
    void givenDynamicStack_whenPop_thenShouldReturnLastElementAndUpdateSize() {
        int stackSize = 11;
        Stack<Integer> stack = new DefaultStack<>();
        for (int i = 0; i < stackSize; i++) {
            stack.push(i + 1);
        }
        Integer popped = stack.pop();
        assertFalse(stack.isEmpty());
        assertEquals(stackSize, popped);
        assertEquals(stackSize - 1, stack.size());
    }

    @Test
    void givenStaticStack_whenExceedsCapacity_thenShouldThrowStackOverflowException() {
        int stackSize = 10;
        Stack<Integer> stack = new DefaultStack<>(stackSize);
        for (int i = 0; i < stackSize; i++) {
            stack.push(i + 1);
        }
        assertThrows(StackOverflow.class, () -> stack.push(2));
    }

}