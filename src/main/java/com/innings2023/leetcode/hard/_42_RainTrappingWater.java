package com.innings2023.leetcode.hard;

public class _42_RainTrappingWater {
    public static int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }

        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int i = 0, j = n-1;

        leftMax[i++] = rightMax[j--] = -1;

        while(i < n){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
            i++;
            j--;
        }

        int sum = 0;
        for(int k=1;k<n-1;k++){
            int diff =  Math.min(leftMax[k], rightMax[k] - height[k]);
            if(diff > 0){
                sum += diff;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
