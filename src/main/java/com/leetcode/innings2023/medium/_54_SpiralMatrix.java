package com.leetcode.innings2023.medium;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] m) {
        List<Integer> ans = new ArrayList<>();
        int rl = 0, rh = m.length;
        int cl = 0, ch = m[0].length;

        while (rl < rh && cl < ch) {
            for (int j = cl; j < ch && rl < rh; j++) {
                ans.add(m[rl][j]);
            }
            rl++;

            for (int i = rl; i < rh && cl < ch; i++) {
                ans.add(m[i][ch-1]);
            }
            ch--;

            for (int j = ch-1; j >= cl && rl < rh; j--) {
                ans.add(m[rh-1][j]);
            }
            rh--;

            for (int i = rh-1; i >= rl && cl < ch; i--) {
                ans.add(m[i][cl]);
            }
            cl++;
        }
        return ans;
    }

    private static void print(int[][] m){
        for(int[] r: m){
            for(int c: r){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        print(m);
        System.out.println(spiralOrder(m));
    }
}
