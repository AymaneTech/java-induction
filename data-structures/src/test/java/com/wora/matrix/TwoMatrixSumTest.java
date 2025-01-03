package com.wora.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class TwoMatrixSumTest {
    private TwoMatrixSum underTest;

    @BeforeEach
    void setup() {
        underTest = new TwoMatrixSum();
    }

    @Test
    void givenMatricesWithDifferentSize_whenAdd_thenThrowIllegalArgumentException() {
        int[][] m1 = new int[2][3];
        int[][] m2 = new int[2][4];

        assertThrowsExactly(IllegalArgumentException.class, () ->
                underTest.add(m1, m2)
        );
    }

    @Test
    void givenValidMatrices_whenAdd_thenShouldReturnNewMatrixWithSum() {
        int[][] m1 = {
                {1, 3, 1},
                {1, 0, 0}
        };
        int[][] m2 = {
                {0, 0, 5},
                {7, 5, 0}
        };

        int[][] actual = underTest.add(m1, m2);

        assertEquals(m1.length, actual.length);
        assertEquals(1, actual[0][0]);
        assertEquals(8, actual[1][0]);
        assertEquals(6, actual[0][2]);
    }

}