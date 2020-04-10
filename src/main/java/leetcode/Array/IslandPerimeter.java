package main.java.leetcode.Array;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int numSides = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    // Up
                    if (i - 1 < 0 || grid[i - 1][j] != 1) numSides++;
                    // Down
                    if (i + 1 >= grid.length || grid[i + 1][j] != 1) numSides++;
                    // Left
                    if (j - 1 < 0 || grid[i][j - 1] != 1) numSides++;
                    // Right
                    if (j + 1 >= grid[i].length || grid[i][j + 1] != 1) numSides++;
                }
            }
        }
        return numSides;
    }

    public static void main(String[] args) {
        int[][] input = {{0,1,0,0},
                         {1,1,1,0},
                         {0,1,0,0},
                         {1,1,0,0}};
        int[][] oneIsland = {{1}};
        System.out.println(islandPerimeter(input));
        System.out.println(islandPerimeter(oneIsland));
    }
}
