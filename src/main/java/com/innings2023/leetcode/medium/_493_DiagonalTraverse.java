package com.innings2023.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _493_DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int k = 0;

        int[] ans = new int[n*m];
        

        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<m+n-1;i++){
            map.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.get(i+j).add(mat[i][j]);
            }
        }

        boolean up = false;
        for(List<Integer> list:map){
            if(up){
                for(int i=0;i<list.size();i++){
                    ans[k++] = list.get(i);
                }
            } else {
                for(int i=list.size()-1;i>=0;i--){
                    ans[k++] = list.get(i);
                }
            }
            up = !up;
        }
       

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6}, {7,8,9}};
        int[][] mat1 = {{1,2}, {3,4}, {5,6}};
        int[][] mat2 = {{1,2,3}, {4,5,6}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
        System.out.println(Arrays.toString(findDiagonalOrder(mat1)));
        System.out.println(Arrays.toString(findDiagonalOrder(mat2)));
    }
}
