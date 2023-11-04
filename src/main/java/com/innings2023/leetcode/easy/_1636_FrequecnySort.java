package com.innings2023.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1636_FrequecnySort {
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0)+ 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2){
                if(map.get(i1) != map.get(i2)){
                    return map.get(i1).compareTo(map.get(i2));
                }
                return i2.compareTo(i1);
            }
        });

        int i = 0, j = 0;
        while(i<nums.length){
            while(j < keys.size() && map.get(keys.get(j)) > 0){
                nums[i++] = keys.get(j);
                map.put(keys.get(j), map.get(keys.get(j)) - 1);

                if(map.get(keys.get(j)) == 0){
                    j++;
                }
            }
        }

        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};

        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
