package com.innings2023.leetcode.medium;

public class _73_SetMatrixZeroes {
    public static void setZeroes(int[][] m) {

        int r = m.length;
        int c = m[0].length;

        int[] row = new int[r];
        int[] col = new int[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(m[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i] == 1 || col[j] == 1){
                    m[i][j] = 0;
                }
            }
        }
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
        int[][] m = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        print(m);
        setZeroes(m);
        print(m);
    }


}
