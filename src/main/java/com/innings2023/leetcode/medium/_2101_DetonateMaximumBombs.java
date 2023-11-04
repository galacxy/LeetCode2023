package com.innings2023.leetcode.medium;

import java.util.Arrays;

public class _2101_DetonateMaximumBombs {

    public static int maximumDetonation(int[][] bombs) {
        if(bombs == null || bombs.length == 0){
            return 0;
        }

        if(bombs.length == 1) {
            return bombs.length;
        }

        boolean[] visited = new boolean[bombs.length];
        Arrays.fill(visited, false);
        int max = Integer.MIN_VALUE;
        int[][] ranges = new int[bombs.length][bombs.length];
        for(int i=0;i< bombs.length;i++){
            Arrays.fill(ranges[i], 0);
            ranges[i][i] = 1;
        }
        for(int i=0;i< bombs.length;i++){
            detonate(bombs, visited, i, ranges);
//            System.out.println(i + " " + range);
            Arrays.fill(visited, false);
        }
        Arrays.fill(visited, false);
        System.out.println(Arrays.deepToString(ranges));
        for (int i = 0;i<ranges.length;i++) {
            max = Math.max(max, traverseRanges(ranges, visited, i));
            Arrays.fill(visited, false);
        }
        return max;
    }

    private static int traverseRanges(int[][] ranges, boolean[] visited, int i){
        if(visited[i]){
            return 0;
        }
        visited[i] = true;
        int count = 0;
        for(int j=0;j<ranges.length;j++){
            if(ranges[i][j] == 1){
                count += traverseRanges(ranges, visited, j);
            }
        }
        return 1 + count;
    }

    private static void detonate(int[][] bombs, boolean[] visited, int current, int[][] ranges){
        if(visited[current]){
            return;
        }
        visited[current] = true;
        for(int i=0;i< bombs.length;i++){
            if(i == current || visited[i]){
                continue;
            }
            double dist = getDistance(bombs[current][0], bombs[current][1], bombs[i][0], bombs[i][1]);
            if (dist <= bombs[current][2]){
                ranges[current][i] = 1;
                detonate(bombs, visited, i, ranges);
            }
        }
    }

    private static double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
    }

    public static void main(String[] args) {
//        int[][] bombs = {{2,1,3},{6,1,4}};
        int[][] bombs = {{1,1,5},{10,10,5}};
//        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println(maximumDetonation(bombs));
    }
}

