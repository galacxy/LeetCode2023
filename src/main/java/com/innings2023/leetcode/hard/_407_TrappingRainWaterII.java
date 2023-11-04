package com.innings2023.leetcode.hard;

public class _407_TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length < 3 || heightMap[0].length < 3){
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;

        int sum = 0;
        for(int i=1;i<m-1;i++){
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            int p = 0, q = n-1;
            while(p < q){
                if (heightMap[i][p] < heightMap[i][q]){
                    left = Math.max(left, heightMap[i][p]);
                    if(heightMap[i-1][p] >= heightMap[i][p] && heightMap[i+1][p] >= heightMap[i][p]){
                        sum += left - heightMap[i][p];
                    }
                    p++;
                } else {
                    right = Math.max(right, heightMap[i][q]);
                    if(heightMap[i-1][q] >= heightMap[i][q] && heightMap[i+1][q] >= heightMap[i][q]){
                        sum += right - heightMap[i][q];
                    }
                    q--;
                }
            }
        }

        for(int j=1;j<n-1;j++){
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            int p = 0, q = n-1;
            while(p < q){
                if (heightMap[p][j] < heightMap[q][j]){
                    left = Math.max(left, heightMap[p][j]);
                    if(heightMap[p][j-1] >= heightMap[p][j] && heightMap[p][j+1] >= heightMap[p][j]){
                        sum += left - heightMap[p][j];
                    }
                    p++;
                } else {
                    right = Math.max(right, heightMap[q][j]);
                    if(heightMap[q][j-1] >= heightMap[q][j] && heightMap[q][j+1] >= heightMap[q][j]){
                        sum += right - heightMap[q][j];
                    }
                    q--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][]heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        System.out.println(new _407_TrappingRainWaterII().trapRainWater(heightMap));
    }
}
