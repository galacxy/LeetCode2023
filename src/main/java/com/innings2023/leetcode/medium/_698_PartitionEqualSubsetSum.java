package com.innings2023.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class _698_PartitionEqualSubsetSum {
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length <= k){
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum%k != 0){
            return false;
        }
        sum /= k;
        int n = nums.length;
        used = new boolean[n];
        while(k-- > 0){
            int[][] memo = new int[n+1][sum+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(memo[i], -1);
            }

            if(dp(nums, n, sum, memo) == 0){
                return false;
            }
        }
        return true;
    }


    private int dp(int[] nums, int n, int sum, int[][] memo){
        if (sum >= 0 && memo[n][sum] >= 0){
            return memo[n][sum];
        }
        if (sum == 0){
            return 1;
        }
        if (n == 0 || sum < 0){
            return 0;
        }
        int res = dp(nums, n-1, sum, memo);
        if (res < 1){
            used[n-1] = true;
            res = dp(nums, n-1, sum - nums[n-1], memo);
        }
        memo[n][sum] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(new _698_PartitionEqualSubsetSum().canPartitionKSubsets(nums, k));
    }
}
