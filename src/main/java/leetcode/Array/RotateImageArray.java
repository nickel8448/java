package main.java.leetcode.Array;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/

import java.util.Arrays;

public class RotateImageArray {
    public static void rotate(int[][] matrix) {
        // There are two steps involved:
        // 1. Swap the diagonal elements
        // 2. Flip horizontals
        int length = matrix.length;

        // Completing step 1 - swapping the diagonals
        for(int i = 0; i < length; ++i) {
            for (int j = i; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Flipping horizontals
        for(int i = 0; i < length; ++i) {
            for(int j = 0; j < length/2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][j+length-1];
                matrix[i][j+length-1]= temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
