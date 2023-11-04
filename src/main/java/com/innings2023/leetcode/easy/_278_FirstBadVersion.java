package com.innings2023.leetcode.easy;

public class _278_FirstBadVersion {

    private static int badVersion;

    public static int firstBadVersion(int n) {
        int i = 1, j = n;

        while(i<j){
            int mid = i + (j-i)/2;

            if(isBadVersion(mid)){
                j = mid;
            } else {
                i = mid+1;
            }
        }

        return i;
    }

    private static boolean isBadVersion(int n){
        return n >= badVersion;
    }

    public static void main(String[] args) {
        int n = 2;
        badVersion = 2;
        System.out.println(firstBadVersion(n));
    }
}
