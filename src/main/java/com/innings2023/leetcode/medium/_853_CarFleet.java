package com.innings2023.leetcode.medium;

import java.util.Arrays;

public class _853_CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Double[][] timeTaken = new Double[position.length][2];
        for (int i=0;i<position.length;i++){
            timeTaken[i][0] = (double)position[i];
            timeTaken[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(timeTaken, (o1, o2) -> (int)(o2[0] - o1[0]));
        int count = 0;
        double maxTime = Integer.MIN_VALUE;
        for(Double[] currentTime:timeTaken){
            if(maxTime < currentTime[1]){
                count++;
                maxTime = currentTime[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target, position, speed));
    }
}
