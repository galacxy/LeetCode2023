package com.leetcode.innings2023.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _252_MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] current: intervals){
            if (!pq.isEmpty()) {
                if (current[0] < pq.peek()) {
                    return false;
                } else {
                    pq.poll();
                }
            }
            pq.offer(current[1]);
        }
        return true;
    }
}
