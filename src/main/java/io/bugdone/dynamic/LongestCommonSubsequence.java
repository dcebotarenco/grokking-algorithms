package io.bugdone.dynamic;

import java.util.Arrays;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        String word1 = "fish";
        String word2 = "fosh";

        int[][] grid = new int[word1.length() + 1][word2.length() + 1]; //avoid out of bounds

        int x = 0;
        int y = 0;
        int maxFound = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
                }

                if (grid[i][j] > maxFound) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println(grid[x][y]);

    }
}
