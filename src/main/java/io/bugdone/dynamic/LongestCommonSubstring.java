package io.bugdone.dynamic;

import java.util.Arrays;
import java.util.LinkedList;

class LongestCommonSubstring {
    public static void main(String[] args) {

        String word1 = "fish";
        String word2 = "fosh";

        int[][] grid = new int[word1.length() + 1][word2.length() + 1]; //avoid out of bounds


        int x = 0;
        int y = 0;
        int maxMatch = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    grid[i][j] = 0;
                    continue;
                }
                grid[i][j] = grid[i - 1][j - 1] + 1;
                if (grid[i][j] > maxMatch) {
                    x = i;
                    y = j;
                }
            }
        }


        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        LinkedList<Character> commonSubstring = new LinkedList<>();
        while (grid[x][y] > 0) {
            commonSubstring.addFirst(word1.charAt(x - 1));
            x--;
            y--;
        }
        System.out.println(commonSubstring);
    }
}
