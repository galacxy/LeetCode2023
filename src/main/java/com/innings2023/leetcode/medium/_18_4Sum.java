package com.innings2023.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _18_4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4){
            throw new IllegalArgumentException();
        }

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;
        while(i<n-3){
            int j = i+1;
            while(j<n-2){
                int p = j+1;
                int q = n-1;
                while(p<q){
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum ==target){
                        set.add(Arrays.asList(i, j, p, q));
                    } else if (target < sum){
                        p++;
                    } else {
                        q--;
                    }
                }
                j++;
            }
            i++;
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

    }
}
