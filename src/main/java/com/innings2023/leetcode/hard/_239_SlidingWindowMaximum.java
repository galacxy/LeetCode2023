package com.innings2023.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _239_SlidingWindowMaximum {

    // Space: O(k)
    // Time: O(nk)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1 || k==1){
            return nums;
        }

        int i = 1;
        int[] ans = new int[nums.length-k+1];
        int p = 0;
        int maxIndex = 0;
        int max = nums[maxIndex];
        while(i < k){
            if(max < nums[i]){
                maxIndex = i;
                max = nums[maxIndex];
            }
            i++;
        }
        ans[p++] = max;

        while(i < nums.length){
            if(maxIndex >= i-k+1){
                if(max < nums[i]){
                    maxIndex = i;
                    max = nums[maxIndex];
                }
            } else {
                int j = i-k+1;
                max = nums[j];
                while(j <= i){
                    if(max < nums[j]){
                        maxIndex = j;
                        max = nums[maxIndex];
                    }
                    j++;
                }
            }
            i++;
            ans[p++] = max;
        }

        return ans;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 1 || k==1){
            return nums;
        }

        int[] ans = new int[nums.length-k+1];
        int p=0;
        Deque<Integer> dq = new ArrayDeque<>();
        int i=0;
        while(i<k){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i++);
        }
        ans[p++] = nums[dq.peekFirst()];

        while (i < nums.length){
            if(dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            ans[p++] = nums[dq.peekFirst()];
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
       int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
         System.out.println(Arrays.toString(maxSlidingWindow2(nums, k)));
    }
}
