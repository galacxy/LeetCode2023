package com.leetcode.innings2023.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _296_BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        List<int[]> friends = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    friends.add(new int[]{i, j});
                }
            }
        }

        int[][] aux = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                final int row = i;
                final int col = j;
                aux[row][col] = friends.stream().mapToInt(f -> Math.abs(f[0] - row) + Math.abs(f[1] -col)).sum();
            }
        }
        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(aux[i]));
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, aux[i][j]);
            }
        }
        return ans;
    }
    public int minTotalDistance2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);
        int rowMid = rows.get(rows.size()/2);
        int colMid = cols.get(cols.size()/2);
        return rows.stream().mapToInt(r -> Math.abs(r - rowMid)).sum() + cols.stream().mapToInt(c -> Math.abs(c - colMid)).sum();
    }


    private List<Integer> getRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                }
            }
        }
        return rows;
    }

    private List<Integer> getCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i] == 1){
                    cols.add(i);
                }
            }
        }
        return cols;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(new _296_BestMeetingPoint().minTotalDistance(grid));
    }
}
