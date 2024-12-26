package com.wora.matrix;

class MatrixTransportation {

    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        return result;
    }
}
