package com.wora.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTransportationTest {
    private MatrixTransportation underTest;

    @BeforeEach
    void setup() {
        underTest = new MatrixTransportation();
    }

    @Test
    void givenMatrix_whenTranspose_thenProduceNewMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {0, -6, 7}
        };

        int[][] expected = {
                {1, 0},
                {2, -6},
                {3, 7}
        };

        int[][] actual = underTest.transpose(matrix);

        assertEquals(expected.length, actual.length);
        assertEquals(expected[0].length, actual[0].length);
        assertEquals(expected[0][0], actual[0][0]);
        assertEquals(expected[1][1], actual[1][1]);
    }

}