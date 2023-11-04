package com.innings2023.leetcode.medium;

public class _48_RotateImage {

    public static void rotate(int[][] m) {
        reverseRow(m);
        transpose(m);
    }

    public static void transpose(int[][] m) {
        int n = m.length;
        for(int i=0;i < n ;i++){
            for(int j=i;j < n;j++){
               int temp = m[i][j];
               m[i][j] = m[j][i];
               m[j][i] = temp;
            }
        }
    }

    public static void reverseRow(int[][] m) {
        int n = m.length;
        for(int i=0;i<n;i++){
            for(int j=0,k=n-1;j<k;j++,k--){
                int temp = m[i][j];
                m[i][j] = m[i][k];
                m[i][k] = temp;
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
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        print(m);
        rotate(m);
        print(m);
    }
}
