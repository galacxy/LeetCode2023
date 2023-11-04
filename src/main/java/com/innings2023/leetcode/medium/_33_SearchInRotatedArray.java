package com.leetcode.innings2023.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _33_SearchInRotatedArray {
    public static int search(int[] nums, int t) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        if(nums.length == 1){
            return nums[0] == t ? 0 : -1;
        }

        if(nums.length == 2){
            return IntStream.range(0, nums.length).filter(x -> nums[x] == t).findFirst().orElse(-1);
        }

        int i=0, j= nums.length-1;

        while (i < nums.length && j >= 0 && i <= j){
            int mid = i + (j-i)/2;

            if(t == nums[mid]){
                return mid;
            }

            if(nums[mid] < nums[j]){
                if(nums[mid] <= t && t <= nums[j]){
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if(nums[i] <= t && t <= nums[mid]){
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int t = 5;

        System.out.println(search(nums, t));
    }
}


