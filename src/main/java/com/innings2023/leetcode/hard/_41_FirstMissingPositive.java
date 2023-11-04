package com.innings2023.leetcode.hard;

public class _41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n && nums[i] != 1){
            i++;
        }
        if (i == n){
            return 1;
        }

        i = 0;
        while(i < n){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
            i++;
        }

        i = 0;

        while(i < n){
            if(nums[i] == n && nums[0] > 0){
                nums[0] = -nums[0];
            } else if (nums[nums[i]] > 0){
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
            i++;
        }

        i = 1;

        while(i < n){
            if(nums[i] > 0){
                return i;
            }
            i++;
        }

        return nums[0] > 0 ? i : i+1;
    }
}
