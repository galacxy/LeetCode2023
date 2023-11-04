package com.innings2023.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _78_Subsets {
    List<List<Integer>> power = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new Stack<>());
        return power;
    }

    private void dfs(int[] nums, int k, Stack<Integer> s){
        power.add(new ArrayList<>(s));
        for(int i = k;i < nums.length;i++){
            s.push(nums[i]);
            dfs(nums, i+1, s);
            s.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new _78_Subsets().subsets(nums));
    }
}
