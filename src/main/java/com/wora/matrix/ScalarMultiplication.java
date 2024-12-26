package com.wora.matrix;

public class ScalarMultiplication {

    public int[][] scalarMultiply(int[][] matrix, int scalar) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                result[r][c] = matrix[r][c] * scalar;
            }
        }
        return result;
    }
}
