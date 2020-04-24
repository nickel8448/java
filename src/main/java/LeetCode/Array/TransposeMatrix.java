package main.java.LeetCode.Array;

import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] A) {
        int rowsLength = A.length;
        int columnLength = A[0].length;

        int[][] new_matrix = new int[columnLength][rowsLength];

        for(int i = 0; i < rowsLength; ++i) {
            for(int j = 0; j < columnLength; ++j) {
                new_matrix[j][i] = A[i][j];
            }
        }
        return new_matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(Arrays.deepToString(transpose(matrix)));
        for(int i = 1; i <= 10; ++i) {
            for (int j = i; j <= 10; j++) {
                System.out.println("i: " + i + " j = " + j);

            }
        }
    }
}
