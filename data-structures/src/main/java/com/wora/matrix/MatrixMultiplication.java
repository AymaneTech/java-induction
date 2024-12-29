package com.wora.matrix;

class MatrixMultiplication {

    public int[][] multiply(int[][] m1, int[][] m2) {
        if (!isMatricesValid(m1, m2))
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");

        int row = m1.length;
        int column = m2[0].length;
        int sharedDimension = m1[0].length;

        int[][] result = new int[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                for (int k = 0; k < sharedDimension; k++) {
                    result[r][c] += m1[r][k] * m2[k][c];
                }
            }
        }

        return result;
    }

    private boolean isMatricesValid(int[][] m1, int[][] m2) {
        return m1[0].length == m2.length;
    }
}
