package com.leetcode.innings2023.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _2150_LonelyNumbers {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return ans;
        }

        Map<Integer, Integer> set = new HashMap<>();
        for(int i:nums){
            set.put(i, set.getOrDefault(i, 0) + 1);
        }

        for(int i:nums){
            if(!(set.containsKey(i+1) || set.containsKey(i-1) || set.get(i) != 1)){
                ans.add(i);
            }
        }

        return ans;
    }
}
