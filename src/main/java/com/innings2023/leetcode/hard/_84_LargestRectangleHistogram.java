package com.leetcode.innings2023.hard;

import java.util.Stack;

public class _84_LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for(int i=0;i<heights.length;i++){
            int minHeight = heights[i];
            for(int j=i;j<heights.length;j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (j-i+1)*minHeight);
            }
        }

        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int maxArea = 0;

        if(heights == null || heights.length == 0){
            return maxArea;
        }


        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int i = 0;
        while(i<heights.length){

            while(s.size() > 1 && heights[s.peek()] > heights[i]){
                int h = s.pop();
                maxArea = Math.max(maxArea, heights[h] * (i - s.peek() - 1));
            }
            s.push(i++);
        }

        while(s.size() > 1){
            int h = s.pop();
            maxArea = Math.max(maxArea, heights[h] * (i - s.peek() - 1));
        }


        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(heights));
    }
}
