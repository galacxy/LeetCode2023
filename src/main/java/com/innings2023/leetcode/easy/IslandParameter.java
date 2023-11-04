package com.leetcode.innings2023.easy;

public class IslandParameter {

    public static int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int p = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 0) {
                    continue;
                }
                if (j ==0 || (grid[i][j - 1] == 0)) {
                    p++;
                }
                if (i == 0 || (grid[i - 1][j] == 0)) {
                    p++;
                }
                if (j == c -1 || (j < c - 1 && grid[i][j + 1] == 0)) {
                    p++;
                }
                if (i == r - 1 || (i < r - 1 && grid[i + 1][j] == 0)) {
                    p++;
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}};
        System.out.println(islandPerimeter(grid));
    }
}
