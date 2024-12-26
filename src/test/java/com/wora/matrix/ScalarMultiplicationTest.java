package com.wora.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScalarMultiplicationTest {
    private ScalarMultiplication underTest;

    @BeforeEach
    void setup() {
        underTest = new ScalarMultiplication();
    }

    @Test
    void givenMatrixAndScalar_whenScalarMultiply_thenReturnNewMatrixWithResult() {
        int scalar = 2;
        int[][] matrix = {
                {1, 8, -3},
                {4, -2, 5}
        };

        int[][] actual = underTest.scalarMultiply(matrix, scalar);

        assertEquals(2, actual[0][0]);
        assertEquals(16, actual[0][1]);
        assertEquals(-4, actual[1][1]);
        assertEquals(10, actual[1][2]);
    }

}