package com.leetcode.innings2023.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_mergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length ==0){
            return new int[0][2];
        }

        if (intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });


        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];

        list.add(prev);

        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];

            if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                list.add(curr);
                prev = curr;
            }
        }

        int[][] ans = new int[list.size()][2];
        int k = 0;
        for(int[] l : list){
            ans[k++] = l;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
