package com.innings2023.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120_MinTriangleSum {
    
    public static int minimumTotal(List<List<Integer>> triangle) {        

        return triangle.stream().reduce(0, (partialSum, list) -> partialSum + list.stream().mapToInt(a -> a).min().getAsInt(), Integer::sum);
    }

    public static void main(String[] args) {
        List<List<Integer>> trianle = new ArrayList<>();
        trianle.add(Arrays.asList(2));
        trianle.add(Arrays.asList(3,4));
        trianle.add(Arrays.asList(6,5,7));
        trianle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(trianle));
    }
}
