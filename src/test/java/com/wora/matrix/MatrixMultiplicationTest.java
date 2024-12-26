package com.wora.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixMultiplicationTest {

    private MatrixMultiplication underTest;

    @BeforeEach
    void setup() {
        underTest = new MatrixMultiplication();
    }

    @Test
    void givenInvalidMatricesLength_whenMultiply_thenThrowIllegalArgumentException() {
        int[][] m1 = new int[4][3];
        int[][] m2 = new int[4][3];

        assertThrows(IllegalArgumentException.class, () ->
                underTest.multiply(m1, m2)
        );
    }

    @Test
    void givenValidMatrices_whenMultiply_thenReturnResult() {
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] m2 = {
                {10, 11},
                {20, 21},
                {30, 31}
        };

        int[][] expected = {
                {140, 146},
                {320, 335}
        };

        int[][] actual = underTest.multiply(m1, m2);

        assertEquals(expected.length, actual.length);
        assertEquals(expected[0].length, actual[0].length);
        assertEquals(expected[0][0], actual[0][0]);
        assertEquals(expected[1][0], actual[1][0]);
        assertEquals(expected[0][1], actual[0][1]);
        assertEquals(expected[1][1], actual[1][1]);
    }

}