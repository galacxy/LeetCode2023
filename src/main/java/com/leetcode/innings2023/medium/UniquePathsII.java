package com.leetcode.innings2023.medium;


public class UniquePathsII {

    private static int uniquePathsWithObstacles(int[][] grid) {



        int r = grid.length;
        int c = grid[0].length;

        if(grid[r-1][c-1] == 1){
            return 0;
        }

        int[][] paths = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if (i == 0 && j == 0){
                    paths[i][j] = 1;
                } else if (i == 0){
                    paths[i][j] = grid[i][j-1] == 1 ? 0 : paths[i][j - 1];
                } else if (j == 0) {
                    paths[i][j] = grid[i - 1][j] == 1 ? 0 : paths[i - 1][j];
                } else {
                    int downCount = grid[i - 1][j] == 1 ? 0 : paths[i - 1][j];
                    int rightCount = grid[i][j-1] == 1 ? 0 : paths[i][j - 1];
                    paths[i][j] = downCount + rightCount;
                }
            }
        }

        return paths[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0},{0,1}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
