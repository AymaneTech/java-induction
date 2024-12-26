package com.wora.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class MatrixTest {

    @Test
    void givenTwoMatrixWithDifferentSize_whenAdd_thenThrowMatrixSizeNotEqual() {
        int[][] m1 = new int[2][3];
        int[][] m2 = new int[2][4];

        assertThrowsExactly(IllegalArgumentException.class, () ->
                Matrix.add(m1, m2)
        );
    }

    @Test
    void givenValidMatrix_whenAdd_thenShouldReturnNewMatrixWithSum() {
        int[][] m1 = {
                {1, 3, 1},
                {1, 0, 0}
        };
        int[][] m2 = {
                {0, 0, 5},
                {7, 5, 0}
        };

        int[][] actual = Matrix.add(m1, m2);

        assertEquals(m1.length, actual.length);
        assertEquals(1, actual[0][0]);
        assertEquals(8, actual[1][0]);
        assertEquals(6, actual[0][2]);
    }


    @Test
    void givenMatrixAndScalar_whenScalarMultiply_thenReturnNewMatrixWithResult() {
        int scalar = 2;
        int[][] matrix = {
                {1, 8, -3},
                {4, -2, 5}
        };

        int[][] actual = Matrix.scalarMultiply(matrix, scalar);

        assertEquals(2, actual[0][0]);
        assertEquals(16, actual[0][1]);
        assertEquals(-4, actual[1][1]);
        assertEquals(10, actual[1][2]);
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

        int[][] actual = Matrix.transpose(matrix);

        assertEquals(expected.length, actual.length);
        assertEquals(expected[0].length, actual[0].length);
        assertEquals(expected[0][0], actual[0][0]);
        assertEquals(expected[1][1], actual[1][1]);
    }
}