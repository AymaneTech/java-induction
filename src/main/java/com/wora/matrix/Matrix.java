package com.wora.matrix;

public class Matrix {
    private Matrix() {

    }

    public static int[][] add(int[][] m1, int[][] m2) {
        if (m1.length != m2.length
                || m1[0].length != m2[0].length) {
            throw new IllegalArgumentException("the matrix 1 and 2 has different row and column length");
        }

        int[][] result = new int[m1.length][m1[0].length];
        for (int r = 0; r < m1.length; r++) {
           for (int c = 0; c < m1[0].length; c++) {
                result[r][c] = m1[r][c] + m2[r][c];
           }
        }
        return result;
    }

    public static int[][] scalarMultiply(int[][] matrix, int scalar) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                result[r][c] = matrix[r][c] * scalar;
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix){
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        return result;
    }

}
