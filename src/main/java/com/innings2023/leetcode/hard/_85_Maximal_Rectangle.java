package com.innings2023.leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

public class _85_Maximal_Rectangle {
    public static int maximalRectangle(char[][] m) {
        if(m == null || m.length ==0 || m[0].length ==0){
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int[] temp = new int[m[0].length];
        for(int i=0;i<m.length;i++){
            int k = 0;
            while( k < m[i].length){
                temp[k] = m[i][k] == '1' ? temp[k] + 1 : 0;
                k++;
            }
            int rowMax = maximumAreaHistogram(temp);
            System.out.println(Arrays.toString(temp) + ": " + rowMax);
            maxArea = Math.max(maxArea, rowMax);
        }

        return maxArea;
    }

    private static int maximumAreaHistogram(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }


        if(nums.length == 1){
            return nums[0];
        }

        int maxArea = nums[0];
        for(int i=0;i<nums.length;i++){
            int minHeight = nums[i];
            for(int j=i;j<nums.length;j++){
                minHeight = Math.min(minHeight, nums[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

    private static int maximumAreaHistogram2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int i = 0;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        s.push(-1);


        while(i<nums.length){
            while(s.size() > 1 && nums[s.peek()] < nums[i] ){
                int h = nums[s.pop()];
                maxArea = Math.max(maxArea, h * (i - s.peek() - 1));
            }
        }

        while (s.size() > 1){
            int h = nums[s.pop()];
            maxArea = Math.max(maxArea, h * (i - s.peek() - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // char[][] m = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] m = {{'0','1'}};
        System.out.println(maximalRectangle(m));
    }
}
