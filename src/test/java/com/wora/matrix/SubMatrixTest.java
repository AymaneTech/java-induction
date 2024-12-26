package com.wora.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubMatrixTest {
    private SubMatrix underTest;

    @BeforeEach
    void setup() {
        underTest = new SubMatrix();
    }

    @Test
    void testSubMatrix() {
        int[][] originalMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int [][] expected = {
                {1,3,4} ,
                {5,7,8}
        };

        int[][] actual = underTest.createSubMatrix(originalMatrix, 3, 2);

        assertEquals(expected[0][0], actual[0][0]);
        assertEquals(expected[0][1], actual[0][1]);
        assertEquals(expected[0][2], actual[0][2]);

        assertEquals(expected[1][0], actual[1][0]);
        assertEquals(expected[1][1], actual[1][1]);
        assertEquals(expected[1][2], actual[1][2]);
    }
}