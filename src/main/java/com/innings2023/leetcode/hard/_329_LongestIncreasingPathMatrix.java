package com.innings2023.leetcode.hard;

import java.util.Arrays;

public class _329_LongestIncreasingPathMatrix {

    int p;
    int q;
    public int longestIncreasingPath(int[][] m) {
        p = m.length;
        q = m[0].length;
        int longestPath = Integer.MIN_VALUE;
        int[][] visiting = new int[p][q];
        long start = System.nanoTime();
        for(int i=0;i<p;i++){
            for(int j=0;j<q;j++){
                longestPath = Math.max(longestPath, dfs(m, i, j, Integer.MIN_VALUE, visiting));
            }
        }
        System.out.println((System.nanoTime() - start)/1000);
        return longestPath;
    }

    private void resetVisit(boolean[][] v){
        for(int i=0;i<v.length;i++){
            Arrays.fill(v[i], false);
        }
    }

    private boolean isValid(int i, int j){
        return i >= 0 && j >= 0 && i < p && j < q;
    }

    private int dfs(int[][] m, int i, int j, int prev, int[][] visiting) {
        if(!isValid(i, j) || visiting[i][j] > 0|| m[i][j] <= prev){
            return 0;
        }

        int horizontal = Math.max(dfs(m, i, j-1, m[i][j], visiting), dfs(m, i, j+1, m[i][j], visiting));
        int vertical = Math.max(dfs(m, i+1, j, m[i][j], visiting), dfs(m, i-1, j, m[i][j], visiting));
        visiting[i][j] = 1 + Math.max(horizontal, vertical);
        return visiting[i][j];
    }

    public static void main(String[] args) {
        // int[][] m = {
        //     {7,6,1,1},
        //     {2,7,6,0},
        //     {1,3,5,1},
        //     {6,6,3,2}};
        int[][] m = {{1,2,2}};
        System.out.println(new _329_LongestIncreasingPathMatrix().longestIncreasingPath(m));
    }

}
