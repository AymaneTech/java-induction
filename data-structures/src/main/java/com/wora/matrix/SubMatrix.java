package com.wora.matrix;

class SubMatrix {
    public int[][] createSubMatrix(int[][] matrix, int deleteRow, int deleteCol) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] subMatrix = new int[row - 1][col - 1];

        int newRow = 0;
        int newCol = 0;
        for (int r = 0; r < row; r++) {
            if (r == deleteRow - 1) continue;

            newCol = 0;
            for (int c = 0; c < col; c++) {
                if (c == deleteCol - 1) continue;
                subMatrix[newRow][newCol] = matrix[r][c];
                newCol++;
            }
            newRow++;
        }
        return subMatrix;
    }
}
