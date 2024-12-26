package com.wora.matrix;

public class Matrix {
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
}
