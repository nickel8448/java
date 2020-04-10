package main.java.leetcode.Array;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, 0, matrix.length - 1,
                0,matrix[0].length- 1, target);

    }

    public static boolean searchMatrix(int[][] matrix, int rowStart, int rowEnd,
                                       int colStart, int colEnd, int target) {
        int midRow = rowStart + (rowEnd - rowStart) / 2;
        int midCol = colStart + (colEnd - colStart) / 2;
        int midElement = matrix[midRow][midCol];
        if(midElement == target) {
            return true;
        } else {
            boolean topRight = false;
            boolean findInRows = false;
            boolean findInCols = false;
            if(midRow != rowEnd || midCol != colStart)
                topRight = searchMatrix(matrix, rowStart, midRow, midCol, colEnd,
                        target);
            if (rowStart == rowEnd && colStart + 1 == colEnd)
                if (matrix[rowStart][rowEnd] == target)
                    if(matrix[midRow][midCol] < target) {
                if(midRow + 1 <= rowEnd) {
                    findInRows = searchMatrix(matrix, midRow + 1, rowEnd,
                            colStart, colEnd, target);
                }
            } else {
                if(midCol - 1 >= 0) {
                    findInCols = searchMatrix(matrix, rowStart, rowEnd, colStart,
                            midCol - 1, target);
                }
            }
            return topRight || findInCols || findInRows;
        }
    }

    public static void main(String[] args) {
        int[][] inputMatrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(inputMatrix, 5));
    }
}
