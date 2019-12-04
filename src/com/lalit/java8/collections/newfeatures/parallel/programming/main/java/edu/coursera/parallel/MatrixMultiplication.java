package com.lalit.java8.collections.newfeatures.parallel.programming.main.java.edu.coursera.parallel;

public class MatrixMultiplication {

    public static int[][] multiplyMatrixSequential(int[][] matrix_A, int[][] matrix_B) throws Exception {
        int matrix_A_row = matrix_A.length;
        int matrix_A_col = matrix_A[0].length;
        int matrix_B_row = matrix_B.length;
        int matrix_B_col = matrix_B[0].length;
        if (matrix_A_col != matrix_B_row) {
            throw new Exception("Multiplication not possible");
        } else {
            int[][] resultant_matrix = new int[matrix_A_row][matrix_B_col];
            for (int i = 0; i < matrix_A_row; ++i) {
                for (int j = 0; j < matrix_B_col; ++j) {
                    for (int k = 0; k < matrix_A_col; ++k) {
                        resultant_matrix[i][j] = resultant_matrix[i][j] + (matrix_A[i][k] * matrix_B[k][j]);
                    }
                }
            }
            return resultant_matrix;
        }

    }

    public static void main(String... s) throws Exception {
        int[][] matrix_A = new int[][]{{3, 3, 3}, {4, 4, 4}};
        int[][] matrix_B = new int[][]{{2, 2}, {3, 3}, {4, 5}};
        int resultantMatrix[][] = MatrixMultiplication.multiplyMatrixSequential(matrix_A, matrix_B);
        MatrixMultiplication.printMatrix(resultantMatrix);
    }

    public static void printMatrix(int[][] resultantMatrix) {
        for (int i = 0; i < resultantMatrix.length; ++i) {
            for (int j = 0; j < resultantMatrix[0].length; ++j) {
                System.out.print(resultantMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
