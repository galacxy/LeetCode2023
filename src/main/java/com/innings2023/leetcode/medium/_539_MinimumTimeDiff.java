package com.innings2023.leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class _539_MinimumTimeDiff {
    public int findMinDifference(List<String> tp) {
        if(tp == null || tp.size() < 2){
            return 0;
        }

        int[][] time = new int[24][60];

        for(String t: tp){
            String[] sp = t.split(":");
            int h = Integer.parseInt(sp[0]);
            int m = Integer.parseInt(sp[1]);
            if (time[h][m] > 0){
                return 0;
            }
            time[h][m]++;
        }

        int min = Integer.MAX_VALUE;
        int i =0, j = 0;
        boolean flag = true;

        while (i<24 && flag){
            while (j<60 && flag){
                if (time[i][j] > 0){
                    flag = false;
                } else{
                    j++;
                }
            }
            if (flag){
                i++;
                j=0;
            }
        }
        int[] prev = new int[]{i,j++};
        while (i<24){
            while (j<60){
                if (time[i][j] == 0){
                    j++;
                    continue;
                }
                if(time[i][j] > 1){
                    return 0;
                }
                if (time[i][j] > 0){
                    int diff = (i - prev[0]) * 60 - prev[1] + j;
                    min = Math.min(min, diff);
                    prev[0] = i;
                    prev[1] = j;
                }
                j++;
            }
            i++;
            j = 0;
        }
        int fwdMin = 0;
        flag = true;
        for (i=0;i<24 && flag;i++){
            for(j=0;j<60 && flag;j++){
                if(time[i][j] > 0){
                    flag = false;
                } else {
                    fwdMin++;
                }
            }
        }
        flag = true;
        int bwdMin = 1;
        for (i=23;i>=0 && flag;i--){
            for(j=59;j>=0 && flag;j--){
                if(time[i][j] > 0){
                    flag = false;
                } else {
                    bwdMin++;
                }
            }
        }

        return Math.min(min, bwdMin+fwdMin);
    }

    public static void main(String[] args) {
        System.out.println(new _539_MinimumTimeDiff().findMinDifference(Arrays.asList("01:01","02:01")));
    }
}
