package com.innings2023.leetcode.medium;

import java.util.Arrays;

public class _34_FirstLastPosition {
    public int[] searchRange(int[] nums, int t) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int idx = binarySearch(nums, 0, nums.length-1, t);
        if(idx == -1){
            return new int[]{-1,-1};
        }

        int i = 0, j = idx-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (nums[mid] == t){
               j = mid-1;
            } else {
                i = mid+1;
            }
        }

        int p = idx+1, q = nums.length-1;
        while (p <= q){
            int mid = p + (q-p)/2;
            if(nums[mid] == t){
                p = mid + 1;
            } else {
                q = mid-1;
            }
        }

        return new int[]{i, q};
    }

    private int binarySearch(int[] nums, int i, int j, int t){
        if(i>j){
            return -1;
        }
        int mid = i + (j-i)/2;
        if (nums[mid] == t){
            return mid;
        } else if (nums[mid] > t){
            return binarySearch(nums, i, mid-1, t);
        } else {
            return binarySearch(nums, mid+1, j, t);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10,10,10};
        System.out.println(Arrays.toString(new _34_FirstLastPosition().searchRange(nums, 10)));
    }
}
